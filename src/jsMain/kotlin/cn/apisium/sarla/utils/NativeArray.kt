@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package cn.apisium.sarla.utils

actual class NativeArray<T> {
    var arr = js("[]")
    actual inline fun length() = arr.length.unsafeCast<Int>()
    actual inline fun clear() { arr = js("[]") }
    actual inline fun add(element: T) = arr.push(element).unsafeCast<Int>()
    actual inline fun add(a: T, b: T) = arr.push(a, b).unsafeCast<Int>()
    actual inline fun forEach(fn: (T) -> Unit) {
        val len = length()
        var i = 0
        while (i < len) fn(arr[i++])
    }
    actual inline fun forEachIndexed(fn: (T, Int) -> Unit) {
        val len = length()
        var i = 0
        while (i < len) fn(arr[i], i++)
    }

    actual inline operator fun get(key: Int): T? = arr[key]
}
