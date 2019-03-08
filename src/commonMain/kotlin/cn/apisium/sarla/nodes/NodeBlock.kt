@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION")

package cn.apisium.sarla.nodes

import cn.apisium.sarla.*
import cn.apisium.sarla.Attr
import cn.apisium.sarla.dom.*

@SarlaDsl
expect class NodeBlock {
    fun <T : Any> Data<T>.get(key: Any): Data<T>

    inline fun Data<*>.get(key: Any): Data<*>

    inline operator fun String.unaryPlus()

    inline operator fun Number.unaryPlus()

    inline operator fun Nothing.unaryPlus()

    inline operator fun Unit.unaryPlus()

    inline operator fun <P, T: SarlaProp<P>> SarlaInstantProp<T>.invoke(props: P? = null, noinline block: Nodes? = null)

    inline operator fun <T: Sarla> SarlaInstantNoProp<T>.invoke(noinline block: Nodes? = null)

    inline fun a(className: String? = null, noinline block: Nodes? = null)
    inline fun address(className: String? = null, noinline block: Nodes? = null)
    inline fun area(className: String? = null, noinline block: Nodes? = null)
    inline fun article(className: String? = null, noinline block: Nodes? = null)
    inline fun aside(className: String? = null, noinline block: Nodes? = null)
    inline fun audio(className: String? = null, noinline block: Nodes? = null)
    inline fun b(className: String? = null, noinline block: Nodes? = null)
    inline fun base(className: String? = null, noinline block: Nodes? = null)
    inline fun bdi(className: String? = null, noinline block: Nodes? = null)
    inline fun bdo(className: String? = null, noinline block: Nodes? = null)
    inline fun big(className: String? = null, noinline block: Nodes? = null)
    inline fun blockquote(className: String? = null, noinline block: Nodes? = null)
    inline fun body(className: String? = null, noinline block: Nodes? = null)
    inline fun br(className: String? = null, noinline block: Nodes? = null)
    inline fun button(className: String? = null, noinline block: Nodes? = null)
    inline fun canvas(className: String? = null, noinline block: Nodes? = null)
    inline fun caption(className: String? = null, noinline block: Nodes? = null)
    inline fun cite(className: String? = null, noinline block: Nodes? = null)
    inline fun code(className: String? = null, noinline block: Nodes? = null)
    inline fun col(className: String? = null, noinline block: Nodes? = null)
    inline fun colgroup(className: String? = null, noinline block: Nodes? = null)
    inline fun data(className: String? = null, noinline block: Nodes? = null)
    inline fun datalist(className: String? = null, noinline block: Nodes? = null)
    inline fun dd(className: String? = null, noinline block: Nodes? = null)
    inline fun del(className: String? = null, noinline block: Nodes? = null)
    inline fun details(className: String? = null, noinline block: Nodes? = null)
    inline fun dfn(className: String? = null, noinline block: Nodes? = null)
    inline fun dialog(className: String? = null, noinline block: Nodes? = null)
    inline fun div(className: String? = null, noinline block: Nodes? = null)
    inline fun dl(className: String? = null, noinline block: Nodes? = null)
    inline fun dt(className: String? = null, noinline block: Nodes? = null)
    inline fun em(className: String? = null, noinline block: Nodes? = null)
    inline fun embed(className: String? = null, noinline block: Nodes? = null)
    inline fun fieldset(className: String? = null, noinline block: Nodes? = null)
    inline fun figcaption(className: String? = null, noinline block: Nodes? = null)
    inline fun figure(className: String? = null, noinline block: Nodes? = null)
    inline fun footer(className: String? = null, noinline block: Nodes? = null)
    inline fun form(className: String? = null, noinline block: Nodes? = null)
    inline fun h1(className: String? = null, noinline block: Nodes? = null)
    inline fun h2(className: String? = null, noinline block: Nodes? = null)
    inline fun h3(className: String? = null, noinline block: Nodes? = null)
    inline fun h4(className: String? = null, noinline block: Nodes? = null)
    inline fun h5(className: String? = null, noinline block: Nodes? = null)
    inline fun h6(className: String? = null, noinline block: Nodes? = null)
    inline fun head(className: String? = null, noinline block: Nodes? = null)
    inline fun header(className: String? = null, noinline block: Nodes? = null)
    inline fun hgroup(className: String? = null, noinline block: Nodes? = null)
    inline fun hr(className: String? = null, noinline block: Nodes? = null)
    inline fun html(className: String? = null, noinline block: Nodes? = null)
    inline fun i(className: String? = null, noinline block: Nodes? = null)
    inline fun iframe(className: String? = null, noinline block: Nodes? = null)
    inline fun img(className: String? = null, noinline block: Nodes? = null)
    inline fun input(className: String? = null, noinline block: Nodes? = null)
    inline fun ins(className: String? = null, noinline block: Nodes? = null)
    inline fun kbd(className: String? = null, noinline block: Nodes? = null)
    inline fun keygen(className: String? = null, noinline block: Nodes? = null)
    inline fun label(className: String? = null, noinline block: Nodes? = null)
    inline fun legend(className: String? = null, noinline block: Nodes? = null)
    inline fun li(className: String? = null, noinline block: Nodes? = null)
    inline fun link(className: String? = null, noinline block: Nodes? = null)
    inline fun main(className: String? = null, noinline block: Nodes? = null)
    inline fun map(className: String? = null, noinline block: Nodes? = null)
    inline fun mark(className: String? = null, noinline block: Nodes? = null)
    inline fun menu(className: String? = null, noinline block: Nodes? = null)
    inline fun menuitem(className: String? = null, noinline block: Nodes? = null)
    inline fun meta(className: String? = null, noinline block: Nodes? = null)
    inline fun meter(className: String? = null, noinline block: Nodes? = null)
    inline fun nav(className: String? = null, noinline block: Nodes? = null)
    inline fun noscript(className: String? = null, noinline block: Nodes? = null)
    inline fun objectElement(className: String? = null, noinline block: Nodes? = null)
    inline fun ol(className: String? = null, noinline block: Nodes? = null)
    inline fun optgroup(className: String? = null, noinline block: Nodes? = null)
    inline fun option(className: String? = null, noinline block: Nodes? = null)
    inline fun output(className: String? = null, noinline block: Nodes? = null)
    inline fun p(className: String? = null, noinline block: Nodes? = null)
    inline fun param(className: String? = null, noinline block: Nodes? = null)
    inline fun picture(className: String? = null, noinline block: Nodes? = null)
    inline fun pre(className: String? = null, noinline block: Nodes? = null)
    inline fun progress(className: String? = null, noinline block: Nodes? = null)
    inline fun q(className: String? = null, noinline block: Nodes? = null)
    inline fun rp(className: String? = null, noinline block: Nodes? = null)
    inline fun rt(className: String? = null, noinline block: Nodes? = null)
    inline fun ruby(className: String? = null, noinline block: Nodes? = null)
    inline fun s(className: String? = null, noinline block: Nodes? = null)
    inline fun samp(className: String? = null, noinline block: Nodes? = null)
    inline fun script(className: String? = null, noinline block: Nodes? = null)
    inline fun section(className: String? = null, noinline block: Nodes? = null)
    inline fun select(className: String? = null, noinline block: Nodes? = null)
    inline fun small(className: String? = null, noinline block: Nodes? = null)
    inline fun source(className: String? = null, noinline block: Nodes? = null)
    inline fun span(className: String? = null, noinline block: Nodes? = null)
    inline fun strong(className: String? = null, noinline block: Nodes? = null)
    inline fun styleElement(className: String? = null, noinline block: Nodes? = null)
    inline fun sub(className: String? = null, noinline block: Nodes? = null)
    inline fun summary(className: String? = null, noinline block: Nodes? = null)
    inline fun sup(className: String? = null, noinline block: Nodes? = null)
    inline fun table(className: String? = null, noinline block: Nodes? = null)
    inline fun tbody(className: String? = null, noinline block: Nodes? = null)
    inline fun td(className: String? = null, noinline block: Nodes? = null)
    inline fun textarea(className: String? = null, noinline block: Nodes? = null)
    inline fun tfoot(className: String? = null, noinline block: Nodes? = null)
    inline fun th(className: String? = null, noinline block: Nodes? = null)
    inline fun thead(className: String? = null, noinline block: Nodes? = null)
    inline fun time(className: String? = null, noinline block: Nodes? = null)
    inline fun title(className: String? = null, noinline block: Nodes? = null)
    inline fun tr(className: String? = null, noinline block: Nodes? = null)
    inline fun track(className: String? = null, noinline block: Nodes? = null)
    inline fun u(className: String? = null, noinline block: Nodes? = null)
    inline fun ul(className: String? = null, noinline block: Nodes? = null)
    inline fun varElement(className: String? = null, noinline block: Nodes? = null)
    inline fun video(className: String? = null, noinline block: Nodes? = null)
    inline fun wbr(className: String? = null, noinline block: Nodes? = null)

    inline fun a(attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, noinline block: Nodes? = null)
    inline fun address(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun area(attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, noinline block: Nodes? = null)
    inline fun article(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun aside(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun audio(attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, noinline block: Nodes? = null)
    inline fun b(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun base(attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, noinline block: Nodes? = null)
    inline fun bdi(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun bdo(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun big(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun blockquote(attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun body(attr: Attr<HTMLAttributes<HTMLBodyElement>>, noinline block: Nodes? = null)
    inline fun br(attr: Attr<HTMLAttributes<HTMLBRElement>>, noinline block: Nodes? = null)
    inline fun button(attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, noinline block: Nodes? = null)
    inline fun canvas(attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, noinline block: Nodes? = null)
    inline fun caption(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun cite(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun code(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun col(attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes? = null)
    inline fun colgroup(attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes? = null)
    inline fun data(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun datalist(attr: Attr<HTMLAttributes<HTMLDataListElement>>, noinline block: Nodes? = null)
    inline fun dd(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun del(attr: Attr<DelHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun details(attr: Attr<DetailsHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun dfn(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun dialog(attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, noinline block: Nodes? = null)
    inline fun div(attr: Attr<HTMLAttributes<HTMLDivElement>>, noinline block: Nodes? = null)
    inline fun dl(attr: Attr<HTMLAttributes<HTMLDListElement>>, noinline block: Nodes? = null)
    inline fun dt(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun em(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun embed(attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, noinline block: Nodes? = null)
    inline fun fieldset(attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, noinline block: Nodes? = null)
    inline fun figcaption(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun figure(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun footer(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun form(attr: Attr<FormHTMLAttributes<HTMLFormElement>>, noinline block: Nodes? = null)
    inline fun h1(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h2(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h3(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h4(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h5(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h6(attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun head(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun header(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun hgroup(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun hr(attr: Attr<HTMLAttributes<HTMLHRElement>>, noinline block: Nodes? = null)
    inline fun html(attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, noinline block: Nodes? = null)
    inline fun i(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun iframe(attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, noinline block: Nodes? = null)
    inline fun img(attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, noinline block: Nodes? = null)
    inline fun input(attr: Attr<InputHTMLAttributes<HTMLInputElement>>, noinline block: Nodes? = null)
    inline fun ins(attr: Attr<InsHTMLAttributes<HTMLModElement>>, noinline block: Nodes? = null)
    inline fun kbd(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun keygen(attr: Attr<KeygenHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun label(attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, noinline block: Nodes? = null)
    inline fun legend(attr: Attr<HTMLAttributes<HTMLLegendElement>>, noinline block: Nodes? = null)
    inline fun li(attr: Attr<LiHTMLAttributes<HTMLLIElement>>, noinline block: Nodes? = null)
    inline fun link(attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, noinline block: Nodes? = null)
    inline fun main(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun map(attr: Attr<MapHTMLAttributes<HTMLMapElement>>, noinline block: Nodes? = null)
    inline fun mark(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun menu(attr: Attr<MenuHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun menuitem(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun meta(attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, noinline block: Nodes? = null)
    inline fun meter(attr: Attr<MeterHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun nav(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun noscript(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun objectElement(attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, noinline block: Nodes? = null)
    inline fun ol(attr: Attr<OlHTMLAttributes<HTMLOListElement>>, noinline block: Nodes? = null)
    inline fun optgroup(attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, noinline block: Nodes? = null)
    inline fun option(attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, noinline block: Nodes? = null)
    inline fun output(attr: Attr<OutputHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun p(attr: Attr<HTMLAttributes<HTMLParagraphElement>>, noinline block: Nodes? = null)
    inline fun param(attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, noinline block: Nodes? = null)
    inline fun picture(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun pre(attr: Attr<HTMLAttributes<HTMLPreElement>>, noinline block: Nodes? = null)
    inline fun progress(attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, noinline block: Nodes? = null)
    inline fun q(attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, noinline block: Nodes? = null)
    inline fun rp(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun rt(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun ruby(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun s(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun samp(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun script(attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, noinline block: Nodes? = null)
    inline fun section(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun select(attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, noinline block: Nodes? = null)
    inline fun small(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun source(attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, noinline block: Nodes? = null)
    inline fun span(attr: Attr<HTMLAttributes<HTMLSpanElement>>, noinline block: Nodes? = null)
    inline fun strong(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun styleElement(attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, noinline block: Nodes? = null)
    inline fun sub(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun summary(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun sup(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun table(attr: Attr<TableHTMLAttributes<HTMLTableElement>>, noinline block: Nodes? = null)
    inline fun tbody(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes? = null)
    inline fun td(attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes? = null)
    inline fun textarea(attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, noinline block: Nodes? = null)
    inline fun tfoot(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes? = null)
    inline fun th(attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes? = null)
    inline fun thead(attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes? = null)
    inline fun time(attr: Attr<TimeHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun title(attr: Attr<HTMLAttributes<HTMLTitleElement>>, noinline block: Nodes? = null)
    inline fun tr(attr: Attr<HTMLAttributes<HTMLTableRowElement>>, noinline block: Nodes? = null)
    inline fun track(attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, noinline block: Nodes? = null)
    inline fun u(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun ul(attr: Attr<HTMLAttributes<HTMLUListElement>>, noinline block: Nodes? = null)
    inline fun varElement(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun video(attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, noinline block: Nodes? = null)
    inline fun wbr(attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)

    inline fun a(className: String, attr: Attr<AnchorHTMLAttributes<HTMLAnchorElement>>, noinline block: Nodes? = null)
    inline fun address(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun area(className: String, attr: Attr<AreaHTMLAttributes<HTMLAreaElement>>, noinline block: Nodes? = null)
    inline fun article(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun aside(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun audio(className: String, attr: Attr<AudioHTMLAttributes<HTMLAudioElement>>, noinline block: Nodes? = null)
    inline fun b(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun base(className: String, attr: Attr<BaseHTMLAttributes<HTMLBaseElement>>, noinline block: Nodes? = null)
    inline fun bdi(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun bdo(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun big(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun blockquote(className: String, attr: Attr<BlockquoteHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun body(className: String, attr: Attr<HTMLAttributes<HTMLBodyElement>>, noinline block: Nodes? = null)
    inline fun br(className: String, attr: Attr<HTMLAttributes<HTMLBRElement>>, noinline block: Nodes? = null)
    inline fun button(className: String, attr: Attr<ButtonHTMLAttributes<HTMLButtonElement>>, noinline block: Nodes? = null)
    inline fun canvas(className: String, attr: Attr<CanvasHTMLAttributes<HTMLCanvasElement>>, noinline block: Nodes? = null)
    inline fun caption(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun cite(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun code(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun col(className: String, attr: Attr<ColHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes? = null)
    inline fun colgroup(className: String, attr: Attr<ColgroupHTMLAttributes<HTMLTableColElement>>, noinline block: Nodes? = null)
    inline fun data(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun datalist(className: String, attr: Attr<HTMLAttributes<HTMLDataListElement>>, noinline block: Nodes? = null)
    inline fun dd(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun del(className: String, attr: Attr<DelHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun details(className: String, attr: Attr<DetailsHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun dfn(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun dialog(className: String, attr: Attr<DialogHTMLAttributes<HTMLDialogElement>>, noinline block: Nodes? = null)
    inline fun div(className: String, attr: Attr<HTMLAttributes<HTMLDivElement>>, noinline block: Nodes? = null)
    inline fun dl(className: String, attr: Attr<HTMLAttributes<HTMLDListElement>>, noinline block: Nodes? = null)
    inline fun dt(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun em(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun embed(className: String, attr: Attr<EmbedHTMLAttributes<HTMLEmbedElement>>, noinline block: Nodes? = null)
    inline fun fieldset(className: String, attr: Attr<FieldsetHTMLAttributes<HTMLFieldSetElement>>, noinline block: Nodes? = null)
    inline fun figcaption(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun figure(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun footer(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun form(className: String, attr: Attr<FormHTMLAttributes<HTMLFormElement>>, noinline block: Nodes? = null)
    inline fun h1(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h2(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h3(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h4(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h5(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun h6(className: String, attr: Attr<HTMLAttributes<HTMLHeadingElement>>, noinline block: Nodes? = null)
    inline fun head(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun header(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun hgroup(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun hr(className: String, attr: Attr<HTMLAttributes<HTMLHRElement>>, noinline block: Nodes? = null)
    inline fun html(className: String, attr: Attr<HtmlHTMLAttributes<HTMLHtmlElement>>, noinline block: Nodes? = null)
    inline fun i(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun iframe(className: String, attr: Attr<IframeHTMLAttributes<HTMLIFrameElement>>, noinline block: Nodes? = null)
    inline fun img(className: String, attr: Attr<ImgHTMLAttributes<HTMLImageElement>>, noinline block: Nodes? = null)
    inline fun input(className: String, attr: Attr<InputHTMLAttributes<HTMLInputElement>>, noinline block: Nodes? = null)
    inline fun ins(className: String, attr: Attr<InsHTMLAttributes<HTMLModElement>>, noinline block: Nodes? = null)
    inline fun kbd(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun keygen(className: String, attr: Attr<KeygenHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun label(className: String, attr: Attr<LabelHTMLAttributes<HTMLLabelElement>>, noinline block: Nodes? = null)
    inline fun legend(className: String, attr: Attr<HTMLAttributes<HTMLLegendElement>>, noinline block: Nodes? = null)
    inline fun li(className: String, attr: Attr<LiHTMLAttributes<HTMLLIElement>>, noinline block: Nodes? = null)
    inline fun link(className: String, attr: Attr<LinkHTMLAttributes<HTMLLinkElement>>, noinline block: Nodes? = null)
    inline fun main(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun map(className: String, attr: Attr<MapHTMLAttributes<HTMLMapElement>>, noinline block: Nodes? = null)
    inline fun mark(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun menu(className: String, attr: Attr<MenuHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun menuitem(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun meta(className: String, attr: Attr<MetaHTMLAttributes<HTMLMetaElement>>, noinline block: Nodes? = null)
    inline fun meter(className: String, attr: Attr<MeterHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun nav(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun noscript(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun objectElement(className: String, attr: Attr<ObjectHTMLAttributes<HTMLObjectElement>>, noinline block: Nodes? = null)
    inline fun ol(className: String, attr: Attr<OlHTMLAttributes<HTMLOListElement>>, noinline block: Nodes? = null)
    inline fun optgroup(className: String, attr: Attr<OptgroupHTMLAttributes<HTMLOptGroupElement>>, noinline block: Nodes? = null)
    inline fun option(className: String, attr: Attr<OptionHTMLAttributes<HTMLOptionElement>>, noinline block: Nodes? = null)
    inline fun output(className: String, attr: Attr<OutputHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun p(className: String, attr: Attr<HTMLAttributes<HTMLParagraphElement>>, noinline block: Nodes? = null)
    inline fun param(className: String, attr: Attr<ParamHTMLAttributes<HTMLParamElement>>, noinline block: Nodes? = null)
    inline fun picture(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun pre(className: String, attr: Attr<HTMLAttributes<HTMLPreElement>>, noinline block: Nodes? = null)
    inline fun progress(className: String, attr: Attr<ProgressHTMLAttributes<HTMLProgressElement>>, noinline block: Nodes? = null)
    inline fun q(className: String, attr: Attr<QuoteHTMLAttributes<HTMLQuoteElement>>, noinline block: Nodes? = null)
    inline fun rp(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun rt(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun ruby(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun s(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun samp(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun script(className: String, attr: Attr<ScriptHTMLAttributes<HTMLScriptElement>>, noinline block: Nodes? = null)
    inline fun section(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun select(className: String, attr: Attr<SelectHTMLAttributes<HTMLSelectElement>>, noinline block: Nodes? = null)
    inline fun small(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun source(className: String, attr: Attr<SourceHTMLAttributes<HTMLSourceElement>>, noinline block: Nodes? = null)
    inline fun span(className: String, attr: Attr<HTMLAttributes<HTMLSpanElement>>, noinline block: Nodes? = null)
    inline fun strong(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun styleElement(className: String, attr: Attr<StyleHTMLAttributes<HTMLStyleElement>>, noinline block: Nodes? = null)
    inline fun sub(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun summary(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun sup(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun table(className: String, attr: Attr<TableHTMLAttributes<HTMLTableElement>>, noinline block: Nodes? = null)
    inline fun tbody(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes? = null)
    inline fun td(className: String, attr: Attr<TdHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes? = null)
    inline fun textarea(className: String, attr: Attr<TextareaHTMLAttributes<HTMLTextAreaElement>>, noinline block: Nodes? = null)
    inline fun tfoot(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes? = null)
    inline fun th(className: String, attr: Attr<ThHTMLAttributes<HTMLTableCellElement>>, noinline block: Nodes? = null)
    inline fun thead(className: String, attr: Attr<HTMLAttributes<HTMLTableSectionElement>>, noinline block: Nodes? = null)
    inline fun time(className: String, attr: Attr<TimeHTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun title(className: String, attr: Attr<HTMLAttributes<HTMLTitleElement>>, noinline block: Nodes? = null)
    inline fun tr(className: String, attr: Attr<HTMLAttributes<HTMLTableRowElement>>, noinline block: Nodes? = null)
    inline fun track(className: String, attr: Attr<TrackHTMLAttributes<HTMLTrackElement>>, noinline block: Nodes? = null)
    inline fun u(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun ul(className: String, attr: Attr<HTMLAttributes<HTMLUListElement>>, noinline block: Nodes? = null)
    inline fun varElement(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
    inline fun video(className: String, attr: Attr<VideoHTMLAttributes<HTMLVideoElement>>, noinline block: Nodes? = null)
    inline fun wbr(className: String, attr: Attr<HTMLAttributes<HTMLElement>>, noinline block: Nodes? = null)
}
