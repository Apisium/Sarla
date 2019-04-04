package cn.apisium.sarla

import cn.apisium.sarla.dom.*
import cn.apisium.sarla.nodes.*
import cn.apisium.sarla.utils.NativeArray
import cn.apisium.sarla.utils.NativeSet
import kotlin.browser.window

external interface Deadline {
    fun timeRemaining(): Int
}

external fun requestIdleCallback(callback: (Deadline) -> Unit)

@Suppress("UNUSED")
private val assign = js("""'assign' in Object && Object.assign.toString().indexOf('native') !== -1
        ? Object.assign : function assign (a, b) { for (var k in b) a[k] = b[k] }""").unsafeCast<(Any, Any) -> Any>()
@Suppress("UNUSED", "DEPRECATION")
private val clearAttr = js("""function (attr, elm) {
        for (var k in attr) switch (k) {
            case 'className': elm.className = ''; break
            case 'style': case 'styleText': elm.style.cssText = ''; break
            default: elm.removeAttribute(k)
        }
        elm.sarlaAttr = null
    }""").unsafeCast<HTMLAttributes<*>, Element>()

@Suppress("NOTHING_TO_INLINE", "UNUSED")
actual class Provider(actual val store: Data<*>, val eventProxy: dynamic) {
    private val list = NativeSet<Data<*>>()
    private val nodesList = NativeSet<DataNodeBlock>()
    private var lockNums = 0
    private var started = false
    private val diffElements = NativeArray<BaseNode>()
    private val diffAttributes = NativeArray<Any?>()
    private val willRemoveAttrID = NativeArray<Int>()
    private val willRemoveAttrNames = NativeArray<Array<String>>()

    actual fun lock() = ++lockNums
    actual fun unlock(): Int {
        if (lockNums != 0 && --lockNums == 0 && !started && (list.size > 0 || nodesList.size > 0)) {
            started = true
            requestIdleCallback(this::patchLoop)
        }
        return lockNums
    }

    private fun diffElement(old: NodeBlock, new: HasAttr) {
        if (new !is D || new !is E) return
        diffElements.add(old)
        diffAttributes.add(new.attr)
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
                        diffElement(old.unsafeCast<E>(), node)
                        @Suppress("UNSAFE_CALL")
                        parent.currentId++
                    }
                    is D -> { // ElementNode
                        val elm = renderNewElement(node.attr, node.type, eventProxy)
                        node.unsafeCast<HasElm>().elm = elm
                        elm.unsafeCast<NodeToSarla>().sarla = node
                        @Suppress("SMARTCAST_IMPOSSIBLE")
                        if (node.renderFunc != null) node.(node.renderFunc)()
                        diffElement(old.unsafeCast<E>(), node)
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
                        if (old != null);
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
        if (diffElements.length() > 0) {
            lock()
            window.requestAnimationFrame(this::patch)
        }
    }

    private fun patch(unused: Double) {
        diffElements.forEachIndexed { it, i ->
            if (it !is E && it !is D) return@forEachIndexed
            val attr = diffAttributes[i]
            val oldAttr = it.unsafeCast<HasAttr>().attr
            if (attr == oldAttr) return@forEachIndexed
            val elm = it.asDynamic().elm.unsafeCast<Element>()
            if (oldAttr == null) {
                patchAttr(attr, elm, eventProxy)
                return@forEachIndexed
            }
            js("""
                var unset = true
                if (attr == null) clearAttr(elm)
                else if (typeof attr === 'string') {
                    if (typeof oldAttr !== 'string') clearAttr(elm)
                    elm.className = attr
                } else for (var name in attr) { var ov = oldAttr[name], nv = attr[name]; if (ov !== nv) switch (name) {
                    case 'key': break
                    case 'className': elm.className = attr.className; break
                    case 'innerHTML': elm.innerHTML = attr.innerHTML; break
                    case 'style': if(!('styleText' in attr)) assign(elm.style, attr.style); break
                    case 'styleText': elm.style.cssText = attr.styleText; break
                    default:
                        if (name in elm) elm[name] = nv || ''
                        else if (name[0] === 'o' && name[1] === 'n') {
                            if (unset) {
                                unset = false
                                elm.sarlaAttr = attr
                            }
                            attr[name] = null
                            attr[name = name.toLowerCase()] = nv
                            if (name.substr(-7) === 'capture') name = name.substring(0, n.length - 7)
                            if (!root[name]) root[name] = eventProxy
                        } else elm.setAttribute(name, nv)
                        ov = null
                        nv = null
                    }
                }
            """).unsafeCast<Unit>()
        }
        willRemoveAttrID.forEachIndexed { id, i ->
            val elm = diffElements[id].asDynamic().elm.unsafeCast<Element>()
            @Suppress("UNSAFE_CALL")
            willRemoveAttrNames[i].forEach { elm.removeAttribute(it) }
        }
        willRemoveAttrID.clear()
        willRemoveAttrNames.clear()
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
