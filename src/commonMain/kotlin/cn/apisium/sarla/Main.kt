@file:Suppress("DEPRECATION")

package cn.apisium.sarla

import cn.apisium.sarla.dom.Element
import cn.apisium.sarla.dom.getElementById

expect fun <G: Any> render(
    store: G,
    root: Element = getElementById("root") ?: throw NullPointerException("Root node is null!"),
    block: Nodes
): Data<G>

fun render(
    root: Element = getElementById("root") ?: throw NullPointerException("Root node is null!"),
    block: Nodes
): Data<Any> = render(object {}, root, block)
