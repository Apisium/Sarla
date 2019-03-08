package cn.apisium.sarla.utils

expect class NativeArray <T>() {
    inline fun length(): Int
    inline fun clear()
    inline fun add(element: T)
    inline fun forEach(fn: (it: T) -> Unit)

    inline operator fun get(key: Int): T?
}