package cn.apisium.sarla

import cn.apisium.sarla.dom.createFragmentElement
import cn.apisium.sarla.dom.renderNewElement
import cn.apisium.sarla.nodes.*
import cn.apisium.sarla.utils.NativeSet

external interface Deadline {
    fun timeRemaining(): Int
}

external fun requestIdleCallback(callback: (Deadline) -> Unit)

@Suppress("NOTHING_TO_INLINE")
actual class Provider(actual val store: Data<*>, val eventProxy: dynamic) {
    private val list = NativeSet<Data<*>>()
    private val nodesList = NativeSet<DataNodeBlock>()
    private var lockNums = 0
    private var started = false

    actual fun lock() = ++lockNums
    actual fun unlock(): Int {
        if (lockNums != 0 && --lockNums == 0 && !started && (list.size > 0 || nodesList.size > 0)) {
            started = true
            requestIdleCallback(this::patchLoop)
        }
        return lockNums
    }

    private fun patchLoop(deadline: Deadline) {
        if (list.size > 0) {
            list.forEach { it.nodes.forEach(nodesList::add) }
            list.clear()
        }
        val iterator = nodesList.values()
        var value = iterator.next()
        while (deadline.timeRemaining() > 0 && !value.done) {
            val it = value.value
            nodesList.delete(it)
            value = iterator.next()
            val oldNode = it.start.unsafeCast<BaseNode>()
            var old: BaseNode? = oldNode
            var node = js("{}").unsafeCast<BaseNode?>()
            it.start = node.unsafeCast<BaseNode>()
            it.end = it.start
            @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
            it.(it.renderFunc)()
            loop@ while (node != null) {
                console.log(node)
                val parent = node.parent.unsafeCast<NodeBlock?>()
                when (node) {
                    is E -> {
                        val elm = renderNewElement(node.attr, node.type, eventProxy)
                        node.unsafeCast<HasElm>().elm = elm
                        elm.unsafeCast<NodeToSarla>().sarla = node
                        @Suppress("UNSAFE_CALL")
                        parent.currentId++
                    }
                    is D -> { // ElementNode
                        val elm = renderNewElement(node.attr, node.type, eventProxy)
                        node.unsafeCast<HasElm>().elm = elm
                        elm.unsafeCast<NodeToSarla>().sarla = node
                        @Suppress("SMARTCAST_IMPOSSIBLE")
                        if (node.renderFunc != null) node.(node.renderFunc)()
                        @Suppress("UNSAFE_CALL")
                        node.id = parent.id + "," + parent.currentId++
                    }
                    is S<*, *> -> @Suppress("UNUSED_VARIABLE") {
                        @Suppress("UNSAFE_CALL")
                        node.id = parent.id + "," + parent.currentId++
                        val clazz = node.clazz.js.asDynamic()
                        val sarla =
                            (if (node.hasProp) js("new clazz(this, node.props)") else js("new clazz(p)")).unsafeCast<Sarla>()
                        val flags = clazz.flags.unsafeCast<Int>()
                        node.instant = sarla
                        if (flags and 32 == 32) node.unsafeCast<EffectPreRender>().preRender()
                        node.(sarla.render())()
                        if (flags and 64 == 64) node.unsafeCast<EffectPostRender>().postRender()
                        val elm = createFragmentElement()
                        node.unsafeCast<HasElm>().elm = elm
                        if (flags and 1 == 1) node.unsafeCast<EffectPreInsert>().preInsert(elm)
                    }
                    is DataNodeBlock -> {
                        @Suppress("UNSAFE_CALL")
                        node.id = parent.id + "," + parent.currentId++
                        @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
                        node.(node.renderFunc)()
                        node.unsafeCast<HasElm>().elm = createFragmentElement()
                    }
                    is NodeBlock -> {
                        @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
                        node.unsafeCast<HasElm>().elm = createFragmentElement()
                        if (parent != null) parent.currentId++
                    }
                    is T -> { // Text
                        if (old is T) {
                            old.elm.nodeValue = node.value
                            old.value = node.value
                        } else Unit // TODO
                        if (parent != null) parent.currentId++
                    }
                    is N -> { // Comment
                        if (parent != null) parent.currentId++
                    }
                }
                val tempNode = node.unsafeCast<NodeBlock>()
                @Suppress("UNNECESSARY_SAFE_CALL")
                if (tempNode.start?.next != null) {
                    node = tempNode.start.next
                    val tempOld = node.unsafeCast<NodeBlock>()
                    if (tempOld.start?.next == null) Unit // TODO
                    continue
                }
                // 光头节点
                @Suppress("UNSAFE_CALL")
                if (node.next == null) {
                    var curr = node.parent
                    var d = curr?.parent
                    var curr2 = old.parent
                    var d2 = curr2?.parent
                    while (d != null) {
                        d.unsafeCast<NodeBlock>().currentId = 0
                        if (curr == it) break@loop
                        if (curr.next != null) break
                        if (curr2.next == null) Unit // TODO
                        curr = d
                        d = d.parent
                        curr2 = d2
                        d2 = d2.parent
                    }
                    node = curr?.next
                } else {
                    node = node.next
                    old = old.next
                }
            }
            it.start = oldNode
        }
        if (nodesList.size > 0) requestIdleCallback(this::patchLoop)
        else started = false
    }

    actual fun notify(data: Data<*>) {
        list.add(data)
        if (!started && lockNums == 0) {
            started = true
            requestIdleCallback(this::patchLoop)
        }
    }

    actual fun notify(nodes: DataNodeBlock) {
        nodesList.add(nodes)
        if (!started && lockNums == 0) {
            started = true
            requestIdleCallback(this::patchLoop)
        }
    }

    actual fun notify(sarla: Sarla) {
    }
}
