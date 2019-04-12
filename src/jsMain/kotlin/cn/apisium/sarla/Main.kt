@file:Suppress("DEPRECATION")

package cn.apisium.sarla

import cn.apisium.sarla.dom.*
import cn.apisium.sarla.nodes.*

external interface HasElm {
    var elm: Node
}

actual fun <G: Any> render(store: G, root: Element, block: Nodes): Data<G> {
    val eventProxy = createEventProxy(root)
    @Suppress("NULL_FOR_NONNULL_TYPE")
    val provider = Provider(null, eventProxy)
    val data = Data(store, provider)
    provider.eventProxy
    provider.asDynamic().store = data
    val rootNode = DataNodeBlock(null, block)
    rootNode.id = ""
    var node = rootNode.unsafeCast<BaseNode?>()
    loop@ while (node != null) {
        val parent = node.parent.unsafeCast<NodeBlock?>()
        when (node.asDynamic().kind.unsafeCast<Int>()) {
            0 -> { // Comment
                node.unsafeCast<N>().elm = createCommentElement()
                if (parent != null) parent.currentId++
            }
            1 -> @Suppress("UNUSED_VARIABLE") { // Sarla
                node = node.unsafeCast<S<*, *>>()
                @Suppress("UNSAFE_CALL")
                node.id = parent.id + "," + parent.currentId++
                val clazz = node.clazz.js.asDynamic()
                val sarla = (if (node.hasProp) js("new clazz(provider, node.props)") else js("new clazz(provider)")).unsafeCast<Sarla>()
                val flags = clazz.flags.unsafeCast<Int>()
                node.instant = sarla
                if (flags and 32 == 32) node.unsafeCast<EffectPreRender>().preRender()
                node.(sarla.render())()
                if (flags and 64 == 64) node.unsafeCast<EffectPostRender>().postRender()
                val elm = createFragmentElement()
                node.unsafeCast<HasElm>().elm = elm
                if (flags and 1 == 1) node.unsafeCast<EffectPreInsert>().preInsert(elm)
            }
            2 -> { // Inline
                node = node.unsafeCast<I<*, *>>()
                @Suppress("UNSAFE_CALL")
                node.id = parent.id + "," + parent.currentId++
                val sarla = SarlaInlineImpl(provider, node.block.unsafeCast<Sarla.() -> Nodes>())
                node.instant = sarla
                node.(sarla.nodes)()
                val elm = createFragmentElement()
                node.unsafeCast<HasElm>().elm = elm
            }
            3 -> { // Text
                node = node.unsafeCast<T>()
                node.elm = createStringElement(node.value)
                if (parent != null) parent.currentId++
            }
            4 -> { // DataElementNode
                node = node.unsafeCast<D<*, *>>()
                @Suppress("SMARTCAST_IMPOSSIBLE")
                if (node.renderFunc != null) node.(node.renderFunc)()
                val elm = renderNewElement(node, eventProxy)
                node.unsafeCast<HasElm>().elm = elm
                @Suppress("UNSAFE_CALL")
                node.id = parent.id + "," + parent.currentId++
            }
            5 -> { // ElementNode
                val elm = renderNewElement(node.unsafeCast<E<*, *>>(), eventProxy)
                node.unsafeCast<HasElm>().elm = elm
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
                if (parent != null) node.id = parent.id + "," + parent.currentId++
                @Suppress("UNSAFE_IMPLICIT_INVOKE_CALL")
                node.(node.renderFunc)()
                node.unsafeCast<HasElm>().elm = createFragmentElement()
            }
            else -> throw ClassCastException(node::class.simpleName)
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
                d.unsafeCast<NodeBlock>().currentId = 0
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
