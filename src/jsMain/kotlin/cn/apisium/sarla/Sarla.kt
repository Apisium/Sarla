package cn.apisium.sarla

import cn.apisium.sarla.dom.CSSProperties
import cn.apisium.sarla.dom.HTMLAttributes
import cn.apisium.sarla.nodes.NodeBlock

actual abstract class Renderable {
    private var nodes: NodeBlock? = null
    actual abstract fun render(): NodeBlock
    actual fun h(block: Nodes): NodeBlock {
        var n = nodes
        if (n == null) {
            n = NodeBlock()
            nodes = n
        } else n.clear()
        n.block()
        return n
    }
}

actual inline fun HTMLAttributes<*>.style(block: CSSProperties.() -> Unit) {
    val style = js("{}").unsafeCast<CSSProperties>()
    style.block()
    this.asDynamic().style = style
}
