package cn.apisium.sarla.utils

@JsName("Set")
external class NativeSet <T> {
    val size: Int
    fun add(obj: T)
    fun forEach(callback: (T) -> Unit)
}
