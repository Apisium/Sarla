package cn.apisium.sarla.utils

expect class NativeObject <K, V> {
    inline operator fun get(key: K?): V?
    inline operator fun set(key: K?, value: V?)
}