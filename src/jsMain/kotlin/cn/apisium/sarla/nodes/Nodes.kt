@file:Suppress("DEPRECATION", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNUSED")

package cn.apisium.sarla.nodes

import cn.apisium.sarla.DataNodes
import cn.apisium.sarla.Nodes
import cn.apisium.sarla.Sarla
import cn.apisium.sarla.dom.Comment
import cn.apisium.sarla.dom.Text
import kotlin.reflect.KClass

abstract class BaseNode(val parent: BaseNode?) {
    @JsName("n")
    var next: BaseNode?
}

class N(parent: BaseNode?): BaseNode(parent) {
    var elm: Comment
}
class S <T: Sarla, P>(parent: BaseNode?, val clazz: KClass<T>,
                      val props: P, val nodes: Any?, val hasProp: Boolean): DataNodeBlock(parent, null) {
    var instant: Sarla
}
class I <T: Sarla, P>(parent: BaseNode?, val block: T.() -> Nodes,
                      val props: P, val nodes: Any?, val hasProp: Boolean): DataNodeBlock(parent, null) {
    var instant: Sarla
}
class T(parent: BaseNode?, var value: String): BaseNode(parent) {
    var elm: Text
}
class D(parent: BaseNode?, val type: String, renderFunc: DataNodes?, val attr: Any?): DataNodeBlock(parent, renderFunc)
class E(parent: BaseNode?, val type: String, val attr: Any?): NodeBlock(parent)
