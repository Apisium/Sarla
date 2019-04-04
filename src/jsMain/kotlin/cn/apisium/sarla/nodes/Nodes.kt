@file:Suppress("DEPRECATION", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNUSED")

package cn.apisium.sarla.nodes

import cn.apisium.sarla.DataNodes
import cn.apisium.sarla.Nodes
import cn.apisium.sarla.Sarla
import cn.apisium.sarla.dom.CSSProperties
import cn.apisium.sarla.dom.Comment
import cn.apisium.sarla.dom.HTMLAttributes
import cn.apisium.sarla.dom.Text
import kotlin.reflect.KClass

abstract class BaseNode(val parent: BaseNode?) {
    @JsName("n")
    var next: BaseNode?
}

external interface HasAttr<T: HTMLAttributes<*>> {
    var attr: T?
    var style: CSSProperties?
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
private external val NULL: String = definedExternally
actual class D <A: HTMLAttributes<*>>(parent: NodeBlock?, val type: String, val className: String? = NULL, renderFunc: D<A>.() -> Unit): DataNodeBlock(parent, renderFunc.unsafeCast<DataNodes>()), HasAttr<A> {
    override var attr: A?
    override var style: CSSProperties?
    actual inline fun attributes(block: A.() -> Unit) {
        attr = js("new Object").unsafeCast<A>()
        @Suppress("SMARTCAST_IMPOSSIBLE")
        attr.block()
    }
    actual inline fun styles(block: CSSProperties.() -> Unit) {
        style = js("new Object").unsafeCast<CSSProperties>()
        @Suppress("SMARTCAST_IMPOSSIBLE")
        style.block()
    }
}

actual class E <A: HTMLAttributes<*>>(parent: NodeBlock?, val type: String, val className: String? = NULL): NodeBlock(parent), HasAttr<A> {
    override var attr: A?
    override var style: CSSProperties?
    actual inline fun attributes(block: A.() -> Unit) {
        attr = js("new Object").unsafeCast<A>()
        @Suppress("SMARTCAST_IMPOSSIBLE")
        attr.block()
    }
    actual inline fun styles(block: CSSProperties.() -> Unit) {
        style = js("new Object").unsafeCast<CSSProperties>()
        @Suppress("SMARTCAST_IMPOSSIBLE")
        style.block()
    }
}
