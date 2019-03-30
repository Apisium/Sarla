package cn.apisium.sarla.utils

external interface Iterator <T> {
    val done: Boolean
    val value: T
}

external interface Iterable <T> {
    fun next(): Iterator<T>
}

@JsName("Set")
external class NativeSet <T> {
    val size: Int
    fun clear()
    fun add(obj: T)
    fun delete(obj: T)
    fun forEach(callback: (T) -> Unit)
    fun values(): Iterable<T>
}
