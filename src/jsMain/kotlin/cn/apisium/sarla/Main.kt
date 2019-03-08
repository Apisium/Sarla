@file:Suppress("DEPRECATION")

package cn.apisium.sarla

import cn.apisium.sarla.dom.Element
import cn.apisium.sarla.dom.createFragmentElement
import cn.apisium.sarla.nodes.ElementNode
import cn.apisium.sarla.nodes.Node
import cn.apisium.sarla.nodes.NodeBlock
import cn.apisium.sarla.nodes.SarlaNode
import cn.apisium.sarla.utils.Utils
import cn.apisium.sarla.dom.Node as DomNode

actual fun <T: Any> render(store: T, root: Element, block: Nodes): Data<T> {
    val data = Data(store)
    val provider = object: Provider {
        override val store = data
    }
    @Suppress("UNUSED_VARIABLE")
    val assign = Utils.assign
    js("console.log(assign)")
    val rootNode = NodeBlock(null, block)
    rootNode.block()
    var node = rootNode as Node?
    var elm: DomNode
    while (node != null) {
        when (node) {
            is NodeBlock -> {
                val elm = createFragmentElement()
                if (node.head != null) {

                }
            }
            is ElementNode -> {

            }
        }
        if (node.next == null) node = node.parent
    }/*
    node.nodes.forEach {
        when (it) {
            is SarlaNode<*, *> -> {
                val p = provider
                val clazz = it.clazz.js
                val sarla = if (it.hasProp) {
                    val props = it.props
                    js("new clazz(p, props)").unsafeCast<Sarla>()
                } else js("new clazz(p)").unsafeCast<Sarla>()
                sarla.render()
                null
            }
            is ElementNode -> {
                js("""
                    var attr = it.attr, elm = document.createElement(it.type)
                    if (attr == null);
                    else if (typeof attr === 'string') elm.className = attr
                    else for (var name in attr) switch (name) {
                        case 'key': case 'renderFunc': break
                        case 'className': elm.className = attr.className; break
                        case 'innerHTML': elm.innerHTML = attr.innerHTML; break
                        case 'style': if(!('styleText' in attr)) assign(elm.style, attr.style); break
                        case 'styleText': elm.style.styleText = attr.styleText; break
                        default: elm.setAttribute(name, attr[name])
                    }
                """)
                null
            }
        }
    }*/
    console.log(root)
    return data
}
