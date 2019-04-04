@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION", "UNUSED", "MUST_BE_INITIALIZED_OR_BE_ABSTRACT")

package cn.apisium.sarla.nodes

import cn.apisium.sarla.*
import cn.apisium.sarla.dom.*

actual open class NodeBlock(parent: BaseNode? = null): BaseNode(parent) {
    var start = js("{}").unsafeCast<BaseNode>()
    @JsName("e")
    var end = start
    var elm: DocumentFragment
    var id: String
    var currentId = 0

    @Suppress("UNUSED_PARAMETER")
    inline fun append(n: BaseNode) {
        js("this.e = this.e.n = n")
    }

    actual inline fun tag(void: Int, name: String, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, name, className, block)) }
    actual inline fun tag(name: String, className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, name, className)
        e.block()
        append(e)
    }
    actual inline fun tag(name: String, className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, name, className)) }

    actual inline operator fun String.unaryPlus() {
        append(T(this@NodeBlock, this))
    }

    actual inline operator fun Number.unaryPlus() {
        append(T(this@NodeBlock, js("'' + this").unsafeCast<String>()))
    }

    actual inline operator fun Nothing.unaryPlus() {
        append(N(this@NodeBlock))
    }

    actual inline operator fun Unit.unaryPlus() {
        append(N(this@NodeBlock))
    }

    actual inline operator fun <P, T: SarlaProp<P>> SarlaInstant<T>.invoke(props: P?, noinline block: Nodes?) {
        append(S(this@NodeBlock, clazz, props, block, true))
    }

    actual inline operator fun <T: Sarla> SarlaInstant<T>.invoke(noinline block: Nodes?) {
        append(S(this@NodeBlock, clazz, null, block, false))
    }

    actual inline operator fun <P, T: SarlaProp<P>> SarlaInstant<T>.invoke(void: Int, props: P?, noinline block: DataNodes?) {
        append(S(this@NodeBlock, clazz, props, block, true))
    }

    actual inline operator fun <T: Sarla> SarlaInstant<T>.invoke(void: Int, noinline block: DataNodes?) {
        append(S(this@NodeBlock, clazz, null, block, false))
    }

    actual inline operator fun <P, T: SarlaProp<P>> SarlaInlineInstant<T>.invoke(props: P?, noinline block: Nodes?) {
        append(I(this@NodeBlock, this.block, props, block, true))
    }

    actual inline operator fun <T: Sarla> SarlaInlineInstant<T>.invoke(noinline block: Nodes?) {
        append(I(this@NodeBlock, this.block, null, block, false))
    }

    actual inline operator fun <P, T: SarlaProp<P>> SarlaInlineInstant<T>.invoke(void: Int, props: P?, noinline block: DataNodes?) {
        append(I(this@NodeBlock, this.block, props, block, true))
    }

    actual inline operator fun <T: Sarla> SarlaInlineInstant<T>.invoke(void: Int, noinline block: DataNodes?) {
        append(I(this@NodeBlock, this.block, null, block, false))
    }

    actual inline fun a(void: Int, className: String?, noinline block: D<AnchorHTMLAttributes<HTMLAnchorElement>>.() -> Unit) { append(D(this, "a", className, block)) }
    actual inline fun address(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "address", className, block)) }
    actual inline fun area(void: Int, className: String?, noinline block: D<AreaHTMLAttributes<HTMLAreaElement>>.() -> Unit) { append(D(this, "area", className, block)) }
    actual inline fun article(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "article", className, block)) }
    actual inline fun aside(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "aside", className, block)) }
    actual inline fun audio(void: Int, className: String?, noinline block: D<AudioHTMLAttributes<HTMLAudioElement>>.() -> Unit) { append(D(this, "audio", className, block)) }
    actual inline fun b(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "b", className, block)) }
    actual inline fun base(void: Int, className: String?, noinline block: D<BaseHTMLAttributes<HTMLBaseElement>>.() -> Unit) { append(D(this, "base", className, block)) }
    actual inline fun bdi(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "bdi", className, block)) }
    actual inline fun bdo(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "bdo", className, block)) }
    actual inline fun big(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "big", className, block)) }
    actual inline fun blockquote(void: Int, className: String?, noinline block: D<BlockquoteHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "blockquote", className, block)) }
    actual inline fun body(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLBodyElement>>.() -> Unit) { append(D(this, "body", className, block)) }
    actual inline fun br(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLBRElement>>.() -> Unit) { append(D(this, "br", className, block)) }
    actual inline fun button(void: Int, className: String?, noinline block: D<ButtonHTMLAttributes<HTMLButtonElement>>.() -> Unit) { append(D(this, "button", className, block)) }
    actual inline fun canvas(void: Int, className: String?, noinline block: D<CanvasHTMLAttributes<HTMLCanvasElement>>.() -> Unit) { append(D(this, "canvas", className, block)) }
    actual inline fun caption(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "caption", className, block)) }
    actual inline fun cite(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "cite", className, block)) }
    actual inline fun code(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "code", className, block)) }
    actual inline fun col(void: Int, className: String?, noinline block: D<ColHTMLAttributes<HTMLTableColElement>>.() -> Unit) { append(D(this, "col", className, block)) }
    actual inline fun colgroup(void: Int, className: String?, noinline block: D<ColgroupHTMLAttributes<HTMLTableColElement>>.() -> Unit) { append(D(this, "colgroup", className, block)) }
    actual inline fun data(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "data", className, block)) }
    actual inline fun datalist(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLDataListElement>>.() -> Unit) { append(D(this, "datalist", className, block)) }
    actual inline fun dd(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "dd", className, block)) }
    actual inline fun del(void: Int, className: String?, noinline block: D<DelHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "del", className, block)) }
    actual inline fun details(void: Int, className: String?, noinline block: D<DetailsHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "details", className, block)) }
    actual inline fun dfn(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "dfn", className, block)) }
    actual inline fun dialog(void: Int, className: String?, noinline block: D<DialogHTMLAttributes<HTMLDialogElement>>.() -> Unit) { append(D(this, "dialog", className, block)) }
    actual inline fun div(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLDivElement>>.() -> Unit) { append(D(this, "div", className, block)) }
    actual inline fun dl(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLDListElement>>.() -> Unit) { append(D(this, "dl", className, block)) }
    actual inline fun dt(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "dt", className, block)) }
    actual inline fun em(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "em", className, block)) }
    actual inline fun embed(void: Int, className: String?, noinline block: D<EmbedHTMLAttributes<HTMLEmbedElement>>.() -> Unit) { append(D(this, "embed", className, block)) }
    actual inline fun fieldset(void: Int, className: String?, noinline block: D<FieldsetHTMLAttributes<HTMLFieldSetElement>>.() -> Unit) { append(D(this, "fieldset", className, block)) }
    actual inline fun figcaption(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "figcaption", className, block)) }
    actual inline fun figure(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "figure", className, block)) }
    actual inline fun footer(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "footer", className, block)) }
    actual inline fun form(void: Int, className: String?, noinline block: D<FormHTMLAttributes<HTMLFormElement>>.() -> Unit) { append(D(this, "form", className, block)) }
    actual inline fun h1(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) { append(D(this, "h1", className, block)) }
    actual inline fun h2(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) { append(D(this, "h2", className, block)) }
    actual inline fun h3(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) { append(D(this, "h3", className, block)) }
    actual inline fun h4(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) { append(D(this, "h4", className, block)) }
    actual inline fun h5(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) { append(D(this, "h5", className, block)) }
    actual inline fun h6(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) { append(D(this, "h6", className, block)) }
    actual inline fun head(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "head", className, block)) }
    actual inline fun header(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "header", className, block)) }
    actual inline fun hgroup(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "hgroup", className, block)) }
    actual inline fun hr(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHRElement>>.() -> Unit) { append(D(this, "hr", className, block)) }
    actual inline fun html(void: Int, className: String?, noinline block: D<HtmlHTMLAttributes<HTMLHtmlElement>>.() -> Unit) { append(D(this, "html", className, block)) }
    actual inline fun i(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "i", className, block)) }
    actual inline fun iframe(void: Int, className: String?, noinline block: D<IframeHTMLAttributes<HTMLIFrameElement>>.() -> Unit) { append(D(this, "iframe", className, block)) }
    actual inline fun img(void: Int, className: String?, noinline block: D<ImgHTMLAttributes<HTMLImageElement>>.() -> Unit) { append(D(this, "img", className, block)) }
    actual inline fun input(void: Int, className: String?, noinline block: D<InputHTMLAttributes<HTMLInputElement>>.() -> Unit) { append(D(this, "input", className, block)) }
    actual inline fun ins(void: Int, className: String?, noinline block: D<InsHTMLAttributes<HTMLModElement>>.() -> Unit) { append(D(this, "ins", className, block)) }
    actual inline fun kbd(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "kbd", className, block)) }
    actual inline fun keygen(void: Int, className: String?, noinline block: D<KeygenHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "keygen", className, block)) }
    actual inline fun label(void: Int, className: String?, noinline block: D<LabelHTMLAttributes<HTMLLabelElement>>.() -> Unit) { append(D(this, "label", className, block)) }
    actual inline fun legend(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLLegendElement>>.() -> Unit) { append(D(this, "legend", className, block)) }
    actual inline fun li(void: Int, className: String?, noinline block: D<LiHTMLAttributes<HTMLLIElement>>.() -> Unit) { append(D(this, "li", className, block)) }
    actual inline fun link(void: Int, className: String?, noinline block: D<LinkHTMLAttributes<HTMLLinkElement>>.() -> Unit) { append(D(this, "link", className, block)) }
    actual inline fun main(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "main", className, block)) }
    actual inline fun map(void: Int, className: String?, noinline block: D<MapHTMLAttributes<HTMLMapElement>>.() -> Unit) { append(D(this, "map", className, block)) }
    actual inline fun mark(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "mark", className, block)) }
    actual inline fun menu(void: Int, className: String?, noinline block: D<MenuHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "menu", className, block)) }
    actual inline fun menuitem(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "menuitem", className, block)) }
    actual inline fun meta(void: Int, className: String?, noinline block: D<MetaHTMLAttributes<HTMLMetaElement>>.() -> Unit) { append(D(this, "meta", className, block)) }
    actual inline fun meter(void: Int, className: String?, noinline block: D<MeterHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "meter", className, block)) }
    actual inline fun nav(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "nav", className, block)) }
    actual inline fun noscript(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "noscript", className, block)) }
    actual inline fun objectElement(void: Int, className: String?, noinline block: D<ObjectHTMLAttributes<HTMLObjectElement>>.() -> Unit) { append(D(this, "object", className, block)) }
    actual inline fun ol(void: Int, className: String?, noinline block: D<OlHTMLAttributes<HTMLOListElement>>.() -> Unit) { append(D(this, "ol", className, block)) }
    actual inline fun optgroup(void: Int, className: String?, noinline block: D<OptgroupHTMLAttributes<HTMLOptGroupElement>>.() -> Unit) { append(D(this, "optgroup", className, block)) }
    actual inline fun option(void: Int, className: String?, noinline block: D<OptionHTMLAttributes<HTMLOptionElement>>.() -> Unit) { append(D(this, "option", className, block)) }
    actual inline fun output(void: Int, className: String?, noinline block: D<OutputHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "output", className, block)) }
    actual inline fun p(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLParagraphElement>>.() -> Unit) { append(D(this, "p", className, block)) }
    actual inline fun param(void: Int, className: String?, noinline block: D<ParamHTMLAttributes<HTMLParamElement>>.() -> Unit) { append(D(this, "param", className, block)) }
    actual inline fun picture(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "picture", className, block)) }
    actual inline fun pre(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLPreElement>>.() -> Unit) { append(D(this, "pre", className, block)) }
    actual inline fun progress(void: Int, className: String?, noinline block: D<ProgressHTMLAttributes<HTMLProgressElement>>.() -> Unit) { append(D(this, "progress", className, block)) }
    actual inline fun q(void: Int, className: String?, noinline block: D<QuoteHTMLAttributes<HTMLQuoteElement>>.() -> Unit) { append(D(this, "q", className, block)) }
    actual inline fun rp(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "rp", className, block)) }
    actual inline fun rt(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "rt", className, block)) }
    actual inline fun ruby(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "ruby", className, block)) }
    actual inline fun s(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "s", className, block)) }
    actual inline fun samp(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "samp", className, block)) }
    actual inline fun script(void: Int, className: String?, noinline block: D<ScriptHTMLAttributes<HTMLScriptElement>>.() -> Unit) { append(D(this, "script", className, block)) }
    actual inline fun section(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "section", className, block)) }
    actual inline fun select(void: Int, className: String?, noinline block: D<SelectHTMLAttributes<HTMLSelectElement>>.() -> Unit) { append(D(this, "select", className, block)) }
    actual inline fun small(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "small", className, block)) }
    actual inline fun source(void: Int, className: String?, noinline block: D<SourceHTMLAttributes<HTMLSourceElement>>.() -> Unit) { append(D(this, "source", className, block)) }
    actual inline fun span(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLSpanElement>>.() -> Unit) { append(D(this, "span", className, block)) }
    actual inline fun strong(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "strong", className, block)) }
    actual inline fun styleElement(void: Int, className: String?, noinline block: D<StyleHTMLAttributes<HTMLStyleElement>>.() -> Unit) { append(D(this, "style", className, block)) }
    actual inline fun sub(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "sub", className, block)) }
    actual inline fun summary(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "summary", className, block)) }
    actual inline fun sup(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "sup", className, block)) }
    actual inline fun table(void: Int, className: String?, noinline block: D<TableHTMLAttributes<HTMLTableElement>>.() -> Unit) { append(D(this, "table", className, block)) }
    actual inline fun tbody(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableSectionElement>>.() -> Unit) { append(D(this, "tbody", className, block)) }
    actual inline fun td(void: Int, className: String?, noinline block: D<TdHTMLAttributes<HTMLTableCellElement>>.() -> Unit) { append(D(this, "td", className, block)) }
    actual inline fun textarea(void: Int, className: String?, noinline block: D<TextareaHTMLAttributes<HTMLTextAreaElement>>.() -> Unit) { append(D(this, "textarea", className, block)) }
    actual inline fun tfoot(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableSectionElement>>.() -> Unit) { append(D(this, "tfoot", className, block)) }
    actual inline fun th(void: Int, className: String?, noinline block: D<ThHTMLAttributes<HTMLTableCellElement>>.() -> Unit) { append(D(this, "th", className, block)) }
    actual inline fun thead(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableSectionElement>>.() -> Unit) { append(D(this, "thead", className, block)) }
    actual inline fun time(void: Int, className: String?, noinline block: D<TimeHTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "time", className, block)) }
    actual inline fun title(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTitleElement>>.() -> Unit) { append(D(this, "title", className, block)) }
    actual inline fun tr(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableRowElement>>.() -> Unit) { append(D(this, "tr", className, block)) }
    actual inline fun track(void: Int, className: String?, noinline block: D<TrackHTMLAttributes<HTMLTrackElement>>.() -> Unit) { append(D(this, "track", className, block)) }
    actual inline fun u(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "u", className, block)) }
    actual inline fun ul(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLUListElement>>.() -> Unit) { append(D(this, "ul", className, block)) }
    actual inline fun varElement(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "var", className, block)) }
    actual inline fun video(void: Int, className: String?, noinline block: D<VideoHTMLAttributes<HTMLVideoElement>>.() -> Unit) { append(D(this, "video", className, block)) }
    actual inline fun wbr(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>>.() -> Unit) { append(D(this, "wbr", className, block)) }

    actual inline fun a(className: String?, block: E<AnchorHTMLAttributes<HTMLAnchorElement>>.() -> Unit) {
        val e = E<AnchorHTMLAttributes<HTMLAnchorElement>>(this, "a", className)
        e.block()
        append(e)
    }
    actual inline fun address(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "address", className)
        e.block()
        append(e)
    }
    actual inline fun area(className: String?, block: E<AreaHTMLAttributes<HTMLAreaElement>>.() -> Unit) {
        val e = E<AreaHTMLAttributes<HTMLAreaElement>>(this, "area", className)
        e.block()
        append(e)
    }
    actual inline fun article(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "article", className)
        e.block()
        append(e)
    }
    actual inline fun aside(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "aside", className)
        e.block()
        append(e)
    }
    actual inline fun audio(className: String?, block: E<AudioHTMLAttributes<HTMLAudioElement>>.() -> Unit) {
        val e = E<AudioHTMLAttributes<HTMLAudioElement>>(this, "audio", className)
        e.block()
        append(e)
    }
    actual inline fun b(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "b", className)
        e.block()
        append(e)
    }
    actual inline fun base(className: String?, block: E<BaseHTMLAttributes<HTMLBaseElement>>.() -> Unit) {
        val e = E<BaseHTMLAttributes<HTMLBaseElement>>(this, "base", className)
        e.block()
        append(e)
    }
    actual inline fun bdi(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "bdi", className)
        e.block()
        append(e)
    }
    actual inline fun bdo(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "bdo", className)
        e.block()
        append(e)
    }
    actual inline fun big(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "big", className)
        e.block()
        append(e)
    }
    actual inline fun blockquote(className: String?, block: E<BlockquoteHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<BlockquoteHTMLAttributes<HTMLElement>>(this, "blockquote", className)
        e.block()
        append(e)
    }
    actual inline fun body(className: String?, block: E<HTMLAttributes<HTMLBodyElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLBodyElement>>(this, "body", className)
        e.block()
        append(e)
    }
    actual inline fun br(className: String?, block: E<HTMLAttributes<HTMLBRElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLBRElement>>(this, "br", className)
        e.block()
        append(e)
    }
    actual inline fun button(className: String?, block: E<ButtonHTMLAttributes<HTMLButtonElement>>.() -> Unit) {
        val e = E<ButtonHTMLAttributes<HTMLButtonElement>>(this, "button", className)
        e.block()
        append(e)
    }
    actual inline fun canvas(className: String?, block: E<CanvasHTMLAttributes<HTMLCanvasElement>>.() -> Unit) {
        val e = E<CanvasHTMLAttributes<HTMLCanvasElement>>(this, "canvas", className)
        e.block()
        append(e)
    }
    actual inline fun caption(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "caption", className)
        e.block()
        append(e)
    }
    actual inline fun cite(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "cite", className)
        e.block()
        append(e)
    }
    actual inline fun code(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "code", className)
        e.block()
        append(e)
    }
    actual inline fun col(className: String?, block: E<ColHTMLAttributes<HTMLTableColElement>>.() -> Unit) {
        val e = E<ColHTMLAttributes<HTMLTableColElement>>(this, "col", className)
        e.block()
        append(e)
    }
    actual inline fun colgroup(className: String?, block: E<ColgroupHTMLAttributes<HTMLTableColElement>>.() -> Unit) {
        val e = E<ColgroupHTMLAttributes<HTMLTableColElement>>(this, "colgroup", className)
        e.block()
        append(e)
    }
    actual inline fun data(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "data", className)
        e.block()
        append(e)
    }
    actual inline fun datalist(className: String?, block: E<HTMLAttributes<HTMLDataListElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLDataListElement>>(this, "datalist", className)
        e.block()
        append(e)
    }
    actual inline fun dd(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "dd", className)
        e.block()
        append(e)
    }
    actual inline fun del(className: String?, block: E<DelHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<DelHTMLAttributes<HTMLElement>>(this, "del", className)
        e.block()
        append(e)
    }
    actual inline fun details(className: String?, block: E<DetailsHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<DetailsHTMLAttributes<HTMLElement>>(this, "details", className)
        e.block()
        append(e)
    }
    actual inline fun dfn(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "dfn", className)
        e.block()
        append(e)
    }
    actual inline fun dialog(className: String?, block: E<DialogHTMLAttributes<HTMLDialogElement>>.() -> Unit) {
        val e = E<DialogHTMLAttributes<HTMLDialogElement>>(this, "dialog", className)
        e.block()
        append(e)
    }
    actual inline fun div(className: String?, block: E<HTMLAttributes<HTMLDivElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLDivElement>>(this, "div", className)
        e.block()
        append(e)
    }
    actual inline fun dl(className: String?, block: E<HTMLAttributes<HTMLDListElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLDListElement>>(this, "dl", className)
        e.block()
        append(e)
    }
    actual inline fun dt(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "dt", className)
        e.block()
        append(e)
    }
    actual inline fun em(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "em", className)
        e.block()
        append(e)
    }
    actual inline fun embed(className: String?, block: E<EmbedHTMLAttributes<HTMLEmbedElement>>.() -> Unit) {
        val e = E<EmbedHTMLAttributes<HTMLEmbedElement>>(this, "embed", className)
        e.block()
        append(e)
    }
    actual inline fun fieldset(className: String?, block: E<FieldsetHTMLAttributes<HTMLFieldSetElement>>.() -> Unit) {
        val e = E<FieldsetHTMLAttributes<HTMLFieldSetElement>>(this, "fieldset", className)
        e.block()
        append(e)
    }
    actual inline fun figcaption(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "figcaption", className)
        e.block()
        append(e)
    }
    actual inline fun figure(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "figure", className)
        e.block()
        append(e)
    }
    actual inline fun footer(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "footer", className)
        e.block()
        append(e)
    }
    actual inline fun form(className: String?, block: E<FormHTMLAttributes<HTMLFormElement>>.() -> Unit) {
        val e = E<FormHTMLAttributes<HTMLFormElement>>(this, "form", className)
        e.block()
        append(e)
    }
    actual inline fun h1(className: String?, block: E<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>>(this, "h1", className)
        e.block()
        append(e)
    }
    actual inline fun h2(className: String?, block: E<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>>(this, "h2", className)
        e.block()
        append(e)
    }
    actual inline fun h3(className: String?, block: E<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>>(this, "h3", className)
        e.block()
        append(e)
    }
    actual inline fun h4(className: String?, block: E<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>>(this, "h4", className)
        e.block()
        append(e)
    }
    actual inline fun h5(className: String?, block: E<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>>(this, "h5", className)
        e.block()
        append(e)
    }
    actual inline fun h6(className: String?, block: E<HTMLAttributes<HTMLHeadingElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>>(this, "h6", className)
        e.block()
        append(e)
    }
    actual inline fun head(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "head", className)
        e.block()
        append(e)
    }
    actual inline fun header(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "header", className)
        e.block()
        append(e)
    }
    actual inline fun hgroup(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "hgroup", className)
        e.block()
        append(e)
    }
    actual inline fun hr(className: String?, block: E<HTMLAttributes<HTMLHRElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHRElement>>(this, "hr", className)
        e.block()
        append(e)
    }
    actual inline fun html(className: String?, block: E<HtmlHTMLAttributes<HTMLHtmlElement>>.() -> Unit) {
        val e = E<HtmlHTMLAttributes<HTMLHtmlElement>>(this, "html", className)
        e.block()
        append(e)
    }
    actual inline fun i(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "i", className)
        e.block()
        append(e)
    }
    actual inline fun iframe(className: String?, block: E<IframeHTMLAttributes<HTMLIFrameElement>>.() -> Unit) {
        val e = E<IframeHTMLAttributes<HTMLIFrameElement>>(this, "iframe", className)
        e.block()
        append(e)
    }
    actual inline fun img(className: String?, block: E<ImgHTMLAttributes<HTMLImageElement>>.() -> Unit) {
        val e = E<ImgHTMLAttributes<HTMLImageElement>>(this, "img", className)
        e.block()
        append(e)
    }
    actual inline fun input(className: String?, block: E<InputHTMLAttributes<HTMLInputElement>>.() -> Unit) {
        val e = E<InputHTMLAttributes<HTMLInputElement>>(this, "input", className)
        e.block()
        append(e)
    }
    actual inline fun ins(className: String?, block: E<InsHTMLAttributes<HTMLModElement>>.() -> Unit) {
        val e = E<InsHTMLAttributes<HTMLModElement>>(this, "ins", className)
        e.block()
        append(e)
    }
    actual inline fun kbd(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "kbd", className)
        e.block()
        append(e)
    }
    actual inline fun keygen(className: String?, block: E<KeygenHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<KeygenHTMLAttributes<HTMLElement>>(this, "keygen", className)
        e.block()
        append(e)
    }
    actual inline fun label(className: String?, block: E<LabelHTMLAttributes<HTMLLabelElement>>.() -> Unit) {
        val e = E<LabelHTMLAttributes<HTMLLabelElement>>(this, "label", className)
        e.block()
        append(e)
    }
    actual inline fun legend(className: String?, block: E<HTMLAttributes<HTMLLegendElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLLegendElement>>(this, "legend", className)
        e.block()
        append(e)
    }
    actual inline fun li(className: String?, block: E<LiHTMLAttributes<HTMLLIElement>>.() -> Unit) {
        val e = E<LiHTMLAttributes<HTMLLIElement>>(this, "li", className)
        e.block()
        append(e)
    }
    actual inline fun link(className: String?, block: E<LinkHTMLAttributes<HTMLLinkElement>>.() -> Unit) {
        val e = E<LinkHTMLAttributes<HTMLLinkElement>>(this, "link", className)
        e.block()
        append(e)
    }
    actual inline fun main(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "main", className)
        e.block()
        append(e)
    }
    actual inline fun map(className: String?, block: E<MapHTMLAttributes<HTMLMapElement>>.() -> Unit) {
        val e = E<MapHTMLAttributes<HTMLMapElement>>(this, "map", className)
        e.block()
        append(e)
    }
    actual inline fun mark(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "mark", className)
        e.block()
        append(e)
    }
    actual inline fun menu(className: String?, block: E<MenuHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<MenuHTMLAttributes<HTMLElement>>(this, "menu", className)
        e.block()
        append(e)
    }
    actual inline fun menuitem(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "menuitem", className)
        e.block()
        append(e)
    }
    actual inline fun meta(className: String?, block: E<MetaHTMLAttributes<HTMLMetaElement>>.() -> Unit) {
        val e = E<MetaHTMLAttributes<HTMLMetaElement>>(this, "meta", className)
        e.block()
        append(e)
    }
    actual inline fun meter(className: String?, block: E<MeterHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<MeterHTMLAttributes<HTMLElement>>(this, "meter", className)
        e.block()
        append(e)
    }
    actual inline fun nav(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "nav", className)
        e.block()
        append(e)
    }
    actual inline fun noscript(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "noscript", className)
        e.block()
        append(e)
    }
    actual inline fun objectElement(className: String?, block: E<ObjectHTMLAttributes<HTMLObjectElement>>.() -> Unit) {
        val e = E<ObjectHTMLAttributes<HTMLObjectElement>>(this, "object", className)
        e.block()
        append(e)
    }
    actual inline fun ol(className: String?, block: E<OlHTMLAttributes<HTMLOListElement>>.() -> Unit) {
        val e = E<OlHTMLAttributes<HTMLOListElement>>(this, "ol", className)
        e.block()
        append(e)
    }
    actual inline fun optgroup(className: String?, block: E<OptgroupHTMLAttributes<HTMLOptGroupElement>>.() -> Unit) {
        val e = E<OptgroupHTMLAttributes<HTMLOptGroupElement>>(this, "optgroup", className)
        e.block()
        append(e)
    }
    actual inline fun option(className: String?, block: E<OptionHTMLAttributes<HTMLOptionElement>>.() -> Unit) {
        val e = E<OptionHTMLAttributes<HTMLOptionElement>>(this, "option", className)
        e.block()
        append(e)
    }
    actual inline fun output(className: String?, block: E<OutputHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<OutputHTMLAttributes<HTMLElement>>(this, "output", className)
        e.block()
        append(e)
    }
    actual inline fun p(className: String?, block: E<HTMLAttributes<HTMLParagraphElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLParagraphElement>>(this, "p", className)
        e.block()
        append(e)
    }
    actual inline fun param(className: String?, block: E<ParamHTMLAttributes<HTMLParamElement>>.() -> Unit) {
        val e = E<ParamHTMLAttributes<HTMLParamElement>>(this, "param", className)
        e.block()
        append(e)
    }
    actual inline fun picture(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "picture", className)
        e.block()
        append(e)
    }
    actual inline fun pre(className: String?, block: E<HTMLAttributes<HTMLPreElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLPreElement>>(this, "pre", className)
        e.block()
        append(e)
    }
    actual inline fun progress(className: String?, block: E<ProgressHTMLAttributes<HTMLProgressElement>>.() -> Unit) {
        val e = E<ProgressHTMLAttributes<HTMLProgressElement>>(this, "progress", className)
        e.block()
        append(e)
    }
    actual inline fun q(className: String?, block: E<QuoteHTMLAttributes<HTMLQuoteElement>>.() -> Unit) {
        val e = E<QuoteHTMLAttributes<HTMLQuoteElement>>(this, "q", className)
        e.block()
        append(e)
    }
    actual inline fun rp(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "rp", className)
        e.block()
        append(e)
    }
    actual inline fun rt(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "rt", className)
        e.block()
        append(e)
    }
    actual inline fun ruby(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "ruby", className)
        e.block()
        append(e)
    }
    actual inline fun s(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "s", className)
        e.block()
        append(e)
    }
    actual inline fun samp(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "samp", className)
        e.block()
        append(e)
    }
    actual inline fun script(className: String?, block: E<ScriptHTMLAttributes<HTMLScriptElement>>.() -> Unit) {
        val e = E<ScriptHTMLAttributes<HTMLScriptElement>>(this, "script", className)
        e.block()
        append(e)
    }
    actual inline fun section(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "section", className)
        e.block()
        append(e)
    }
    actual inline fun select(className: String?, block: E<SelectHTMLAttributes<HTMLSelectElement>>.() -> Unit) {
        val e = E<SelectHTMLAttributes<HTMLSelectElement>>(this, "select", className)
        e.block()
        append(e)
    }
    actual inline fun small(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "small", className)
        e.block()
        append(e)
    }
    actual inline fun source(className: String?, block: E<SourceHTMLAttributes<HTMLSourceElement>>.() -> Unit) {
        val e = E<SourceHTMLAttributes<HTMLSourceElement>>(this, "source", className)
        e.block()
        append(e)
    }
    actual inline fun span(className: String?, block: E<HTMLAttributes<HTMLSpanElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLSpanElement>>(this, "span", className)
        e.block()
        append(e)
    }
    actual inline fun strong(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "strong", className)
        e.block()
        append(e)
    }
    actual inline fun styleElement(className: String?, block: E<StyleHTMLAttributes<HTMLStyleElement>>.() -> Unit) {
        val e = E<StyleHTMLAttributes<HTMLStyleElement>>(this, "style", className)
        e.block()
        append(e)
    }
    actual inline fun sub(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "sub", className)
        e.block()
        append(e)
    }
    actual inline fun summary(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "summary", className)
        e.block()
        append(e)
    }
    actual inline fun sup(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "sup", className)
        e.block()
        append(e)
    }
    actual inline fun table(className: String?, block: E<TableHTMLAttributes<HTMLTableElement>>.() -> Unit) {
        val e = E<TableHTMLAttributes<HTMLTableElement>>(this, "table", className)
        e.block()
        append(e)
    }
    actual inline fun tbody(className: String?, block: E<HTMLAttributes<HTMLTableSectionElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableSectionElement>>(this, "tbody", className)
        e.block()
        append(e)
    }
    actual inline fun td(className: String?, block: E<TdHTMLAttributes<HTMLTableCellElement>>.() -> Unit) {
        val e = E<TdHTMLAttributes<HTMLTableCellElement>>(this, "td", className)
        e.block()
        append(e)
    }
    actual inline fun textarea(className: String?, block: E<TextareaHTMLAttributes<HTMLTextAreaElement>>.() -> Unit) {
        val e = E<TextareaHTMLAttributes<HTMLTextAreaElement>>(this, "textarea", className)
        e.block()
        append(e)
    }
    actual inline fun tfoot(className: String?, block: E<HTMLAttributes<HTMLTableSectionElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableSectionElement>>(this, "tfoot", className)
        e.block()
        append(e)
    }
    actual inline fun th(className: String?, block: E<ThHTMLAttributes<HTMLTableCellElement>>.() -> Unit) {
        val e = E<ThHTMLAttributes<HTMLTableCellElement>>(this, "th", className)
        e.block()
        append(e)
    }
    actual inline fun thead(className: String?, block: E<HTMLAttributes<HTMLTableSectionElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableSectionElement>>(this, "thead", className)
        e.block()
        append(e)
    }
    actual inline fun time(className: String?, block: E<TimeHTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<TimeHTMLAttributes<HTMLElement>>(this, "time", className)
        e.block()
        append(e)
    }
    actual inline fun title(className: String?, block: E<HTMLAttributes<HTMLTitleElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTitleElement>>(this, "title", className)
        e.block()
        append(e)
    }
    actual inline fun tr(className: String?, block: E<HTMLAttributes<HTMLTableRowElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableRowElement>>(this, "tr", className)
        e.block()
        append(e)
    }
    actual inline fun track(className: String?, block: E<TrackHTMLAttributes<HTMLTrackElement>>.() -> Unit) {
        val e = E<TrackHTMLAttributes<HTMLTrackElement>>(this, "track", className)
        e.block()
        append(e)
    }
    actual inline fun u(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "u", className)
        e.block()
        append(e)
    }
    actual inline fun ul(className: String?, block: E<HTMLAttributes<HTMLUListElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLUListElement>>(this, "ul", className)
        e.block()
        append(e)
    }
    actual inline fun varElement(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "var", className)
        e.block()
        append(e)
    }
    actual inline fun video(className: String?, block: E<VideoHTMLAttributes<HTMLVideoElement>>.() -> Unit) {
        val e = E<VideoHTMLAttributes<HTMLVideoElement>>(this, "video", className)
        e.block()
        append(e)
    }
    actual inline fun wbr(className: String?, block: E<HTMLAttributes<HTMLElement>>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>>(this, "wbr", className)
        e.block()
        append(e)
    }

    actual inline fun a(className: String?) { append(E<AnchorHTMLAttributes<HTMLAnchorElement>>(this, "a", className)) }
    actual inline fun address(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "address", className)) }
    actual inline fun area(className: String?) { append(E<AreaHTMLAttributes<HTMLAreaElement>>(this, "area", className)) }
    actual inline fun article(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "article", className)) }
    actual inline fun aside(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "aside", className)) }
    actual inline fun audio(className: String?) { append(E<AudioHTMLAttributes<HTMLAudioElement>>(this, "audio", className)) }
    actual inline fun b(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "b", className)) }
    actual inline fun base(className: String?) { append(E<BaseHTMLAttributes<HTMLBaseElement>>(this, "base", className)) }
    actual inline fun bdi(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "bdi", className)) }
    actual inline fun bdo(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "bdo", className)) }
    actual inline fun big(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "big", className)) }
    actual inline fun blockquote(className: String?) { append(E<BlockquoteHTMLAttributes<HTMLElement>>(this, "blockquote", className)) }
    actual inline fun body(className: String?) { append(E<HTMLAttributes<HTMLBodyElement>>(this, "body", className)) }
    actual inline fun br(className: String?) { append(E<HTMLAttributes<HTMLBRElement>>(this, "br", className)) }
    actual inline fun button(className: String?) { append(E<ButtonHTMLAttributes<HTMLButtonElement>>(this, "button", className)) }
    actual inline fun canvas(className: String?) { append(E<CanvasHTMLAttributes<HTMLCanvasElement>>(this, "canvas", className)) }
    actual inline fun caption(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "caption", className)) }
    actual inline fun cite(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "cite", className)) }
    actual inline fun code(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "code", className)) }
    actual inline fun col(className: String?) { append(E<ColHTMLAttributes<HTMLTableColElement>>(this, "col", className)) }
    actual inline fun colgroup(className: String?) { append(E<ColgroupHTMLAttributes<HTMLTableColElement>>(this, "colgroup", className)) }
    actual inline fun data(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "data", className)) }
    actual inline fun datalist(className: String?) { append(E<HTMLAttributes<HTMLDataListElement>>(this, "datalist", className)) }
    actual inline fun dd(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "dd", className)) }
    actual inline fun del(className: String?) { append(E<DelHTMLAttributes<HTMLElement>>(this, "del", className)) }
    actual inline fun details(className: String?) { append(E<DetailsHTMLAttributes<HTMLElement>>(this, "details", className)) }
    actual inline fun dfn(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "dfn", className)) }
    actual inline fun dialog(className: String?) { append(E<DialogHTMLAttributes<HTMLDialogElement>>(this, "dialog", className)) }
    actual inline fun div(className: String?) { append(E<HTMLAttributes<HTMLDivElement>>(this, "div", className)) }
    actual inline fun dl(className: String?) { append(E<HTMLAttributes<HTMLDListElement>>(this, "dl", className)) }
    actual inline fun dt(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "dt", className)) }
    actual inline fun em(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "em", className)) }
    actual inline fun embed(className: String?) { append(E<EmbedHTMLAttributes<HTMLEmbedElement>>(this, "embed", className)) }
    actual inline fun fieldset(className: String?) { append(E<FieldsetHTMLAttributes<HTMLFieldSetElement>>(this, "fieldset", className)) }
    actual inline fun figcaption(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "figcaption", className)) }
    actual inline fun figure(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "figure", className)) }
    actual inline fun footer(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "footer", className)) }
    actual inline fun form(className: String?) { append(E<FormHTMLAttributes<HTMLFormElement>>(this, "form", className)) }
    actual inline fun h1(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>>(this, "h1", className)) }
    actual inline fun h2(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>>(this, "h2", className)) }
    actual inline fun h3(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>>(this, "h3", className)) }
    actual inline fun h4(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>>(this, "h4", className)) }
    actual inline fun h5(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>>(this, "h5", className)) }
    actual inline fun h6(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>>(this, "h6", className)) }
    actual inline fun head(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "head", className)) }
    actual inline fun header(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "header", className)) }
    actual inline fun hgroup(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "hgroup", className)) }
    actual inline fun hr(className: String?) { append(E<HTMLAttributes<HTMLHRElement>>(this, "hr", className)) }
    actual inline fun html(className: String?) { append(E<HtmlHTMLAttributes<HTMLHtmlElement>>(this, "html", className)) }
    actual inline fun i(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "i", className)) }
    actual inline fun iframe(className: String?) { append(E<IframeHTMLAttributes<HTMLIFrameElement>>(this, "iframe", className)) }
    actual inline fun img(className: String?) { append(E<ImgHTMLAttributes<HTMLImageElement>>(this, "img", className)) }
    actual inline fun input(className: String?) { append(E<InputHTMLAttributes<HTMLInputElement>>(this, "input", className)) }
    actual inline fun ins(className: String?) { append(E<InsHTMLAttributes<HTMLModElement>>(this, "ins", className)) }
    actual inline fun kbd(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "kbd", className)) }
    actual inline fun keygen(className: String?) { append(E<KeygenHTMLAttributes<HTMLElement>>(this, "keygen", className)) }
    actual inline fun label(className: String?) { append(E<LabelHTMLAttributes<HTMLLabelElement>>(this, "label", className)) }
    actual inline fun legend(className: String?) { append(E<HTMLAttributes<HTMLLegendElement>>(this, "legend", className)) }
    actual inline fun li(className: String?) { append(E<LiHTMLAttributes<HTMLLIElement>>(this, "li", className)) }
    actual inline fun link(className: String?) { append(E<LinkHTMLAttributes<HTMLLinkElement>>(this, "link", className)) }
    actual inline fun main(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "main", className)) }
    actual inline fun map(className: String?) { append(E<MapHTMLAttributes<HTMLMapElement>>(this, "map", className)) }
    actual inline fun mark(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "mark", className)) }
    actual inline fun menu(className: String?) { append(E<MenuHTMLAttributes<HTMLElement>>(this, "menu", className)) }
    actual inline fun menuitem(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "menuitem", className)) }
    actual inline fun meta(className: String?) { append(E<MetaHTMLAttributes<HTMLMetaElement>>(this, "meta", className)) }
    actual inline fun meter(className: String?) { append(E<MeterHTMLAttributes<HTMLElement>>(this, "meter", className)) }
    actual inline fun nav(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "nav", className)) }
    actual inline fun noscript(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "noscript", className)) }
    actual inline fun objectElement(className: String?) { append(E<ObjectHTMLAttributes<HTMLObjectElement>>(this, "object", className)) }
    actual inline fun ol(className: String?) { append(E<OlHTMLAttributes<HTMLOListElement>>(this, "ol", className)) }
    actual inline fun optgroup(className: String?) { append(E<OptgroupHTMLAttributes<HTMLOptGroupElement>>(this, "optgroup", className)) }
    actual inline fun option(className: String?) { append(E<OptionHTMLAttributes<HTMLOptionElement>>(this, "option", className)) }
    actual inline fun output(className: String?) { append(E<OutputHTMLAttributes<HTMLElement>>(this, "output", className)) }
    actual inline fun p(className: String?) { append(E<HTMLAttributes<HTMLParagraphElement>>(this, "p", className)) }
    actual inline fun param(className: String?) { append(E<ParamHTMLAttributes<HTMLParamElement>>(this, "param", className)) }
    actual inline fun picture(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "picture", className)) }
    actual inline fun pre(className: String?) { append(E<HTMLAttributes<HTMLPreElement>>(this, "pre", className)) }
    actual inline fun progress(className: String?) { append(E<ProgressHTMLAttributes<HTMLProgressElement>>(this, "progress", className)) }
    actual inline fun q(className: String?) { append(E<QuoteHTMLAttributes<HTMLQuoteElement>>(this, "q", className)) }
    actual inline fun rp(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "rp", className)) }
    actual inline fun rt(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "rt", className)) }
    actual inline fun ruby(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "ruby", className)) }
    actual inline fun s(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "s", className)) }
    actual inline fun samp(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "samp", className)) }
    actual inline fun script(className: String?) { append(E<ScriptHTMLAttributes<HTMLScriptElement>>(this, "script", className)) }
    actual inline fun section(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "section", className)) }
    actual inline fun select(className: String?) { append(E<SelectHTMLAttributes<HTMLSelectElement>>(this, "select", className)) }
    actual inline fun small(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "small", className)) }
    actual inline fun source(className: String?) { append(E<SourceHTMLAttributes<HTMLSourceElement>>(this, "source", className)) }
    actual inline fun span(className: String?) { append(E<HTMLAttributes<HTMLSpanElement>>(this, "span", className)) }
    actual inline fun strong(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "strong", className)) }
    actual inline fun styleElement(className: String?) { append(E<StyleHTMLAttributes<HTMLStyleElement>>(this, "style", className)) }
    actual inline fun sub(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "sub", className)) }
    actual inline fun summary(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "summary", className)) }
    actual inline fun sup(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "sup", className)) }
    actual inline fun table(className: String?) { append(E<TableHTMLAttributes<HTMLTableElement>>(this, "table", className)) }
    actual inline fun tbody(className: String?) { append(E<HTMLAttributes<HTMLTableSectionElement>>(this, "tbody", className)) }
    actual inline fun td(className: String?) { append(E<TdHTMLAttributes<HTMLTableCellElement>>(this, "td", className)) }
    actual inline fun textarea(className: String?) { append(E<TextareaHTMLAttributes<HTMLTextAreaElement>>(this, "textarea", className)) }
    actual inline fun tfoot(className: String?) { append(E<HTMLAttributes<HTMLTableSectionElement>>(this, "tfoot", className)) }
    actual inline fun th(className: String?) { append(E<ThHTMLAttributes<HTMLTableCellElement>>(this, "th", className)) }
    actual inline fun thead(className: String?) { append(E<HTMLAttributes<HTMLTableSectionElement>>(this, "thead", className)) }
    actual inline fun time(className: String?) { append(E<TimeHTMLAttributes<HTMLElement>>(this, "time", className)) }
    actual inline fun title(className: String?) { append(E<HTMLAttributes<HTMLTitleElement>>(this, "title", className)) }
    actual inline fun tr(className: String?) { append(E<HTMLAttributes<HTMLTableRowElement>>(this, "tr", className)) }
    actual inline fun track(className: String?) { append(E<TrackHTMLAttributes<HTMLTrackElement>>(this, "track", className)) }
    actual inline fun u(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "u", className)) }
    actual inline fun ul(className: String?) { append(E<HTMLAttributes<HTMLUListElement>>(this, "ul", className)) }
    actual inline fun varElement(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "var", className)) }
    actual inline fun video(className: String?) { append(E<VideoHTMLAttributes<HTMLVideoElement>>(this, "video", className)) }
    actual inline fun wbr(className: String?) { append(E<HTMLAttributes<HTMLElement>>(this, "wbr", className)) }
}
