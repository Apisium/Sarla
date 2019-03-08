@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION", "UNUSED", "ASSIGNMENT_IN_EXPRESSION_CONTEXT")

package cn.apisium.sarla.nodes

import cn.apisium.sarla.*
import cn.apisium.sarla.Attr
import cn.apisium.sarla.dom.*

actual class NodeBlock(parent: Node?, val renderFunc: Nodes?): Node(parent) {
    var head: Node? = null
    var end: Node? = null

    actual fun <T : Any> Data<T>.get(key: Any): Data<T> = Data(object{}.unsafeCast<T>())

    actual inline fun Data<*>.get(key: Any): Data<*> = Data(object{})

    @Suppress("UNSAFE_CALL")
    @JsName("_")
    fun append(node: Node) {
        if (head == null) head = end = node else end = end.next = node
    }

    inline fun tag(tagName: String, attr: Any?, noinline block: Nodes?) {
        append(ElementNode(this, tagName, block?.let {
            val n = NodeBlock(this, block)
            n.it()
            n
        }, attr))
    }

    actual inline operator fun String.unaryPlus() {
        append(StringNode(this@NodeBlock, this))
    }

    actual inline operator fun Number.unaryPlus() {
        append(StringNode(this@NodeBlock, this.toString()))
    }

    actual inline operator fun Nothing.unaryPlus() {
        append(NullNode(this@NodeBlock))
    }

    actual inline operator fun Unit.unaryPlus() {
        append(NullNode(this@NodeBlock))
    }

    actual inline operator fun <P, T: SarlaProp<P>> SarlaInstantProp<T>.invoke(props: P?, noinline block: Nodes?) {
        append(SarlaNode(this@NodeBlock, this.clazz, props, block, true))
    }

    actual inline operator fun <T: Sarla> SarlaInstantNoProp<T>.invoke(noinline block: Nodes?) {
        append(SarlaNode(this@NodeBlock, this.clazz, null, block, false))
    }

    actual inline fun a(className: String?, noinline block: Nodes?) { tag("a", className, block) }
    actual inline fun address(className: String?, noinline block: Nodes?) { tag("address", className, block) }
    actual inline fun area(className: String?, noinline block: Nodes?) { tag("area", className, block) }
    actual inline fun article(className: String?, noinline block: Nodes?) { tag("article", className, block) }
    actual inline fun aside(className: String?, noinline block: Nodes?) { tag("aside", className, block) }
    actual inline fun audio(className: String?, noinline block: Nodes?) { tag("audio", className, block) }
    actual inline fun b(className: String?, noinline block: Nodes?) { tag("b", className, block) }
    actual inline fun base(className: String?, noinline block: Nodes?) { tag("base", className, block) }
    actual inline fun bdi(className: String?, noinline block: Nodes?) { tag("bdi", className, block) }
    actual inline fun bdo(className: String?, noinline block: Nodes?) { tag("bdo", className, block) }
    actual inline fun big(className: String?, noinline block: Nodes?) { tag("big", className, block) }
    actual inline fun blockquote(className: String?, noinline block: Nodes?) { tag("blockquote", className, block) }
    actual inline fun body(className: String?, noinline block: Nodes?) { tag("body", className, block) }
    actual inline fun br(className: String?, noinline block: Nodes?) { tag("br", className, block) }
    actual inline fun button(className: String?, noinline block: Nodes?) { tag("button", className, block) }
    actual inline fun canvas(className: String?, noinline block: Nodes?) { tag("canvas", className, block) }
    actual inline fun caption(className: String?, noinline block: Nodes?) { tag("caption", className, block) }
    actual inline fun cite(className: String?, noinline block: Nodes?) { tag("cite", className, block) }
    actual inline fun code(className: String?, noinline block: Nodes?) { tag("code", className, block) }
    actual inline fun col(className: String?, noinline block: Nodes?) { tag("col", className, block) }
    actual inline fun colgroup(className: String?, noinline block: Nodes?) { tag("colgroup", className, block) }
    actual inline fun data(className: String?, noinline block: Nodes?) { tag("data", className, block) }
    actual inline fun datalist(className: String?, noinline block: Nodes?) { tag("datalist", className, block) }
    actual inline fun dd(className: String?, noinline block: Nodes?) { tag("dd", className, block) }
    actual inline fun del(className: String?, noinline block: Nodes?) { tag("del", className, block) }
    actual inline fun details(className: String?, noinline block: Nodes?) { tag("details", className, block) }
    actual inline fun dfn(className: String?, noinline block: Nodes?) { tag("dfn", className, block) }
    actual inline fun dialog(className: String?, noinline block: Nodes?) { tag("dialog", className, block) }
    actual inline fun div(className: String?, noinline block: Nodes?) { tag("div", className, block) }
    actual inline fun dl(className: String?, noinline block: Nodes?) { tag("dl", className, block) }
    actual inline fun dt(className: String?, noinline block: Nodes?) { tag("dt", className, block) }
    actual inline fun em(className: String?, noinline block: Nodes?) { tag("em", className, block) }
    actual inline fun embed(className: String?, noinline block: Nodes?) { tag("embed", className, block) }
    actual inline fun fieldset(className: String?, noinline block: Nodes?) { tag("fieldset", className, block) }
    actual inline fun figcaption(className: String?, noinline block: Nodes?) { tag("figcaption", className, block) }
    actual inline fun figure(className: String?, noinline block: Nodes?) { tag("figure", className, block) }
    actual inline fun footer(className: String?, noinline block: Nodes?) { tag("footer", className, block) }
    actual inline fun form(className: String?, noinline block: Nodes?) { tag("form", className, block) }
    actual inline fun h1(className: String?, noinline block: Nodes?) { tag("h1", className, block) }
    actual inline fun h2(className: String?, noinline block: Nodes?) { tag("h2", className, block) }
    actual inline fun h3(className: String?, noinline block: Nodes?) { tag("h3", className, block) }
    actual inline fun h4(className: String?, noinline block: Nodes?) { tag("h4", className, block) }
    actual inline fun h5(className: String?, noinline block: Nodes?) { tag("h5", className, block) }
    actual inline fun h6(className: String?, noinline block: Nodes?) { tag("h6", className, block) }
    actual inline fun head(className: String?, noinline block: Nodes?) { tag("head", className, block) }
    actual inline fun header(className: String?, noinline block: Nodes?) { tag("header", className, block) }
    actual inline fun hgroup(className: String?, noinline block: Nodes?) { tag("hgroup", className, block) }
    actual inline fun hr(className: String?, noinline block: Nodes?) { tag("hr", className, block) }
    actual inline fun html(className: String?, noinline block: Nodes?) { tag("html", className, block) }
    actual inline fun i(className: String?, noinline block: Nodes?) { tag("i", className, block) }
    actual inline fun iframe(className: String?, noinline block: Nodes?) { tag("iframe", className, block) }
    actual inline fun img(className: String?, noinline block: Nodes?) { tag("img", className, block) }
    actual inline fun input(className: String?, noinline block: Nodes?) { tag("input", className, block) }
    actual inline fun ins(className: String?, noinline block: Nodes?) { tag("ins", className, block) }
    actual inline fun kbd(className: String?, noinline block: Nodes?) { tag("kbd", className, block) }
    actual inline fun keygen(className: String?, noinline block: Nodes?) { tag("keygen", className, block) }
    actual inline fun label(className: String?, noinline block: Nodes?) { tag("label", className, block) }
    actual inline fun legend(className: String?, noinline block: Nodes?) { tag("legend", className, block) }
    actual inline fun li(className: String?, noinline block: Nodes?) { tag("li", className, block) }
    actual inline fun link(className: String?, noinline block: Nodes?) { tag("link", className, block) }
    actual inline fun main(className: String?, noinline block: Nodes?) { tag("main", className, block) }
    actual inline fun map(className: String?, noinline block: Nodes?) { tag("map", className, block) }
    actual inline fun mark(className: String?, noinline block: Nodes?) { tag("mark", className, block) }
    actual inline fun menu(className: String?, noinline block: Nodes?) { tag("menu", className, block) }
    actual inline fun menuitem(className: String?, noinline block: Nodes?) { tag("menuitem", className, block) }
    actual inline fun meta(className: String?, noinline block: Nodes?) { tag("meta", className, block) }
    actual inline fun meter(className: String?, noinline block: Nodes?) { tag("meter", className, block) }
    actual inline fun nav(className: String?, noinline block: Nodes?) { tag("nav", className, block) }
    actual inline fun noscript(className: String?, noinline block: Nodes?) { tag("noscript", className, block) }
    actual inline fun objectElement(className: String?, noinline block: Nodes?) { tag("object", className, block) }
    actual inline fun ol(className: String?, noinline block: Nodes?) { tag("ol", className, block) }
    actual inline fun optgroup(className: String?, noinline block: Nodes?) { tag("optgroup", className, block) }
    actual inline fun option(className: String?, noinline block: Nodes?) { tag("option", className, block) }
    actual inline fun output(className: String?, noinline block: Nodes?) { tag("output", className, block) }
    actual inline fun p(className: String?, noinline block: Nodes?) { tag("p", className, block) }
    actual inline fun param(className: String?, noinline block: Nodes?) { tag("param", className, block) }
    actual inline fun picture(className: String?, noinline block: Nodes?) { tag("picture", className, block) }
    actual inline fun pre(className: String?, noinline block: Nodes?) { tag("pre", className, block) }
    actual inline fun progress(className: String?, noinline block: Nodes?) { tag("progress", className, block) }
    actual inline fun q(className: String?, noinline block: Nodes?) { tag("q", className, block) }
    actual inline fun rp(className: String?, noinline block: Nodes?) { tag("rp", className, block) }
    actual inline fun rt(className: String?, noinline block: Nodes?) { tag("rt", className, block) }
    actual inline fun ruby(className: String?, noinline block: Nodes?) { tag("ruby", className, block) }
    actual inline fun s(className: String?, noinline block: Nodes?) { tag("s", className, block) }
    actual inline fun samp(className: String?, noinline block: Nodes?) { tag("samp", className, block) }
    actual inline fun script(className: String?, noinline block: Nodes?) { tag("script", className, block) }
    actual inline fun section(className: String?, noinline block: Nodes?) { tag("section", className, block) }
    actual inline fun select(className: String?, noinline block: Nodes?) { tag("select", className, block) }
    actual inline fun small(className: String?, noinline block: Nodes?) { tag("small", className, block) }
    actual inline fun source(className: String?, noinline block: Nodes?) { tag("source", className, block) }
    actual inline fun span(className: String?, noinline block: Nodes?) { tag("span", className, block) }
    actual inline fun strong(className: String?, noinline block: Nodes?) { tag("strong", className, block) }
    actual inline fun styleElement(className: String?, noinline block: Nodes?) { tag("style", className, block) }
    actual inline fun sub(className: String?, noinline block: Nodes?) { tag("sub", className, block) }
    actual inline fun summary(className: String?, noinline block: Nodes?) { tag("summary", className, block) }
    actual inline fun sup(className: String?, noinline block: Nodes?) { tag("sup", className, block) }
    actual inline fun table(className: String?, noinline block: Nodes?) { tag("table", className, block) }
    actual inline fun tbody(className: String?, noinline block: Nodes?) { tag("tbody", className, block) }
    actual inline fun td(className: String?, noinline block: Nodes?) { tag("td", className, block) }
    actual inline fun textarea(className: String?, noinline block: Nodes?) { tag("textarea", className, block) }
    actual inline fun tfoot(className: String?, noinline block: Nodes?) { tag("tfoot", className, block) }
    actual inline fun th(className: String?, noinline block: Nodes?) { tag("th", className, block) }
    actual inline fun thead(className: String?, noinline block: Nodes?) { tag("thead", className, block) }
    actual inline fun time(className: String?, noinline block: Nodes?) { tag("time", className, block) }
    actual inline fun title(className: String?, noinline block: Nodes?) { tag("title", className, block) }
    actual inline fun tr(className: String?, noinline block: Nodes?) { tag("tr", className, block) }
    actual inline fun track(className: String?, noinline block: Nodes?) { tag("track", className, block) }
    actual inline fun u(className: String?, noinline block: Nodes?) { tag("u", className, block) }
    actual inline fun ul(className: String?, noinline block: Nodes?) { tag("ul", className, block) }
    actual inline fun varElement(className: String?, noinline block: Nodes?) { tag("var", className, block) }
    actual inline fun video(className: String?, noinline block: Nodes?) { tag("video", className, block) }
    actual inline fun wbr(className: String?, noinline block: Nodes?) { tag("wbr", className, block) }

    actual inline fun a(attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<AnchorHTMLAttributes<HTMLAnchorElement>>()
        a.attr()
        tag("a", a, block)
    }
    actual inline fun address(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("address", a, block)
    }
    actual inline fun area(attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<AreaHTMLAttributes<HTMLAreaElement>>()
        a.attr()
        tag("area", a, block)
    }
    actual inline fun article(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("article", a, block)
    }
    actual inline fun aside(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("aside", a, block)
    }
    actual inline fun audio(attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<AudioHTMLAttributes<HTMLAudioElement>>()
        a.attr()
        tag("audio", a, block)
    }
    actual inline fun b(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("b", a, block)
    }
    actual inline fun base(attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<BaseHTMLAttributes<HTMLBaseElement>>()
        a.attr()
        tag("base", a, block)
    }
    actual inline fun bdi(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("bdi", a, block)
    }
    actual inline fun bdo(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("bdo", a, block)
    }
    actual inline fun big(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("big", a, block)
    }
    actual inline fun blockquote(attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<BlockquoteHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("blockquote", a, block)
    }
    actual inline fun body(attr: Attr<HTMLAttributes<HTMLBodyElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLBodyElement>>()
        a.attr()
        tag("body", a, block)
    }
    actual inline fun br(attr: Attr<HTMLAttributes<HTMLBRElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLBRElement>>()
        a.attr()
        tag("br", a, block)
    }
    actual inline fun button(attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ButtonHTMLAttributes<HTMLButtonElement>>()
        a.attr()
        tag("button", a, block)
    }
    actual inline fun canvas(attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<CanvasHTMLAttributes<HTMLCanvasElement>>()
        a.attr()
        tag("canvas", a, block)
    }
    actual inline fun caption(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("caption", a, block)
    }
    actual inline fun cite(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("cite", a, block)
    }
    actual inline fun code(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("code", a, block)
    }
    actual inline fun col(attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ColHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        tag("col", a, block)
    }
    actual inline fun colgroup(attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ColgroupHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        tag("colgroup", a, block)
    }
    actual inline fun data(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("data", a, block)
    }
    actual inline fun datalist(attr: Attr<HTMLAttributes<HTMLDataListElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLDataListElement>>()
        a.attr()
        tag("datalist", a, block)
    }
    actual inline fun dd(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dd", a, block)
    }
    actual inline fun del(attr: Attr<DelHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<DelHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("del", a, block)
    }
    actual inline fun details(attr: Attr<DetailsHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<DetailsHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("details", a, block)
    }
    actual inline fun dfn(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dfn", a, block)
    }
    actual inline fun dialog(attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<DialogHTMLAttributes<HTMLDialogElement>>()
        a.attr()
        tag("dialog", a, block)
    }
    actual inline fun div(attr: Attr<HTMLAttributes<HTMLDivElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLDivElement>>()
        a.attr()
        tag("div", a, block)
    }
    actual inline fun dl(attr: Attr<HTMLAttributes<HTMLDListElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLDListElement>>()
        a.attr()
        tag("dl", a, block)
    }
    actual inline fun dt(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dt", a, block)
    }
    actual inline fun em(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("em", a, block)
    }
    actual inline fun embed(attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<EmbedHTMLAttributes<HTMLEmbedElement>>()
        a.attr()
        tag("embed", a, block)
    }
    actual inline fun fieldset(attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<FieldsetHTMLAttributes<HTMLFieldSetElement>>()
        a.attr()
        tag("fieldset", a, block)
    }
    actual inline fun figcaption(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("figcaption", a, block)
    }
    actual inline fun figure(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("figure", a, block)
    }
    actual inline fun footer(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("footer", a, block)
    }
    actual inline fun form(attr: Attr<FormHTMLAttributes<HTMLFormElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<FormHTMLAttributes<HTMLFormElement>>()
        a.attr()
        tag("form", a, block)
    }
    actual inline fun h1(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h1", a, block)
    }
    actual inline fun h2(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h2", a, block)
    }
    actual inline fun h3(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h3", a, block)
    }
    actual inline fun h4(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h4", a, block)
    }
    actual inline fun h5(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h5", a, block)
    }
    actual inline fun h6(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h6", a, block)
    }
    actual inline fun head(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("head", a, block)
    }
    actual inline fun header(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("header", a, block)
    }
    actual inline fun hgroup(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("hgroup", a, block)
    }
    actual inline fun hr(attr: Attr<HTMLAttributes<HTMLHRElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLHRElement>>()
        a.attr()
        tag("hr", a, block)
    }
    actual inline fun html(attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HtmlHTMLAttributes<HTMLHtmlElement>>()
        a.attr()
        tag("html", a, block)
    }
    actual inline fun i(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("i", a, block)
    }
    actual inline fun iframe(attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<IframeHTMLAttributes<HTMLIFrameElement>>()
        a.attr()
        tag("iframe", a, block)
    }
    actual inline fun img(attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ImgHTMLAttributes<HTMLImageElement>>()
        a.attr()
        tag("img", a, block)
    }
    actual inline fun input(attr: Attr<InputHTMLAttributes<HTMLInputElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<InputHTMLAttributes<HTMLInputElement>>()
        a.attr()
        tag("input", a, block)
    }
    actual inline fun ins(attr: Attr<InsHTMLAttributes<HTMLModElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<InsHTMLAttributes<HTMLModElement>>()
        a.attr()
        tag("ins", a, block)
    }
    actual inline fun kbd(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("kbd", a, block)
    }
    actual inline fun keygen(attr: Attr<KeygenHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<KeygenHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("keygen", a, block)
    }
    actual inline fun label(attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<LabelHTMLAttributes<HTMLLabelElement>>()
        a.attr()
        tag("label", a, block)
    }
    actual inline fun legend(attr: Attr<HTMLAttributes<HTMLLegendElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLLegendElement>>()
        a.attr()
        tag("legend", a, block)
    }
    actual inline fun li(attr: Attr<LiHTMLAttributes<HTMLLIElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<LiHTMLAttributes<HTMLLIElement>>()
        a.attr()
        tag("li", a, block)
    }
    actual inline fun link(attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<LinkHTMLAttributes<HTMLLinkElement>>()
        a.attr()
        tag("link", a, block)
    }
    actual inline fun main(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("main", a, block)
    }
    actual inline fun map(attr: Attr<MapHTMLAttributes<HTMLMapElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<MapHTMLAttributes<HTMLMapElement>>()
        a.attr()
        tag("map", a, block)
    }
    actual inline fun mark(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("mark", a, block)
    }
    actual inline fun menu(attr: Attr<MenuHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<MenuHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("menu", a, block)
    }
    actual inline fun menuitem(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("menuitem", a, block)
    }
    actual inline fun meta(attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<MetaHTMLAttributes<HTMLMetaElement>>()
        a.attr()
        tag("meta", a, block)
    }
    actual inline fun meter(attr: Attr<MeterHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<MeterHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("meter", a, block)
    }
    actual inline fun nav(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("nav", a, block)
    }
    actual inline fun noscript(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("noscript", a, block)
    }
    actual inline fun objectElement(attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ObjectHTMLAttributes<HTMLObjectElement>>()
        a.attr()
        tag("object", a, block)
    }
    actual inline fun ol(attr: Attr<OlHTMLAttributes<HTMLOListElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<OlHTMLAttributes<HTMLOListElement>>()
        a.attr()
        tag("ol", a, block)
    }
    actual inline fun optgroup(attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<OptgroupHTMLAttributes<HTMLOptGroupElement>>()
        a.attr()
        tag("optgroup", a, block)
    }
    actual inline fun option(attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<OptionHTMLAttributes<HTMLOptionElement>>()
        a.attr()
        tag("option", a, block)
    }
    actual inline fun output(attr: Attr<OutputHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<OutputHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("output", a, block)
    }
    actual inline fun p(attr: Attr<HTMLAttributes<HTMLParagraphElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLParagraphElement>>()
        a.attr()
        tag("p", a, block)
    }
    actual inline fun param(attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ParamHTMLAttributes<HTMLParamElement>>()
        a.attr()
        tag("param", a, block)
    }
    actual inline fun picture(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("picture", a, block)
    }
    actual inline fun pre(attr: Attr<HTMLAttributes<HTMLPreElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLPreElement>>()
        a.attr()
        tag("pre", a, block)
    }
    actual inline fun progress(attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ProgressHTMLAttributes<HTMLProgressElement>>()
        a.attr()
        tag("progress", a, block)
    }
    actual inline fun q(attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<QuoteHTMLAttributes<HTMLQuoteElement>>()
        a.attr()
        tag("q", a, block)
    }
    actual inline fun rp(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("rp", a, block)
    }
    actual inline fun rt(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("rt", a, block)
    }
    actual inline fun ruby(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("ruby", a, block)
    }
    actual inline fun s(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("s", a, block)
    }
    actual inline fun samp(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("samp", a, block)
    }
    actual inline fun script(attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ScriptHTMLAttributes<HTMLScriptElement>>()
        a.attr()
        tag("script", a, block)
    }
    actual inline fun section(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("section", a, block)
    }
    actual inline fun select(attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<SelectHTMLAttributes<HTMLSelectElement>>()
        a.attr()
        tag("select", a, block)
    }
    actual inline fun small(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("small", a, block)
    }
    actual inline fun source(attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<SourceHTMLAttributes<HTMLSourceElement>>()
        a.attr()
        tag("source", a, block)
    }
    actual inline fun span(attr: Attr<HTMLAttributes<HTMLSpanElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLSpanElement>>()
        a.attr()
        tag("span", a, block)
    }
    actual inline fun strong(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("strong", a, block)
    }
    actual inline fun styleElement(attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<StyleHTMLAttributes<HTMLStyleElement>>()
        a.attr()
        tag("style", a, block)
    }
    actual inline fun sub(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("sub", a, block)
    }
    actual inline fun summary(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("summary", a, block)
    }
    actual inline fun sup(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("sup", a, block)
    }
    actual inline fun table(attr: Attr<TableHTMLAttributes<HTMLTableElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<TableHTMLAttributes<HTMLTableElement>>()
        a.attr()
        tag("table", a, block)
    }
    actual inline fun tbody(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("tbody", a, block)
    }
    actual inline fun td(attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<TdHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        tag("td", a, block)
    }
    actual inline fun textarea(attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<TextareaHTMLAttributes<HTMLTextAreaElement>>()
        a.attr()
        tag("textarea", a, block)
    }
    actual inline fun tfoot(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("tfoot", a, block)
    }
    actual inline fun th(attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<ThHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        tag("th", a, block)
    }
    actual inline fun thead(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("thead", a, block)
    }
    actual inline fun time(attr: Attr<TimeHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<TimeHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("time", a, block)
    }
    actual inline fun title(attr: Attr<HTMLAttributes<HTMLTitleElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLTitleElement>>()
        a.attr()
        tag("title", a, block)
    }
    actual inline fun tr(attr: Attr<HTMLAttributes<HTMLTableRowElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLTableRowElement>>()
        a.attr()
        tag("tr", a, block)
    }
    actual inline fun track(attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<TrackHTMLAttributes<HTMLTrackElement>>()
        a.attr()
        tag("track", a, block)
    }
    actual inline fun u(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("u", a, block)
    }
    actual inline fun ul(attr: Attr<HTMLAttributes<HTMLUListElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLUListElement>>()
        a.attr()
        tag("ul", a, block)
    }
    actual inline fun varElement(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("var", a, block)
    }
    actual inline fun video(attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<VideoHTMLAttributes<HTMLVideoElement>>()
        a.attr()
        tag("video", a, block)
    }
    actual inline fun wbr(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{}").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("wbr", a, block)
    }

    actual inline fun a(className: String, attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<AnchorHTMLAttributes<HTMLAnchorElement>>()
        a.attr()
        tag("a", a, block)
    }
    actual inline fun address(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("address", a, block)
    }
    actual inline fun area(className: String, attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<AreaHTMLAttributes<HTMLAreaElement>>()
        a.attr()
        tag("area", a, block)
    }
    actual inline fun article(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("article", a, block)
    }
    actual inline fun aside(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("aside", a, block)
    }
    actual inline fun audio(className: String, attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<AudioHTMLAttributes<HTMLAudioElement>>()
        a.attr()
        tag("audio", a, block)
    }
    actual inline fun b(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("b", a, block)
    }
    actual inline fun base(className: String, attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<BaseHTMLAttributes<HTMLBaseElement>>()
        a.attr()
        tag("base", a, block)
    }
    actual inline fun bdi(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("bdi", a, block)
    }
    actual inline fun bdo(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("bdo", a, block)
    }
    actual inline fun big(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("big", a, block)
    }
    actual inline fun blockquote(className: String, attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<BlockquoteHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("blockquote", a, block)
    }
    actual inline fun body(className: String, attr: Attr<HTMLAttributes<HTMLBodyElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLBodyElement>>()
        a.attr()
        tag("body", a, block)
    }
    actual inline fun br(className: String, attr: Attr<HTMLAttributes<HTMLBRElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLBRElement>>()
        a.attr()
        tag("br", a, block)
    }
    actual inline fun button(className: String, attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ButtonHTMLAttributes<HTMLButtonElement>>()
        a.attr()
        tag("button", a, block)
    }
    actual inline fun canvas(className: String, attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<CanvasHTMLAttributes<HTMLCanvasElement>>()
        a.attr()
        tag("canvas", a, block)
    }
    actual inline fun caption(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("caption", a, block)
    }
    actual inline fun cite(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("cite", a, block)
    }
    actual inline fun code(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("code", a, block)
    }
    actual inline fun col(className: String, attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ColHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        tag("col", a, block)
    }
    actual inline fun colgroup(className: String, attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ColgroupHTMLAttributes<HTMLTableColElement>>()
        a.attr()
        tag("colgroup", a, block)
    }
    actual inline fun data(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("data", a, block)
    }
    actual inline fun datalist(className: String, attr: Attr<HTMLAttributes<HTMLDataListElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLDataListElement>>()
        a.attr()
        tag("datalist", a, block)
    }
    actual inline fun dd(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dd", a, block)
    }
    actual inline fun del(className: String, attr: Attr<DelHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<DelHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("del", a, block)
    }
    actual inline fun details(className: String, attr: Attr<DetailsHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<DetailsHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("details", a, block)
    }
    actual inline fun dfn(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dfn", a, block)
    }
    actual inline fun dialog(className: String, attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<DialogHTMLAttributes<HTMLDialogElement>>()
        a.attr()
        tag("dialog", a, block)
    }
    actual inline fun div(className: String, attr: Attr<HTMLAttributes<HTMLDivElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLDivElement>>()
        a.attr()
        tag("div", a, block)
    }
    actual inline fun dl(className: String, attr: Attr<HTMLAttributes<HTMLDListElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLDListElement>>()
        a.attr()
        tag("dl", a, block)
    }
    actual inline fun dt(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("dt", a, block)
    }
    actual inline fun em(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("em", a, block)
    }
    actual inline fun embed(className: String, attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<EmbedHTMLAttributes<HTMLEmbedElement>>()
        a.attr()
        tag("embed", a, block)
    }
    actual inline fun fieldset(className: String, attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<FieldsetHTMLAttributes<HTMLFieldSetElement>>()
        a.attr()
        tag("fieldset", a, block)
    }
    actual inline fun figcaption(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("figcaption", a, block)
    }
    actual inline fun figure(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("figure", a, block)
    }
    actual inline fun footer(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("footer", a, block)
    }
    actual inline fun form(className: String, attr: Attr<FormHTMLAttributes<HTMLFormElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<FormHTMLAttributes<HTMLFormElement>>()
        a.attr()
        tag("form", a, block)
    }
    actual inline fun h1(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h1", a, block)
    }
    actual inline fun h2(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h2", a, block)
    }
    actual inline fun h3(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h3", a, block)
    }
    actual inline fun h4(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h4", a, block)
    }
    actual inline fun h5(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h5", a, block)
    }
    actual inline fun h6(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLHeadingElement>>()
        a.attr()
        tag("h6", a, block)
    }
    actual inline fun head(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("head", a, block)
    }
    actual inline fun header(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("header", a, block)
    }
    actual inline fun hgroup(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("hgroup", a, block)
    }
    actual inline fun hr(className: String, attr: Attr<HTMLAttributes<HTMLHRElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLHRElement>>()
        a.attr()
        tag("hr", a, block)
    }
    actual inline fun html(className: String, attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HtmlHTMLAttributes<HTMLHtmlElement>>()
        a.attr()
        tag("html", a, block)
    }
    actual inline fun i(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("i", a, block)
    }
    actual inline fun iframe(className: String, attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<IframeHTMLAttributes<HTMLIFrameElement>>()
        a.attr()
        tag("iframe", a, block)
    }
    actual inline fun img(className: String, attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ImgHTMLAttributes<HTMLImageElement>>()
        a.attr()
        tag("img", a, block)
    }
    actual inline fun input(className: String, attr: Attr<InputHTMLAttributes<HTMLInputElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<InputHTMLAttributes<HTMLInputElement>>()
        a.attr()
        tag("input", a, block)
    }
    actual inline fun ins(className: String, attr: Attr<InsHTMLAttributes<HTMLModElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<InsHTMLAttributes<HTMLModElement>>()
        a.attr()
        tag("ins", a, block)
    }
    actual inline fun kbd(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("kbd", a, block)
    }
    actual inline fun keygen(className: String, attr: Attr<KeygenHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<KeygenHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("keygen", a, block)
    }
    actual inline fun label(className: String, attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<LabelHTMLAttributes<HTMLLabelElement>>()
        a.attr()
        tag("label", a, block)
    }
    actual inline fun legend(className: String, attr: Attr<HTMLAttributes<HTMLLegendElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLLegendElement>>()
        a.attr()
        tag("legend", a, block)
    }
    actual inline fun li(className: String, attr: Attr<LiHTMLAttributes<HTMLLIElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<LiHTMLAttributes<HTMLLIElement>>()
        a.attr()
        tag("li", a, block)
    }
    actual inline fun link(className: String, attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<LinkHTMLAttributes<HTMLLinkElement>>()
        a.attr()
        tag("link", a, block)
    }
    actual inline fun main(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("main", a, block)
    }
    actual inline fun map(className: String, attr: Attr<MapHTMLAttributes<HTMLMapElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<MapHTMLAttributes<HTMLMapElement>>()
        a.attr()
        tag("map", a, block)
    }
    actual inline fun mark(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("mark", a, block)
    }
    actual inline fun menu(className: String, attr: Attr<MenuHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<MenuHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("menu", a, block)
    }
    actual inline fun menuitem(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("menuitem", a, block)
    }
    actual inline fun meta(className: String, attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<MetaHTMLAttributes<HTMLMetaElement>>()
        a.attr()
        tag("meta", a, block)
    }
    actual inline fun meter(className: String, attr: Attr<MeterHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<MeterHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("meter", a, block)
    }
    actual inline fun nav(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("nav", a, block)
    }
    actual inline fun noscript(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("noscript", a, block)
    }
    actual inline fun objectElement(className: String, attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ObjectHTMLAttributes<HTMLObjectElement>>()
        a.attr()
        tag("object", a, block)
    }
    actual inline fun ol(className: String, attr: Attr<OlHTMLAttributes<HTMLOListElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<OlHTMLAttributes<HTMLOListElement>>()
        a.attr()
        tag("ol", a, block)
    }
    actual inline fun optgroup(className: String, attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<OptgroupHTMLAttributes<HTMLOptGroupElement>>()
        a.attr()
        tag("optgroup", a, block)
    }
    actual inline fun option(className: String, attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<OptionHTMLAttributes<HTMLOptionElement>>()
        a.attr()
        tag("option", a, block)
    }
    actual inline fun output(className: String, attr: Attr<OutputHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<OutputHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("output", a, block)
    }
    actual inline fun p(className: String, attr: Attr<HTMLAttributes<HTMLParagraphElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLParagraphElement>>()
        a.attr()
        tag("p", a, block)
    }
    actual inline fun param(className: String, attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ParamHTMLAttributes<HTMLParamElement>>()
        a.attr()
        tag("param", a, block)
    }
    actual inline fun picture(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("picture", a, block)
    }
    actual inline fun pre(className: String, attr: Attr<HTMLAttributes<HTMLPreElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLPreElement>>()
        a.attr()
        tag("pre", a, block)
    }
    actual inline fun progress(className: String, attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ProgressHTMLAttributes<HTMLProgressElement>>()
        a.attr()
        tag("progress", a, block)
    }
    actual inline fun q(className: String, attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<QuoteHTMLAttributes<HTMLQuoteElement>>()
        a.attr()
        tag("q", a, block)
    }
    actual inline fun rp(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("rp", a, block)
    }
    actual inline fun rt(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("rt", a, block)
    }
    actual inline fun ruby(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("ruby", a, block)
    }
    actual inline fun s(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("s", a, block)
    }
    actual inline fun samp(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("samp", a, block)
    }
    actual inline fun script(className: String, attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ScriptHTMLAttributes<HTMLScriptElement>>()
        a.attr()
        tag("script", a, block)
    }
    actual inline fun section(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("section", a, block)
    }
    actual inline fun select(className: String, attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<SelectHTMLAttributes<HTMLSelectElement>>()
        a.attr()
        tag("select", a, block)
    }
    actual inline fun small(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("small", a, block)
    }
    actual inline fun source(className: String, attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<SourceHTMLAttributes<HTMLSourceElement>>()
        a.attr()
        tag("source", a, block)
    }
    actual inline fun span(className: String, attr: Attr<HTMLAttributes<HTMLSpanElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLSpanElement>>()
        a.attr()
        tag("span", a, block)
    }
    actual inline fun strong(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("strong", a, block)
    }
    actual inline fun styleElement(className: String, attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<StyleHTMLAttributes<HTMLStyleElement>>()
        a.attr()
        tag("style", a, block)
    }
    actual inline fun sub(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("sub", a, block)
    }
    actual inline fun summary(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("summary", a, block)
    }
    actual inline fun sup(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("sup", a, block)
    }
    actual inline fun table(className: String, attr: Attr<TableHTMLAttributes<HTMLTableElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<TableHTMLAttributes<HTMLTableElement>>()
        a.attr()
        tag("table", a, block)
    }
    actual inline fun tbody(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("tbody", a, block)
    }
    actual inline fun td(className: String, attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<TdHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        tag("td", a, block)
    }
    actual inline fun textarea(className: String, attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<TextareaHTMLAttributes<HTMLTextAreaElement>>()
        a.attr()
        tag("textarea", a, block)
    }
    actual inline fun tfoot(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("tfoot", a, block)
    }
    actual inline fun th(className: String, attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<ThHTMLAttributes<HTMLTableCellElement>>()
        a.attr()
        tag("th", a, block)
    }
    actual inline fun thead(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLTableSectionElement>>()
        a.attr()
        tag("thead", a, block)
    }
    actual inline fun time(className: String, attr: Attr<TimeHTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<TimeHTMLAttributes<HTMLElement>>()
        a.attr()
        tag("time", a, block)
    }
    actual inline fun title(className: String, attr: Attr<HTMLAttributes<HTMLTitleElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLTitleElement>>()
        a.attr()
        tag("title", a, block)
    }
    actual inline fun tr(className: String, attr: Attr<HTMLAttributes<HTMLTableRowElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLTableRowElement>>()
        a.attr()
        tag("tr", a, block)
    }
    actual inline fun track(className: String, attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<TrackHTMLAttributes<HTMLTrackElement>>()
        a.attr()
        tag("track", a, block)
    }
    actual inline fun u(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("u", a, block)
    }
    actual inline fun ul(className: String, attr: Attr<HTMLAttributes<HTMLUListElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLUListElement>>()
        a.attr()
        tag("ul", a, block)
    }
    actual inline fun varElement(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("var", a, block)
    }
    actual inline fun video(className: String, attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<VideoHTMLAttributes<HTMLVideoElement>>()
        a.attr()
        tag("video", a, block)
    }
    actual inline fun wbr(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes?) {
        val a = js("{ className: className }").unsafeCast<HTMLAttributes<HTMLElement>>()
        a.attr()
        tag("wbr", a, block)
    }}
