package cn.apisium.sarla.nodes

import cn.apisium.sarla.*
import cn.apisium.sarla.dom.HTMLAttributes
import kotlin.reflect.KClass

abstract class Node(val parent: Node?) {
    var next: Node? = null
}

@JsName("n")
class NullNode(parent: Node?): Node(parent)
@JsName("s")
class SarlaNode <T: Sarla, P>(parent: Node?, val clazz: KClass<T>,
                              val props: P, val nodes: Nodes?, val hasProp: Boolean): Node(parent)
@JsName("t")
class StringNode(parent: Node?, val value: String): Node(parent)
@JsName("e")
class ElementNode(parent: Node?, val type: String, val nodes: NodeBlock?, val attr: Any?): Node(parent)
