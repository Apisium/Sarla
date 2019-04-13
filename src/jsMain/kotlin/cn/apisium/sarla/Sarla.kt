package cn.apisium.sarla

import cn.apisium.sarla.nodes.NodeBlock
import kotlin.reflect.KClass

@Suppress("NOTHING_TO_INLINE", "UNUSED")
actual abstract class Sarla actual constructor(actual val provider: Provider) {
    actual val store = provider.store

    actual abstract fun render(): Nodes

    actual inline fun effect(type: Int, block: () -> Unit) = Unit

    actual inline fun h(noinline block: Nodes) = block
    actual inline fun h(void: Int, noinline block: DataNodes) = block

    actual inline fun <T> inject(fn: (provider: Provider) -> T) = fn(provider)
    actual inline fun <T : Any> data(value: T) = Data(value, provider)
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

actual class SarlaInlineInstant<T: Sarla> actual constructor(val block: T.() -> Nodes)
class SarlaInlineImpl(provider: Provider, block: Sarla.() -> Nodes): Sarla(provider) {
    val nodes = this.block()
    override fun render() = nodes
}

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

@Suppress("NOTHING_TO_INLINE", "UNUSED")
actual inline fun NodeBlock.awesome() { div {
    span {
        styles {
            color = "transparent"
            webkitBackgroundClip = "text"
            backgroundImage = "linear-gradient(135deg,#667eea 0%,#764ba2 100%)"
        }
        +"Sarla is awesome, your code will be like poetry "
    }
    +"\uD83D\uDCDC"
} }
