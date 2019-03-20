package sample

import cn.apisium.sarla.*
import cn.apisium.sarla.dom.DocumentFragment

val fuck = sarla {
    var times = data(0)
    val loading = data(false)
    effect {
        // Do sth...
        loading(true)
    }
    h {
        button({ onClick = { times++ } }) { +"Click me!" }
        div(0) {
            if (loading()) +"Loading..."
            else +times()
        }
    }
}

private class TestImpl(p: Provider): Sarla(p), EffectPreInsert {
    override fun preInsert(elm: DocumentFragment) {
        log(elm)
    }

    override fun render() = h {
        a({ href = "hhh"}) {}
        div({ style { color = "red" } }) { +"Hello World!" }
        div {
            button({ onClick = { println(233) } }) { +"Click This!" }
        }
    }
}

private val Test = pack(TestImpl::class)

fun main() {
    render {
        Test()
    }
}

expect fun log(vararg args: Any)