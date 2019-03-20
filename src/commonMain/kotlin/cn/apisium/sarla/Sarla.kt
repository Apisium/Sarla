@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package cn.apisium.sarla

import cn.apisium.sarla.dom.BaseSyntheticEvent
import cn.apisium.sarla.dom.CSSProperties
import cn.apisium.sarla.dom.DocumentFragment
import cn.apisium.sarla.dom.HTMLAttributes
import cn.apisium.sarla.nodes.DataNodeBlock
import cn.apisium.sarla.nodes.NodeBlock
import kotlin.reflect.KClass

@DslMarker
annotation class SarlaDsl

expect abstract class Sarla(provider: Provider) {
    val provider: Provider
    val store: Data<*>

    abstract fun render(): Nodes

    inline fun h(noinline block: Nodes): Nodes
    inline fun h(void: Int, noinline block: DataNodes): DataNodes

    inline fun <T> inject(fn: (provider: Provider) -> T): T
    inline fun effect(type: Int = 0, block: () -> Unit)
    inline fun <T: Any> data(value: T): Data<T>
}

typealias Attr <T> = T.() -> Unit
typealias DataNodes = DataNodeBlock.() -> Unit
typealias Nodes = NodeBlock.() -> Unit

expect class Provider {
    val store: Data<*>
    fun notify(data: Data<*>)
    fun notify(nodes: DataNodeBlock)
    fun notify(sarla: Sarla)
}

abstract class SarlaProp<T>(provider: Provider, val props: T): Sarla(provider)

expect class SarlaInstant <T: Sarla>(clazz: KClass<T>)

inline fun <T: Sarla> pack(clazz: KClass<T>) = SarlaInstant(clazz)
inline fun <P, T: SarlaProp<P>> pack(clazz: KClass<T>) = SarlaInstant(clazz)

class SarlaInlineInstant(block: Sarla.() -> Nodes)
class SarlaInlineInstantProp<P>(block: Sarla.() -> Nodes)

fun sarla(block: Sarla.() -> Nodes) = SarlaInlineInstant(block)
fun <P> sarla(block: Sarla.() -> Nodes) = SarlaInlineInstantProp<P>(block)

const val PRE_INSERT = 1
const val POST_INSERT = 2
const val PRE_REMOVE = 4
const val POST_REMOVE = 8
const val SHOULD_PATCH = 16
const val PRE_RENDER = 32
const val POST_RENDER = 64

expect inline fun HTMLAttributes<*>.style(block: CSSProperties.() -> Unit)
inline fun BaseSyntheticEvent<*, *, *>.stopPropagation() { canceled = true }
inline fun BaseSyntheticEvent<*, *, *>.preventDefault() { returnValue = false }

expect operator fun <T: Any> Data<T>.invoke(): T
expect operator fun Data<Int>.inc(): Data<Int>
expect operator fun Data<Int>.dec(): Data<Int>

interface EffectPreInsert { fun preInsert (elm: DocumentFragment) }
interface EffectPostInsert { fun postInsert (elm: DocumentFragment) }
interface EffectPreRemove { fun preRemove (elm: DocumentFragment) }
interface EffectPostRemove { fun postRemove () }
interface EffectShouldPatch { fun shouldPatch () }
interface EffectPreRender { fun preRender () }
interface EffectPostRender { fun postRender () }
