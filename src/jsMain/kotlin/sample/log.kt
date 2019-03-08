package sample

actual fun log(vararg args: Any) {
    js("console.log.apply(null, args)")
}