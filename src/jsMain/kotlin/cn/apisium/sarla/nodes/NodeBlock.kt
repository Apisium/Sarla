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

    init {
        asDynamic().kind = 6
    }

    @Suppress("UNUSED_PARAMETER")
    inline fun append(n: BaseNode) {
        js("this.e = this.e.n = n")
    }

    actual inline fun tag(void: Int, name: String, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, name, className, block)) }
    actual inline fun tag(name: String, className: String?, block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, name, className)
        e.block()
        append(e)
    }
    actual inline fun tag(name: String, className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, name, className)) }

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

    actual inline fun htmlText(name: String, html: String) {
        // TODO
    }

    actual inline fun input(bind: Data<String>, className: String?, noinline block: (D<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement>.() -> Unit)?) {
        append(D<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement>(this, "input", className) { if (block != null) let(block); bindWith(bind) })
    }

    actual inline fun a(void: Int, className: String?, noinline block: D<AnchorHTMLAttributes<HTMLAnchorElement>, HTMLAnchorElement>.() -> Unit) { append(D(this, "a", className, block)) }
    actual inline fun address(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "address", className, block)) }
    actual inline fun area(void: Int, className: String?, noinline block: D<AreaHTMLAttributes<HTMLAreaElement>, HTMLAreaElement>.() -> Unit) { append(D(this, "area", className, block)) }
    actual inline fun article(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "article", className, block)) }
    actual inline fun aside(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "aside", className, block)) }
    actual inline fun audio(void: Int, className: String?, noinline block: D<AudioHTMLAttributes<HTMLAudioElement>, HTMLAudioElement>.() -> Unit) { append(D(this, "audio", className, block)) }
    actual inline fun b(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "b", className, block)) }
    actual inline fun base(void: Int, className: String?, noinline block: D<BaseHTMLAttributes<HTMLBaseElement>, HTMLBaseElement>.() -> Unit) { append(D(this, "base", className, block)) }
    actual inline fun bdi(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "bdi", className, block)) }
    actual inline fun bdo(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "bdo", className, block)) }
    actual inline fun big(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "big", className, block)) }
    actual inline fun blockquote(void: Int, className: String?, noinline block: D<BlockquoteHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "blockquote", className, block)) }
    actual inline fun body(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLBodyElement>, HTMLBodyElement>.() -> Unit) { append(D(this, "body", className, block)) }
    actual inline fun br(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLBRElement>, HTMLBRElement>.() -> Unit) { append(D(this, "br", className, block)) }
    actual inline fun button(void: Int, className: String?, noinline block: D<ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement>.() -> Unit) { append(D(this, "button", className, block)) }
    actual inline fun canvas(void: Int, className: String?, noinline block: D<CanvasHTMLAttributes<HTMLCanvasElement>, HTMLCanvasElement>.() -> Unit) { append(D(this, "canvas", className, block)) }
    actual inline fun caption(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "caption", className, block)) }
    actual inline fun cite(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "cite", className, block)) }
    actual inline fun code(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "code", className, block)) }
    actual inline fun col(void: Int, className: String?, noinline block: D<ColHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>.() -> Unit) { append(D(this, "col", className, block)) }
    actual inline fun colgroup(void: Int, className: String?, noinline block: D<ColgroupHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>.() -> Unit) { append(D(this, "colgroup", className, block)) }
    actual inline fun data(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "data", className, block)) }
    actual inline fun datalist(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLDataListElement>, HTMLDataListElement>.() -> Unit) { append(D(this, "datalist", className, block)) }
    actual inline fun dd(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "dd", className, block)) }
    actual inline fun del(void: Int, className: String?, noinline block: D<DelHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "del", className, block)) }
    actual inline fun details(void: Int, className: String?, noinline block: D<DetailsHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "details", className, block)) }
    actual inline fun dfn(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "dfn", className, block)) }
    actual inline fun dialog(void: Int, className: String?, noinline block: D<DialogHTMLAttributes<HTMLDialogElement>, HTMLDialogElement>.() -> Unit) { append(D(this, "dialog", className, block)) }
    actual inline fun div(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLDivElement>, HTMLDivElement>.() -> Unit) { append(D(this, "div", className, block)) }
    actual inline fun dl(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLDListElement>, HTMLDListElement>.() -> Unit) { append(D(this, "dl", className, block)) }
    actual inline fun dt(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "dt", className, block)) }
    actual inline fun em(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "em", className, block)) }
    actual inline fun embed(void: Int, className: String?, noinline block: D<EmbedHTMLAttributes<HTMLEmbedElement>, HTMLEmbedElement>.() -> Unit) { append(D(this, "embed", className, block)) }
    actual inline fun fieldset(void: Int, className: String?, noinline block: D<FieldsetHTMLAttributes<HTMLFieldSetElement>, HTMLFieldSetElement>.() -> Unit) { append(D(this, "fieldset", className, block)) }
    actual inline fun figcaption(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "figcaption", className, block)) }
    actual inline fun figure(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "figure", className, block)) }
    actual inline fun footer(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "footer", className, block)) }
    actual inline fun form(void: Int, className: String?, noinline block: D<FormHTMLAttributes<HTMLFormElement>, HTMLFormElement>.() -> Unit) { append(D(this, "form", className, block)) }
    actual inline fun h1(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) { append(D(this, "h1", className, block)) }
    actual inline fun h2(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) { append(D(this, "h2", className, block)) }
    actual inline fun h3(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) { append(D(this, "h3", className, block)) }
    actual inline fun h4(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) { append(D(this, "h4", className, block)) }
    actual inline fun h5(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) { append(D(this, "h5", className, block)) }
    actual inline fun h6(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) { append(D(this, "h6", className, block)) }
    actual inline fun head(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "head", className, block)) }
    actual inline fun header(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "header", className, block)) }
    actual inline fun hgroup(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "hgroup", className, block)) }
    actual inline fun hr(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLHRElement>, HTMLHRElement>.() -> Unit) { append(D(this, "hr", className, block)) }
    actual inline fun html(void: Int, className: String?, noinline block: D<HtmlHTMLAttributes<HTMLHtmlElement>, HTMLHtmlElement>.() -> Unit) { append(D(this, "html", className, block)) }
    actual inline fun i(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "i", className, block)) }
    actual inline fun iframe(void: Int, className: String?, noinline block: D<IframeHTMLAttributes<HTMLIFrameElement>, HTMLIFrameElement>.() -> Unit) { append(D(this, "iframe", className, block)) }
    actual inline fun img(void: Int, className: String?, noinline block: D<ImgHTMLAttributes<HTMLImageElement>, HTMLImageElement>.() -> Unit) { append(D(this, "img", className, block)) }
    actual inline fun input(void: Int, className: String?, noinline block: D<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement>.() -> Unit) { append(D(this, "input", className, block)) }
    actual inline fun ins(void: Int, className: String?, noinline block: D<InsHTMLAttributes<HTMLModElement>, HTMLModElement>.() -> Unit) { append(D(this, "ins", className, block)) }
    actual inline fun kbd(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "kbd", className, block)) }
    actual inline fun keygen(void: Int, className: String?, noinline block: D<KeygenHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "keygen", className, block)) }
    actual inline fun label(void: Int, className: String?, noinline block: D<LabelHTMLAttributes<HTMLLabelElement>, HTMLLabelElement>.() -> Unit) { append(D(this, "label", className, block)) }
    actual inline fun legend(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLLegendElement>, HTMLLegendElement>.() -> Unit) { append(D(this, "legend", className, block)) }
    actual inline fun li(void: Int, className: String?, noinline block: D<LiHTMLAttributes<HTMLLIElement>, HTMLLIElement>.() -> Unit) { append(D(this, "li", className, block)) }
    actual inline fun link(void: Int, className: String?, noinline block: D<LinkHTMLAttributes<HTMLLinkElement>, HTMLLinkElement>.() -> Unit) { append(D(this, "link", className, block)) }
    actual inline fun main(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "main", className, block)) }
    actual inline fun map(void: Int, className: String?, noinline block: D<MapHTMLAttributes<HTMLMapElement>, HTMLMapElement>.() -> Unit) { append(D(this, "map", className, block)) }
    actual inline fun mark(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "mark", className, block)) }
    actual inline fun menu(void: Int, className: String?, noinline block: D<MenuHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "menu", className, block)) }
    actual inline fun menuitem(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "menuitem", className, block)) }
    actual inline fun meta(void: Int, className: String?, noinline block: D<MetaHTMLAttributes<HTMLMetaElement>, HTMLMetaElement>.() -> Unit) { append(D(this, "meta", className, block)) }
    actual inline fun meter(void: Int, className: String?, noinline block: D<MeterHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "meter", className, block)) }
    actual inline fun nav(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "nav", className, block)) }
    actual inline fun noscript(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "noscript", className, block)) }
    actual inline fun objectElement(void: Int, className: String?, noinline block: D<ObjectHTMLAttributes<HTMLObjectElement>, HTMLObjectElement>.() -> Unit) { append(D(this, "object", className, block)) }
    actual inline fun ol(void: Int, className: String?, noinline block: D<OlHTMLAttributes<HTMLOListElement>, HTMLOListElement>.() -> Unit) { append(D(this, "ol", className, block)) }
    actual inline fun optgroup(void: Int, className: String?, noinline block: D<OptgroupHTMLAttributes<HTMLOptGroupElement>, HTMLOptGroupElement>.() -> Unit) { append(D(this, "optgroup", className, block)) }
    actual inline fun option(void: Int, className: String?, noinline block: D<OptionHTMLAttributes<HTMLOptionElement>, HTMLOptionElement>.() -> Unit) { append(D(this, "option", className, block)) }
    actual inline fun output(void: Int, className: String?, noinline block: D<OutputHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "output", className, block)) }
    actual inline fun p(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLParagraphElement>, HTMLParagraphElement>.() -> Unit) { append(D(this, "p", className, block)) }
    actual inline fun param(void: Int, className: String?, noinline block: D<ParamHTMLAttributes<HTMLParamElement>, HTMLParamElement>.() -> Unit) { append(D(this, "param", className, block)) }
    actual inline fun picture(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "picture", className, block)) }
    actual inline fun pre(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLPreElement>, HTMLPreElement>.() -> Unit) { append(D(this, "pre", className, block)) }
    actual inline fun progress(void: Int, className: String?, noinline block: D<ProgressHTMLAttributes<HTMLProgressElement>, HTMLProgressElement>.() -> Unit) { append(D(this, "progress", className, block)) }
    actual inline fun q(void: Int, className: String?, noinline block: D<QuoteHTMLAttributes<HTMLQuoteElement>, HTMLQuoteElement>.() -> Unit) { append(D(this, "q", className, block)) }
    actual inline fun rp(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "rp", className, block)) }
    actual inline fun rt(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "rt", className, block)) }
    actual inline fun ruby(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "ruby", className, block)) }
    actual inline fun s(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "s", className, block)) }
    actual inline fun samp(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "samp", className, block)) }
    actual inline fun script(void: Int, className: String?, noinline block: D<ScriptHTMLAttributes<HTMLScriptElement>, HTMLScriptElement>.() -> Unit) { append(D(this, "script", className, block)) }
    actual inline fun section(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "section", className, block)) }
    actual inline fun select(void: Int, className: String?, noinline block: D<SelectHTMLAttributes<HTMLSelectElement>, HTMLSelectElement>.() -> Unit) { append(D(this, "select", className, block)) }
    actual inline fun small(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "small", className, block)) }
    actual inline fun source(void: Int, className: String?, noinline block: D<SourceHTMLAttributes<HTMLSourceElement>, HTMLSourceElement>.() -> Unit) { append(D(this, "source", className, block)) }
    actual inline fun span(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLSpanElement>, HTMLSpanElement>.() -> Unit) { append(D(this, "span", className, block)) }
    actual inline fun strong(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "strong", className, block)) }
    actual inline fun styleElement(void: Int, className: String?, noinline block: D<StyleHTMLAttributes<HTMLStyleElement>, HTMLStyleElement>.() -> Unit) { append(D(this, "style", className, block)) }
    actual inline fun sub(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "sub", className, block)) }
    actual inline fun summary(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "summary", className, block)) }
    actual inline fun sup(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "sup", className, block)) }
    actual inline fun table(void: Int, className: String?, noinline block: D<TableHTMLAttributes<HTMLTableElement>, HTMLTableElement>.() -> Unit) { append(D(this, "table", className, block)) }
    actual inline fun tbody(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>.() -> Unit) { append(D(this, "tbody", className, block)) }
    actual inline fun td(void: Int, className: String?, noinline block: D<TdHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>.() -> Unit) { append(D(this, "td", className, block)) }
    actual inline fun textarea(void: Int, className: String?, noinline block: D<TextareaHTMLAttributes<HTMLTextAreaElement>, HTMLTextAreaElement>.() -> Unit) { append(D(this, "textarea", className, block)) }
    actual inline fun tfoot(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>.() -> Unit) { append(D(this, "tfoot", className, block)) }
    actual inline fun th(void: Int, className: String?, noinline block: D<ThHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>.() -> Unit) { append(D(this, "th", className, block)) }
    actual inline fun thead(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>.() -> Unit) { append(D(this, "thead", className, block)) }
    actual inline fun time(void: Int, className: String?, noinline block: D<TimeHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "time", className, block)) }
    actual inline fun title(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTitleElement>, HTMLTitleElement>.() -> Unit) { append(D(this, "title", className, block)) }
    actual inline fun tr(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLTableRowElement>, HTMLTableRowElement>.() -> Unit) { append(D(this, "tr", className, block)) }
    actual inline fun track(void: Int, className: String?, noinline block: D<TrackHTMLAttributes<HTMLTrackElement>, HTMLTrackElement>.() -> Unit) { append(D(this, "track", className, block)) }
    actual inline fun u(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "u", className, block)) }
    actual inline fun ul(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLUListElement>, HTMLUListElement>.() -> Unit) { append(D(this, "ul", className, block)) }
    actual inline fun varElement(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "var", className, block)) }
    actual inline fun video(void: Int, className: String?, noinline block: D<VideoHTMLAttributes<HTMLVideoElement>, HTMLVideoElement>.() -> Unit) { append(D(this, "video", className, block)) }
    actual inline fun wbr(void: Int, className: String?, noinline block: D<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) { append(D(this, "wbr", className, block)) }

    actual inline fun a(className: String?, noinline block: E<AnchorHTMLAttributes<HTMLAnchorElement>, HTMLAnchorElement>.() -> Unit) {
        val e = E<AnchorHTMLAttributes<HTMLAnchorElement>, HTMLAnchorElement>(this, "a", className)
        e.block()
        append(e)
    }
    actual inline fun address(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "address", className)
        e.block()
        append(e)
    }
    actual inline fun area(className: String?, noinline block: E<AreaHTMLAttributes<HTMLAreaElement>, HTMLAreaElement>.() -> Unit) {
        val e = E<AreaHTMLAttributes<HTMLAreaElement>, HTMLAreaElement>(this, "area", className)
        e.block()
        append(e)
    }
    actual inline fun article(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "article", className)
        e.block()
        append(e)
    }
    actual inline fun aside(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "aside", className)
        e.block()
        append(e)
    }
    actual inline fun audio(className: String?, noinline block: E<AudioHTMLAttributes<HTMLAudioElement>, HTMLAudioElement>.() -> Unit) {
        val e = E<AudioHTMLAttributes<HTMLAudioElement>, HTMLAudioElement>(this, "audio", className)
        e.block()
        append(e)
    }
    actual inline fun b(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "b", className)
        e.block()
        append(e)
    }
    actual inline fun base(className: String?, noinline block: E<BaseHTMLAttributes<HTMLBaseElement>, HTMLBaseElement>.() -> Unit) {
        val e = E<BaseHTMLAttributes<HTMLBaseElement>, HTMLBaseElement>(this, "base", className)
        e.block()
        append(e)
    }
    actual inline fun bdi(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "bdi", className)
        e.block()
        append(e)
    }
    actual inline fun bdo(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "bdo", className)
        e.block()
        append(e)
    }
    actual inline fun big(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "big", className)
        e.block()
        append(e)
    }
    actual inline fun blockquote(className: String?, noinline block: E<BlockquoteHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<BlockquoteHTMLAttributes<HTMLElement>, HTMLElement>(this, "blockquote", className)
        e.block()
        append(e)
    }
    actual inline fun body(className: String?, noinline block: E<HTMLAttributes<HTMLBodyElement>, HTMLBodyElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLBodyElement>, HTMLBodyElement>(this, "body", className)
        e.block()
        append(e)
    }
    actual inline fun br(className: String?, noinline block: E<HTMLAttributes<HTMLBRElement>, HTMLBRElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLBRElement>, HTMLBRElement>(this, "br", className)
        e.block()
        append(e)
    }
    actual inline fun button(className: String?, noinline block: E<ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement>.() -> Unit) {
        val e = E<ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement>(this, "button", className)
        e.block()
        append(e)
    }
    actual inline fun canvas(className: String?, noinline block: E<CanvasHTMLAttributes<HTMLCanvasElement>, HTMLCanvasElement>.() -> Unit) {
        val e = E<CanvasHTMLAttributes<HTMLCanvasElement>, HTMLCanvasElement>(this, "canvas", className)
        e.block()
        append(e)
    }
    actual inline fun caption(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "caption", className)
        e.block()
        append(e)
    }
    actual inline fun cite(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "cite", className)
        e.block()
        append(e)
    }
    actual inline fun code(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "code", className)
        e.block()
        append(e)
    }
    actual inline fun col(className: String?, noinline block: E<ColHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>.() -> Unit) {
        val e = E<ColHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>(this, "col", className)
        e.block()
        append(e)
    }
    actual inline fun colgroup(className: String?, noinline block: E<ColgroupHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>.() -> Unit) {
        val e = E<ColgroupHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>(this, "colgroup", className)
        e.block()
        append(e)
    }
    actual inline fun data(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "data", className)
        e.block()
        append(e)
    }
    actual inline fun datalist(className: String?, noinline block: E<HTMLAttributes<HTMLDataListElement>, HTMLDataListElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLDataListElement>, HTMLDataListElement>(this, "datalist", className)
        e.block()
        append(e)
    }
    actual inline fun dd(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "dd", className)
        e.block()
        append(e)
    }
    actual inline fun del(className: String?, noinline block: E<DelHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<DelHTMLAttributes<HTMLElement>, HTMLElement>(this, "del", className)
        e.block()
        append(e)
    }
    actual inline fun details(className: String?, noinline block: E<DetailsHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<DetailsHTMLAttributes<HTMLElement>, HTMLElement>(this, "details", className)
        e.block()
        append(e)
    }
    actual inline fun dfn(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "dfn", className)
        e.block()
        append(e)
    }
    actual inline fun dialog(className: String?, noinline block: E<DialogHTMLAttributes<HTMLDialogElement>, HTMLDialogElement>.() -> Unit) {
        val e = E<DialogHTMLAttributes<HTMLDialogElement>, HTMLDialogElement>(this, "dialog", className)
        e.block()
        append(e)
    }
    actual inline fun div(className: String?, noinline block: E<HTMLAttributes<HTMLDivElement>, HTMLDivElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLDivElement>, HTMLDivElement>(this, "div", className)
        e.block()
        append(e)
    }
    actual inline fun dl(className: String?, noinline block: E<HTMLAttributes<HTMLDListElement>, HTMLDListElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLDListElement>, HTMLDListElement>(this, "dl", className)
        e.block()
        append(e)
    }
    actual inline fun dt(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "dt", className)
        e.block()
        append(e)
    }
    actual inline fun em(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "em", className)
        e.block()
        append(e)
    }
    actual inline fun embed(className: String?, noinline block: E<EmbedHTMLAttributes<HTMLEmbedElement>, HTMLEmbedElement>.() -> Unit) {
        val e = E<EmbedHTMLAttributes<HTMLEmbedElement>, HTMLEmbedElement>(this, "embed", className)
        e.block()
        append(e)
    }
    actual inline fun fieldset(className: String?, noinline block: E<FieldsetHTMLAttributes<HTMLFieldSetElement>, HTMLFieldSetElement>.() -> Unit) {
        val e = E<FieldsetHTMLAttributes<HTMLFieldSetElement>, HTMLFieldSetElement>(this, "fieldset", className)
        e.block()
        append(e)
    }
    actual inline fun figcaption(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "figcaption", className)
        e.block()
        append(e)
    }
    actual inline fun figure(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "figure", className)
        e.block()
        append(e)
    }
    actual inline fun footer(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "footer", className)
        e.block()
        append(e)
    }
    actual inline fun form(className: String?, noinline block: E<FormHTMLAttributes<HTMLFormElement>, HTMLFormElement>.() -> Unit) {
        val e = E<FormHTMLAttributes<HTMLFormElement>, HTMLFormElement>(this, "form", className)
        e.block()
        append(e)
    }
    actual inline fun h1(className: String?, noinline block: E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h1", className)
        e.block()
        append(e)
    }
    actual inline fun h2(className: String?, noinline block: E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h2", className)
        e.block()
        append(e)
    }
    actual inline fun h3(className: String?, noinline block: E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h3", className)
        e.block()
        append(e)
    }
    actual inline fun h4(className: String?, noinline block: E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h4", className)
        e.block()
        append(e)
    }
    actual inline fun h5(className: String?, noinline block: E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h5", className)
        e.block()
        append(e)
    }
    actual inline fun h6(className: String?, noinline block: E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h6", className)
        e.block()
        append(e)
    }
    actual inline fun head(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "head", className)
        e.block()
        append(e)
    }
    actual inline fun header(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "header", className)
        e.block()
        append(e)
    }
    actual inline fun hgroup(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "hgroup", className)
        e.block()
        append(e)
    }
    actual inline fun hr(className: String?, noinline block: E<HTMLAttributes<HTMLHRElement>, HTMLHRElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLHRElement>, HTMLHRElement>(this, "hr", className)
        e.block()
        append(e)
    }
    actual inline fun html(className: String?, noinline block: E<HtmlHTMLAttributes<HTMLHtmlElement>, HTMLHtmlElement>.() -> Unit) {
        val e = E<HtmlHTMLAttributes<HTMLHtmlElement>, HTMLHtmlElement>(this, "html", className)
        e.block()
        append(e)
    }
    actual inline fun i(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "i", className)
        e.block()
        append(e)
    }
    actual inline fun iframe(className: String?, noinline block: E<IframeHTMLAttributes<HTMLIFrameElement>, HTMLIFrameElement>.() -> Unit) {
        val e = E<IframeHTMLAttributes<HTMLIFrameElement>, HTMLIFrameElement>(this, "iframe", className)
        e.block()
        append(e)
    }
    actual inline fun img(className: String?, noinline block: E<ImgHTMLAttributes<HTMLImageElement>, HTMLImageElement>.() -> Unit) {
        val e = E<ImgHTMLAttributes<HTMLImageElement>, HTMLImageElement>(this, "img", className)
        e.block()
        append(e)
    }
    actual inline fun input(className: String?, noinline block: E<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement>.() -> Unit) {
        val e = E<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement>(this, "input", className)
        e.block()
        append(e)
    }
    actual inline fun ins(className: String?, noinline block: E<InsHTMLAttributes<HTMLModElement>, HTMLModElement>.() -> Unit) {
        val e = E<InsHTMLAttributes<HTMLModElement>, HTMLModElement>(this, "ins", className)
        e.block()
        append(e)
    }
    actual inline fun kbd(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "kbd", className)
        e.block()
        append(e)
    }
    actual inline fun keygen(className: String?, noinline block: E<KeygenHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<KeygenHTMLAttributes<HTMLElement>, HTMLElement>(this, "keygen", className)
        e.block()
        append(e)
    }
    actual inline fun label(className: String?, noinline block: E<LabelHTMLAttributes<HTMLLabelElement>, HTMLLabelElement>.() -> Unit) {
        val e = E<LabelHTMLAttributes<HTMLLabelElement>, HTMLLabelElement>(this, "label", className)
        e.block()
        append(e)
    }
    actual inline fun legend(className: String?, noinline block: E<HTMLAttributes<HTMLLegendElement>, HTMLLegendElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLLegendElement>, HTMLLegendElement>(this, "legend", className)
        e.block()
        append(e)
    }
    actual inline fun li(className: String?, noinline block: E<LiHTMLAttributes<HTMLLIElement>, HTMLLIElement>.() -> Unit) {
        val e = E<LiHTMLAttributes<HTMLLIElement>, HTMLLIElement>(this, "li", className)
        e.block()
        append(e)
    }
    actual inline fun link(className: String?, noinline block: E<LinkHTMLAttributes<HTMLLinkElement>, HTMLLinkElement>.() -> Unit) {
        val e = E<LinkHTMLAttributes<HTMLLinkElement>, HTMLLinkElement>(this, "link", className)
        e.block()
        append(e)
    }
    actual inline fun main(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "main", className)
        e.block()
        append(e)
    }
    actual inline fun map(className: String?, noinline block: E<MapHTMLAttributes<HTMLMapElement>, HTMLMapElement>.() -> Unit) {
        val e = E<MapHTMLAttributes<HTMLMapElement>, HTMLMapElement>(this, "map", className)
        e.block()
        append(e)
    }
    actual inline fun mark(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "mark", className)
        e.block()
        append(e)
    }
    actual inline fun menu(className: String?, noinline block: E<MenuHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<MenuHTMLAttributes<HTMLElement>, HTMLElement>(this, "menu", className)
        e.block()
        append(e)
    }
    actual inline fun menuitem(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "menuitem", className)
        e.block()
        append(e)
    }
    actual inline fun meta(className: String?, noinline block: E<MetaHTMLAttributes<HTMLMetaElement>, HTMLMetaElement>.() -> Unit) {
        val e = E<MetaHTMLAttributes<HTMLMetaElement>, HTMLMetaElement>(this, "meta", className)
        e.block()
        append(e)
    }
    actual inline fun meter(className: String?, noinline block: E<MeterHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<MeterHTMLAttributes<HTMLElement>, HTMLElement>(this, "meter", className)
        e.block()
        append(e)
    }
    actual inline fun nav(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "nav", className)
        e.block()
        append(e)
    }
    actual inline fun noscript(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "noscript", className)
        e.block()
        append(e)
    }
    actual inline fun objectElement(className: String?, noinline block: E<ObjectHTMLAttributes<HTMLObjectElement>, HTMLObjectElement>.() -> Unit) {
        val e = E<ObjectHTMLAttributes<HTMLObjectElement>, HTMLObjectElement>(this, "object", className)
        e.block()
        append(e)
    }
    actual inline fun ol(className: String?, noinline block: E<OlHTMLAttributes<HTMLOListElement>, HTMLOListElement>.() -> Unit) {
        val e = E<OlHTMLAttributes<HTMLOListElement>, HTMLOListElement>(this, "ol", className)
        e.block()
        append(e)
    }
    actual inline fun optgroup(className: String?, noinline block: E<OptgroupHTMLAttributes<HTMLOptGroupElement>, HTMLOptGroupElement>.() -> Unit) {
        val e = E<OptgroupHTMLAttributes<HTMLOptGroupElement>, HTMLOptGroupElement>(this, "optgroup", className)
        e.block()
        append(e)
    }
    actual inline fun option(className: String?, noinline block: E<OptionHTMLAttributes<HTMLOptionElement>, HTMLOptionElement>.() -> Unit) {
        val e = E<OptionHTMLAttributes<HTMLOptionElement>, HTMLOptionElement>(this, "option", className)
        e.block()
        append(e)
    }
    actual inline fun output(className: String?, noinline block: E<OutputHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<OutputHTMLAttributes<HTMLElement>, HTMLElement>(this, "output", className)
        e.block()
        append(e)
    }
    actual inline fun p(className: String?, noinline block: E<HTMLAttributes<HTMLParagraphElement>, HTMLParagraphElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLParagraphElement>, HTMLParagraphElement>(this, "p", className)
        e.block()
        append(e)
    }
    actual inline fun param(className: String?, noinline block: E<ParamHTMLAttributes<HTMLParamElement>, HTMLParamElement>.() -> Unit) {
        val e = E<ParamHTMLAttributes<HTMLParamElement>, HTMLParamElement>(this, "param", className)
        e.block()
        append(e)
    }
    actual inline fun picture(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "picture", className)
        e.block()
        append(e)
    }
    actual inline fun pre(className: String?, noinline block: E<HTMLAttributes<HTMLPreElement>, HTMLPreElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLPreElement>, HTMLPreElement>(this, "pre", className)
        e.block()
        append(e)
    }
    actual inline fun progress(className: String?, noinline block: E<ProgressHTMLAttributes<HTMLProgressElement>, HTMLProgressElement>.() -> Unit) {
        val e = E<ProgressHTMLAttributes<HTMLProgressElement>, HTMLProgressElement>(this, "progress", className)
        e.block()
        append(e)
    }
    actual inline fun q(className: String?, noinline block: E<QuoteHTMLAttributes<HTMLQuoteElement>, HTMLQuoteElement>.() -> Unit) {
        val e = E<QuoteHTMLAttributes<HTMLQuoteElement>, HTMLQuoteElement>(this, "q", className)
        e.block()
        append(e)
    }
    actual inline fun rp(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "rp", className)
        e.block()
        append(e)
    }
    actual inline fun rt(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "rt", className)
        e.block()
        append(e)
    }
    actual inline fun ruby(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "ruby", className)
        e.block()
        append(e)
    }
    actual inline fun s(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "s", className)
        e.block()
        append(e)
    }
    actual inline fun samp(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "samp", className)
        e.block()
        append(e)
    }
    actual inline fun script(className: String?, noinline block: E<ScriptHTMLAttributes<HTMLScriptElement>, HTMLScriptElement>.() -> Unit) {
        val e = E<ScriptHTMLAttributes<HTMLScriptElement>, HTMLScriptElement>(this, "script", className)
        e.block()
        append(e)
    }
    actual inline fun section(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "section", className)
        e.block()
        append(e)
    }
    actual inline fun select(className: String?, noinline block: E<SelectHTMLAttributes<HTMLSelectElement>, HTMLSelectElement>.() -> Unit) {
        val e = E<SelectHTMLAttributes<HTMLSelectElement>, HTMLSelectElement>(this, "select", className)
        e.block()
        append(e)
    }
    actual inline fun small(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "small", className)
        e.block()
        append(e)
    }
    actual inline fun source(className: String?, noinline block: E<SourceHTMLAttributes<HTMLSourceElement>, HTMLSourceElement>.() -> Unit) {
        val e = E<SourceHTMLAttributes<HTMLSourceElement>, HTMLSourceElement>(this, "source", className)
        e.block()
        append(e)
    }
    actual inline fun span(className: String?, noinline block: E<HTMLAttributes<HTMLSpanElement>, HTMLSpanElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLSpanElement>, HTMLSpanElement>(this, "span", className)
        e.block()
        append(e)
    }
    actual inline fun strong(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "strong", className)
        e.block()
        append(e)
    }
    actual inline fun styleElement(className: String?, noinline block: E<StyleHTMLAttributes<HTMLStyleElement>, HTMLStyleElement>.() -> Unit) {
        val e = E<StyleHTMLAttributes<HTMLStyleElement>, HTMLStyleElement>(this, "style", className)
        e.block()
        append(e)
    }
    actual inline fun sub(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "sub", className)
        e.block()
        append(e)
    }
    actual inline fun summary(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "summary", className)
        e.block()
        append(e)
    }
    actual inline fun sup(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "sup", className)
        e.block()
        append(e)
    }
    actual inline fun table(className: String?, noinline block: E<TableHTMLAttributes<HTMLTableElement>, HTMLTableElement>.() -> Unit) {
        val e = E<TableHTMLAttributes<HTMLTableElement>, HTMLTableElement>(this, "table", className)
        e.block()
        append(e)
    }
    actual inline fun tbody(className: String?, noinline block: E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>(this, "tbody", className)
        e.block()
        append(e)
    }
    actual inline fun td(className: String?, noinline block: E<TdHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>.() -> Unit) {
        val e = E<TdHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>(this, "td", className)
        e.block()
        append(e)
    }
    actual inline fun textarea(className: String?, noinline block: E<TextareaHTMLAttributes<HTMLTextAreaElement>, HTMLTextAreaElement>.() -> Unit) {
        val e = E<TextareaHTMLAttributes<HTMLTextAreaElement>, HTMLTextAreaElement>(this, "textarea", className)
        e.block()
        append(e)
    }
    actual inline fun tfoot(className: String?, noinline block: E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>(this, "tfoot", className)
        e.block()
        append(e)
    }
    actual inline fun th(className: String?, noinline block: E<ThHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>.() -> Unit) {
        val e = E<ThHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>(this, "th", className)
        e.block()
        append(e)
    }
    actual inline fun thead(className: String?, noinline block: E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>(this, "thead", className)
        e.block()
        append(e)
    }
    actual inline fun time(className: String?, noinline block: E<TimeHTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<TimeHTMLAttributes<HTMLElement>, HTMLElement>(this, "time", className)
        e.block()
        append(e)
    }
    actual inline fun title(className: String?, noinline block: E<HTMLAttributes<HTMLTitleElement>, HTMLTitleElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTitleElement>, HTMLTitleElement>(this, "title", className)
        e.block()
        append(e)
    }
    actual inline fun tr(className: String?, noinline block: E<HTMLAttributes<HTMLTableRowElement>, HTMLTableRowElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLTableRowElement>, HTMLTableRowElement>(this, "tr", className)
        e.block()
        append(e)
    }
    actual inline fun track(className: String?, noinline block: E<TrackHTMLAttributes<HTMLTrackElement>, HTMLTrackElement>.() -> Unit) {
        val e = E<TrackHTMLAttributes<HTMLTrackElement>, HTMLTrackElement>(this, "track", className)
        e.block()
        append(e)
    }
    actual inline fun u(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "u", className)
        e.block()
        append(e)
    }
    actual inline fun ul(className: String?, noinline block: E<HTMLAttributes<HTMLUListElement>, HTMLUListElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLUListElement>, HTMLUListElement>(this, "ul", className)
        e.block()
        append(e)
    }
    actual inline fun varElement(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "var", className)
        e.block()
        append(e)
    }
    actual inline fun video(className: String?, noinline block: E<VideoHTMLAttributes<HTMLVideoElement>, HTMLVideoElement>.() -> Unit) {
        val e = E<VideoHTMLAttributes<HTMLVideoElement>, HTMLVideoElement>(this, "video", className)
        e.block()
        append(e)
    }
    actual inline fun wbr(className: String?, noinline block: E<HTMLAttributes<HTMLElement>, HTMLElement>.() -> Unit) {
        val e = E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "wbr", className)
        e.block()
        append(e)
    }

    actual inline fun a(className: String?) { append(E<AnchorHTMLAttributes<HTMLAnchorElement>, HTMLAnchorElement>(this, "a", className)) }
    actual inline fun address(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "address", className)) }
    actual inline fun area(className: String?) { append(E<AreaHTMLAttributes<HTMLAreaElement>, HTMLAreaElement>(this, "area", className)) }
    actual inline fun article(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "article", className)) }
    actual inline fun aside(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "aside", className)) }
    actual inline fun audio(className: String?) { append(E<AudioHTMLAttributes<HTMLAudioElement>, HTMLAudioElement>(this, "audio", className)) }
    actual inline fun b(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "b", className)) }
    actual inline fun base(className: String?) { append(E<BaseHTMLAttributes<HTMLBaseElement>, HTMLBaseElement>(this, "base", className)) }
    actual inline fun bdi(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "bdi", className)) }
    actual inline fun bdo(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "bdo", className)) }
    actual inline fun big(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "big", className)) }
    actual inline fun blockquote(className: String?) { append(E<BlockquoteHTMLAttributes<HTMLElement>, HTMLElement>(this, "blockquote", className)) }
    actual inline fun body(className: String?) { append(E<HTMLAttributes<HTMLBodyElement>, HTMLBodyElement>(this, "body", className)) }
    actual inline fun br(className: String?) { append(E<HTMLAttributes<HTMLBRElement>, HTMLBRElement>(this, "br", className)) }
    actual inline fun button(className: String?) { append(E<ButtonHTMLAttributes<HTMLButtonElement>, HTMLButtonElement>(this, "button", className)) }
    actual inline fun canvas(className: String?) { append(E<CanvasHTMLAttributes<HTMLCanvasElement>, HTMLCanvasElement>(this, "canvas", className)) }
    actual inline fun caption(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "caption", className)) }
    actual inline fun cite(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "cite", className)) }
    actual inline fun code(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "code", className)) }
    actual inline fun col(className: String?) { append(E<ColHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>(this, "col", className)) }
    actual inline fun colgroup(className: String?) { append(E<ColgroupHTMLAttributes<HTMLTableColElement>, HTMLTableColElement>(this, "colgroup", className)) }
    actual inline fun data(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "data", className)) }
    actual inline fun datalist(className: String?) { append(E<HTMLAttributes<HTMLDataListElement>, HTMLDataListElement>(this, "datalist", className)) }
    actual inline fun dd(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "dd", className)) }
    actual inline fun del(className: String?) { append(E<DelHTMLAttributes<HTMLElement>, HTMLElement>(this, "del", className)) }
    actual inline fun details(className: String?) { append(E<DetailsHTMLAttributes<HTMLElement>, HTMLElement>(this, "details", className)) }
    actual inline fun dfn(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "dfn", className)) }
    actual inline fun dialog(className: String?) { append(E<DialogHTMLAttributes<HTMLDialogElement>, HTMLDialogElement>(this, "dialog", className)) }
    actual inline fun div(className: String?) { append(E<HTMLAttributes<HTMLDivElement>, HTMLDivElement>(this, "div", className)) }
    actual inline fun dl(className: String?) { append(E<HTMLAttributes<HTMLDListElement>, HTMLDListElement>(this, "dl", className)) }
    actual inline fun dt(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "dt", className)) }
    actual inline fun em(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "em", className)) }
    actual inline fun embed(className: String?) { append(E<EmbedHTMLAttributes<HTMLEmbedElement>, HTMLEmbedElement>(this, "embed", className)) }
    actual inline fun fieldset(className: String?) { append(E<FieldsetHTMLAttributes<HTMLFieldSetElement>, HTMLFieldSetElement>(this, "fieldset", className)) }
    actual inline fun figcaption(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "figcaption", className)) }
    actual inline fun figure(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "figure", className)) }
    actual inline fun footer(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "footer", className)) }
    actual inline fun form(className: String?) { append(E<FormHTMLAttributes<HTMLFormElement>, HTMLFormElement>(this, "form", className)) }
    actual inline fun h1(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h1", className)) }
    actual inline fun h2(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h2", className)) }
    actual inline fun h3(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h3", className)) }
    actual inline fun h4(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h4", className)) }
    actual inline fun h5(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h5", className)) }
    actual inline fun h6(className: String?) { append(E<HTMLAttributes<HTMLHeadingElement>, HTMLHeadingElement>(this, "h6", className)) }
    actual inline fun head(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "head", className)) }
    actual inline fun header(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "header", className)) }
    actual inline fun hgroup(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "hgroup", className)) }
    actual inline fun hr(className: String?) { append(E<HTMLAttributes<HTMLHRElement>, HTMLHRElement>(this, "hr", className)) }
    actual inline fun html(className: String?) { append(E<HtmlHTMLAttributes<HTMLHtmlElement>, HTMLHtmlElement>(this, "html", className)) }
    actual inline fun i(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "i", className)) }
    actual inline fun iframe(className: String?) { append(E<IframeHTMLAttributes<HTMLIFrameElement>, HTMLIFrameElement>(this, "iframe", className)) }
    actual inline fun img(className: String?) { append(E<ImgHTMLAttributes<HTMLImageElement>, HTMLImageElement>(this, "img", className)) }
    actual inline fun input(className: String?) { append(E<InputHTMLAttributes<HTMLInputElement>, HTMLInputElement>(this, "input", className)) }
    actual inline fun ins(className: String?) { append(E<InsHTMLAttributes<HTMLModElement>, HTMLModElement>(this, "ins", className)) }
    actual inline fun kbd(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "kbd", className)) }
    actual inline fun keygen(className: String?) { append(E<KeygenHTMLAttributes<HTMLElement>, HTMLElement>(this, "keygen", className)) }
    actual inline fun label(className: String?) { append(E<LabelHTMLAttributes<HTMLLabelElement>, HTMLLabelElement>(this, "label", className)) }
    actual inline fun legend(className: String?) { append(E<HTMLAttributes<HTMLLegendElement>, HTMLLegendElement>(this, "legend", className)) }
    actual inline fun li(className: String?) { append(E<LiHTMLAttributes<HTMLLIElement>, HTMLLIElement>(this, "li", className)) }
    actual inline fun link(className: String?) { append(E<LinkHTMLAttributes<HTMLLinkElement>, HTMLLinkElement>(this, "link", className)) }
    actual inline fun main(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "main", className)) }
    actual inline fun map(className: String?) { append(E<MapHTMLAttributes<HTMLMapElement>, HTMLMapElement>(this, "map", className)) }
    actual inline fun mark(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "mark", className)) }
    actual inline fun menu(className: String?) { append(E<MenuHTMLAttributes<HTMLElement>, HTMLElement>(this, "menu", className)) }
    actual inline fun menuitem(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "menuitem", className)) }
    actual inline fun meta(className: String?) { append(E<MetaHTMLAttributes<HTMLMetaElement>, HTMLMetaElement>(this, "meta", className)) }
    actual inline fun meter(className: String?) { append(E<MeterHTMLAttributes<HTMLElement>, HTMLElement>(this, "meter", className)) }
    actual inline fun nav(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "nav", className)) }
    actual inline fun noscript(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "noscript", className)) }
    actual inline fun objectElement(className: String?) { append(E<ObjectHTMLAttributes<HTMLObjectElement>, HTMLObjectElement>(this, "object", className)) }
    actual inline fun ol(className: String?) { append(E<OlHTMLAttributes<HTMLOListElement>, HTMLOListElement>(this, "ol", className)) }
    actual inline fun optgroup(className: String?) { append(E<OptgroupHTMLAttributes<HTMLOptGroupElement>, HTMLOptGroupElement>(this, "optgroup", className)) }
    actual inline fun option(className: String?) { append(E<OptionHTMLAttributes<HTMLOptionElement>, HTMLOptionElement>(this, "option", className)) }
    actual inline fun output(className: String?) { append(E<OutputHTMLAttributes<HTMLElement>, HTMLElement>(this, "output", className)) }
    actual inline fun p(className: String?) { append(E<HTMLAttributes<HTMLParagraphElement>, HTMLParagraphElement>(this, "p", className)) }
    actual inline fun param(className: String?) { append(E<ParamHTMLAttributes<HTMLParamElement>, HTMLParamElement>(this, "param", className)) }
    actual inline fun picture(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "picture", className)) }
    actual inline fun pre(className: String?) { append(E<HTMLAttributes<HTMLPreElement>, HTMLPreElement>(this, "pre", className)) }
    actual inline fun progress(className: String?) { append(E<ProgressHTMLAttributes<HTMLProgressElement>, HTMLProgressElement>(this, "progress", className)) }
    actual inline fun q(className: String?) { append(E<QuoteHTMLAttributes<HTMLQuoteElement>, HTMLQuoteElement>(this, "q", className)) }
    actual inline fun rp(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "rp", className)) }
    actual inline fun rt(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "rt", className)) }
    actual inline fun ruby(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "ruby", className)) }
    actual inline fun s(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "s", className)) }
    actual inline fun samp(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "samp", className)) }
    actual inline fun script(className: String?) { append(E<ScriptHTMLAttributes<HTMLScriptElement>, HTMLScriptElement>(this, "script", className)) }
    actual inline fun section(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "section", className)) }
    actual inline fun select(className: String?) { append(E<SelectHTMLAttributes<HTMLSelectElement>, HTMLSelectElement>(this, "select", className)) }
    actual inline fun small(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "small", className)) }
    actual inline fun source(className: String?) { append(E<SourceHTMLAttributes<HTMLSourceElement>, HTMLSourceElement>(this, "source", className)) }
    actual inline fun span(className: String?) { append(E<HTMLAttributes<HTMLSpanElement>, HTMLSpanElement>(this, "span", className)) }
    actual inline fun strong(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "strong", className)) }
    actual inline fun styleElement(className: String?) { append(E<StyleHTMLAttributes<HTMLStyleElement>, HTMLStyleElement>(this, "style", className)) }
    actual inline fun sub(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "sub", className)) }
    actual inline fun summary(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "summary", className)) }
    actual inline fun sup(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "sup", className)) }
    actual inline fun table(className: String?) { append(E<TableHTMLAttributes<HTMLTableElement>, HTMLTableElement>(this, "table", className)) }
    actual inline fun tbody(className: String?) { append(E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>(this, "tbody", className)) }
    actual inline fun td(className: String?) { append(E<TdHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>(this, "td", className)) }
    actual inline fun textarea(className: String?) { append(E<TextareaHTMLAttributes<HTMLTextAreaElement>, HTMLTextAreaElement>(this, "textarea", className)) }
    actual inline fun tfoot(className: String?) { append(E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>(this, "tfoot", className)) }
    actual inline fun th(className: String?) { append(E<ThHTMLAttributes<HTMLTableCellElement>, HTMLTableCellElement>(this, "th", className)) }
    actual inline fun thead(className: String?) { append(E<HTMLAttributes<HTMLTableSectionElement>, HTMLTableSectionElement>(this, "thead", className)) }
    actual inline fun time(className: String?) { append(E<TimeHTMLAttributes<HTMLElement>, HTMLElement>(this, "time", className)) }
    actual inline fun title(className: String?) { append(E<HTMLAttributes<HTMLTitleElement>, HTMLTitleElement>(this, "title", className)) }
    actual inline fun tr(className: String?) { append(E<HTMLAttributes<HTMLTableRowElement>, HTMLTableRowElement>(this, "tr", className)) }
    actual inline fun track(className: String?) { append(E<TrackHTMLAttributes<HTMLTrackElement>, HTMLTrackElement>(this, "track", className)) }
    actual inline fun u(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "u", className)) }
    actual inline fun ul(className: String?) { append(E<HTMLAttributes<HTMLUListElement>, HTMLUListElement>(this, "ul", className)) }
    actual inline fun varElement(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "var", className)) }
    actual inline fun video(className: String?) { append(E<VideoHTMLAttributes<HTMLVideoElement>, HTMLVideoElement>(this, "video", className)) }
    actual inline fun wbr(className: String?) { append(E<HTMLAttributes<HTMLElement>, HTMLElement>(this, "wbr", className)) }
}
