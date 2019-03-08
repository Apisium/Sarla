package sample

import cn.apisium.sarla.*

private class TestImpl(p: Provider): Sarla(p) {
    override fun render() = h {
        a({ href = "hhh"})
    }
}

class M <K, V> (b: Map<K, V>): Map<K, V> by b
private val Test = pack(TestImpl::class)

fun main(args: Array<String>) {
    render {
        div({ style { color = "red" } }) { +"Hello World!" }
    }
}

expect fun log(vararg args: Any)