package cn.apisium.sarla

expect class Data <T: Any> (data: T) {
    val data: T
    operator fun invoke(): T
}
