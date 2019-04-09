package cn.apisium.sarla.nodes

import cn.apisium.sarla.Data

@Suppress("NOTHING_TO_INLINE", "UNUSED_VARIABLE")
actual open class DataNodeBlock(parent: BaseNode?, var renderFunc: (DataNodeBlock.() -> Unit)?) : NodeBlock(parent) {
    init {
        asDynamic().kind = 7
    }
    actual operator fun <T: Any> Data<T>.get(key: Any): Data<T> {
        this.nodes.add(this@DataNodeBlock)
        var d = caches[key]
        if (d === null) {
            d = Data(value.asDynamic()[key], provider)
            caches[key] = d
        }
        return d.unsafeCast<Data<T>>()
    }
    actual operator fun <T: Any> Data<T>.invoke(): T {
        nodes.add(this@DataNodeBlock)
        return value
    }
    //actual inline operator fun Data<*>.get(key: Any): Data<*> = this.unsafeCast<Data<Any>>().get<Any>(key).unsafeCast<Data<*>>()
    //actual inline operator fun Data<*>.invoke(): Any = this.unsafeCast<Data<Any>>().invoke<Any>()
    actual inline operator fun <T: Number> Data<T>.plus(value: T): T {
        nodes.add(this@DataNodeBlock)
        val v = this.value
        return js("v + value").unsafeCast<T>()
    }

    actual inline operator fun <T: Number> Data<T>.unaryPlus() {
        nodes.add(this@DataNodeBlock)
        val v = value
        append(T(this@DataNodeBlock, js("'' + v").unsafeCast<String>()))
    }
}
