@file:Suppress("NOTHING_TO_INLINE")

package cn.apisium.sarla

import cn.apisium.sarla.dom.CSSProperties
import cn.apisium.sarla.dom.HTMLAttributes
import cn.apisium.sarla.nodes.NodeBlock
import sample.log
import kotlin.reflect.KClass

@DslMarker
annotation class SarlaDsl

abstract class Sarla(val provider: Provider): Renderable() {
    val store = provider.store

    inline fun <T> inject(fn: (provider: Provider) -> T) = fn(provider)
}

typealias Attr <T> = T.() -> Unit

expect abstract class Renderable() {
    abstract fun render(): NodeBlock
    fun h(block: Nodes): NodeBlock
}

interface Provider {
    val store: Data<*>
}

abstract class SarlaProp<T>(provider: Provider, val props: T): Sarla(provider)

private interface SarlaInstant

class SarlaInstantNoProp <T: Sarla>(val clazz: KClass<T>): SarlaInstant
class SarlaInstantProp <T: Sarla>(val clazz: KClass<T>): SarlaInstant

inline fun <T: Sarla> pack(clazz: KClass<T>) = SarlaInstantNoProp(clazz)
inline fun <P, T: SarlaProp<P>> pack(clazz: KClass<T>) = SarlaInstantProp(clazz)

expect inline fun HTMLAttributes<*>.style(block: CSSProperties.() -> Unit)
