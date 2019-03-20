package cn.apisium.sarla

import cn.apisium.sarla.dom.CSSProperties
import cn.apisium.sarla.dom.HTMLAttributes
import kotlin.reflect.KClass

@Suppress("NOTHING_TO_INLINE")
actual abstract class Sarla actual constructor(actual val provider: Provider) {
    actual val store = provider.store

    actual abstract fun render(): Nodes

    actual inline fun effect(type: Int, block: () -> Unit) = Unit

    actual inline fun h(noinline block: Nodes) = block
    actual inline fun h(void: Int, noinline block: DataNodes) = block

    actual inline fun <T> inject(fn: (provider: Provider) -> T) = fn(provider)
    actual inline fun <T : Any> data(value: T) = Data(value, provider)
}

actual inline fun HTMLAttributes<*>.style(block: CSSProperties.() -> Unit) {
    val style = js("new Object").unsafeCast<CSSProperties>()
    style.block()
    this.asDynamic().style = style
}
@Suppress("UNUSED_VARIABLE")
actual class SarlaInstant <T: Sarla> actual constructor(val clazz: KClass<T>) {
    init {
        val d = clazz.js
        js("""
            var c = d.prototype
            d.flags = (typeof c.preInsert === 'function' && 1) |
                (typeof c.postInsert === 'function' && 2) |
                (typeof c.preRemove === 'function' && 4) |
                (typeof c.postRemove === 'function' && 8) |
                (typeof c.shouldPatch === 'function' && 16) |
                (typeof c.preRender === 'function' && 32) |
                (typeof c.postRender === 'function' && 64)
            c = null
        """)
    }
}

actual operator fun <T: Any> Data<T>.invoke() = value
actual operator fun Data<Int>.inc(): Data<Int> {
    value++
    provider.notify(this)
    return this
}
actual operator fun Data<Int>.dec(): Data<Int> {
    value--
    provider.notify(this)
    return this
}
