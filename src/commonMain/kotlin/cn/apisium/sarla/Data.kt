package cn.apisium.sarla

expect class Data <T: Any> internal constructor(value: T, provider: Provider) {
    operator fun invoke(value: T)
}

fun Symbol(name: String) = "$name\$${kotlin.math.abs(name.hashCode())}"
