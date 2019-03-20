@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION", "UNUSED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT")

package cn.apisium.sarla.nodes

import cn.apisium.sarla.*
import cn.apisium.sarla.dom.*

actual open class NodeBlock(parent: BaseNode? = null): BaseNode(parent) {
    val start = js("{}").unsafeCast<NodeBlock>()
    @JsName("e")
    var end = start
    var elm: DocumentFragment

    @Suppress("UNUSED_PARAMETER")
    inline fun append(n: BaseNode) {
        js("this.e = this.e.n = n")
    }

    inline fun tag(tagName: String, attr: Any?, noinline block: DataNodes?) {
        append(D(this, tagName, block, attr))
    }

    actual inline operator fun String.unaryPlus() {
        append(T(this@NodeBlock, this))
    }

    actual inline operator fun Number.unaryPlus() {
        append(T(this@NodeBlock, this.toString()))
    }

    actual inline operator fun Nothing.unaryPlus() {
        append(N(this@NodeBlock))
    }

    actual inline operator fun Unit.unaryPlus() {
        append(N(this@NodeBlock))
    }

    actual inline operator fun <P, T: SarlaProp<P>> SarlaInstant<T>.invoke(props: P?, noinline block: Nodes?) {
        append(S(this@NodeBlock, this.clazz, props, block, true))
    }

    actual inline operator fun <T: Sarla> SarlaInstant<T>.invoke(noinline block: Nodes?) {
        append(S(this@NodeBlock, this.clazz, null, block, false))
    }

    actual inline operator fun <P, T: SarlaProp<P>> SarlaInstant<T>.invoke(void: Int, props: P?, noinline block: DataNodes?) {
        append(S(this@NodeBlock, this.clazz, props, block, true))
    }

    actual inline operator fun <T: Sarla> SarlaInstant<T>.invoke(void: Int, noinline block: DataNodes?) {
        append(S(this@NodeBlock, this.clazz, null, block, false))
    }

    actual inline fun a(void: Int, className: String?, noinline block: DataNodes?) { tag("a", className, block) }
    actual inline fun address(void: Int, className: String?, noinline block: DataNodes?) { tag("address", className, block) }
    actual inline fun area(void: Int, className: String?, noinline block: DataNodes?) { tag("area", className, block) }
    actual inline fun article(void: Int, className: String?, noinline block: DataNodes?) { tag("article", className, block) }
    actual inline fun aside(void: Int, className: String?, noinline block: DataNodes?) { tag("aside", className, block) }
    actual inline fun audio(void: Int, className: String?, noinline block: DataNodes?) { tag("audio", className, block) }
    actual inline fun b(void: Int, className: String?, noinline block: DataNodes?) { tag("b", className, block) }
    actual inline fun base(void: Int, className: String?, noinline block: DataNodes?) { tag("base", className, block) }
    actual inline fun bdi(void: Int, className: String?, noinline block: DataNodes?) { tag("bdi", className, block) }
    actual inline fun bdo(void: Int, className: String?, noinline block: DataNodes?) { tag("bdo", className, block) }
    actual inline fun big(void: Int, className: String?, noinline block: DataNodes?) { tag("big", className, block) }
    actual inline fun blockquote(void: Int, className: String?, noinline block: DataNodes?) { tag("blockquote", className, block) }
    actual inline fun body(void: Int, className: String?, noinline block: DataNodes?) { tag("body", className, block) }
    actual inline fun br(void: Int, className: String?, noinline block: DataNodes?) { tag("br", className, block) }
    actual inline fun button(void: Int, className: String?, noinline block: DataNodes?) { tag("button", className, block) }
    actual inline fun canvas(void: Int, className: String?, noinline block: DataNodes?) { tag("canvas", className, block) }
    actual inline fun caption(void: Int, className: String?, noinline block: DataNodes?) { tag("caption", className, block) }
    actual inline fun cite(void: Int, className: String?, noinline block: DataNodes?) { tag("cite", className, block) }
    actual inline fun code(void: Int, className: String?, noinline block: DataNodes?) { tag("code", className, block) }
    actual inline fun col(void: Int, className: String?, noinline block: DataNodes?) { tag("col", className, block) }
    actual inline fun colgroup(void: Int, className: String?, noinline block: DataNodes?) { tag("colgroup", className, block) }
    actual inline fun data(void: Int, className: String?, noinline block: DataNodes?) { tag("data", className, block) }
    actual inline fun datalist(void: Int, className: String?, noinline block: DataNodes?) { tag("datalist", className, block) }
    actual inline fun dd(void: Int, className: String?, noinline block: DataNodes?) { tag("dd", className, block) }
    actual inline fun del(void: Int, className: String?, noinline block: DataNodes?) { tag("del", className, block) }
    actual inline fun details(void: Int, className: String?, noinline block: DataNodes?) { tag("details", className, block) }
    actual inline fun dfn(void: Int, className: String?, noinline block: DataNodes?) { tag("dfn", className, block) }
    actual inline fun dialog(void: Int, className: String?, noinline block: DataNodes?) { tag("dialog", className, block) }
    actual inline fun div(void: Int, className: String?, noinline block: DataNodes?) { tag("div", className, block) }
    actual inline fun dl(void: Int, className: String?, noinline block: DataNodes?) { tag("dl", className, block) }
    actual inline fun dt(void: Int, className: String?, noinline block: DataNodes?) { tag("dt", className, block) }
    actual inline fun em(void: Int, className: String?, noinline block: DataNodes?) { tag("em", className, block) }
    actual inline fun embed(void: Int, className: String?, noinline block: DataNodes?) { tag("embed", className, block) }
    actual inline fun fieldset(void: Int, className: String?, noinline block: DataNodes?) { tag("fieldset", className, block) }
    actual inline fun figcaption(void: Int, className: String?, noinline block: DataNodes?) { tag("figcaption", className, block) }
    actual inline fun figure(void: Int, className: String?, noinline block: DataNodes?) { tag("figure", className, block) }
    actual inline fun footer(void: Int, className: String?, noinline block: DataNodes?) { tag("footer", className, block) }
    actual inline fun form(void: Int, className: String?, noinline block: DataNodes?) { tag("form", className, block) }
    actual inline fun h1(void: Int, className: String?, noinline block: DataNodes?) { tag("h1", className, block) }
    actual inline fun h2(void: Int, className: String?, noinline block: DataNodes?) { tag("h2", className, block) }
    actual inline fun h3(void: Int, className: String?, noinline block: DataNodes?) { tag("h3", className, block) }
    actual inline fun h4(void: Int, className: String?, noinline block: DataNodes?) { tag("h4", className, block) }
    actual inline fun h5(void: Int, className: String?, noinline block: DataNodes?) { tag("h5", className, block) }
    actual inline fun h6(void: Int, className: String?, noinline block: DataNodes?) { tag("h6", className, block) }
    actual inline fun head(void: Int, className: String?, noinline block: DataNodes?) { tag("start", className, block) }
    actual inline fun header(void: Int, className: String?, noinline block: DataNodes?) { tag("header", className, block) }
    actual inline fun hgroup(void: Int, className: String?, noinline block: DataNodes?) { tag("hgroup", className, block) }
    actual inline fun hr(void: Int, className: String?, noinline block: DataNodes?) { tag("hr", className, block) }
    actual inline fun html(void: Int, className: String?, noinline block: DataNodes?) { tag("html", className, block) }
    actual inline fun i(void: Int, className: String?, noinline block: DataNodes?) { tag("i", className, block) }
    actual inline fun iframe(void: Int, className: String?, noinline block: DataNodes?) { tag("iframe", className, block) }
    actual inline fun img(void: Int, className: String?, noinline block: DataNodes?) { tag("img", className, block) }
    actual inline fun input(void: Int, className: String?, noinline block: DataNodes?) { tag("input", className, block) }
    actual inline fun ins(void: Int, className: String?, noinline block: DataNodes?) { tag("ins", className, block) }
    actual inline fun kbd(void: Int, className: String?, noinline block: DataNodes?) { tag("kbd", className, block) }
    actual inline fun keygen(void: Int, className: String?, noinline block: DataNodes?) { tag("keygen", className, block) }
    actual inline fun label(void: Int, className: String?, noinline block: DataNodes?) { tag("label", className, block) }
    actual inline fun legend(void: Int, className: String?, noinline block: DataNodes?) { tag("legend", className, block) }
    actual inline fun li(void: Int, className: String?, noinline block: DataNodes?) { tag("li", className, block) }
    actual inline fun link(void: Int, className: String?, noinline block: DataNodes?) { tag("link", className, block) }
    actual inline fun main(void: Int, className: String?, noinline block: DataNodes?) { tag("main", className, block) }
    actual inline fun map(void: Int, className: String?, noinline block: DataNodes?) { tag("map", className, block) }
    actual inline fun mark(void: Int, className: String?, noinline block: DataNodes?) { tag("mark", className, block) }
    actual inline fun menu(void: Int, className: String?, noinline block: DataNodes?) { tag("menu", className, block) }
    actual inline fun menuitem(void: Int, className: String?, noinline block: DataNodes?) { tag("menuitem", className, block) }
    actual inline fun meta(void: Int, className: String?, noinline block: DataNodes?) { tag("meta", className, block) }
    actual inline fun meter(void: Int, className: String?, noinline block: DataNodes?) { tag("meter", className, block) }
    actual inline fun nav(void: Int, className: String?, noinline block: DataNodes?) { tag("nav", className, block) }
    actual inline fun noscript(void: Int, className: String?, noinline block: DataNodes?) { tag("noscript", className, block) }
    actual inline fun objectElement(void: Int, className: String?, noinline block: DataNodes?) { tag("object", className, block) }
    actual inline fun ol(void: Int, className: String?, noinline block: DataNodes?) { tag("ol", className, block) }
    actual inline fun optgroup(void: Int, className: String?, noinline block: DataNodes?) { tag("optgroup", className, block) }
    actual inline fun option(void: Int, className: String?, noinline block: DataNodes?) { tag("option", className, block) }
    actual inline fun output(void: Int, className: String?, noinline block: DataNodes?) { tag("output", className, block) }
    actual inline fun p(void: Int, className: String?, noinline block: DataNodes?) { tag("p", className, block) }
    actual inline fun param(void: Int, className: String?, noinline block: DataNodes?) { tag("param", className, block) }
    actual inline fun picture(void: Int, className: String?, noinline block: DataNodes?) { tag("picture", className, block) }
    actual inline fun pre(void: Int, className: String?, noinline block: DataNodes?) { tag("pre", className, block) }
    actual inline fun progress(void: Int, className: String?, noinline block: DataNodes?) { tag("progress", className, block) }
    actual inline fun q(void: Int, className: String?, noinline block: DataNodes?) { tag("q", className, block) }
    actual inline fun rp(void: Int, className: String?, noinline block: DataNodes?) { tag("rp", className, block) }
    actual inline fun rt(void: Int, className: String?, noinline block: DataNodes?) { tag("rt", className, block) }
    actual inline fun ruby(void: Int, className: String?, noinline block: DataNodes?) { tag("ruby", className, block) }
    actual inline fun s(void: Int, className: String?, noinline block: DataNodes?) { tag("s", className, block) }
    actual inline fun samp(void: Int, className: String?, noinline block: DataNodes?) { tag("samp", className, block) }
    actual inline fun script(void: Int, className: String?, noinline block: DataNodes?) { tag("script", className, block) }
    actual inline fun section(void: Int, className: String?, noinline block: DataNodes?) { tag("section", className, block) }
    actual inline fun select(void: Int, className: String?, noinline block: DataNodes?) { tag("select", className, block) }
    actual inline fun small(void: Int, className: String?, noinline block: DataNodes?) { tag("small", className, block) }
    actual inline fun source(void: Int, className: String?, noinline block: DataNodes?) { tag("source", className, block) }
    actual inline fun span(void: Int, className: String?, noinline block: DataNodes?) { tag("span", className, block) }
    actual inline fun strong(void: Int, className: String?, noinline block: DataNodes?) { tag("strong", className, block) }
    actual inline fun styleElement(void: Int, className: String?, noinline block: DataNodes?) { tag("style", className, block) }
    actual inline fun sub(void: Int, className: String?, noinline block: DataNodes?) { tag("sub", className, block) }
    actual inline fun summary(void: Int, className: String?, noinline block: DataNodes?) { tag("summary", className, block) }
    actual inline fun sup(void: Int, className: String?, noinline block: DataNodes?) { tag("sup", className, block) }
    actual inline fun table(void: Int, className: String?, noinline block: DataNodes?) { tag("table", className, block) }
    actual inline fun tbody(void: Int, className: String?, noinline block: DataNodes?) { tag("tbody", className, block) }
    actual inline fun td(void: Int, className: String?, noinline block: DataNodes?) { tag("td", className, block) }
    actual inline fun textarea(void: Int, className: String?, noinline block: DataNodes?) { tag("textarea", className, block) }
    actual inline fun tfoot(void: Int, className: String?, noinline block: DataNodes?) { tag("tfoot", className, block) }
    actual inline fun th(void: Int, className: String?, noinline block: DataNodes?) { tag("th", className, block) }
    actual inline fun thead(void: Int, className: String?, noinline block: DataNodes?) { tag("thead", className, block) }
    actual inline fun time(void: Int, className: String?, noinline block: DataNodes?) { tag("time", className, block) }
    actual inline fun title(void: Int, className: String?, noinline block: DataNodes?) { tag("title", className, block) }
    actual inline fun tr(void: Int, className: String?, noinline block: DataNodes?) { tag("tr", className, block) }
    actual inline fun track(void: Int, className: String?, noinline block: DataNodes?) { tag("track", className, block) }
    actual inline fun u(void: Int, className: String?, noinline block: DataNodes?) { tag("u", className, block) }
    actual inline fun ul(void: Int, className: String?, noinline block: DataNodes?) { tag("ul", className, block) }
    actual inline fun varElement(void: Int, className: String?, noinline block: DataNodes?) { tag("var", className, block) }
    actual inline fun video(void: Int, className: String?, noinline block: DataNodes?) { tag("video", className, block) }
    actual inline fun wbr(void: Int, className: String?, noinline block: DataNodes?) { tag("wbr", className, block) }

    actual inline fun a(void: Int, attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<AnchorHTMLAttributes<HTMLAnchorElement>>()
        a.attr()
        tag("a", a, block)
    }
    actual inline fun address(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("address", a, block)
    }
    actual inline fun area(void: Int, attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<AreaHTMLAttributes<HTMLAreaElement>>()
        a.attr()
        tag("area", a, block)
    }
    actual inline fun article(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("article", a, block)
    }
    actual inline fun aside(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("aside", a, block)
    }
    actual inline fun audio(void: Int, attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<AudioHTMLAttributes<HTMLAudioElement>>()
        a.attr()
        tag("audio", a, block)
    }
    actual inline fun b(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("b", a, block)
    }
    actual inline fun base(void: Int, attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<BaseHTMLAttributes<HTMLBaseElement>>()
        a.attr()
        tag("base", a, block)
    }
    actual inline fun bdi(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("bdi", a, block)
    }
    actual inline fun bdo(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("bdo", a, block)
    }
    actual inline fun big(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("big", a, block)
    }
    actual inline fun blockquote(void: Int, attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<BlockquoteHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("blockquote", a, block)
    }
    actual inline fun body(void: Int, attr: Attr<HTMLAttributes<HTMLBodyElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBodyElement>>()
        a.attr()
        tag("body", a, block)
    }
    actual inline fun br(void: Int, attr: Attr<HTMLAttributes<HTMLBRElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBRElement>>()
        a.attr()
        tag("br", a, block)
    }
    actual inline fun button(void: Int, attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ButtonHTMLAttributes<HTMLButtonElement>>()
        a.attr()
        tag("button", a, block)
    }
    actual inline fun canvas(void: Int, attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<CanvasHTMLAttributes<HTMLCanvasElement>>()
        a.attr()
        tag("canvas", a, block)
    }
    actual inline fun caption(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("caption", a, block)
    }
    actual inline fun cite(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("cite", a, block)
    }
    actual inline fun code(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("code", a, block)
    }
    actual inline fun col(void: Int, attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ColHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        tag("col", a, block)
    }
    actual inline fun colgroup(void: Int, attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ColgroupHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        tag("colgroup", a, block)
    }
    actual inline fun data(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("data", a, block)
    }
    actual inline fun datalist(void: Int, attr: Attr<HTMLAttributes<HTMLDataListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDataListElement>>()
        a.attr()
        tag("datalist", a, block)
    }
    actual inline fun dd(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dd", a, block)
    }
    actual inline fun del(void: Int, attr: Attr<DelHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<DelHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("del", a, block)
    }
    actual inline fun details(void: Int, attr: Attr<DetailsHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<DetailsHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("details", a, block)
    }
    actual inline fun dfn(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dfn", a, block)
    }
    actual inline fun dialog(void: Int, attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<DialogHTMLAttributes<HTMLDialogElement>>()
        a.attr()
        tag("dialog", a, block)
    }
    actual inline fun div(void: Int, attr: Attr<HTMLAttributes<HTMLDivElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDivElement>>()
        a.attr()
        tag("div", a, block)
    }
    actual inline fun dl(void: Int, attr: Attr<HTMLAttributes<HTMLDListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDListElement>>()
        a.attr()
        tag("dl", a, block)
    }
    actual inline fun dt(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dt", a, block)
    }
    actual inline fun em(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("em", a, block)
    }
    actual inline fun embed(void: Int, attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<EmbedHTMLAttributes<HTMLEmbedElement>>()
        a.attr()
        tag("embed", a, block)
    }
    actual inline fun fieldset(void: Int, attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<FieldsetHTMLAttributes<HTMLFieldSetElement>>()
        a.attr()
        tag("fieldset", a, block)
    }
    actual inline fun figcaption(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("figcaption", a, block)
    }
    actual inline fun figure(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("figure", a, block)
    }
    actual inline fun footer(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("footer", a, block)
    }
    actual inline fun form(void: Int, attr: Attr<FormHTMLAttributes<HTMLFormElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<FormHTMLAttributes<HTMLFormElement>>()
        a.attr()
        tag("form", a, block)
    }
    actual inline fun h1(void: Int, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h1", a, block)
    }
    actual inline fun h2(void: Int, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h2", a, block)
    }
    actual inline fun h3(void: Int, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h3", a, block)
    }
    actual inline fun h4(void: Int, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h4", a, block)
    }
    actual inline fun h5(void: Int, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h5", a, block)
    }
    actual inline fun h6(void: Int, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h6", a, block)
    }
    actual inline fun head(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("start", a, block)
    }
    actual inline fun header(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("header", a, block)
    }
    actual inline fun hgroup(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("hgroup", a, block)
    }
    actual inline fun hr(void: Int, attr: Attr<HTMLAttributes<HTMLHRElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHRElement>>()
        a.attr()
        tag("hr", a, block)
    }
    actual inline fun html(void: Int, attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HtmlHTMLAttributes<HTMLHtmlElement>>()
        a.attr()
        tag("html", a, block)
    }
    actual inline fun i(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("i", a, block)
    }
    actual inline fun iframe(void: Int, attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<IframeHTMLAttributes<HTMLIFrameElement>>()
        a.attr()
        tag("iframe", a, block)
    }
    actual inline fun img(void: Int, attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ImgHTMLAttributes<HTMLImageElement>>()
        a.attr()
        tag("img", a, block)
    }
    actual inline fun input(void: Int, attr: Attr<InputHTMLAttributes<HTMLInputElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<InputHTMLAttributes<HTMLInputElement>>()
        a.attr()
        tag("input", a, block)
    }
    actual inline fun ins(void: Int, attr: Attr<InsHTMLAttributes<HTMLModElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<InsHTMLAttributes<HTMLModElement>>()
        a.attr()
        tag("ins", a, block)
    }
    actual inline fun kbd(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("kbd", a, block)
    }
    actual inline fun keygen(void: Int, attr: Attr<KeygenHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<KeygenHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("keygen", a, block)
    }
    actual inline fun label(void: Int, attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<LabelHTMLAttributes<HTMLLabelElement>>()
        a.attr()
        tag("label", a, block)
    }
    actual inline fun legend(void: Int, attr: Attr<HTMLAttributes<HTMLLegendElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLLegendElement>>()
        a.attr()
        tag("legend", a, block)
    }
    actual inline fun li(void: Int, attr: Attr<LiHTMLAttributes<HTMLLIElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<LiHTMLAttributes<HTMLLIElement>>()
        a.attr()
        tag("li", a, block)
    }
    actual inline fun link(void: Int, attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<LinkHTMLAttributes<HTMLLinkElement>>()
        a.attr()
        tag("link", a, block)
    }
    actual inline fun main(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("main", a, block)
    }
    actual inline fun map(void: Int, attr: Attr<MapHTMLAttributes<HTMLMapElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MapHTMLAttributes<HTMLMapElement>>()
        a.attr()
        tag("map", a, block)
    }
    actual inline fun mark(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("mark", a, block)
    }
    actual inline fun menu(void: Int, attr: Attr<MenuHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MenuHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("menu", a, block)
    }
    actual inline fun menuitem(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("menuitem", a, block)
    }
    actual inline fun meta(void: Int, attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MetaHTMLAttributes<HTMLMetaElement>>()
        a.attr()
        tag("meta", a, block)
    }
    actual inline fun meter(void: Int, attr: Attr<MeterHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MeterHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("meter", a, block)
    }
    actual inline fun nav(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("nav", a, block)
    }
    actual inline fun noscript(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("noscript", a, block)
    }
    actual inline fun objectElement(void: Int, attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ObjectHTMLAttributes<HTMLObjectElement>>()
        a.attr()
        tag("object", a, block)
    }
    actual inline fun ol(void: Int, attr: Attr<OlHTMLAttributes<HTMLOListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OlHTMLAttributes<HTMLOListElement>>()
        a.attr()
        tag("ol", a, block)
    }
    actual inline fun optgroup(void: Int, attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OptgroupHTMLAttributes<HTMLOptGroupElement>>()
        a.attr()
        tag("optgroup", a, block)
    }
    actual inline fun option(void: Int, attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OptionHTMLAttributes<HTMLOptionElement>>()
        a.attr()
        tag("option", a, block)
    }
    actual inline fun output(void: Int, attr: Attr<OutputHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OutputHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("output", a, block)
    }
    actual inline fun p(void: Int, attr: Attr<HTMLAttributes<HTMLParagraphElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLParagraphElement>>()
        a.attr()
        tag("p", a, block)
    }
    actual inline fun param(void: Int, attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ParamHTMLAttributes<HTMLParamElement>>()
        a.attr()
        tag("param", a, block)
    }
    actual inline fun picture(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("picture", a, block)
    }
    actual inline fun pre(void: Int, attr: Attr<HTMLAttributes<HTMLPreElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLPreElement>>()
        a.attr()
        tag("pre", a, block)
    }
    actual inline fun progress(void: Int, attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ProgressHTMLAttributes<HTMLProgressElement>>()
        a.attr()
        tag("progress", a, block)
    }
    actual inline fun q(void: Int, attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<QuoteHTMLAttributes<HTMLQuoteElement>>()
        a.attr()
        tag("q", a, block)
    }
    actual inline fun rp(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("rp", a, block)
    }
    actual inline fun rt(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("rt", a, block)
    }
    actual inline fun ruby(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("ruby", a, block)
    }
    actual inline fun s(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("s", a, block)
    }
    actual inline fun samp(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("samp", a, block)
    }
    actual inline fun script(void: Int, attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ScriptHTMLAttributes<HTMLScriptElement>>()
        a.attr()
        tag("script", a, block)
    }
    actual inline fun section(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("section", a, block)
    }
    actual inline fun select(void: Int, attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<SelectHTMLAttributes<HTMLSelectElement>>()
        a.attr()
        tag("select", a, block)
    }
    actual inline fun small(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("small", a, block)
    }
    actual inline fun source(void: Int, attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<SourceHTMLAttributes<HTMLSourceElement>>()
        a.attr()
        tag("source", a, block)
    }
    actual inline fun span(void: Int, attr: Attr<HTMLAttributes<HTMLSpanElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLSpanElement>>()
        a.attr()
        tag("span", a, block)
    }
    actual inline fun strong(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("strong", a, block)
    }
    actual inline fun styleElement(void: Int, attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<StyleHTMLAttributes<HTMLStyleElement>>()
        a.attr()
        tag("style", a, block)
    }
    actual inline fun sub(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("sub", a, block)
    }
    actual inline fun summary(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("summary", a, block)
    }
    actual inline fun sup(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("sup", a, block)
    }
    actual inline fun table(void: Int, attr: Attr<TableHTMLAttributes<HTMLTableElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TableHTMLAttributes<HTMLTableElement>>()
        a.attr()
        tag("table", a, block)
    }
    actual inline fun tbody(void: Int, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("tbody", a, block)
    }
    actual inline fun td(void: Int, attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TdHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        tag("td", a, block)
    }
    actual inline fun textarea(void: Int, attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TextareaHTMLAttributes<HTMLTextAreaElement>>()
        a.attr()
        tag("textarea", a, block)
    }
    actual inline fun tfoot(void: Int, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("tfoot", a, block)
    }
    actual inline fun th(void: Int, attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ThHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        tag("th", a, block)
    }
    actual inline fun thead(void: Int, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("thead", a, block)
    }
    actual inline fun time(void: Int, attr: Attr<TimeHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TimeHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("time", a, block)
    }
    actual inline fun title(void: Int, attr: Attr<HTMLAttributes<HTMLTitleElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTitleElement>>()
        a.attr()
        tag("title", a, block)
    }
    actual inline fun tr(void: Int, attr: Attr<HTMLAttributes<HTMLTableRowElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableRowElement>>()
        a.attr()
        tag("tr", a, block)
    }
    actual inline fun track(void: Int, attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TrackHTMLAttributes<HTMLTrackElement>>()
        a.attr()
        tag("track", a, block)
    }
    actual inline fun u(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("u", a, block)
    }
    actual inline fun ul(void: Int, attr: Attr<HTMLAttributes<HTMLUListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLUListElement>>()
        a.attr()
        tag("ul", a, block)
    }
    actual inline fun varElement(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("var", a, block)
    }
    actual inline fun video(void: Int, attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<VideoHTMLAttributes<HTMLVideoElement>>()
        a.attr()
        tag("video", a, block)
    }
    actual inline fun wbr(void: Int, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("wbr", a, block)
    }

    actual inline fun a(void: Int, className: String, attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<AnchorHTMLAttributes<HTMLAnchorElement>>()
        a.attr()
        a.className = className
        tag("a", a, block)
    }
    actual inline fun address(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("address", a, block)
    }
    actual inline fun area(void: Int, className: String, attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<AreaHTMLAttributes<HTMLAreaElement>>()
        a.attr()
        a.className = className
        tag("area", a, block)
    }
    actual inline fun article(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("article", a, block)
    }
    actual inline fun aside(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("aside", a, block)
    }
    actual inline fun audio(void: Int, className: String, attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<AudioHTMLAttributes<HTMLAudioElement>>()
        a.attr()
        a.className = className
        tag("audio", a, block)
    }
    actual inline fun b(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("b", a, block)
    }
    actual inline fun base(void: Int, className: String, attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<BaseHTMLAttributes<HTMLBaseElement>>()
        a.attr()
        a.className = className
        tag("base", a, block)
    }
    actual inline fun bdi(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("bdi", a, block)
    }
    actual inline fun bdo(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("bdo", a, block)
    }
    actual inline fun big(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("big", a, block)
    }
    actual inline fun blockquote(void: Int, className: String, attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<BlockquoteHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("blockquote", a, block)
    }
    actual inline fun body(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLBodyElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBodyElement>>()
        a.attr()
        a.className = className
        tag("body", a, block)
    }
    actual inline fun br(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLBRElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBRElement>>()
        a.attr()
        a.className = className
        tag("br", a, block)
    }
    actual inline fun button(void: Int, className: String, attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ButtonHTMLAttributes<HTMLButtonElement>>()
        a.attr()
        a.className = className
        tag("button", a, block)
    }
    actual inline fun canvas(void: Int, className: String, attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<CanvasHTMLAttributes<HTMLCanvasElement>>()
        a.attr()
        a.className = className
        tag("canvas", a, block)
    }
    actual inline fun caption(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("caption", a, block)
    }
    actual inline fun cite(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("cite", a, block)
    }
    actual inline fun code(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("code", a, block)
    }
    actual inline fun col(void: Int, className: String, attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ColHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        a.className = className
        tag("col", a, block)
    }
    actual inline fun colgroup(void: Int, className: String, attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ColgroupHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        a.className = className
        tag("colgroup", a, block)
    }
    actual inline fun data(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("data", a, block)
    }
    actual inline fun datalist(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLDataListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDataListElement>>()
        a.attr()
        a.className = className
        tag("datalist", a, block)
    }
    actual inline fun dd(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("dd", a, block)
    }
    actual inline fun del(void: Int, className: String, attr: Attr<DelHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<DelHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("del", a, block)
    }
    actual inline fun details(void: Int, className: String, attr: Attr<DetailsHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<DetailsHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("details", a, block)
    }
    actual inline fun dfn(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("dfn", a, block)
    }
    actual inline fun dialog(void: Int, className: String, attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<DialogHTMLAttributes<HTMLDialogElement>>()
        a.attr()
        a.className = className
        tag("dialog", a, block)
    }
    actual inline fun div(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLDivElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDivElement>>()
        a.attr()
        a.className = className
        tag("div", a, block)
    }
    actual inline fun dl(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLDListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDListElement>>()
        a.attr()
        a.className = className
        tag("dl", a, block)
    }
    actual inline fun dt(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("dt", a, block)
    }
    actual inline fun em(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("em", a, block)
    }
    actual inline fun embed(void: Int, className: String, attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<EmbedHTMLAttributes<HTMLEmbedElement>>()
        a.attr()
        a.className = className
        tag("embed", a, block)
    }
    actual inline fun fieldset(void: Int, className: String, attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<FieldsetHTMLAttributes<HTMLFieldSetElement>>()
        a.attr()
        a.className = className
        tag("fieldset", a, block)
    }
    actual inline fun figcaption(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("figcaption", a, block)
    }
    actual inline fun figure(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("figure", a, block)
    }
    actual inline fun footer(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("footer", a, block)
    }
    actual inline fun form(void: Int, className: String, attr: Attr<FormHTMLAttributes<HTMLFormElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<FormHTMLAttributes<HTMLFormElement>>()
        a.attr()
        a.className = className
        tag("form", a, block)
    }
    actual inline fun h1(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        tag("h1", a, block)
    }
    actual inline fun h2(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        tag("h2", a, block)
    }
    actual inline fun h3(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        tag("h3", a, block)
    }
    actual inline fun h4(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        tag("h4", a, block)
    }
    actual inline fun h5(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        tag("h5", a, block)
    }
    actual inline fun h6(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        tag("h6", a, block)
    }
    actual inline fun head(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("start", a, block)
    }
    actual inline fun header(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("header", a, block)
    }
    actual inline fun hgroup(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("hgroup", a, block)
    }
    actual inline fun hr(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLHRElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHRElement>>()
        a.attr()
        a.className = className
        tag("hr", a, block)
    }
    actual inline fun html(void: Int, className: String, attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HtmlHTMLAttributes<HTMLHtmlElement>>()
        a.attr()
        a.className = className
        tag("html", a, block)
    }
    actual inline fun i(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("i", a, block)
    }
    actual inline fun iframe(void: Int, className: String, attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<IframeHTMLAttributes<HTMLIFrameElement>>()
        a.attr()
        a.className = className
        tag("iframe", a, block)
    }
    actual inline fun img(void: Int, className: String, attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ImgHTMLAttributes<HTMLImageElement>>()
        a.attr()
        a.className = className
        tag("img", a, block)
    }
    actual inline fun input(void: Int, className: String, attr: Attr<InputHTMLAttributes<HTMLInputElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<InputHTMLAttributes<HTMLInputElement>>()
        a.attr()
        a.className = className
        tag("input", a, block)
    }
    actual inline fun ins(void: Int, className: String, attr: Attr<InsHTMLAttributes<HTMLModElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<InsHTMLAttributes<HTMLModElement>>()
        a.attr()
        a.className = className
        tag("ins", a, block)
    }
    actual inline fun kbd(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("kbd", a, block)
    }
    actual inline fun keygen(void: Int, className: String, attr: Attr<KeygenHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<KeygenHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("keygen", a, block)
    }
    actual inline fun label(void: Int, className: String, attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<LabelHTMLAttributes<HTMLLabelElement>>()
        a.attr()
        a.className = className
        tag("label", a, block)
    }
    actual inline fun legend(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLLegendElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLLegendElement>>()
        a.attr()
        a.className = className
        tag("legend", a, block)
    }
    actual inline fun li(void: Int, className: String, attr: Attr<LiHTMLAttributes<HTMLLIElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<LiHTMLAttributes<HTMLLIElement>>()
        a.attr()
        a.className = className
        tag("li", a, block)
    }
    actual inline fun link(void: Int, className: String, attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<LinkHTMLAttributes<HTMLLinkElement>>()
        a.attr()
        a.className = className
        tag("link", a, block)
    }
    actual inline fun main(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("main", a, block)
    }
    actual inline fun map(void: Int, className: String, attr: Attr<MapHTMLAttributes<HTMLMapElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MapHTMLAttributes<HTMLMapElement>>()
        a.attr()
        a.className = className
        tag("map", a, block)
    }
    actual inline fun mark(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("mark", a, block)
    }
    actual inline fun menu(void: Int, className: String, attr: Attr<MenuHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MenuHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("menu", a, block)
    }
    actual inline fun menuitem(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("menuitem", a, block)
    }
    actual inline fun meta(void: Int, className: String, attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MetaHTMLAttributes<HTMLMetaElement>>()
        a.attr()
        a.className = className
        tag("meta", a, block)
    }
    actual inline fun meter(void: Int, className: String, attr: Attr<MeterHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<MeterHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("meter", a, block)
    }
    actual inline fun nav(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("nav", a, block)
    }
    actual inline fun noscript(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("noscript", a, block)
    }
    actual inline fun objectElement(void: Int, className: String, attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ObjectHTMLAttributes<HTMLObjectElement>>()
        a.attr()
        a.className = className
        tag("object", a, block)
    }
    actual inline fun ol(void: Int, className: String, attr: Attr<OlHTMLAttributes<HTMLOListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OlHTMLAttributes<HTMLOListElement>>()
        a.attr()
        a.className = className
        tag("ol", a, block)
    }
    actual inline fun optgroup(void: Int, className: String, attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OptgroupHTMLAttributes<HTMLOptGroupElement>>()
        a.attr()
        a.className = className
        tag("optgroup", a, block)
    }
    actual inline fun option(void: Int, className: String, attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OptionHTMLAttributes<HTMLOptionElement>>()
        a.attr()
        a.className = className
        tag("option", a, block)
    }
    actual inline fun output(void: Int, className: String, attr: Attr<OutputHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<OutputHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("output", a, block)
    }
    actual inline fun p(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLParagraphElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLParagraphElement>>()
        a.attr()
        a.className = className
        tag("p", a, block)
    }
    actual inline fun param(void: Int, className: String, attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ParamHTMLAttributes<HTMLParamElement>>()
        a.attr()
        a.className = className
        tag("param", a, block)
    }
    actual inline fun picture(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("picture", a, block)
    }
    actual inline fun pre(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLPreElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLPreElement>>()
        a.attr()
        a.className = className
        tag("pre", a, block)
    }
    actual inline fun progress(void: Int, className: String, attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ProgressHTMLAttributes<HTMLProgressElement>>()
        a.attr()
        a.className = className
        tag("progress", a, block)
    }
    actual inline fun q(void: Int, className: String, attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<QuoteHTMLAttributes<HTMLQuoteElement>>()
        a.attr()
        a.className = className
        tag("q", a, block)
    }
    actual inline fun rp(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("rp", a, block)
    }
    actual inline fun rt(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("rt", a, block)
    }
    actual inline fun ruby(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("ruby", a, block)
    }
    actual inline fun s(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("s", a, block)
    }
    actual inline fun samp(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("samp", a, block)
    }
    actual inline fun script(void: Int, className: String, attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ScriptHTMLAttributes<HTMLScriptElement>>()
        a.attr()
        a.className = className
        tag("script", a, block)
    }
    actual inline fun section(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("section", a, block)
    }
    actual inline fun select(void: Int, className: String, attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<SelectHTMLAttributes<HTMLSelectElement>>()
        a.attr()
        a.className = className
        tag("select", a, block)
    }
    actual inline fun small(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("small", a, block)
    }
    actual inline fun source(void: Int, className: String, attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<SourceHTMLAttributes<HTMLSourceElement>>()
        a.attr()
        a.className = className
        tag("source", a, block)
    }
    actual inline fun span(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLSpanElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLSpanElement>>()
        a.attr()
        a.className = className
        tag("span", a, block)
    }
    actual inline fun strong(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("strong", a, block)
    }
    actual inline fun styleElement(void: Int, className: String, attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<StyleHTMLAttributes<HTMLStyleElement>>()
        a.attr()
        a.className = className
        tag("style", a, block)
    }
    actual inline fun sub(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("sub", a, block)
    }
    actual inline fun summary(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("summary", a, block)
    }
    actual inline fun sup(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("sup", a, block)
    }
    actual inline fun table(void: Int, className: String, attr: Attr<TableHTMLAttributes<HTMLTableElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TableHTMLAttributes<HTMLTableElement>>()
        a.attr()
        a.className = className
        tag("table", a, block)
    }
    actual inline fun tbody(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        a.className = className
        tag("tbody", a, block)
    }
    actual inline fun td(void: Int, className: String, attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TdHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        a.className = className
        tag("td", a, block)
    }
    actual inline fun textarea(void: Int, className: String, attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TextareaHTMLAttributes<HTMLTextAreaElement>>()
        a.attr()
        a.className = className
        tag("textarea", a, block)
    }
    actual inline fun tfoot(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        a.className = className
        tag("tfoot", a, block)
    }
    actual inline fun th(void: Int, className: String, attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<ThHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        a.className = className
        tag("th", a, block)
    }
    actual inline fun thead(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        a.className = className
        tag("thead", a, block)
    }
    actual inline fun time(void: Int, className: String, attr: Attr<TimeHTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TimeHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("time", a, block)
    }
    actual inline fun title(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLTitleElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTitleElement>>()
        a.attr()
        a.className = className
        tag("title", a, block)
    }
    actual inline fun tr(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLTableRowElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableRowElement>>()
        a.attr()
        a.className = className
        tag("tr", a, block)
    }
    actual inline fun track(void: Int, className: String, attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<TrackHTMLAttributes<HTMLTrackElement>>()
        a.attr()
        a.className = className
        tag("track", a, block)
    }
    actual inline fun u(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("u", a, block)
    }
    actual inline fun ul(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLUListElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLUListElement>>()
        a.attr()
        a.className = className
        tag("ul", a, block)
    }
    actual inline fun varElement(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("var", a, block)
    }
    actual inline fun video(void: Int, className: String, attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<VideoHTMLAttributes<HTMLVideoElement>>()
        a.attr()
        a.className = className
        tag("video", a, block)
    }
    actual inline fun wbr(void: Int, className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: DataNodes?) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        tag("wbr", a, block)
    }

    actual inline fun a(className: String?, block: Nodes) {
        val e = E(this, "a", className)
        e.block()
        append(e)
    }
    actual inline fun address(className: String?, block: Nodes) {
        val e = E(this, "address", className)
        e.block()
        append(e)
    }
    actual inline fun area(className: String?, block: Nodes) {
        val e = E(this, "area", className)
        e.block()
        append(e)
    }
    actual inline fun article(className: String?, block: Nodes) {
        val e = E(this, "article", className)
        e.block()
        append(e)
    }
    actual inline fun aside(className: String?, block: Nodes) {
        val e = E(this, "aside", className)
        e.block()
        append(e)
    }
    actual inline fun audio(className: String?, block: Nodes) {
        val e = E(this, "audio", className)
        e.block()
        append(e)
    }
    actual inline fun b(className: String?, block: Nodes) {
        val e = E(this, "b", className)
        e.block()
        append(e)
    }
    actual inline fun base(className: String?, block: Nodes) {
        val e = E(this, "base", className)
        e.block()
        append(e)
    }
    actual inline fun bdi(className: String?, block: Nodes) {
        val e = E(this, "bdi", className)
        e.block()
        append(e)
    }
    actual inline fun bdo(className: String?, block: Nodes) {
        val e = E(this, "bdo", className)
        e.block()
        append(e)
    }
    actual inline fun big(className: String?, block: Nodes) {
        val e = E(this, "big", className)
        e.block()
        append(e)
    }
    actual inline fun blockquote(className: String?, block: Nodes) {
        val e = E(this, "blockquote", className)
        e.block()
        append(e)
    }
    actual inline fun body(className: String?, block: Nodes) {
        val e = E(this, "body", className)
        e.block()
        append(e)
    }
    actual inline fun br(className: String?, block: Nodes) {
        val e = E(this, "br", className)
        e.block()
        append(e)
    }
    actual inline fun button(className: String?, block: Nodes) {
        val e = E(this, "button", className)
        e.block()
        append(e)
    }
    actual inline fun canvas(className: String?, block: Nodes) {
        val e = E(this, "canvas", className)
        e.block()
        append(e)
    }
    actual inline fun caption(className: String?, block: Nodes) {
        val e = E(this, "caption", className)
        e.block()
        append(e)
    }
    actual inline fun cite(className: String?, block: Nodes) {
        val e = E(this, "cite", className)
        e.block()
        append(e)
    }
    actual inline fun code(className: String?, block: Nodes) {
        val e = E(this, "code", className)
        e.block()
        append(e)
    }
    actual inline fun col(className: String?, block: Nodes) {
        val e = E(this, "col", className)
        e.block()
        append(e)
    }
    actual inline fun colgroup(className: String?, block: Nodes) {
        val e = E(this, "colgroup", className)
        e.block()
        append(e)
    }
    actual inline fun data(className: String?, block: Nodes) {
        val e = E(this, "data", className)
        e.block()
        append(e)
    }
    actual inline fun datalist(className: String?, block: Nodes) {
        val e = E(this, "datalist", className)
        e.block()
        append(e)
    }
    actual inline fun dd(className: String?, block: Nodes) {
        val e = E(this, "dd", className)
        e.block()
        append(e)
    }
    actual inline fun del(className: String?, block: Nodes) {
        val e = E(this, "del", className)
        e.block()
        append(e)
    }
    actual inline fun details(className: String?, block: Nodes) {
        val e = E(this, "details", className)
        e.block()
        append(e)
    }
    actual inline fun dfn(className: String?, block: Nodes) {
        val e = E(this, "dfn", className)
        e.block()
        append(e)
    }
    actual inline fun dialog(className: String?, block: Nodes) {
        val e = E(this, "dialog", className)
        e.block()
        append(e)
    }
    actual inline fun div(className: String?, block: Nodes) {
        val e = E(this, "div", className)
        e.block()
        append(e)
    }
    actual inline fun dl(className: String?, block: Nodes) {
        val e = E(this, "dl", className)
        e.block()
        append(e)
    }
    actual inline fun dt(className: String?, block: Nodes) {
        val e = E(this, "dt", className)
        e.block()
        append(e)
    }
    actual inline fun em(className: String?, block: Nodes) {
        val e = E(this, "em", className)
        e.block()
        append(e)
    }
    actual inline fun embed(className: String?, block: Nodes) {
        val e = E(this, "embed", className)
        e.block()
        append(e)
    }
    actual inline fun fieldset(className: String?, block: Nodes) {
        val e = E(this, "fieldset", className)
        e.block()
        append(e)
    }
    actual inline fun figcaption(className: String?, block: Nodes) {
        val e = E(this, "figcaption", className)
        e.block()
        append(e)
    }
    actual inline fun figure(className: String?, block: Nodes) {
        val e = E(this, "figure", className)
        e.block()
        append(e)
    }
    actual inline fun footer(className: String?, block: Nodes) {
        val e = E(this, "footer", className)
        e.block()
        append(e)
    }
    actual inline fun form(className: String?, block: Nodes) {
        val e = E(this, "form", className)
        e.block()
        append(e)
    }
    actual inline fun h1(className: String?, block: Nodes) {
        val e = E(this, "h1", className)
        e.block()
        append(e)
    }
    actual inline fun h2(className: String?, block: Nodes) {
        val e = E(this, "h2", className)
        e.block()
        append(e)
    }
    actual inline fun h3(className: String?, block: Nodes) {
        val e = E(this, "h3", className)
        e.block()
        append(e)
    }
    actual inline fun h4(className: String?, block: Nodes) {
        val e = E(this, "h4", className)
        e.block()
        append(e)
    }
    actual inline fun h5(className: String?, block: Nodes) {
        val e = E(this, "h5", className)
        e.block()
        append(e)
    }
    actual inline fun h6(className: String?, block: Nodes) {
        val e = E(this, "h6", className)
        e.block()
        append(e)
    }
    actual inline fun head(className: String?, block: Nodes) {
        val e = E(this, "start", className)
        e.block()
        append(e)
    }
    actual inline fun header(className: String?, block: Nodes) {
        val e = E(this, "header", className)
        e.block()
        append(e)
    }
    actual inline fun hgroup(className: String?, block: Nodes) {
        val e = E(this, "hgroup", className)
        e.block()
        append(e)
    }
    actual inline fun hr(className: String?, block: Nodes) {
        val e = E(this, "hr", className)
        e.block()
        append(e)
    }
    actual inline fun html(className: String?, block: Nodes) {
        val e = E(this, "html", className)
        e.block()
        append(e)
    }
    actual inline fun i(className: String?, block: Nodes) {
        val e = E(this, "i", className)
        e.block()
        append(e)
    }
    actual inline fun iframe(className: String?, block: Nodes) {
        val e = E(this, "iframe", className)
        e.block()
        append(e)
    }
    actual inline fun img(className: String?, block: Nodes) {
        val e = E(this, "img", className)
        e.block()
        append(e)
    }
    actual inline fun input(className: String?, block: Nodes) {
        val e = E(this, "input", className)
        e.block()
        append(e)
    }
    actual inline fun ins(className: String?, block: Nodes) {
        val e = E(this, "ins", className)
        e.block()
        append(e)
    }
    actual inline fun kbd(className: String?, block: Nodes) {
        val e = E(this, "kbd", className)
        e.block()
        append(e)
    }
    actual inline fun keygen(className: String?, block: Nodes) {
        val e = E(this, "keygen", className)
        e.block()
        append(e)
    }
    actual inline fun label(className: String?, block: Nodes) {
        val e = E(this, "label", className)
        e.block()
        append(e)
    }
    actual inline fun legend(className: String?, block: Nodes) {
        val e = E(this, "legend", className)
        e.block()
        append(e)
    }
    actual inline fun li(className: String?, block: Nodes) {
        val e = E(this, "li", className)
        e.block()
        append(e)
    }
    actual inline fun link(className: String?, block: Nodes) {
        val e = E(this, "link", className)
        e.block()
        append(e)
    }
    actual inline fun main(className: String?, block: Nodes) {
        val e = E(this, "main", className)
        e.block()
        append(e)
    }
    actual inline fun map(className: String?, block: Nodes) {
        val e = E(this, "map", className)
        e.block()
        append(e)
    }
    actual inline fun mark(className: String?, block: Nodes) {
        val e = E(this, "mark", className)
        e.block()
        append(e)
    }
    actual inline fun menu(className: String?, block: Nodes) {
        val e = E(this, "menu", className)
        e.block()
        append(e)
    }
    actual inline fun menuitem(className: String?, block: Nodes) {
        val e = E(this, "menuitem", className)
        e.block()
        append(e)
    }
    actual inline fun meta(className: String?, block: Nodes) {
        val e = E(this, "meta", className)
        e.block()
        append(e)
    }
    actual inline fun meter(className: String?, block: Nodes) {
        val e = E(this, "meter", className)
        e.block()
        append(e)
    }
    actual inline fun nav(className: String?, block: Nodes) {
        val e = E(this, "nav", className)
        e.block()
        append(e)
    }
    actual inline fun noscript(className: String?, block: Nodes) {
        val e = E(this, "noscript", className)
        e.block()
        append(e)
    }
    actual inline fun objectElement(className: String?, block: Nodes) {
        val e = E(this, "object", className)
        e.block()
        append(e)
    }
    actual inline fun ol(className: String?, block: Nodes) {
        val e = E(this, "ol", className)
        e.block()
        append(e)
    }
    actual inline fun optgroup(className: String?, block: Nodes) {
        val e = E(this, "optgroup", className)
        e.block()
        append(e)
    }
    actual inline fun option(className: String?, block: Nodes) {
        val e = E(this, "option", className)
        e.block()
        append(e)
    }
    actual inline fun output(className: String?, block: Nodes) {
        val e = E(this, "output", className)
        e.block()
        append(e)
    }
    actual inline fun p(className: String?, block: Nodes) {
        val e = E(this, "p", className)
        e.block()
        append(e)
    }
    actual inline fun param(className: String?, block: Nodes) {
        val e = E(this, "param", className)
        e.block()
        append(e)
    }
    actual inline fun picture(className: String?, block: Nodes) {
        val e = E(this, "picture", className)
        e.block()
        append(e)
    }
    actual inline fun pre(className: String?, block: Nodes) {
        val e = E(this, "pre", className)
        e.block()
        append(e)
    }
    actual inline fun progress(className: String?, block: Nodes) {
        val e = E(this, "progress", className)
        e.block()
        append(e)
    }
    actual inline fun q(className: String?, block: Nodes) {
        val e = E(this, "q", className)
        e.block()
        append(e)
    }
    actual inline fun rp(className: String?, block: Nodes) {
        val e = E(this, "rp", className)
        e.block()
        append(e)
    }
    actual inline fun rt(className: String?, block: Nodes) {
        val e = E(this, "rt", className)
        e.block()
        append(e)
    }
    actual inline fun ruby(className: String?, block: Nodes) {
        val e = E(this, "ruby", className)
        e.block()
        append(e)
    }
    actual inline fun s(className: String?, block: Nodes) {
        val e = E(this, "s", className)
        e.block()
        append(e)
    }
    actual inline fun samp(className: String?, block: Nodes) {
        val e = E(this, "samp", className)
        e.block()
        append(e)
    }
    actual inline fun script(className: String?, block: Nodes) {
        val e = E(this, "script", className)
        e.block()
        append(e)
    }
    actual inline fun section(className: String?, block: Nodes) {
        val e = E(this, "section", className)
        e.block()
        append(e)
    }
    actual inline fun select(className: String?, block: Nodes) {
        val e = E(this, "select", className)
        e.block()
        append(e)
    }
    actual inline fun small(className: String?, block: Nodes) {
        val e = E(this, "small", className)
        e.block()
        append(e)
    }
    actual inline fun source(className: String?, block: Nodes) {
        val e = E(this, "source", className)
        e.block()
        append(e)
    }
    actual inline fun span(className: String?, block: Nodes) {
        val e = E(this, "span", className)
        e.block()
        append(e)
    }
    actual inline fun strong(className: String?, block: Nodes) {
        val e = E(this, "strong", className)
        e.block()
        append(e)
    }
    actual inline fun styleElement(className: String?, block: Nodes) {
        val e = E(this, "style", className)
        e.block()
        append(e)
    }
    actual inline fun sub(className: String?, block: Nodes) {
        val e = E(this, "sub", className)
        e.block()
        append(e)
    }
    actual inline fun summary(className: String?, block: Nodes) {
        val e = E(this, "summary", className)
        e.block()
        append(e)
    }
    actual inline fun sup(className: String?, block: Nodes) {
        val e = E(this, "sup", className)
        e.block()
        append(e)
    }
    actual inline fun table(className: String?, block: Nodes) {
        val e = E(this, "table", className)
        e.block()
        append(e)
    }
    actual inline fun tbody(className: String?, block: Nodes) {
        val e = E(this, "tbody", className)
        e.block()
        append(e)
    }
    actual inline fun td(className: String?, block: Nodes) {
        val e = E(this, "td", className)
        e.block()
        append(e)
    }
    actual inline fun textarea(className: String?, block: Nodes) {
        val e = E(this, "textarea", className)
        e.block()
        append(e)
    }
    actual inline fun tfoot(className: String?, block: Nodes) {
        val e = E(this, "tfoot", className)
        e.block()
        append(e)
    }
    actual inline fun th(className: String?, block: Nodes) {
        val e = E(this, "th", className)
        e.block()
        append(e)
    }
    actual inline fun thead(className: String?, block: Nodes) {
        val e = E(this, "thead", className)
        e.block()
        append(e)
    }
    actual inline fun time(className: String?, block: Nodes) {
        val e = E(this, "time", className)
        e.block()
        append(e)
    }
    actual inline fun title(className: String?, block: Nodes) {
        val e = E(this, "title", className)
        e.block()
        append(e)
    }
    actual inline fun tr(className: String?, block: Nodes) {
        val e = E(this, "tr", className)
        e.block()
        append(e)
    }
    actual inline fun track(className: String?, block: Nodes) {
        val e = E(this, "track", className)
        e.block()
        append(e)
    }
    actual inline fun u(className: String?, block: Nodes) {
        val e = E(this, "u", className)
        e.block()
        append(e)
    }
    actual inline fun ul(className: String?, block: Nodes) {
        val e = E(this, "ul", className)
        e.block()
        append(e)
    }
    actual inline fun varElement(className: String?, block: Nodes) {
        val e = E(this, "var", className)
        e.block()
        append(e)
    }
    actual inline fun video(className: String?, block: Nodes) {
        val e = E(this, "video", className)
        e.block()
        append(e)
    }
    actual inline fun wbr(className: String?, block: Nodes) {
        val e = E(this, "wbr", className)
        e.block()
        append(e)
    }

    actual inline fun a(className: String?) { append(E(this, "a", className)) }
    actual inline fun address(className: String?) { append(E(this, "address", className)) }
    actual inline fun area(className: String?) { append(E(this, "area", className)) }
    actual inline fun article(className: String?) { append(E(this, "article", className)) }
    actual inline fun aside(className: String?) { append(E(this, "aside", className)) }
    actual inline fun audio(className: String?) { append(E(this, "audio", className)) }
    actual inline fun b(className: String?) { append(E(this, "b", className)) }
    actual inline fun base(className: String?) { append(E(this, "base", className)) }
    actual inline fun bdi(className: String?) { append(E(this, "bdi", className)) }
    actual inline fun bdo(className: String?) { append(E(this, "bdo", className)) }
    actual inline fun big(className: String?) { append(E(this, "big", className)) }
    actual inline fun blockquote(className: String?) { append(E(this, "blockquote", className)) }
    actual inline fun body(className: String?) { append(E(this, "body", className)) }
    actual inline fun br(className: String?) { append(E(this, "br", className)) }
    actual inline fun button(className: String?) { append(E(this, "button", className)) }
    actual inline fun canvas(className: String?) { append(E(this, "canvas", className)) }
    actual inline fun caption(className: String?) { append(E(this, "caption", className)) }
    actual inline fun cite(className: String?) { append(E(this, "cite", className)) }
    actual inline fun code(className: String?) { append(E(this, "code", className)) }
    actual inline fun col(className: String?) { append(E(this, "col", className)) }
    actual inline fun colgroup(className: String?) { append(E(this, "colgroup", className)) }
    actual inline fun data(className: String?) { append(E(this, "data", className)) }
    actual inline fun datalist(className: String?) { append(E(this, "datalist", className)) }
    actual inline fun dd(className: String?) { append(E(this, "dd", className)) }
    actual inline fun del(className: String?) { append(E(this, "del", className)) }
    actual inline fun details(className: String?) { append(E(this, "details", className)) }
    actual inline fun dfn(className: String?) { append(E(this, "dfn", className)) }
    actual inline fun dialog(className: String?) { append(E(this, "dialog", className)) }
    actual inline fun div(className: String?) { append(E(this, "div", className)) }
    actual inline fun dl(className: String?) { append(E(this, "dl", className)) }
    actual inline fun dt(className: String?) { append(E(this, "dt", className)) }
    actual inline fun em(className: String?) { append(E(this, "em", className)) }
    actual inline fun embed(className: String?) { append(E(this, "embed", className)) }
    actual inline fun fieldset(className: String?) { append(E(this, "fieldset", className)) }
    actual inline fun figcaption(className: String?) { append(E(this, "figcaption", className)) }
    actual inline fun figure(className: String?) { append(E(this, "figure", className)) }
    actual inline fun footer(className: String?) { append(E(this, "footer", className)) }
    actual inline fun form(className: String?) { append(E(this, "form", className)) }
    actual inline fun h1(className: String?) { append(E(this, "h1", className)) }
    actual inline fun h2(className: String?) { append(E(this, "h2", className)) }
    actual inline fun h3(className: String?) { append(E(this, "h3", className)) }
    actual inline fun h4(className: String?) { append(E(this, "h4", className)) }
    actual inline fun h5(className: String?) { append(E(this, "h5", className)) }
    actual inline fun h6(className: String?) { append(E(this, "h6", className)) }
    actual inline fun head(className: String?) { append(E(this, "start", className)) }
    actual inline fun header(className: String?) { append(E(this, "header", className)) }
    actual inline fun hgroup(className: String?) { append(E(this, "hgroup", className)) }
    actual inline fun hr(className: String?) { append(E(this, "hr", className)) }
    actual inline fun html(className: String?) { append(E(this, "html", className)) }
    actual inline fun i(className: String?) { append(E(this, "i", className)) }
    actual inline fun iframe(className: String?) { append(E(this, "iframe", className)) }
    actual inline fun img(className: String?) { append(E(this, "img", className)) }
    actual inline fun input(className: String?) { append(E(this, "input", className)) }
    actual inline fun ins(className: String?) { append(E(this, "ins", className)) }
    actual inline fun kbd(className: String?) { append(E(this, "kbd", className)) }
    actual inline fun keygen(className: String?) { append(E(this, "keygen", className)) }
    actual inline fun label(className: String?) { append(E(this, "label", className)) }
    actual inline fun legend(className: String?) { append(E(this, "legend", className)) }
    actual inline fun li(className: String?) { append(E(this, "li", className)) }
    actual inline fun link(className: String?) { append(E(this, "link", className)) }
    actual inline fun main(className: String?) { append(E(this, "main", className)) }
    actual inline fun map(className: String?) { append(E(this, "map", className)) }
    actual inline fun mark(className: String?) { append(E(this, "mark", className)) }
    actual inline fun menu(className: String?) { append(E(this, "menu", className)) }
    actual inline fun menuitem(className: String?) { append(E(this, "menuitem", className)) }
    actual inline fun meta(className: String?) { append(E(this, "meta", className)) }
    actual inline fun meter(className: String?) { append(E(this, "meter", className)) }
    actual inline fun nav(className: String?) { append(E(this, "nav", className)) }
    actual inline fun noscript(className: String?) { append(E(this, "noscript", className)) }
    actual inline fun objectElement(className: String?) { append(E(this, "object", className)) }
    actual inline fun ol(className: String?) { append(E(this, "ol", className)) }
    actual inline fun optgroup(className: String?) { append(E(this, "optgroup", className)) }
    actual inline fun option(className: String?) { append(E(this, "option", className)) }
    actual inline fun output(className: String?) { append(E(this, "output", className)) }
    actual inline fun p(className: String?) { append(E(this, "p", className)) }
    actual inline fun param(className: String?) { append(E(this, "param", className)) }
    actual inline fun picture(className: String?) { append(E(this, "picture", className)) }
    actual inline fun pre(className: String?) { append(E(this, "pre", className)) }
    actual inline fun progress(className: String?) { append(E(this, "progress", className)) }
    actual inline fun q(className: String?) { append(E(this, "q", className)) }
    actual inline fun rp(className: String?) { append(E(this, "rp", className)) }
    actual inline fun rt(className: String?) { append(E(this, "rt", className)) }
    actual inline fun ruby(className: String?) { append(E(this, "ruby", className)) }
    actual inline fun s(className: String?) { append(E(this, "s", className)) }
    actual inline fun samp(className: String?) { append(E(this, "samp", className)) }
    actual inline fun script(className: String?) { append(E(this, "script", className)) }
    actual inline fun section(className: String?) { append(E(this, "section", className)) }
    actual inline fun select(className: String?) { append(E(this, "select", className)) }
    actual inline fun small(className: String?) { append(E(this, "small", className)) }
    actual inline fun source(className: String?) { append(E(this, "source", className)) }
    actual inline fun span(className: String?) { append(E(this, "span", className)) }
    actual inline fun strong(className: String?) { append(E(this, "strong", className)) }
    actual inline fun styleElement(className: String?) { append(E(this, "style", className)) }
    actual inline fun sub(className: String?) { append(E(this, "sub", className)) }
    actual inline fun summary(className: String?) { append(E(this, "summary", className)) }
    actual inline fun sup(className: String?) { append(E(this, "sup", className)) }
    actual inline fun table(className: String?) { append(E(this, "table", className)) }
    actual inline fun tbody(className: String?) { append(E(this, "tbody", className)) }
    actual inline fun td(className: String?) { append(E(this, "td", className)) }
    actual inline fun textarea(className: String?) { append(E(this, "textarea", className)) }
    actual inline fun tfoot(className: String?) { append(E(this, "tfoot", className)) }
    actual inline fun th(className: String?) { append(E(this, "th", className)) }
    actual inline fun thead(className: String?) { append(E(this, "thead", className)) }
    actual inline fun time(className: String?) { append(E(this, "time", className)) }
    actual inline fun title(className: String?) { append(E(this, "title", className)) }
    actual inline fun tr(className: String?) { append(E(this, "tr", className)) }
    actual inline fun track(className: String?) { append(E(this, "track", className)) }
    actual inline fun u(className: String?) { append(E(this, "u", className)) }
    actual inline fun ul(className: String?) { append(E(this, "ul", className)) }
    actual inline fun varElement(className: String?) { append(E(this, "var", className)) }
    actual inline fun video(className: String?) { append(E(this, "video", className)) }
    actual inline fun wbr(className: String?) { append(E(this, "wbr", className)) }

    actual inline fun a(className: String, attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<AnchorHTMLAttributes<HTMLAnchorElement>>()
        a.attr()
        a.className = className
        val e = E(this, "a", a)
        e.block()
        append(e)
    }
    actual inline fun address(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "address", a)
        e.block()
        append(e)
    }
    actual inline fun area(className: String, attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<AreaHTMLAttributes<HTMLAreaElement>>()
        a.attr()
        a.className = className
        val e = E(this, "area", a)
        e.block()
        append(e)
    }
    actual inline fun article(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "article", a)
        e.block()
        append(e)
    }
    actual inline fun aside(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "aside", a)
        e.block()
        append(e)
    }
    actual inline fun audio(className: String, attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<AudioHTMLAttributes<HTMLAudioElement>>()
        a.attr()
        a.className = className
        val e = E(this, "audio", a)
        e.block()
        append(e)
    }
    actual inline fun b(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "b", a)
        e.block()
        append(e)
    }
    actual inline fun base(className: String, attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<BaseHTMLAttributes<HTMLBaseElement>>()
        a.attr()
        a.className = className
        val e = E(this, "base", a)
        e.block()
        append(e)
    }
    actual inline fun bdi(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "bdi", a)
        e.block()
        append(e)
    }
    actual inline fun bdo(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "bdo", a)
        e.block()
        append(e)
    }
    actual inline fun big(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "big", a)
        e.block()
        append(e)
    }
    actual inline fun blockquote(className: String, attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<BlockquoteHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "blockquote", a)
        e.block()
        append(e)
    }
    actual inline fun body(className: String, attr: Attr<HTMLAttributes<HTMLBodyElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBodyElement>>()
        a.attr()
        a.className = className
        val e = E(this, "body", a)
        e.block()
        append(e)
    }
    actual inline fun br(className: String, attr: Attr<HTMLAttributes<HTMLBRElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBRElement>>()
        a.attr()
        a.className = className
        val e = E(this, "br", a)
        e.block()
        append(e)
    }
    actual inline fun button(className: String, attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ButtonHTMLAttributes<HTMLButtonElement>>()
        a.attr()
        a.className = className
        val e = E(this, "button", a)
        e.block()
        append(e)
    }
    actual inline fun canvas(className: String, attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<CanvasHTMLAttributes<HTMLCanvasElement>>()
        a.attr()
        a.className = className
        val e = E(this, "canvas", a)
        e.block()
        append(e)
    }
    actual inline fun caption(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "caption", a)
        e.block()
        append(e)
    }
    actual inline fun cite(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "cite", a)
        e.block()
        append(e)
    }
    actual inline fun code(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "code", a)
        e.block()
        append(e)
    }
    actual inline fun col(className: String, attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ColHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        a.className = className
        val e = E(this, "col", a)
        e.block()
        append(e)
    }
    actual inline fun colgroup(className: String, attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ColgroupHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        a.className = className
        val e = E(this, "colgroup", a)
        e.block()
        append(e)
    }
    actual inline fun data(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "data", a)
        e.block()
        append(e)
    }
    actual inline fun datalist(className: String, attr: Attr<HTMLAttributes<HTMLDataListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDataListElement>>()
        a.attr()
        a.className = className
        val e = E(this, "datalist", a)
        e.block()
        append(e)
    }
    actual inline fun dd(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "dd", a)
        e.block()
        append(e)
    }
    actual inline fun del(className: String, attr: Attr<DelHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<DelHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "del", a)
        e.block()
        append(e)
    }
    actual inline fun details(className: String, attr: Attr<DetailsHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<DetailsHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "details", a)
        e.block()
        append(e)
    }
    actual inline fun dfn(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "dfn", a)
        e.block()
        append(e)
    }
    actual inline fun dialog(className: String, attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<DialogHTMLAttributes<HTMLDialogElement>>()
        a.attr()
        a.className = className
        val e = E(this, "dialog", a)
        e.block()
        append(e)
    }
    actual inline fun div(className: String, attr: Attr<HTMLAttributes<HTMLDivElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDivElement>>()
        a.attr()
        a.className = className
        val e = E(this, "div", a)
        e.block()
        append(e)
    }
    actual inline fun dl(className: String, attr: Attr<HTMLAttributes<HTMLDListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDListElement>>()
        a.attr()
        a.className = className
        val e = E(this, "dl", a)
        e.block()
        append(e)
    }
    actual inline fun dt(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "dt", a)
        e.block()
        append(e)
    }
    actual inline fun em(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "em", a)
        e.block()
        append(e)
    }
    actual inline fun embed(className: String, attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<EmbedHTMLAttributes<HTMLEmbedElement>>()
        a.attr()
        a.className = className
        val e = E(this, "embed", a)
        e.block()
        append(e)
    }
    actual inline fun fieldset(className: String, attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<FieldsetHTMLAttributes<HTMLFieldSetElement>>()
        a.attr()
        a.className = className
        val e = E(this, "fieldset", a)
        e.block()
        append(e)
    }
    actual inline fun figcaption(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "figcaption", a)
        e.block()
        append(e)
    }
    actual inline fun figure(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "figure", a)
        e.block()
        append(e)
    }
    actual inline fun footer(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "footer", a)
        e.block()
        append(e)
    }
    actual inline fun form(className: String, attr: Attr<FormHTMLAttributes<HTMLFormElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<FormHTMLAttributes<HTMLFormElement>>()
        a.attr()
        a.className = className
        val e = E(this, "form", a)
        e.block()
        append(e)
    }
    actual inline fun h1(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        val e = E(this, "h1", a)
        e.block()
        append(e)
    }
    actual inline fun h2(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        val e = E(this, "h2", a)
        e.block()
        append(e)
    }
    actual inline fun h3(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        val e = E(this, "h3", a)
        e.block()
        append(e)
    }
    actual inline fun h4(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        val e = E(this, "h4", a)
        e.block()
        append(e)
    }
    actual inline fun h5(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        val e = E(this, "h5", a)
        e.block()
        append(e)
    }
    actual inline fun h6(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        a.className = className
        val e = E(this, "h6", a)
        e.block()
        append(e)
    }
    actual inline fun head(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "start", a)
        e.block()
        append(e)
    }
    actual inline fun header(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "header", a)
        e.block()
        append(e)
    }
    actual inline fun hgroup(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "hgroup", a)
        e.block()
        append(e)
    }
    actual inline fun hr(className: String, attr: Attr<HTMLAttributes<HTMLHRElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHRElement>>()
        a.attr()
        a.className = className
        val e = E(this, "hr", a)
        e.block()
        append(e)
    }
    actual inline fun html(className: String, attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HtmlHTMLAttributes<HTMLHtmlElement>>()
        a.attr()
        a.className = className
        val e = E(this, "html", a)
        e.block()
        append(e)
    }
    actual inline fun i(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "i", a)
        e.block()
        append(e)
    }
    actual inline fun iframe(className: String, attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<IframeHTMLAttributes<HTMLIFrameElement>>()
        a.attr()
        a.className = className
        val e = E(this, "iframe", a)
        e.block()
        append(e)
    }
    actual inline fun img(className: String, attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ImgHTMLAttributes<HTMLImageElement>>()
        a.attr()
        a.className = className
        val e = E(this, "img", a)
        e.block()
        append(e)
    }
    actual inline fun input(className: String, attr: Attr<InputHTMLAttributes<HTMLInputElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<InputHTMLAttributes<HTMLInputElement>>()
        a.attr()
        a.className = className
        val e = E(this, "input", a)
        e.block()
        append(e)
    }
    actual inline fun ins(className: String, attr: Attr<InsHTMLAttributes<HTMLModElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<InsHTMLAttributes<HTMLModElement>>()
        a.attr()
        a.className = className
        val e = E(this, "ins", a)
        e.block()
        append(e)
    }
    actual inline fun kbd(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "kbd", a)
        e.block()
        append(e)
    }
    actual inline fun keygen(className: String, attr: Attr<KeygenHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<KeygenHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "keygen", a)
        e.block()
        append(e)
    }
    actual inline fun label(className: String, attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<LabelHTMLAttributes<HTMLLabelElement>>()
        a.attr()
        a.className = className
        val e = E(this, "label", a)
        e.block()
        append(e)
    }
    actual inline fun legend(className: String, attr: Attr<HTMLAttributes<HTMLLegendElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLLegendElement>>()
        a.attr()
        a.className = className
        val e = E(this, "legend", a)
        e.block()
        append(e)
    }
    actual inline fun li(className: String, attr: Attr<LiHTMLAttributes<HTMLLIElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<LiHTMLAttributes<HTMLLIElement>>()
        a.attr()
        a.className = className
        val e = E(this, "li", a)
        e.block()
        append(e)
    }
    actual inline fun link(className: String, attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<LinkHTMLAttributes<HTMLLinkElement>>()
        a.attr()
        a.className = className
        val e = E(this, "link", a)
        e.block()
        append(e)
    }
    actual inline fun main(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "main", a)
        e.block()
        append(e)
    }
    actual inline fun map(className: String, attr: Attr<MapHTMLAttributes<HTMLMapElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MapHTMLAttributes<HTMLMapElement>>()
        a.attr()
        a.className = className
        val e = E(this, "map", a)
        e.block()
        append(e)
    }
    actual inline fun mark(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "mark", a)
        e.block()
        append(e)
    }
    actual inline fun menu(className: String, attr: Attr<MenuHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MenuHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "menu", a)
        e.block()
        append(e)
    }
    actual inline fun menuitem(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "menuitem", a)
        e.block()
        append(e)
    }
    actual inline fun meta(className: String, attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MetaHTMLAttributes<HTMLMetaElement>>()
        a.attr()
        a.className = className
        val e = E(this, "meta", a)
        e.block()
        append(e)
    }
    actual inline fun meter(className: String, attr: Attr<MeterHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MeterHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "meter", a)
        e.block()
        append(e)
    }
    actual inline fun nav(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "nav", a)
        e.block()
        append(e)
    }
    actual inline fun noscript(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "noscript", a)
        e.block()
        append(e)
    }
    actual inline fun objectElement(className: String, attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ObjectHTMLAttributes<HTMLObjectElement>>()
        a.attr()
        a.className = className
        val e = E(this, "object", a)
        e.block()
        append(e)
    }
    actual inline fun ol(className: String, attr: Attr<OlHTMLAttributes<HTMLOListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OlHTMLAttributes<HTMLOListElement>>()
        a.attr()
        a.className = className
        val e = E(this, "ol", a)
        e.block()
        append(e)
    }
    actual inline fun optgroup(className: String, attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OptgroupHTMLAttributes<HTMLOptGroupElement>>()
        a.attr()
        a.className = className
        val e = E(this, "optgroup", a)
        e.block()
        append(e)
    }
    actual inline fun option(className: String, attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OptionHTMLAttributes<HTMLOptionElement>>()
        a.attr()
        a.className = className
        val e = E(this, "option", a)
        e.block()
        append(e)
    }
    actual inline fun output(className: String, attr: Attr<OutputHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OutputHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "output", a)
        e.block()
        append(e)
    }
    actual inline fun p(className: String, attr: Attr<HTMLAttributes<HTMLParagraphElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLParagraphElement>>()
        a.attr()
        a.className = className
        val e = E(this, "p", a)
        e.block()
        append(e)
    }
    actual inline fun param(className: String, attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ParamHTMLAttributes<HTMLParamElement>>()
        a.attr()
        a.className = className
        val e = E(this, "param", a)
        e.block()
        append(e)
    }
    actual inline fun picture(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "picture", a)
        e.block()
        append(e)
    }
    actual inline fun pre(className: String, attr: Attr<HTMLAttributes<HTMLPreElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLPreElement>>()
        a.attr()
        a.className = className
        val e = E(this, "pre", a)
        e.block()
        append(e)
    }
    actual inline fun progress(className: String, attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ProgressHTMLAttributes<HTMLProgressElement>>()
        a.attr()
        a.className = className
        val e = E(this, "progress", a)
        e.block()
        append(e)
    }
    actual inline fun q(className: String, attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<QuoteHTMLAttributes<HTMLQuoteElement>>()
        a.attr()
        a.className = className
        val e = E(this, "q", a)
        e.block()
        append(e)
    }
    actual inline fun rp(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "rp", a)
        e.block()
        append(e)
    }
    actual inline fun rt(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "rt", a)
        e.block()
        append(e)
    }
    actual inline fun ruby(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "ruby", a)
        e.block()
        append(e)
    }
    actual inline fun s(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "s", a)
        e.block()
        append(e)
    }
    actual inline fun samp(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "samp", a)
        e.block()
        append(e)
    }
    actual inline fun script(className: String, attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ScriptHTMLAttributes<HTMLScriptElement>>()
        a.attr()
        a.className = className
        val e = E(this, "script", a)
        e.block()
        append(e)
    }
    actual inline fun section(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "section", a)
        e.block()
        append(e)
    }
    actual inline fun select(className: String, attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<SelectHTMLAttributes<HTMLSelectElement>>()
        a.attr()
        a.className = className
        val e = E(this, "select", a)
        e.block()
        append(e)
    }
    actual inline fun small(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "small", a)
        e.block()
        append(e)
    }
    actual inline fun source(className: String, attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<SourceHTMLAttributes<HTMLSourceElement>>()
        a.attr()
        a.className = className
        val e = E(this, "source", a)
        e.block()
        append(e)
    }
    actual inline fun span(className: String, attr: Attr<HTMLAttributes<HTMLSpanElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLSpanElement>>()
        a.attr()
        a.className = className
        val e = E(this, "span", a)
        e.block()
        append(e)
    }
    actual inline fun strong(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "strong", a)
        e.block()
        append(e)
    }
    actual inline fun styleElement(className: String, attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<StyleHTMLAttributes<HTMLStyleElement>>()
        a.attr()
        a.className = className
        val e = E(this, "style", a)
        e.block()
        append(e)
    }
    actual inline fun sub(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "sub", a)
        e.block()
        append(e)
    }
    actual inline fun summary(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "summary", a)
        e.block()
        append(e)
    }
    actual inline fun sup(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "sup", a)
        e.block()
        append(e)
    }
    actual inline fun table(className: String, attr: Attr<TableHTMLAttributes<HTMLTableElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TableHTMLAttributes<HTMLTableElement>>()
        a.attr()
        a.className = className
        val e = E(this, "table", a)
        e.block()
        append(e)
    }
    actual inline fun tbody(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        a.className = className
        val e = E(this, "tbody", a)
        e.block()
        append(e)
    }
    actual inline fun td(className: String, attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TdHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        a.className = className
        val e = E(this, "td", a)
        e.block()
        append(e)
    }
    actual inline fun textarea(className: String, attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TextareaHTMLAttributes<HTMLTextAreaElement>>()
        a.attr()
        a.className = className
        val e = E(this, "textarea", a)
        e.block()
        append(e)
    }
    actual inline fun tfoot(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        a.className = className
        val e = E(this, "tfoot", a)
        e.block()
        append(e)
    }
    actual inline fun th(className: String, attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ThHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        a.className = className
        val e = E(this, "th", a)
        e.block()
        append(e)
    }
    actual inline fun thead(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        a.className = className
        val e = E(this, "thead", a)
        e.block()
        append(e)
    }
    actual inline fun time(className: String, attr: Attr<TimeHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TimeHTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "time", a)
        e.block()
        append(e)
    }
    actual inline fun title(className: String, attr: Attr<HTMLAttributes<HTMLTitleElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTitleElement>>()
        a.attr()
        a.className = className
        val e = E(this, "title", a)
        e.block()
        append(e)
    }
    actual inline fun tr(className: String, attr: Attr<HTMLAttributes<HTMLTableRowElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableRowElement>>()
        a.attr()
        a.className = className
        val e = E(this, "tr", a)
        e.block()
        append(e)
    }
    actual inline fun track(className: String, attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TrackHTMLAttributes<HTMLTrackElement>>()
        a.attr()
        a.className = className
        val e = E(this, "track", a)
        e.block()
        append(e)
    }
    actual inline fun u(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "u", a)
        e.block()
        append(e)
    }
    actual inline fun ul(className: String, attr: Attr<HTMLAttributes<HTMLUListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLUListElement>>()
        a.attr()
        a.className = className
        val e = E(this, "ul", a)
        e.block()
        append(e)
    }
    actual inline fun varElement(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "var", a)
        e.block()
        append(e)
    }
    actual inline fun video(className: String, attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<VideoHTMLAttributes<HTMLVideoElement>>()
        a.attr()
        a.className = className
        val e = E(this, "video", a)
        e.block()
        append(e)
    }
    actual inline fun wbr(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        a.className = className
        val e = E(this, "wbr", a)
        e.block()
        append(e)
    }

    actual inline fun a(attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<AnchorHTMLAttributes<HTMLAnchorElement>>()
        a.attr()
        val e = E(this, "a", a)
        e.block()
        append(e)
    }
    actual inline fun address(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "address", a)
        e.block()
        append(e)
    }
    actual inline fun area(attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<AreaHTMLAttributes<HTMLAreaElement>>()
        a.attr()
        val e = E(this, "area", a)
        e.block()
        append(e)
    }
    actual inline fun article(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "article", a)
        e.block()
        append(e)
    }
    actual inline fun aside(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "aside", a)
        e.block()
        append(e)
    }
    actual inline fun audio(attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<AudioHTMLAttributes<HTMLAudioElement>>()
        a.attr()
        val e = E(this, "audio", a)
        e.block()
        append(e)
    }
    actual inline fun b(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "b", a)
        e.block()
        append(e)
    }
    actual inline fun base(attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<BaseHTMLAttributes<HTMLBaseElement>>()
        a.attr()
        val e = E(this, "base", a)
        e.block()
        append(e)
    }
    actual inline fun bdi(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "bdi", a)
        e.block()
        append(e)
    }
    actual inline fun bdo(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "bdo", a)
        e.block()
        append(e)
    }
    actual inline fun big(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "big", a)
        e.block()
        append(e)
    }
    actual inline fun blockquote(attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<BlockquoteHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "blockquote", a)
        e.block()
        append(e)
    }
    actual inline fun body(attr: Attr<HTMLAttributes<HTMLBodyElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBodyElement>>()
        a.attr()
        val e = E(this, "body", a)
        e.block()
        append(e)
    }
    actual inline fun br(attr: Attr<HTMLAttributes<HTMLBRElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLBRElement>>()
        a.attr()
        val e = E(this, "br", a)
        e.block()
        append(e)
    }
    actual inline fun button(attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ButtonHTMLAttributes<HTMLButtonElement>>()
        a.attr()
        val e = E(this, "button", a)
        e.block()
        append(e)
    }
    actual inline fun canvas(attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<CanvasHTMLAttributes<HTMLCanvasElement>>()
        a.attr()
        val e = E(this, "canvas", a)
        e.block()
        append(e)
    }
    actual inline fun caption(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "caption", a)
        e.block()
        append(e)
    }
    actual inline fun cite(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "cite", a)
        e.block()
        append(e)
    }
    actual inline fun code(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "code", a)
        e.block()
        append(e)
    }
    actual inline fun col(attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ColHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        val e = E(this, "col", a)
        e.block()
        append(e)
    }
    actual inline fun colgroup(attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ColgroupHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        val e = E(this, "colgroup", a)
        e.block()
        append(e)
    }
    actual inline fun data(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "data", a)
        e.block()
        append(e)
    }
    actual inline fun datalist(attr: Attr<HTMLAttributes<HTMLDataListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDataListElement>>()
        a.attr()
        val e = E(this, "datalist", a)
        e.block()
        append(e)
    }
    actual inline fun dd(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "dd", a)
        e.block()
        append(e)
    }
    actual inline fun del(attr: Attr<DelHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<DelHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "del", a)
        e.block()
        append(e)
    }
    actual inline fun details(attr: Attr<DetailsHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<DetailsHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "details", a)
        e.block()
        append(e)
    }
    actual inline fun dfn(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "dfn", a)
        e.block()
        append(e)
    }
    actual inline fun dialog(attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<DialogHTMLAttributes<HTMLDialogElement>>()
        a.attr()
        val e = E(this, "dialog", a)
        e.block()
        append(e)
    }
    actual inline fun div(attr: Attr<HTMLAttributes<HTMLDivElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDivElement>>()
        a.attr()
        val e = E(this, "div", a)
        e.block()
        append(e)
    }
    actual inline fun dl(attr: Attr<HTMLAttributes<HTMLDListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLDListElement>>()
        a.attr()
        val e = E(this, "dl", a)
        e.block()
        append(e)
    }
    actual inline fun dt(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "dt", a)
        e.block()
        append(e)
    }
    actual inline fun em(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "em", a)
        e.block()
        append(e)
    }
    actual inline fun embed(attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<EmbedHTMLAttributes<HTMLEmbedElement>>()
        a.attr()
        val e = E(this, "embed", a)
        e.block()
        append(e)
    }
    actual inline fun fieldset(attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<FieldsetHTMLAttributes<HTMLFieldSetElement>>()
        a.attr()
        val e = E(this, "fieldset", a)
        e.block()
        append(e)
    }
    actual inline fun figcaption(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "figcaption", a)
        e.block()
        append(e)
    }
    actual inline fun figure(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "figure", a)
        e.block()
        append(e)
    }
    actual inline fun footer(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "footer", a)
        e.block()
        append(e)
    }
    actual inline fun form(attr: Attr<FormHTMLAttributes<HTMLFormElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<FormHTMLAttributes<HTMLFormElement>>()
        a.attr()
        val e = E(this, "form", a)
        e.block()
        append(e)
    }
    actual inline fun h1(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        val e = E(this, "h1", a)
        e.block()
        append(e)
    }
    actual inline fun h2(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        val e = E(this, "h2", a)
        e.block()
        append(e)
    }
    actual inline fun h3(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        val e = E(this, "h3", a)
        e.block()
        append(e)
    }
    actual inline fun h4(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        val e = E(this, "h4", a)
        e.block()
        append(e)
    }
    actual inline fun h5(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        val e = E(this, "h5", a)
        e.block()
        append(e)
    }
    actual inline fun h6(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        val e = E(this, "h6", a)
        e.block()
        append(e)
    }
    actual inline fun head(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "start", a)
        e.block()
        append(e)
    }
    actual inline fun header(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "header", a)
        e.block()
        append(e)
    }
    actual inline fun hgroup(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "hgroup", a)
        e.block()
        append(e)
    }
    actual inline fun hr(attr: Attr<HTMLAttributes<HTMLHRElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLHRElement>>()
        a.attr()
        val e = E(this, "hr", a)
        e.block()
        append(e)
    }
    actual inline fun html(attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HtmlHTMLAttributes<HTMLHtmlElement>>()
        a.attr()
        val e = E(this, "html", a)
        e.block()
        append(e)
    }
    actual inline fun i(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "i", a)
        e.block()
        append(e)
    }
    actual inline fun iframe(attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<IframeHTMLAttributes<HTMLIFrameElement>>()
        a.attr()
        val e = E(this, "iframe", a)
        e.block()
        append(e)
    }
    actual inline fun img(attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ImgHTMLAttributes<HTMLImageElement>>()
        a.attr()
        val e = E(this, "img", a)
        e.block()
        append(e)
    }
    actual inline fun input(attr: Attr<InputHTMLAttributes<HTMLInputElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<InputHTMLAttributes<HTMLInputElement>>()
        a.attr()
        val e = E(this, "input", a)
        e.block()
        append(e)
    }
    actual inline fun ins(attr: Attr<InsHTMLAttributes<HTMLModElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<InsHTMLAttributes<HTMLModElement>>()
        a.attr()
        val e = E(this, "ins", a)
        e.block()
        append(e)
    }
    actual inline fun kbd(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "kbd", a)
        e.block()
        append(e)
    }
    actual inline fun keygen(attr: Attr<KeygenHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<KeygenHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "keygen", a)
        e.block()
        append(e)
    }
    actual inline fun label(attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<LabelHTMLAttributes<HTMLLabelElement>>()
        a.attr()
        val e = E(this, "label", a)
        e.block()
        append(e)
    }
    actual inline fun legend(attr: Attr<HTMLAttributes<HTMLLegendElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLLegendElement>>()
        a.attr()
        val e = E(this, "legend", a)
        e.block()
        append(e)
    }
    actual inline fun li(attr: Attr<LiHTMLAttributes<HTMLLIElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<LiHTMLAttributes<HTMLLIElement>>()
        a.attr()
        val e = E(this, "li", a)
        e.block()
        append(e)
    }
    actual inline fun link(attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<LinkHTMLAttributes<HTMLLinkElement>>()
        a.attr()
        val e = E(this, "link", a)
        e.block()
        append(e)
    }
    actual inline fun main(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "main", a)
        e.block()
        append(e)
    }
    actual inline fun map(attr: Attr<MapHTMLAttributes<HTMLMapElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MapHTMLAttributes<HTMLMapElement>>()
        a.attr()
        val e = E(this, "map", a)
        e.block()
        append(e)
    }
    actual inline fun mark(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "mark", a)
        e.block()
        append(e)
    }
    actual inline fun menu(attr: Attr<MenuHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MenuHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "menu", a)
        e.block()
        append(e)
    }
    actual inline fun menuitem(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "menuitem", a)
        e.block()
        append(e)
    }
    actual inline fun meta(attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MetaHTMLAttributes<HTMLMetaElement>>()
        a.attr()
        val e = E(this, "meta", a)
        e.block()
        append(e)
    }
    actual inline fun meter(attr: Attr<MeterHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<MeterHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "meter", a)
        e.block()
        append(e)
    }
    actual inline fun nav(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "nav", a)
        e.block()
        append(e)
    }
    actual inline fun noscript(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "noscript", a)
        e.block()
        append(e)
    }
    actual inline fun objectElement(attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ObjectHTMLAttributes<HTMLObjectElement>>()
        a.attr()
        val e = E(this, "object", a)
        e.block()
        append(e)
    }
    actual inline fun ol(attr: Attr<OlHTMLAttributes<HTMLOListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OlHTMLAttributes<HTMLOListElement>>()
        a.attr()
        val e = E(this, "ol", a)
        e.block()
        append(e)
    }
    actual inline fun optgroup(attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OptgroupHTMLAttributes<HTMLOptGroupElement>>()
        a.attr()
        val e = E(this, "optgroup", a)
        e.block()
        append(e)
    }
    actual inline fun option(attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OptionHTMLAttributes<HTMLOptionElement>>()
        a.attr()
        val e = E(this, "option", a)
        e.block()
        append(e)
    }
    actual inline fun output(attr: Attr<OutputHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<OutputHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "output", a)
        e.block()
        append(e)
    }
    actual inline fun p(attr: Attr<HTMLAttributes<HTMLParagraphElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLParagraphElement>>()
        a.attr()
        val e = E(this, "p", a)
        e.block()
        append(e)
    }
    actual inline fun param(attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ParamHTMLAttributes<HTMLParamElement>>()
        a.attr()
        val e = E(this, "param", a)
        e.block()
        append(e)
    }
    actual inline fun picture(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "picture", a)
        e.block()
        append(e)
    }
    actual inline fun pre(attr: Attr<HTMLAttributes<HTMLPreElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLPreElement>>()
        a.attr()
        val e = E(this, "pre", a)
        e.block()
        append(e)
    }
    actual inline fun progress(attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ProgressHTMLAttributes<HTMLProgressElement>>()
        a.attr()
        val e = E(this, "progress", a)
        e.block()
        append(e)
    }
    actual inline fun q(attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<QuoteHTMLAttributes<HTMLQuoteElement>>()
        a.attr()
        val e = E(this, "q", a)
        e.block()
        append(e)
    }
    actual inline fun rp(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "rp", a)
        e.block()
        append(e)
    }
    actual inline fun rt(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "rt", a)
        e.block()
        append(e)
    }
    actual inline fun ruby(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "ruby", a)
        e.block()
        append(e)
    }
    actual inline fun s(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "s", a)
        e.block()
        append(e)
    }
    actual inline fun samp(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "samp", a)
        e.block()
        append(e)
    }
    actual inline fun script(attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ScriptHTMLAttributes<HTMLScriptElement>>()
        a.attr()
        val e = E(this, "script", a)
        e.block()
        append(e)
    }
    actual inline fun section(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "section", a)
        e.block()
        append(e)
    }
    actual inline fun select(attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<SelectHTMLAttributes<HTMLSelectElement>>()
        a.attr()
        val e = E(this, "select", a)
        e.block()
        append(e)
    }
    actual inline fun small(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "small", a)
        e.block()
        append(e)
    }
    actual inline fun source(attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<SourceHTMLAttributes<HTMLSourceElement>>()
        a.attr()
        val e = E(this, "source", a)
        e.block()
        append(e)
    }
    actual inline fun span(attr: Attr<HTMLAttributes<HTMLSpanElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLSpanElement>>()
        a.attr()
        val e = E(this, "span", a)
        e.block()
        append(e)
    }
    actual inline fun strong(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "strong", a)
        e.block()
        append(e)
    }
    actual inline fun styleElement(attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<StyleHTMLAttributes<HTMLStyleElement>>()
        a.attr()
        val e = E(this, "style", a)
        e.block()
        append(e)
    }
    actual inline fun sub(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "sub", a)
        e.block()
        append(e)
    }
    actual inline fun summary(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "summary", a)
        e.block()
        append(e)
    }
    actual inline fun sup(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "sup", a)
        e.block()
        append(e)
    }
    actual inline fun table(attr: Attr<TableHTMLAttributes<HTMLTableElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TableHTMLAttributes<HTMLTableElement>>()
        a.attr()
        val e = E(this, "table", a)
        e.block()
        append(e)
    }
    actual inline fun tbody(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        val e = E(this, "tbody", a)
        e.block()
        append(e)
    }
    actual inline fun td(attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TdHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        val e = E(this, "td", a)
        e.block()
        append(e)
    }
    actual inline fun textarea(attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TextareaHTMLAttributes<HTMLTextAreaElement>>()
        a.attr()
        val e = E(this, "textarea", a)
        e.block()
        append(e)
    }
    actual inline fun tfoot(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        val e = E(this, "tfoot", a)
        e.block()
        append(e)
    }
    actual inline fun th(attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<ThHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        val e = E(this, "th", a)
        e.block()
        append(e)
    }
    actual inline fun thead(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        val e = E(this, "thead", a)
        e.block()
        append(e)
    }
    actual inline fun time(attr: Attr<TimeHTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TimeHTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "time", a)
        e.block()
        append(e)
    }
    actual inline fun title(attr: Attr<HTMLAttributes<HTMLTitleElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTitleElement>>()
        a.attr()
        val e = E(this, "title", a)
        e.block()
        append(e)
    }
    actual inline fun tr(attr: Attr<HTMLAttributes<HTMLTableRowElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLTableRowElement>>()
        a.attr()
        val e = E(this, "tr", a)
        e.block()
        append(e)
    }
    actual inline fun track(attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<TrackHTMLAttributes<HTMLTrackElement>>()
        a.attr()
        val e = E(this, "track", a)
        e.block()
        append(e)
    }
    actual inline fun u(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "u", a)
        e.block()
        append(e)
    }
    actual inline fun ul(attr: Attr<HTMLAttributes<HTMLUListElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLUListElement>>()
        a.attr()
        val e = E(this, "ul", a)
        e.block()
        append(e)
    }
    actual inline fun varElement(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "var", a)
        e.block()
        append(e)
    }
    actual inline fun video(attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<VideoHTMLAttributes<HTMLVideoElement>>()
        a.attr()
        val e = E(this, "video", a)
        e.block()
        append(e)
    }
    actual inline fun wbr(attr: Attr<HTMLAttributes<HTMLElement>>, block: Nodes) {
        val a = js("new Object").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        val e = E(this, "wbr", a)
        e.block()
        append(e)
    }
}
