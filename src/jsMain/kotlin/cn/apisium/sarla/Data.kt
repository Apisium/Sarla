package cn.apisium.sarla

import cn.apisium.sarla.nodes.DataNodeBlock
import cn.apisium.sarla.utils.NativeObject
import cn.apisium.sarla.utils.NativeSet

actual class Data<T: Any> @PublishedApi internal actual constructor(var value: T, val provider: Provider) {
    var nodes = NativeSet<DataNodeBlock>()
    var caches = NativeObject<Any, Data<*>>()

    actual operator fun invoke(value: T): Data<T> {
        this.value = value
        provider.notify(this)
        return this
    }

    actual override fun toString(): String = throw Exception("Should not call toString.")
}
