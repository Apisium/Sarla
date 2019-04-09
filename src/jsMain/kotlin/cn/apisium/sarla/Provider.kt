@file:Suppress("DEPRECATION")

package cn.apisium.sarla

import cn.apisium.sarla.dom.*
import cn.apisium.sarla.nodes.*
import cn.apisium.sarla.utils.NativeArray
import cn.apisium.sarla.utils.NativeSet
import kotlin.browser.window

external interface Deadline {
    fun timeRemaining(): Int
}

@Suppress("UNUSED")
private class HasAttrImpl(val elm: Element, val className: String?, val attr: HTMLAttributes<*>?,
                          val style: CSSProperties?, val event: DOMEvents<*>?) { val kind = 4 }

external fun requestIdleCallback(callback: (Deadline) -> Unit)

@Suppress("UNUSED")
private val assign = js("""'assign' in Object && Object.assign.toString().indexOf('native') !== -1
        ? Object.assign : function assign (a, b) { for (var k in b) a[k] = b[k] }""").unsafeCast<(Any, Any) -> Any>()

@Suppress("NOTHING_TO_INLINE", "UNUSED")
actual class Provider(actual val store: Data<*>, val eventProxy: (String) -> Unit) {
    private val list = NativeSet<Data<*>>()
    private val nodesList = NativeSet<DataNodeBlock>()
    private var lockNums = 0
    private var started = false
    private val diffElements = NativeArray<BaseNode>()
    private val willRemoveAttrID = NativeArray<Int>()
    private val willRemoveAttrNames = NativeArray<Array<String>>()
    private val willRemoveStyleID = NativeArray<Int>()
    private val willRemoveStyleNames = NativeArray<Array<String>>()

    actual fun lock() = ++lockNums
    actual fun unlock(): Int {
        if (lockNums != 0 && --lockNums == 0 && !started && (list.size > 0 || nodesList.size > 0)) {
            started = true
            requestIdleCallback(this::patchLoop)
        }
        return lockNums
    }

    private fun diffElement(o: NodeBlock, new: NodeBlock) {
        val kind = o.asDynamic().kind.unsafeCast<Int>()
        if (kind != 4 && kind != 5) return
        val node = new.unsafeCast<HasAttr<*, *>>()
        val old = o.unsafeCast<HasAttr<*, *>>()
        val attr = node.attr
        val oldAttr = old.attr
        val i = diffElements.add(new, o)
        if (attr != null && oldAttr != null) {
            val arr: Array<String>? = null
            js("for (var name in oldAttr) if (!(name in attr)) arr ? arr.push(name) : (arr = new Array)")
            arr?.let {
                willRemoveAttrID.add(i)
                willRemoveAttrNames.add(it)
            }
        }
        val style = node.style
        val oldStyle = old.style
        if (style != null && oldStyle != null) {
            val arr: Array<String>? = null
            js("for (var name in oldStyle) if (!(name in style)) arr ? arr.push(name) : (arr = new Array)")
            arr?.let {
                willRemoveStyleID.add(i)
                willRemoveStyleNames.add(it)
            }
        }
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
            val kind = it.asDynamic().kind.unsafeCast<Int>()
            @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
            if (kind == 4 || kind == 5) {
                val d = it.unsafeCast<HasAttr<*, *>>()
                val o = HasAttrImpl(it.elm.unsafeCast<Element>(), d.className, d.attr, d.style, d.event)
                it.(it.renderFunc)()
                diffElement(o.unsafeCast<NodeBlock>(), it.unsafeCast<NodeBlock>())
            } else it.(it.renderFunc)()
            loop@ while (node != null) {
                val parent = node.parent.unsafeCast<NodeBlock?>()
                when (node.asDynamic().kind.unsafeCast<Int>()) {
                    0 -> { // Comment
                        if (old != null) Unit // TODO
                        if (parent != null) parent.currentId++
                    }
                    1, 2 -> @Suppress("UNUSED_VARIABLE") { // Sarla
                        node = node.unsafeCast<S<*, *>>()
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
                    3 -> { // Text
                        node = node.unsafeCast<T>()
                        if (old is T) {
                            old.elm.nodeValue = node.value
                            old.value = node.value
                        } else Unit // TODO
                        if (parent != null) parent.currentId++
                    }
                    4 -> { // DataElementNode
                        node = node.unsafeCast<D<*, *>>()
                        @Suppress("SMARTCAST_IMPOSSIBLE")
                        if (node.renderFunc != null) node.(node.renderFunc)()
                        diffElement(old.unsafeCast<E<*, *>>(), node)
                        @Suppress("UNSAFE_CALL")
                        node.id = parent.id + "," + parent.currentId++
                    }
                    5 -> { // ElementNode
                        diffElement(old.unsafeCast<E<*, *>>(), node.unsafeCast<E<*, *>>())
                        @Suppress("UNSAFE_CALL")
                        parent.currentId++
                    }
                    6 -> { // Nodes
                        @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
                        node.unsafeCast<HasElm>().elm = createFragmentElement()
                        if (parent != null) parent.currentId++
                    }
                    7 -> { // DataNodes
                        node = node.unsafeCast<DataNodeBlock>()
                        @Suppress("UNSAFE_CALL")
                        node.id = parent.id + "," + parent.currentId++
                        @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
                        node.(node.renderFunc)()
                        node.unsafeCast<HasElm>().elm = createFragmentElement()
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
        if (diffElements.length() > 0) {
            lock()
            window.requestAnimationFrame(this::patch)
        }
    }

    @Suppress("UNUSED_PARAMETER")
    private fun patch(unused: Double) {
        var i = diffElements.length()
        while (i != 0) {
            val old = diffElements[--i].unsafeCast<HasAttr<*, *>>()
            val new = diffElements[--i].unsafeCast<HasAttr<*, *>>()
            val elm = old.asDynamic().elm.unsafeCast<Element>()
            if (old.className != new.className) elm.className = new.className ?: ""
            if (new.event == null) {
                if (old.event != null) elm.asDynamic().sarlaEvents = null
            } else elm.asDynamic().sarlaEvents = new.event
            val attr = new.attr
            val oldAttr = old.attr
            if (attr == null) {
                if (oldAttr != null) clearAttr(oldAttr, elm)
            } else if (oldAttr != null) patchOldAttr(attr, oldAttr, elm)

            val oldStyle = old.style
            val style = new.style
            if (style == null) {
                if (oldStyle != null) clearStyle(oldStyle, elm.style)
            } else if (oldStyle == null) assign(elm.style, style) else patchStyle(style, oldStyle, elm.style)
        }
        willRemoveAttrID.forEachIndexed { id, j ->
            val elm = diffElements[id].asDynamic().elm.unsafeCast<Element>()
            @Suppress("UNSAFE_CALL")
            willRemoveAttrNames[j].forEach { elm.removeAttribute(it) }
        }
        willRemoveStyleID.forEachIndexed { id, j ->
            val elm = diffElements[id].asDynamic().elm.unsafeCast<Element>()
            @Suppress("UNSAFE_CALL")
            willRemoveStyleNames[j].forEach { elm.style.asDynamic()[it] = "" }
        }
        willRemoveAttrID.clear()
        willRemoveAttrNames.clear()
        willRemoveStyleID.clear()
        willRemoveStyleNames.clear()
        diffElements.clear()
        unlock()
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
