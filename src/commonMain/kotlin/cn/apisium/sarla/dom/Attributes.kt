@file:Suppress("UNUSED")

package cn.apisium.sarla.dom

import kotlin.js.JsName

typealias EventHandler<E> = (event: E) -> Unit

typealias SarlaEventHandler<T> = EventHandler<SyntheticEvent<T, *>>

typealias ClipboardEventHandler<T> = EventHandler<ClipboardEvent<T>>
typealias CompositionEventHandler<T> = EventHandler<CompositionEvent<T>>
typealias DragEventHandler<T> = EventHandler<DragEvent<T>>
typealias FocusEventHandler<T> = EventHandler<FocusEvent<T>>
typealias FormEventHandler<T> = EventHandler<FormEvent<T>>
typealias ChangeEventHandler<T> = EventHandler<ChangeEvent<T>>
typealias KeyboardEventHandler<T> = EventHandler<KeyboardEvent<T>>
typealias MouseEventHandler<T> = EventHandler<MouseEvent<T, *>>
typealias TouchEventHandler<T> = EventHandler<TouchEvent<T>>
typealias PointerEventHandler<T> = EventHandler<PointerEvent<T>>
typealias UIEventHandler<T> = EventHandler<UIEvent<T>>
typealias WheelEventHandler<T> = EventHandler<WheelEvent<T>>
typealias AnimationEventHandler<T> = EventHandler<AnimationEvent<T>>
typealias TransitionEventHandler<T> = EventHandler<TransitionEvent<T>>

external interface Props {
    var value: String?
    var label: String?
    var selected: Boolean?
    var text: String?
    var disabled: Boolean?
    var defaultSelected: Boolean?
}

external interface DOMEvents<T> {
    @JsName("oncopycapture")
    var onCopyCapture: ClipboardEventHandler<T>?
    @JsName("oncut")
    var onCut: ClipboardEventHandler<T>?
    @JsName("oncutcapture")
    var onCutCapture: ClipboardEventHandler<T>?
    @JsName("onpaste")
    var onPaste: ClipboardEventHandler<T>?
    @JsName("onpastecapture")
    var onPasteCapture: ClipboardEventHandler<T>?
    @JsName("oncompositionend")
    var onCompositionEnd: CompositionEventHandler<T>?
    @JsName("oncompositionendcapture")
    var onCompositionEndCapture: CompositionEventHandler<T>?
    @JsName("oncompositionstart")
    var onCompositionStart: CompositionEventHandler<T>?
    @JsName("oncompositionstartcapture")
    var onCompositionStartCapture: CompositionEventHandler<T>?
    @JsName("oncompositionupdate")
    var onCompositionUpdate: CompositionEventHandler<T>?
    @JsName("oncompositionupdatecapture")
    var onCompositionUpdateCapture: CompositionEventHandler<T>?
    @JsName("onfocus")
    var onFocus: FocusEventHandler<T>?
    @JsName("onfocuscapture")
    var onFocusCapture: FocusEventHandler<T>?
    @JsName("onblur")
    var onBlur: FocusEventHandler<T>?
    @JsName("onblurcapture")
    var onBlurCapture: FocusEventHandler<T>?
    @JsName("onchange")
    var onChange: FormEventHandler<T>?
    @JsName("onchangecapture")
    var onChangeCapture: FormEventHandler<T>?
    @JsName("onbeforeinput")
    var onBeforeInput: FormEventHandler<T>?
    @JsName("onbeforeinputcapture")
    var onBeforeInputCapture: FormEventHandler<T>?
    @JsName("oninput")
    var onInput: FormEventHandler<T>?
    @JsName("oninputcapture")
    var onInputCapture: FormEventHandler<T>?
    @JsName("onreset")
    var onReset: FormEventHandler<T>?
    @JsName("onresetcapture")
    var onResetCapture: FormEventHandler<T>?
    @JsName("onsubmit")
    var onSubmit: FormEventHandler<T>?
    @JsName("onsubmitcapture")
    var onSubmitCapture: FormEventHandler<T>?
    @JsName("oninvalid")
    var onInvalid: FormEventHandler<T>?
    @JsName("oninvalidcapture")
    var onInvalidCapture: FormEventHandler<T>?
    @JsName("onload")
    var onLoad: SarlaEventHandler<T>?
    @JsName("onloadcapture")
    var onLoadCapture: SarlaEventHandler<T>?
    @JsName("onerror")
    var onError: SarlaEventHandler<T>?
    @JsName("onerrorcapture")
    var onErrorCapture: SarlaEventHandler<T>?
    @JsName("onkeydown")
    var onKeyDown: KeyboardEventHandler<T>?
    @JsName("onkeydowncapture")
    var onKeyDownCapture: KeyboardEventHandler<T>?
    @JsName("onkeypress")
    var onKeyPress: KeyboardEventHandler<T>?
    @JsName("onkeypresscapture")
    var onKeyPressCapture: KeyboardEventHandler<T>?
    @JsName("onkeyup")
    var onKeyUp: KeyboardEventHandler<T>?
    @JsName("onkeyupcapture")
    var onKeyUpCapture: KeyboardEventHandler<T>?
    @JsName("onabort")
    var onAbort: SarlaEventHandler<T>?
    @JsName("onabortcapture")
    var onAbortCapture: SarlaEventHandler<T>?
    @JsName("oncanplay")
    var onCanPlay: SarlaEventHandler<T>?
    @JsName("oncanplaycapture")
    var onCanPlayCapture: SarlaEventHandler<T>?
    @JsName("oncanplaythrough")
    var onCanPlayThrough: SarlaEventHandler<T>?
    @JsName("oncanplaythroughcapture")
    var onCanPlayThroughCapture: SarlaEventHandler<T>?
    @JsName("ondurationchange")
    var onDurationChange: SarlaEventHandler<T>?
    @JsName("ondurationchangecapture")
    var onDurationChangeCapture: SarlaEventHandler<T>?
    @JsName("onemptied")
    var onEmptied: SarlaEventHandler<T>?
    @JsName("onemptiedcapture")
    var onEmptiedCapture: SarlaEventHandler<T>?
    @JsName("onencrypted")
    var onEncrypted: SarlaEventHandler<T>?
    @JsName("onencryptedcapture")
    var onEncryptedCapture: SarlaEventHandler<T>?
    @JsName("onended")
    var onEnded: SarlaEventHandler<T>?
    @JsName("onendedcapture")
    var onEndedCapture: SarlaEventHandler<T>?
    @JsName("onloadeddata")
    var onLoadedData: SarlaEventHandler<T>?
    @JsName("onloadeddatacapture")
    var onLoadedDataCapture: SarlaEventHandler<T>?
    @JsName("onloadedmetadata")
    var onLoadedMetadata: SarlaEventHandler<T>?
    @JsName("onloadedmetadatacapture")
    var onLoadedMetadataCapture: SarlaEventHandler<T>?
    @JsName("onloadstart")
    var onLoadStart: SarlaEventHandler<T>?
    @JsName("onloadstartcapture")
    var onLoadStartCapture: SarlaEventHandler<T>?
    @JsName("onpause")
    var onPause: SarlaEventHandler<T>?
    @JsName("onpausecapture")
    var onPauseCapture: SarlaEventHandler<T>?
    @JsName("onplay")
    var onPlay: SarlaEventHandler<T>?
    @JsName("onplaycapture")
    var onPlayCapture: SarlaEventHandler<T>?
    @JsName("onplaying")
    var onPlaying: SarlaEventHandler<T>?
    @JsName("onplayingcapture")
    var onPlayingCapture: SarlaEventHandler<T>?
    @JsName("onprogress")
    var onProgress: SarlaEventHandler<T>?
    @JsName("onprogresscapture")
    var onProgressCapture: SarlaEventHandler<T>?
    @JsName("onratechange")
    var onRateChange: SarlaEventHandler<T>?
    @JsName("onratechangecapture")
    var onRateChangeCapture: SarlaEventHandler<T>?
    @JsName("onseeked")
    var onSeeked: SarlaEventHandler<T>?
    @JsName("onseekedcapture")
    var onSeekedCapture: SarlaEventHandler<T>?
    @JsName("onseeking")
    var onSeeking: SarlaEventHandler<T>?
    @JsName("onseekingcapture")
    var onSeekingCapture: SarlaEventHandler<T>?
    @JsName("onstalled")
    var onStalled: SarlaEventHandler<T>?
    @JsName("onstalledcapture")
    var onStalledCapture: SarlaEventHandler<T>?
    @JsName("onsuspend")
    var onSuspend: SarlaEventHandler<T>?
    @JsName("onsuspendcapture")
    var onSuspendCapture: SarlaEventHandler<T>?
    @JsName("ontimeupdate")
    var onTimeUpdate: SarlaEventHandler<T>?
    @JsName("ontimeupdatecapture")
    var onTimeUpdateCapture: SarlaEventHandler<T>?
    @JsName("onvolumechange")
    var onVolumeChange: SarlaEventHandler<T>?
    @JsName("onvolumechangecapture")
    var onVolumeChangeCapture: SarlaEventHandler<T>?
    @JsName("onwaiting")
    var onWaiting: SarlaEventHandler<T>?
    @JsName("onwaitingcapture")
    var onWaitingCapture: SarlaEventHandler<T>?
    @JsName("onclick")
    var onClick: MouseEventHandler<T>?
    @JsName("onclickcapture")
    var onClickCapture: MouseEventHandler<T>?
    @JsName("oncontextmenu")
    var onContextMenu: MouseEventHandler<T>?
    @JsName("oncontextmenucapture")
    var onContextMenuCapture: MouseEventHandler<T>?
    @JsName("ondoubleclick")
    var onDoubleClick: MouseEventHandler<T>?
    @JsName("ondoubleclickcapture")
    var onDoubleClickCapture: MouseEventHandler<T>?
    @JsName("ondrag")
    var onDrag: DragEventHandler<T>?
    @JsName("ondragcapture")
    var onDragCapture: DragEventHandler<T>?
    @JsName("ondragend")
    var onDragEnd: DragEventHandler<T>?
    @JsName("ondragendcapture")
    var onDragEndCapture: DragEventHandler<T>?
    @JsName("ondragenter")
    var onDragEnter: DragEventHandler<T>?
    @JsName("ondragentercapture")
    var onDragEnterCapture: DragEventHandler<T>?
    @JsName("ondragexit")
    var onDragExit: DragEventHandler<T>?
    @JsName("ondragexitcapture")
    var onDragExitCapture: DragEventHandler<T>?
    @JsName("ondragleave")
    var onDragLeave: DragEventHandler<T>?
    @JsName("ondragleavecapture")
    var onDragLeaveCapture: DragEventHandler<T>?
    @JsName("ondragover")
    var onDragOver: DragEventHandler<T>?
    @JsName("ondragovercapture")
    var onDragOverCapture: DragEventHandler<T>?
    @JsName("ondragstart")
    var onDragStart: DragEventHandler<T>?
    @JsName("ondragstartcapture")
    var onDragStartCapture: DragEventHandler<T>?
    @JsName("ondrop")
    var onDrop: DragEventHandler<T>?
    @JsName("ondropcapture")
    var onDropCapture: DragEventHandler<T>?
    @JsName("onmousedown")
    var onMouseDown: MouseEventHandler<T>?
    @JsName("onmousedowncapture")
    var onMouseDownCapture: MouseEventHandler<T>?
    @JsName("onmouseenter")
    var onMouseEnter: MouseEventHandler<T>?
    @JsName("onmouseleave")
    var onMouseLeave: MouseEventHandler<T>?
    @JsName("onmousemove")
    var onMouseMove: MouseEventHandler<T>?
    @JsName("onmousemovecapture")
    var onMouseMoveCapture: MouseEventHandler<T>?
    @JsName("onmouseout")
    var onMouseOut: MouseEventHandler<T>?
    @JsName("onmouseoutcapture")
    var onMouseOutCapture: MouseEventHandler<T>?
    @JsName("onmouseover")
    var onMouseOver: MouseEventHandler<T>?
    @JsName("onmouseovercapture")
    var onMouseOverCapture: MouseEventHandler<T>?
    @JsName("onmouseup")
    var onMouseUp: MouseEventHandler<T>?
    @JsName("onmouseupcapture")
    var onMouseUpCapture: MouseEventHandler<T>?
    @JsName("onselect")
    var onSelect: SarlaEventHandler<T>?
    @JsName("onselectcapture")
    var onSelectCapture: SarlaEventHandler<T>?
    @JsName("ontouchcancel")
    var onTouchCancel: TouchEventHandler<T>?
    @JsName("ontouchcancelcapture")
    var onTouchCancelCapture: TouchEventHandler<T>?
    @JsName("ontouchend")
    var onTouchEnd: TouchEventHandler<T>?
    @JsName("ontouchendcapture")
    var onTouchEndCapture: TouchEventHandler<T>?
    @JsName("ontouchmove")
    var onTouchMove: TouchEventHandler<T>?
    @JsName("ontouchmovecapture")
    var onTouchMoveCapture: TouchEventHandler<T>?
    @JsName("ontouchstart")
    var onTouchStart: TouchEventHandler<T>?
    @JsName("ontouchstartcapture")
    var onTouchStartCapture: TouchEventHandler<T>?
    @JsName("onpointerdown")
    var onPointerDown: PointerEventHandler<T>?
    @JsName("onpointerdowncapture")
    var onPointerDownCapture: PointerEventHandler<T>?
    @JsName("onpointermove")
    var onPointerMove: PointerEventHandler<T>?
    @JsName("onpointermovecapture")
    var onPointerMoveCapture: PointerEventHandler<T>?
    @JsName("onpointerup")
    var onPointerUp: PointerEventHandler<T>?
    @JsName("onpointerupcapture")
    var onPointerUpCapture: PointerEventHandler<T>?
    @JsName("onpointercancel")
    var onPointerCancel: PointerEventHandler<T>?
    @JsName("onpointercancelcapture")
    var onPointerCancelCapture: PointerEventHandler<T>?
    @JsName("onpointerenter")
    var onPointerEnter: PointerEventHandler<T>?
    @JsName("onpointerentercapture")
    var onPointerEnterCapture: PointerEventHandler<T>?
    @JsName("onpointerleave")
    var onPointerLeave: PointerEventHandler<T>?
    @JsName("onpointerleavecapture")
    var onPointerLeaveCapture: PointerEventHandler<T>?
    @JsName("onpointerover")
    var onPointerOver: PointerEventHandler<T>?
    @JsName("onpointerovercapture")
    var onPointerOverCapture: PointerEventHandler<T>?
    @JsName("onpointerout")
    var onPointerOut: PointerEventHandler<T>?
    @JsName("onpointeroutcapture")
    var onPointerOutCapture: PointerEventHandler<T>?
    @JsName("ongotpointercapture")
    var onGotPointerCapture: PointerEventHandler<T>?
    @JsName("ongotpointercapturecapture")
    var onGotPointerCaptureCapture: PointerEventHandler<T>?
    @JsName("onlostpointercapture")
    var onLostPointerCapture: PointerEventHandler<T>?
    @JsName("onlostpointercapturecapture")
    var onLostPointerCaptureCapture: PointerEventHandler<T>?
    @JsName("onscroll")
    var onScroll: UIEventHandler<T>?
    @JsName("onscrollcapture")
    var onScrollCapture: UIEventHandler<T>?
    @JsName("onwheel")
    var onWheel: WheelEventHandler<T>?
    @JsName("onwheelcapture")
    var onWheelCapture: WheelEventHandler<T>?
    @JsName("onanimationstart")
    var onAnimationStart: AnimationEventHandler<T>?
    @JsName("onanimationstartcapture")
    var onAnimationStartCapture: AnimationEventHandler<T>?
    @JsName("onanimationend")
    var onAnimationEnd: AnimationEventHandler<T>?
    @JsName("onanimationendcapture")
    var onAnimationEndCapture: AnimationEventHandler<T>?
    @JsName("onanimationiteration")
    var onAnimationIteration: AnimationEventHandler<T>?
    @JsName("onanimationiterationcapture")
    var onAnimationIterationCapture: AnimationEventHandler<T>?
    @JsName("ontransitionend")
    var onTransitionEnd: TransitionEventHandler<T>?
    @JsName("ontransitionendcapture")
    var onTransitionEndCapture: TransitionEventHandler<T>?
}
external interface HTMLAttributes<T> {
    var accessKey: String?
    var className: String?
    var contentEditable: Boolean?
    var contextMenu: String?
    var dir: String?
    var draggable: Boolean?
    var hidden: Boolean?
    var id: String?
    var lang: String?
    var placeholder: String?
    var slot: String?
    var spellCheck: Boolean?
    var styleText: String?
    var tabIndex: Number?
    var title: String?
    var inputMode: String?
    var `is`: String?
    var radioGroup: String?
    var role: String?
    var about: String?
    var datatype: String?
    var inlist: Any?
    var prefix: String?
    var property: String?
    var resource: String?
    var `typeof`: String?
    var vocab: String?
    var autoCapitalize: String?
    var autoCorrect: String?
    var autoSave: String?
    var color: String?
    var itemProp: String?
    var itemScope: Boolean?
    var itemType: String?
    var itemID: String?
    var itemRef: String?
    var results: Number?
    var security: String?
    var unselectable: String?
}
external interface AllHTMLAttributes<T> : HTMLAttributes<T> {
    var accept: String?
    var acceptCharset: String?
    var action: String?
    var allowFullScreen: Boolean?
    var allowTransparency: Boolean?
    var alt: String?
    var `as`: String?
    var async: Boolean?
    var autoComplete: String?
    var autoFocus: Boolean?
    var autoPlay: Boolean?
    var capture: Boolean?
    var cellPadding: Any?
    var cellSpacing: Any?
    var charSet: String?
    var challenge: String?
    var checked: Boolean?
    var cite: String?
    var classID: String?
    var cols: Number?
    var colSpan: Number?
    var content: String?
    var controls: Boolean?
    var coords: String?
    var crossOrigin: String?
    var data: String?
    var dateTime: String?
    var default: Boolean?
    var defer: Boolean?
    var disabled: Boolean?
    var download: Any?
    var encType: String?
    var form: String?
    var formAction: String?
    var formEncType: String?
    var formMethod: String?
    var formNoValidate: Boolean?
    var formTarget: String?
    var frameBorder: Any?
    var headers: String?
    var height: Any?
    var high: Number?
    var href: String?
    var hrefLang: String?
    var htmlFor: String?
    var httpEquiv: String?
    var integrity: String?
    var keyParams: String?
    var keyType: String?
    var kind: String?
    var label: String?
    var list: String?
    var loop: Boolean?
    var low: Number?
    var manifest: String?
    var marginHeight: Number?
    var marginWidth: Number?
    var max: Any?
    var maxLength: Number?
    var media: String?
    var mediaGroup: String?
    var method: String?
    var min: Any?
    var minLength: Number?
    var multiple: Boolean?
    var muted: Boolean?
    var name: String?
    var nonce: String?
    var noValidate: Boolean?
    var open: Boolean?
    var optimum: Number?
    var pattern: String?
    override var placeholder: String?
    var playsInline: Boolean?
    var poster: String?
    var preload: String?
    var readOnly: Boolean?
    var rel: String?
    var required: Boolean?
    var reversed: Boolean?
    var rows: Number?
    var rowSpan: Number?
    var sandbox: String?
    var scope: String?
    var scoped: Boolean?
    var scrolling: String?
    var seamless: Boolean?
    var selected: Boolean?
    var shape: String?
    var size: Number?
    var sizes: String?
    var span: Number?
    var src: String?
    var srcDoc: String?
    var srcLang: String?
    var srcSet: String?
    var start: Number?
    var step: Any?
    var summary: String?
    var target: String?
    var type: String?
    var useMap: String?
    var value: Any?
    var width: Any?
    var wmode: String?
    var wrap: String?
}
external interface AnchorHTMLAttributes<T> : HTMLAttributes<T> {
    var download: Any?
    var href: String?
    var hrefLang: String?
    var media: String?
    var rel: String?
    var target: String?
    var type: String?
}
external interface AudioHTMLAttributes<T> : MediaHTMLAttributes<T>
external interface AreaHTMLAttributes<T> : HTMLAttributes<T> {
    var alt: String?
    var coords: String?
    var download: Any?
    var href: String?
    var hrefLang: String?
    var media: String?
    var rel: String?
    var shape: String?
    var target: String?
}
external interface BaseHTMLAttributes<T> : HTMLAttributes<T> {
    var href: String?
    var target: String?
}
external interface BlockquoteHTMLAttributes<T> : HTMLAttributes<T> {
    var cite: String?
}
external interface ButtonHTMLAttributes<T> : HTMLAttributes<T> {
    var autoFocus: Boolean?
    var disabled: Boolean?
    var form: String?
    var formAction: String?
    var formEncType: String?
    var formMethod: String?
    var formNoValidate: Boolean?
    var formTarget: String?
    var name: String?
    var type: String?
    var value: Any?
}
external interface CanvasHTMLAttributes<T> : HTMLAttributes<T> {
    var height: Any?
    var width: Any?
}
external interface ColHTMLAttributes<T> : HTMLAttributes<T> {
    var span: Number?
    var width: Any?
}
external interface ColgroupHTMLAttributes<T> : HTMLAttributes<T> {
    var span: Number?
}
external interface DetailsHTMLAttributes<T> : HTMLAttributes<T> {
    var open: Boolean?
}
external interface DelHTMLAttributes<T> : HTMLAttributes<T> {
    var cite: String?
    var dateTime: String?
}
external interface DialogHTMLAttributes<T> : HTMLAttributes<T> {
    var open: Boolean?
}
external interface EmbedHTMLAttributes<T> : HTMLAttributes<T> {
    var height: Any?
    var src: String?
    var type: String?
    var width: Any?
}
external interface FieldsetHTMLAttributes<T> : HTMLAttributes<T> {
    var disabled: Boolean?
    var form: String?
    var name: String?
}
external interface FormHTMLAttributes<T> : HTMLAttributes<T> {
    var acceptCharset: String?
    var action: String?
    var autoComplete: String?
    var encType: String?
    var method: String?
    var name: String?
    var noValidate: Boolean?
    var target: String?
}
external interface HtmlHTMLAttributes<T> : HTMLAttributes<T> {
    var manifest: String?
}
external interface IframeHTMLAttributes<T> : HTMLAttributes<T> {
    var allow: String?
    var allowFullScreen: Boolean?
    var allowTransparency: Boolean?
    var frameBorder: Any?
    var height: Any?
    var marginHeight: Number?
    var marginWidth: Number?
    var name: String?
    var sandbox: String?
    var scrolling: String?
    var seamless: Boolean?
    var src: String?
    var srcDoc: String?
    var width: Any?
}
external interface ImgHTMLAttributes<T> : HTMLAttributes<T> {
    var alt: String?
    var crossOrigin: String?
    var decoding: String?
    var height: Any?
    var sizes: String?
    var src: String?
    var srcSet: String?
    var useMap: String?
    var width: Any?
}
external interface InsHTMLAttributes<T> : HTMLAttributes<T> {
    var cite: String?
    var dateTime: String?
}
external interface InputHTMLAttributes<T> : HTMLAttributes<T> {
    var accept: String?
    var alt: String?
    var autoComplete: String?
    var autoFocus: Boolean?
    var capture: Boolean?
    var checked: Boolean?
    var crossOrigin: String?
    var disabled: Boolean?
    var form: String?
    var formAction: String?
    var formEncType: String?
    var formMethod: String?
    var formNoValidate: Boolean?
    var formTarget: String?
    var height: Any?
    var list: String?
    var max: Any?
    var maxLength: Number?
    var min: Any?
    var minLength: Number?
    var multiple: Boolean?
    var name: String?
    var pattern: String?
    override var placeholder: String?
    var readOnly: Boolean?
    var required: Boolean?
    var size: Number?
    var src: String?
    var step: Any?
    var type: String?
    var value: Any?
    var width: Any?
}
external interface KeygenHTMLAttributes<T> : HTMLAttributes<T> {
    var autoFocus: Boolean?
    var challenge: String?
    var disabled: Boolean?
    var form: String?
    var keyType: String?
    var keyParams: String?
    var name: String?
}
external interface LabelHTMLAttributes<T> : HTMLAttributes<T> {
    var form: String?
    var htmlFor: String?
}
external interface LiHTMLAttributes<T> : HTMLAttributes<T> {
    var value: Any?
}
external interface LinkHTMLAttributes<T> : HTMLAttributes<T> {
    var `as`: String?
    var crossOrigin: String?
    var href: String?
    var hrefLang: String?
    var integrity: String?
    var media: String?
    var rel: String?
    var sizes: String?
    var type: String?
}
external interface MapHTMLAttributes<T> : HTMLAttributes<T> {
    var name: String?
}
external interface MenuHTMLAttributes<T> : HTMLAttributes<T> {
    var type: String?
}
external interface MediaHTMLAttributes<T> : HTMLAttributes<T> {
    var autoPlay: Boolean?
    var controls: Boolean?
    var controlsList: String?
    var crossOrigin: String?
    var loop: Boolean?
    var mediaGroup: String?
    var muted: Boolean?
    var playsinline: Boolean?
    var preload: String?
    var src: String?
}
external interface MetaHTMLAttributes<T> : HTMLAttributes<T> {
    var charSet: String?
    var content: String?
    var httpEquiv: String?
    var name: String?
}
external interface MeterHTMLAttributes<T> : HTMLAttributes<T> {
    var form: String?
    var high: Number?
    var low: Number?
    var max: Any?
    var min: Any?
    var optimum: Number?
    var value: Any?
}
external interface QuoteHTMLAttributes<T> : HTMLAttributes<T> {
    var cite: String?
}
external interface ObjectHTMLAttributes<T> : HTMLAttributes<T> {
    var classID: String?
    var data: String?
    var form: String?
    var height: Any?
    var name: String?
    var type: String?
    var useMap: String?
    var width: Any?
    var wmode: String?
}
external interface OlHTMLAttributes<T> : HTMLAttributes<T> {
    var reversed: Boolean?
    var start: Number?
    var type: String?
}
external interface OptgroupHTMLAttributes<T> : HTMLAttributes<T> {
    var disabled: Boolean?
    var label: String?
}
external interface OptionHTMLAttributes<T> : HTMLAttributes<T> {
    var disabled: Boolean?
    var label: String?
    var selected: Boolean?
    var value: Any?
}
external interface OutputHTMLAttributes<T> : HTMLAttributes<T> {
    var form: String?
    var htmlFor: String?
    var name: String?
}
external interface ParamHTMLAttributes<T> : HTMLAttributes<T> {
    var name: String?
    var value: Any?
}
external interface ProgressHTMLAttributes<T> : HTMLAttributes<T> {
    var max: Any?
    var value: Any?
}
external interface ScriptHTMLAttributes<T> : HTMLAttributes<T> {
    var async: Boolean?
    var charSet: String?
    var crossOrigin: String?
    var defer: Boolean?
    var integrity: String?
    var noModule: Boolean?
    var nonce: String?
    var src: String?
    var type: String?
}
external interface SelectHTMLAttributes<T> : HTMLAttributes<T> {
    var autoComplete: String?
    var autoFocus: Boolean?
    var disabled: Boolean?
    var form: String?
    var multiple: Boolean?
    var name: String?
    var required: Boolean?
    var size: Number?
    var value: Any?
}
external interface SourceHTMLAttributes<T> : HTMLAttributes<T> {
    var media: String?
    var sizes: String?
    var src: String?
    var srcSet: String?
    var type: String?
}
external interface StyleHTMLAttributes<T> : HTMLAttributes<T> {
    var media: String?
    var nonce: String?
    var scoped: Boolean?
    var type: String?
}
external interface TableHTMLAttributes<T> : HTMLAttributes<T> {
    var cellPadding: Any?
    var cellSpacing: Any?
    var summary: String?
}
external interface TextareaHTMLAttributes<T> : HTMLAttributes<T> {
    var autoComplete: String?
    var autoFocus: Boolean?
    var cols: Number?
    var dirName: String?
    var disabled: Boolean?
    var form: String?
    var maxLength: Number?
    var minLength: Number?
    var name: String?
    override var placeholder: String?
    var readOnly: Boolean?
    var required: Boolean?
    var rows: Number?
    var value: Any?
    var wrap: String?
}
external interface TdHTMLAttributes<T> : HTMLAttributes<T> {
    var align: String?
    var colSpan: Number?
    var headers: String?
    var rowSpan: Number?
    var scope: String?
}
external interface ThHTMLAttributes<T> : HTMLAttributes<T> {
    var align: String?
    var colSpan: Number?
    var headers: String?
    var rowSpan: Number?
    var scope: String?
}
external interface TimeHTMLAttributes<T> : HTMLAttributes<T> {
    var dateTime: String?
}
external interface TrackHTMLAttributes<T> : HTMLAttributes<T> {
    var default: Boolean?
    var kind: String?
    var label: String?
    var src: String?
    var srcLang: String?
}
external interface VideoHTMLAttributes<T> : MediaHTMLAttributes<T> {
    var height: Any?
    var playsInline: Boolean?
    var poster: String?
    var width: Any?
}
external interface SVGAttributes<T> {
    var className: String?
    var color: String?
    var height: Any?
    var id: String?
    var lang: String?
    var max: Any?
    var media: String?
    var method: String?
    var min: Any?
    var name: String?
    var style: CSSProperties?
    var target: String?
    var type: String?
    var width: Any?
    var role: String?
    var tabIndex: Number?
    var accentHeight: Any?
    var accumulate: String?
    var additive: String?
    var alignmentBaseline: String?
    var allowReorder: String?
    var alphabetic: Any?
    var amplitude: Any?
    var arabicForm: String?
    var ascent: Any?
    var attributeName: String?
    var attributeType: String?
    var autoReverse: Any?
    var azimuth: Any?
    var baseFrequency: Any?
    var baselineShift: Any?
    var baseProfile: Any?
    var bbox: Any?
    var begin: Any?
    var bias: Any?
    var by: Any?
    var calcMode: Any?
    var capHeight: Any?
    var clip: Any?
    var clipPath: String?
    var clipPathUnits: Any?
    var clipRule: Any?
    var colorInterpolation: Any?
    var colorInterpolationFilters: String?
    var colorProfile: Any?
    var colorRendering: Any?
    var contentScriptType: Any?
    var contentStyleType: Any?
    var cursor: Any?
    var cx: Any?
    var cy: Any?
    var d: String?
    var decelerate: Any?
    var descent: Any?
    var diffuseConstant: Any?
    var direction: Any?
    var display: Any?
    var divisor: Any?
    var dominantBaseline: Any?
    var dur: Any?
    var dx: Any?
    var dy: Any?
    var edgeMode: Any?
    var elevation: Any?
    var enableBackground: Any?
    var end: Any?
    var exponent: Any?
    var externalResourcesRequired: Any?
    var fill: String?
    var fillOpacity: Any?
    var fillRule: String?
    var filter: String?
    var filterRes: Any?
    var filterUnits: Any?
    var floodColor: Any?
    var floodOpacity: Any?
    var focusable: Any?
    var fontFamily: String?
    var fontSize: Any?
    var fontSizeAdjust: Any?
    var fontStretch: Any?
    var fontStyle: Any?
    var fontVariant: Any?
    var fontWeight: Any?
    var format: Any?
    var from: Any?
    var fx: Any?
    var fy: Any?
    var g1: Any?
    var g2: Any?
    var glyphName: Any?
    var glyphOrientationHorizontal: Any?
    var glyphOrientationVertical: Any?
    var glyphRef: Any?
    var gradientTransform: String?
    var gradientUnits: String?
    var hanging: Any?
    var horizAdvX: Any?
    var horizOriginX: Any?
    var href: String?
    var ideographic: Any?
    var imageRendering: Any?
    var in2: Any?
    var `in`: String?
    var intercept: Any?
    var k1: Any?
    var k2: Any?
    var k3: Any?
    var k4: Any?
    var k: Any?
    var kernelMatrix: Any?
    var kernelUnitLength: Any?
    var kerning: Any?
    var keyPoints: Any?
    var keySplines: Any?
    var keyTimes: Any?
    var lengthAdjust: Any?
    var letterSpacing: Any?
    var lightingColor: Any?
    var limitingConeAngle: Any?
    var local: Any?
    var markerEnd: String?
    var markerHeight: Any?
    var markerMid: String?
    var markerStart: String?
    var markerUnits: Any?
    var markerWidth: Any?
    var mask: String?
    var maskContentUnits: Any?
    var maskUnits: Any?
    var mathematical: Any?
    var mode: Any?
    var numOctaves: Any?
    var offset: Any?
    var opacity: Any?
    var operator: Any?
    var order: Any?
    var orient: Any?
    var orientation: Any?
    var origin: Any?
    var overflow: Any?
    var overlinePosition: Any?
    var overlineThickness: Any?
    var paintOrder: Any?
    var panose1: Any?
    var pathLength: Any?
    var patternContentUnits: String?
    var patternTransform: Any?
    var patternUnits: String?
    var pointerEvents: Any?
    var points: String?
    var pointsAtX: Any?
    var pointsAtY: Any?
    var pointsAtZ: Any?
    var preserveAlpha: Any?
    var preserveAspectRatio: String?
    var primitiveUnits: Any?
    var r: Any?
    var radius: Any?
    var refX: Any?
    var refY: Any?
    var renderingIntent: Any?
    var repeatCount: Any?
    var repeatDur: Any?
    var requiredExtensions: Any?
    var requiredFeatures: Any?
    var restart: Any?
    var result: String?
    var rotate: Any?
    var rx: Any?
    var ry: Any?
    var scale: Any?
    var seed: Any?
    var shapeRendering: Any?
    var slope: Any?
    var spacing: Any?
    var specularConstant: Any?
    var specularExponent: Any?
    var speed: Any?
    var spreadMethod: String?
    var startOffset: Any?
    var stdDeviation: Any?
    var stemh: Any?
    var stemv: Any?
    var stitchTiles: Any?
    var stopColor: String?
    var stopOpacity: Any?
    var strikethroughPosition: Any?
    var strikethroughThickness: Any?
    var string: Any?
    var stroke: String?
    var strokeDasharray: Any?
    var strokeDashoffset: Any?
    var strokeLinecap: String?
    var strokeLinejoin: String?
    var strokeMiterlimit: Any?
    var strokeOpacity: Any?
    var strokeWidth: Any?
    var surfaceScale: Any?
    var systemLanguage: Any?
    var tableValues: Any?
    var targetX: Any?
    var targetY: Any?
    var textAnchor: String?
    var textDecoration: Any?
    var textLength: Any?
    var textRendering: Any?
    var to: Any?
    var transform: String?
    var u1: Any?
    var u2: Any?
    var underlinePosition: Any?
    var underlineThickness: Any?
    var unicode: Any?
    var unicodeBidi: Any?
    var unicodeRange: Any?
    var unitsPerEm: Any?
    var vAlphabetic: Any?
    var values: String?
    var vectorEffect: Any?
    var version: String?
    var vertAdvY: Any?
    var vertOriginX: Any?
    var vertOriginY: Any?
    var vHanging: Any?
    var vIdeographic: Any?
    var viewBox: String?
    var viewTarget: Any?
    var visibility: Any?
    var vMathematical: Any?
    var widths: Any?
    var wordSpacing: Any?
    var writingMode: Any?
    var x1: Any?
    var x2: Any?
    var x: Any?
    var xChannelSelector: String?
    var xHeight: Any?
    var xlinkActuate: String?
    var xlinkArcrole: String?
    var xlinkHref: String?
    var xlinkRole: String?
    var xlinkShow: String?
    var xlinkTitle: String?
    var xlinkType: String?
    var xmlBase: String?
    var xmlLang: String?
    var xmlns: String?
    var xmlnsXlink: String?
    var xmlSpace: String?
    var y1: Any?
    var y2: Any?
    var y: Any?
    var yChannelSelector: String?
    var z: Any?
    var zoomAndPan: String?
}
external interface WebViewHTMLAttributes<T> : HTMLAttributes<T> {
    var allowFullScreen: Boolean?
    var allowpopups: Boolean?
    var autoFocus: Boolean?
    var autosize: Boolean?
    var blinkfeatures: String?
    var disableblinkfeatures: String?
    var disableguestresize: Boolean?
    var disablewebsecurity: Boolean?
    var guestinstance: String?
    var httpreferrer: String?
    var nodeintegration: Boolean?
    var partition: String?
    var plugins: Boolean?
    var preload: String?
    var src: String?
    var useragent: String?
    var webpreferences: String?
}
