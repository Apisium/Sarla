package cn.apisium.sarla.nodes

import cn.apisium.sarla.Data
import cn.apisium.sarla.DataNodes

@Suppress("NOTHING_TO_INLINE")
actual open class DataNodeBlock(parent: BaseNode?, var renderFunc: DataNodes?): NodeBlock(parent) {
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
    actual inline operator fun Data<Int>.plus(value: Int): Int {
        nodes.add(this@DataNodeBlock)
        return this.value + value
    }
}
