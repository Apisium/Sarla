@file:Suppress("NOTHING_TO_INLINE")

package cn.apisium.sarla.utils

actual class NativeArray<T> {
    var arr = js("[]")
    actual inline fun length() = arr.length.unsafeCast<Int>()
    actual inline fun clear() { arr = js("[]") }
    actual inline fun add(element: T) {
        arr.push(element)
    }
    actual inline fun forEach(fn: (it: T) -> Unit) {
        val len = length()
        var i = 0
        while (i < len) fn(arr[i++])
    }

    actual inline operator fun get(key: Int): T? = arr[key]

}