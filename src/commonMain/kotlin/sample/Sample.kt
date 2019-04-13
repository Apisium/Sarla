package sample

import cn.apisium.sarla.awesome
import cn.apisium.sarla.render
import cn.apisium.sarla.sarla

val component = sarla {
    val str = data("")
    h {
        div(0) { +"Typed: ${str()}" }
        input(str)
        awesome()
    }
}

fun main() {
    render {
        component()
    }
}

//private class TestImpl(p: Provider): Sarla(p), EffectPreInsert {
//    var times = data(0)
//    override fun preInsert(elm: DocumentFragment) {
//        log(elm)
//    }
//
//    override fun render() = h {
//        div(0, { style { color = "red" } }) { +times }
//        div {
//            button({ onClick = { times++ } }) { +"Click This!" }
//        }
//    }
//}
//
//private val Test = pack(TestImpl::class)

expect fun log(vararg args: Any)