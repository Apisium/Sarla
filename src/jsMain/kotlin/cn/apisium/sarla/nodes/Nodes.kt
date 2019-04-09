@file:Suppress("DEPRECATION", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT", "UNUSED")

package cn.apisium.sarla.nodes

import cn.apisium.sarla.DataNodes
import cn.apisium.sarla.Nodes
import cn.apisium.sarla.Sarla
import cn.apisium.sarla.dom.*
import kotlin.reflect.KClass

abstract class BaseNode(val parent: BaseNode?) {
    @JsName("n")
    var next: BaseNode?
}

external interface HasAttr<T: HTMLAttributes<Q>, Q: Element> {
    var attr: T?
    var style: CSSProperties?
    var prop: Props?
    var event: DOMEvents<Q>?
    val type: String
    val className: String?
}

/*
NULL: 0
SARLA: 1
INLINE: 2
TEXT: 3
DATA: 4
ELEMENT: 5
NODES: 6
DATA_NODES: 7
 */

class N(parent: BaseNode?): BaseNode(parent) {
    var elm: Comment
    val kind = 0
}
class S <T: Sarla, P>(parent: BaseNode?, val clazz: KClass<T>,
                      val props: P, val nodes: Any?, val hasProp: Boolean): DataNodeBlock(parent, null) {
    var instant: Sarla
    val kind = 1
}
class I <T: Sarla, P>(parent: BaseNode?, val block: T.() -> Nodes,
                      val props: P, val nodes: Any?, val hasProp: Boolean): DataNodeBlock(parent, null) {
    var instant: Sarla
    val kind = 2
}
class T(parent: BaseNode?, var value: String): BaseNode(parent) {
    var elm: Text
    val kind = 3
}
@Suppress("SMARTCAST_IMPOSSIBLE")
actual class D <A: HTMLAttributes<Q>, Q: Element>(parent: NodeBlock?, val type: String, val className: String?, renderFunc: D<A, Q>.() -> Unit): DataNodeBlock(parent, renderFunc.unsafeCast<DataNodes>()) {
    val kind = 4
    var attr: A?
    var style: CSSProperties?
    var prop: Props?
    var event: DOMEvents<Q>?
    actual inline fun attributes(block: A.() -> Unit) {
        attr = js("new Object").unsafeCast<A>()
        attr.block()
    }
    actual inline fun styles(block: CSSProperties.() -> Unit) {
        style = js("new Object").unsafeCast<CSSProperties>()
        style.block()
    }
    actual inline fun props(block: Props.() -> Unit) {
        prop = js("new Object").unsafeCast<Props>()
        prop.block()
    }
    actual inline fun events(block: DOMEvents<Q>.() -> Unit) {
        event = js("new Object").unsafeCast<DOMEvents<Q>>()
        event.block()
    }
}

@Suppress("SMARTCAST_IMPOSSIBLE")
actual class E <A: HTMLAttributes<Q>, Q: Element>(parent: NodeBlock?, val type: String, val className: String?): NodeBlock(parent) {
    val kind = 5
    var attr: A?
    var style: CSSProperties?
    var prop: Props?
    var event: DOMEvents<Q>?
    actual inline fun attributes(block: A.() -> Unit) {
        attr = js("new Object").unsafeCast<A>()
        attr.block()
    }
    actual inline fun styles(block: CSSProperties.() -> Unit) {
        style = js("new Object").unsafeCast<CSSProperties>()
        style.block()
    }
    actual inline fun props(block: Props.() -> Unit) {
        prop = js("new Object").unsafeCast<Props>()
        prop.block()
    }
    actual inline fun events(block: DOMEvents<Q>.() -> Unit) {
        event = js("new Object").unsafeCast<DOMEvents<Q>>()
        event.block()
    }
}
