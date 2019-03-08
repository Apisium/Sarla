@file:Suppress("DEPRECATION")

package cn.apisium.sarla

import cn.apisium.sarla.dom.Element
import cn.apisium.sarla.dom.getElementById
import cn.apisium.sarla.nodes.NodeBlock

typealias Nodes = NodeBlock.() -> Unit

expect fun <T: Any> render(
    store: T,
    root: Element = getElementById("root") ?: throw NullPointerException("Root node is null!"),
    block: Nodes
): Data<T>

fun render(
    root: Element = getElementById("root") ?: throw NullPointerException("Root node is null!"),
    block: Nodes
): Data<Any> = render(object {}, root, block)
