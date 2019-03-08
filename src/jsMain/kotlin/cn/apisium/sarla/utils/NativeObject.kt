@file:Suppress("NOTHING_TO_INLINE")

package cn.apisium.sarla.utils

actual class NativeObject<K, V> {
    actual inline operator fun get(key: K?) = asDynamic()[key].unsafeCast<V?>()
    actual inline operator fun set(key: K?, value: V?) { asDynamic()[key] = value }
}