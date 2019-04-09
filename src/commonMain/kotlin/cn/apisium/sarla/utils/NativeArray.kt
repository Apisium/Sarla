package cn.apisium.sarla.utils

expect class NativeArray <T>() {
    inline fun length(): Int
    inline fun clear()
    inline fun add(element: T): Int
    inline fun add(a: T, b: T): Int
    inline fun forEach(fn: (T) -> Unit)
    inline fun forEachIndexed(fn: (T, Int) -> Unit)

    inline operator fun get(key: Int): T?
}