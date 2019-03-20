@file:Suppress("DEPRECATION")

package cn.apisium.sarla

import cn.apisium.sarla.dom.*
import cn.apisium.sarla.nodes.*

private external interface HasElm {
    var elm: Node
}

private external interface NodeToSarla {
    var sarla: BaseNode
}

actual fun <G: Any> render(store: G, root: Element, block: Nodes): Data<G> {
    val provider = js("{}").unsafeCast<Provider>()
    val data = Data(store, provider)
    provider.asDynamic().store = data
    @Suppress("UNUSED_VARIABLE")
    val eventProxy = js("""function (e) {
        e = e || window.event
        var target = e.target, nodes = [], unPrevent = true,
            type = 'on' + e.type.toLowerCase()
        if (!target) target = e.target = e.srcElement
        if (!e.returnValue) e.returnValue = true
        do {
            var attr = target.sarlaAttr
            if (attr) {
                if (!e.canceled) {
                    var fn = attr[type]
                    if (fn) {
                        e.current = target
                        try { fn(e) } catch (a) { console.error(a) }
                        if (unPrevent && !e.returnValue) {
                            unPrevent = false
                            if ('preventDefault' in e) e.preventDefault()
                        }
                    }
                }
                fn = attr[type + 'capture']
                if (fn) nodes.push(fn, target)
            }
            target = target.parentNode
        } while (target !== root)
        e.canceled = false
        var i = nodes.length / 2
        while (i--) {
            e.current = nodes[i * 2 + 1]
            try { nodes[i * 2]() } catch (a) { console.error(a) }
            if (unPrevent && !e.returnValue) {
                unPrevent = false
                if ('preventDefault' in e) e.preventDefault()
            }
            if (e.canceled) break
        }
        e = null
        nodes = null
        target = null
    }""")
    val rootNode = DataNodeBlock(null, block)
    var node = rootNode as BaseNode?
    loop@ while (node != null) {
        when (node) {
            is E -> {
                val elm = renderNewElement(node.attr, node.type, eventProxy)
                node.unsafeCast<HasElm>().elm = elm
                elm.unsafeCast<NodeToSarla>().sarla = node
            }
            is D -> { // ElementNode
                val elm = renderNewElement(node.attr, node.type, eventProxy)
                node.unsafeCast<HasElm>().elm = elm
                elm.unsafeCast<NodeToSarla>().sarla = node
                @Suppress("SMARTCAST_IMPOSSIBLE")
                if (node.renderFunc != null) node.(node.renderFunc)()
            }
            is S<*, *> -> @Suppress("UNUSED_VARIABLE") {
                val p = provider
                val clazz = node.clazz.js.asDynamic()
                val sarla = (if (node.hasProp) js("new clazz(p, node.props)") else js("new clazz(p)")).unsafeCast<Sarla>()
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
                @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
                node.(node.renderFunc)()
                node.unsafeCast<HasElm>().elm = createFragmentElement()
            }
            is NodeBlock -> {
                @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
                node.unsafeCast<HasElm>().elm = createFragmentElement()
            }
            is T -> { // Text
                node.elm = createStringElement(node.value)
            }
            is N -> { // Comment
                node.elm = createCommentElement()
            }
            else -> console.log(node)
        }
        val tempNode = node.unsafeCast<NodeBlock>()
        @Suppress("UNNECESSARY_SAFE_CALL")
        if (tempNode.start?.next != null) {
            node = tempNode.start.next
            continue
        }
        // 光头节点
        node.parent.unsafeCast<HasElm>().elm.appendChild(node.unsafeCast<HasElm>().elm)
        @Suppress("UNSAFE_CALL")
        if (node.next == null) {
            var curr = node.parent
            var d = curr?.parent
            while (d != null) {
                d.unsafeCast<HasElm?>()?.elm.appendChild(curr.unsafeCast<HasElm>().elm)
                if (curr.next != null) break
                curr = d
                d = d.parent
            }
            node = curr?.next
        } else node = node.next
    }
    root.appendChild(rootNode.unsafeCast<HasElm>().elm)
    return data
}
