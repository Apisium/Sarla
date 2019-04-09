@file:Suppress("TYPEALIAS_EXPANSION_DEPRECATION", "DEPRECATION", "UNUSED")

package cn.apisium.sarla.dom

import cn.apisium.sarla.utils.NativeObject

external interface ItemArrayLike<out T> {
    val length: Int
    fun item(index: Int): T?
}

@Deprecated("JS only.")
external interface EventListener {
    @Deprecated("JS only.")
    fun handleEvent(event: Event)
}

@Deprecated("JS only.")
external interface EventTarget {
    fun addEventListener(type: String, callback: EventListener?, options: Any?)
    fun addEventListener(type: String, callback: ((Event) -> Unit)?, options: Any?)
    fun removeEventListener(type: String, callback: EventListener?, options: Any?)
    fun removeEventListener(type: String, callback: ((Event) -> Unit)?, options: Any?)
    fun dispatchEvent(event: Event): Boolean
}

@Deprecated("JS only.")
external interface NonElementParentNode {
    fun getElementById(elementId: String): Element?
}

@Deprecated("JS only.")
external interface DocumentOrShadowRoot {
    val fullscreenElement: Element?
}

@Deprecated("JS only.")
external interface Location {
    var href: String
    val origin: String
    var protocol: String
    var host: String
    var hostname: String
    var port: String
    var pathname: String
    var search: String
    var hash: String
    val ancestorOrigins: Array<out String>
    fun assign(url: String)
    fun replace(url: String)
    fun reload()
}

@Deprecated("JS only.")
external interface HTMLHeadElement : HTMLElement

@Deprecated("JS only.")
external interface Document : Node, NonElementParentNode, DocumentOrShadowRoot, ParentNode, GeometryUtils {
    val fullscreenEnabled: Boolean
    val fullscreen: Boolean
    var onfullscreenchange: ((Event) -> Any?)?
    var onfullscreenerror: ((Event) -> Any?)?
    // val rootElement: SVGSVGElement?
    var title: String
    val referrer: String
    var domain: String
    val activeElement: Element?
    val location: Location?
    var cookie: String
    val lastModified: String
    val readyState: Any
    var dir: String
    var body: HTMLElement?
    val head: HTMLHeadElement?
    val images: HTMLCollection
    val embeds: HTMLCollection
    val plugins: HTMLCollection
    val links: HTMLCollection
    val forms: HTMLCollection
    val scripts: HTMLCollection
//    val currentScript: HTMLOrSVGScriptElement?
    val defaultView: Window?
    var designMode: String
    var onreadystatechange: ((Event) -> Any?)?
    var fgColor: String
    var linkColor: String
    var vlinkColor: String
    var alinkColor: String
    var bgColor: String
    val anchors: HTMLCollection
    val applets: HTMLCollection
    val all: HTMLAllCollection
    val implementation: Any
    val URL: String
    val documentURI: String
    val origin: String
    val compatMode: String
    val characterSet: String
    val charset: String
    val inputEncoding: String
    val contentType: String
    val doctype: DocumentType?
    val documentElement: Element?
    val scrollingElement: Element?
    val styleSheets: StyleSheetList
    override val fullscreenElement: Element?
    override val children: HTMLCollection
    override val firstElementChild: Element?
    override val lastElementChild: Element?
    override val childElementCount: Int
    fun exitFullscreen(): Any
    fun getElementsByName(elementName: String): NodeList
    fun open(type: String, replace: String): Document
    fun open(url: String, name: String, features: String): Window
    fun close()
    fun write(vararg text: String)
    fun writeln(vararg text: String)
    fun hasFocus(): Boolean
    fun execCommand(commandId: String, showUI: Boolean, value: String): Boolean
    fun queryCommandEnabled(commandId: String): Boolean
    fun queryCommandIndeterm(commandId: String): Boolean
    fun queryCommandState(commandId: String): Boolean
    fun queryCommandSupported(commandId: String): Boolean
    fun queryCommandValue(commandId: String): String
    fun clear()
    fun captureEvents()
    fun releaseEvents()
    fun getElementsByTagName(qualifiedName: String): HTMLCollection
    fun getElementsByTagNameNS(namespace: String?, localName: String): HTMLCollection
    fun getElementsByClassName(classNames: String): HTMLCollection
    fun createElement(localName: String, options: ElementCreationOptions): Element
    fun createElementNS(namespace: String?, qualifiedName: String, options: ElementCreationOptions): Element
    fun createDocumentFragment(): DocumentFragment
    fun createTextNode(data: String): Text
    fun createCDATASection(data: String): Any
    fun createComment(data: String): Comment
    fun createProcessingInstruction(target: String, data: String): Any
    fun importNode(node: Node, deep: Boolean): Node
    fun adoptNode(node: Node): Node
    fun createAttribute(localName: String): Attr
    fun createAttributeNS(namespace: String?, qualifiedName: String): Attr
    fun createEvent(interface_: String): Event
    fun createRange(): Any
    fun createNodeIterator(root: Node, whatToShow: Int, filter: NodeFilter?): NodeIterator
    fun createNodeIterator(root: Node, whatToShow: Int, filter: ((Node) -> Short)?): NodeIterator
    fun createTreeWalker(root: Node, whatToShow: Int, filter: NodeFilter?): TreeWalker
    fun createTreeWalker(root: Node, whatToShow: Int, filter: ((Node) -> Short)?): TreeWalker
    fun elementFromPoint(x: Double, y: Double): Element?
    fun elementsFromPoint(x: Double, y: Double): Array<Element>
    fun caretPositionFromPoint(x: Double, y: Double): Any?
    override fun getElementById(elementId: String): Element?
    fun prepend(vararg nodes: Any?)
    fun append(vararg nodes: Any?)
    override fun querySelector(selectors: String): Element?
    override fun querySelectorAll(selectors: String): NodeList
    fun getBoxQuads(options: Any): Array<Any>
    fun convertQuadFromNode(quad: Any?, from: Any?, options: Any): Any
    fun convertRectFromNode(rect: Any, from: Any?, options: Any): Any
    fun convertPointFromNode(point: Any, from: Any?, options: Any): Any
}

@Deprecated("JS only.")
external interface MediaList : ItemArrayLike<String> {
    var mediaText: String
    override val length: Int
    override fun item(index: Int): String?
    fun appendMedium(medium: String)
    fun deleteMedium(medium: String)
}

@Deprecated("JS only.")
external interface StyleSheet {
    val type: String
    val href: String?
    val ownerNode: Any?
    val parentStyleSheet: StyleSheet?
    val title: String?
    val media: MediaList
    var disabled: Boolean
}

@Deprecated("JS only.")
external interface Comment: CharacterData {
    override val previousElementSibling: Element?
    override val nextElementSibling: Element?
    override fun before(vararg nodes: Node)
    override fun after(vararg nodes: Node)
    override fun replaceWith(vararg nodes: Node)
    override fun remove()
}

@Deprecated("JS only.")
external interface StyleSheetList : ItemArrayLike<StyleSheet> {
    override val length: Int
    override fun item(index: Int): StyleSheet?
}

@Deprecated("JS only.")
external interface ElementCreationOptions {
    var `is`: String?
}

@Deprecated("JS only.")
external interface HTMLAllCollection {
    val length: Int
    fun item(nameOrIndex: String): Any?
}

@Deprecated("JS only.")
external interface Text : CharacterData, Slotable, GeometryUtils {
    val wholeText: String
    override val previousElementSibling: Element?
    override val nextElementSibling: Element?
    override val assignedSlot: HTMLSlotElement?
    fun splitText(offset: Int): Text
    override fun before(vararg nodes: Node)
    override fun after(vararg nodes: Node)
    override fun replaceWith(vararg nodes: Node)
    override fun remove()
    fun getBoxQuads(options: Any): Array<Any>
    fun convertQuadFromNode(quad: Any?, from: Any?, options: Any): Any
    fun convertRectFromNode(rect: Any, from: Any?, options: Any): Any
    fun convertPointFromNode(point: Any, from: Any?, options: Any): Any
}

@Deprecated("JS only.")
external interface CharacterData : Node, NonDocumentTypeChildNode, ChildNode {
    var data: String
    val length: Int
    fun substringData(offset: Int, count: Int): String
    fun appendData(data: String)
    fun insertData(offset: Int, data: String)
    fun deleteData(offset: Int, count: Int)
    fun replaceData(offset: Int, count: Int, data: String)
}

external interface DocumentFragment : Node, NonElementParentNode, ParentNode {
    override val children: HTMLCollection
    override val firstElementChild: Element?
    override val lastElementChild: Element?
    override val childElementCount: Int
    override fun getElementById(elementId: String): Element?
    override fun prepend(vararg nodes: Node)
    override fun append(vararg nodes: Node)
    override fun querySelector(selectors: String): Element?
    override fun querySelectorAll(selectors: String): NodeList
}

@Deprecated("JS only.")
external interface TreeWalker {
    val root: Node
    val whatToShow: Int
    val filter: NodeFilter?
    var currentNode: Node
    fun parentNode(): Node?
    fun firstChild(): Node?
    fun lastChild(): Node?
    fun previousSibling(): Node?
    fun nextSibling(): Node?
    fun previousNode(): Node?
    fun nextNode(): Node?
}

@Deprecated("JS only.")
external interface NodeFilter {
    fun acceptNode(node: Node): Short
}

@Deprecated("JS only.")
external interface NodeIterator {
    val root: Node
    val referenceNode: Node
    val pointerBeforeReferenceNode: Boolean
    val whatToShow: Int
    val filter: NodeFilter?
    fun nextNode(): Node?
    fun previousNode(): Node?
    fun detach()
}

@Deprecated("JS only.")
external interface DocumentType : Node, ChildNode {
    val name: String
    val publicId: String
    val systemId: String
}

@Deprecated("JS only.")
external interface Attr : Node {
    val namespaceURI: String?
    val prefix: String?
    val localName: String
    val name: String
    var value: String
    val ownerElement: Element?
    val specified: Boolean
}

@Deprecated("JS only.")
external interface Node : EventTarget {
    val nodeType: Short
    val nodeName: String
    val baseURI: String
    val isConnected: Boolean
    val ownerDocument: Document?
    val parentNode: Node?
    val parentElement: Element?
    val childNodes: Any
    val firstChild: Node?
    val lastChild: Node?
    val previousSibling: Node?
    val nextSibling: Node?
    var nodeValue: String?
    var textContent: String?
    fun getRootNode(options: Any?): Node
    fun hasChildNodes(): Boolean
    fun normalize()
    fun cloneNode(deep: Boolean): Node
    fun isEqualNode(otherNode: Node?): Boolean
    fun isSameNode(otherNode: Node?): Boolean
    fun compareDocumentPosition(other: Node): Short
    fun contains(other: Node?): Boolean
    fun lookupPrefix(namespace: String?): String?
    fun lookupNamespaceURI(prefix: String?): String?
    fun isDefaultNamespace(namespace: String?): Boolean
    fun insertBefore(node: Node, child: Node?): Node
    fun appendChild(node: Node): Node
    fun replaceChild(node: Node, child: Node): Node
    fun removeChild(child: Node): Node
}

@Deprecated("JS only.")
external interface ParentNode {
    val children: Any
    val firstElementChild: Element?
    val lastElementChild: Element?
    val childElementCount: Int
    fun prepend(vararg nodes: Node)
    fun append(vararg nodes: Node)
    fun querySelector(selectors: String): Element?
    fun querySelectorAll(selectors: String): Any
}

@Deprecated("JS only.")
external interface NonDocumentTypeChildNode {
    val previousElementSibling: Element?
    val nextElementSibling: Element?
}

@Deprecated("JS only.")
external interface ChildNode {
    fun before(vararg nodes: Node)
    fun after(vararg nodes: Node)
    fun replaceWith(vararg nodes: Node)
    fun remove()
}

@Deprecated("JS only.")
external interface Slotable {
    val assignedSlot: Any?
}

@Deprecated("JS only.")
external interface GeometryUtils {
    fun getBoxQuads(options: Any?): Array<Any>
    fun convertQuadFromNode(quad: Any?, from: Any?, options: Any?): Any
    fun convertRectFromNode(rect: Any, from: Any?, options: Any?): Any
    fun convertPointFromNode(point: Any, from: Any?, options: Any?): Any
}

@Deprecated("JS only.")
external interface Element : Node, ParentNode, NonDocumentTypeChildNode, ChildNode, Slotable, GeometryUtils {
    var innerHTML: String
    var outerHTML: String
    val namespaceURI: String?
    val prefix: String?
    val localName: String
    val tagName: String
    var id: String
    var className: String
    val classList: Any
    var slot: String
    val attributes: Any
    val shadowRoot: Any?
    var scrollTop: Double
    var scrollLeft: Double
    val scrollWidth: Int
    val scrollHeight: Int
    val clientTop: Int
    val clientLeft: Int
    val clientWidth: Int
    val clientHeight: Int
    val style: CSSProperties
    fun requestFullscreen(): Any
    fun setPointerCapture(pointerId: Int)
    fun releasePointerCapture(pointerId: Int)
    fun hasPointerCapture(pointerId: Int): Boolean
    fun insertAdjacentHTML(position: String, text: String)
    fun hasAttributes(): Boolean
    fun getAttributeNames(): Array<String>
    fun getAttribute(qualifiedName: String): String?
    fun getAttributeNS(namespace: String?, localName: String): String?
    fun setAttribute(qualifiedName: String, value: String)
    fun setAttributeNS(namespace: String?, qualifiedName: String, value: String)
    fun removeAttribute(qualifiedName: String)
    fun removeAttributeNS(namespace: String?, localName: String)
    fun hasAttribute(qualifiedName: String): Boolean
    fun hasAttributeNS(namespace: String?, localName: String): Boolean
    fun getAttributeNode(qualifiedName: String): Attr?
    fun getAttributeNodeNS(namespace: String?, localName: String): Attr?
    fun setAttributeNode(attr: Attr): Attr?
    fun setAttributeNodeNS(attr: Attr): Attr?
    fun removeAttributeNode(attr: Attr): Attr
    fun attachShadow(init: Any): Any
    fun closest(selectors: String): Element?
    fun matches(selectors: String): Boolean
    fun webkitMatchesSelector(selectors: String): Boolean
    fun getElementsByTagName(qualifiedName: String): Any
    fun getElementsByTagNameNS(namespace: String?, localName: String): Any
    fun getElementsByClassName(classNames: String): Any
    fun insertAdjacentElement(where: String, element: Element): Element?
    fun insertAdjacentText(where: String, data: String)
    fun getClientRects(): Array<Any>
    fun getBoundingClientRect(): Any
    fun scrollIntoView()
    fun scrollIntoView(arg: Any)
    fun scroll(options: Any?)
    fun scroll(x: Double, y: Double)
    fun scrollTo(options: Any?)
    fun scrollTo(x: Double, y: Double)
    fun scrollBy(options: Any?)
    fun scrollBy(x: Double, y: Double)
}

@Deprecated("JS only.")
external interface LinkStyle {
    val sheet: StyleSheet?
}

@Deprecated("JS only.")
external interface ElementContentEditable {
    var contentEditable: String
    val isContentEditable: Boolean
}

@Deprecated("JS only.")
typealias DOMTokenList = Any?

@Deprecated("JS only.")
external interface HTMLElement : Element, ElementCSSInlineStyle, ElementContentEditable {
    var title: String
    var lang: String
    var translate: Boolean
    var dir: String
    val dataset: NativeObject<String, String>
    var hidden: Boolean
    var tabIndex: Int
    var accessKey: String
    val accessKeyLabel: String
    var draggable: Boolean
    val dropzone: DOMTokenList
    var contextMenu: HTMLMenuElement?
    var spellcheck: Boolean
    var innerText: String
    val offsetParent: Element?
    val offsetTop: Int
    val offsetLeft: Int
    val offsetWidth: Int
    val offsetHeight: Int
    fun click()
    fun focus()
    fun blur()
    fun forceSpellCheck()
}

@Deprecated("JS only.")
external interface HTMLHyperlinkElementUtils {
    var href: String
    val origin: String
    var protocol: String
    var username: String
    var password: String
    var host: String
    var hostname: String
    var port: String
    var pathname: String
    var search: String
    var hash: String
}

@Deprecated("JS only.")
external interface HTMLAnchorElement : HTMLElement, HTMLHyperlinkElementUtils {
    var target: String
    var download: String
    var ping: String
    var rel: String
    val relList: DOMTokenList
    var hreflang: String
    var type: String
    var text: String
    var referrerPolicy: String
    var coords: String
    var charset: String
    var name: String
    var rev: String
    var shape: String
}

@Deprecated("JS only.")
external interface HTMLMediaElement : HTMLElement {
    val error: Any?
    var src: String
    var srcObject: Any?
    val currentSrc: String
    var crossOrigin: String?
    val networkState: Short
    var preload: String
    val buffered: Any
    val readyState: Short
    val seeking: Boolean
    var currentTime: Double
    val duration: Double
    val paused: Boolean
    var defaultPlaybackRate: Double
    var playbackRate: Double
    val played: Any
    val seekable: Any
    val ended: Boolean
    var autoplay: Boolean
    var loop: Boolean
    var controls: Boolean
    var volume: Double
    var muted: Boolean
    var defaultMuted: Boolean
    val audioTracks: Any
    val videoTracks: Any
    val textTracks: Any
    fun load()
    fun canPlayType(type: String): Any
    fun fastSeek(time: Double)
    fun getStartDate(): Any?
    fun play(): Any
    fun pause()
    fun addTextTrack(kind: Any, label: String?, language: String?): Any
}

@Deprecated("JS only.")
external interface HTMLAudioElement : HTMLMediaElement

@Deprecated("JS only.")
external interface HTMLBaseElement : HTMLElement {
    var href: String
    var target: String
}

@Deprecated("JS only.")
external interface HTMLLinkElement : HTMLElement, LinkStyle {
    var scope: String
    var workerType: Any
    var href: String
    var crossOrigin: String?
    var rel: String
    val relList: DOMTokenList
    var media: String
    var nonce: String
    var hreflang: String
    var type: String
    val sizes: DOMTokenList
    var referrerPolicy: String
    var charset: String
    var rev: String
    var target: String
}

@Deprecated("JS only.")
external interface HTMLMetaElement : HTMLElement {
    var name: String
    var httpEquiv: String
    var content: String
    var scheme: String
}

@Deprecated("JS only.")
external interface HTMLStyleElement : HTMLElement, LinkStyle {
    var media: String
    var nonce: String
    var type: String
}

@Deprecated("JS only.")
external interface HTMLBodyElement : HTMLElement {
    var text: String
    var link: String
    var vLink: String
    var aLink: String
    var bgColor: String
    var background: String
}

@Deprecated("JS only.")
external interface HTMLHeadingElement : HTMLElement {
    var align: String
}

@Deprecated("JS only.")
external interface HTMLParagraphElement : HTMLElement {
    var align: String
}

@Deprecated("JS only.")
external interface HTMLHRElement : HTMLElement {
    var align: String
    var color: String
    var noShade: Boolean
    var size: String
    var width: String
}

@Deprecated("JS only.")
external interface HTMLPreElement : HTMLElement {
    var width: Int
}

@Deprecated("JS only.")
external interface HTMLQuoteElement : HTMLElement {
    var cite: String
}

@Deprecated("JS only.")
external interface HTMLOListElement : HTMLElement {
    var reversed: Boolean
    var start: Int
    var type: String
    var compact: Boolean
}

@Deprecated("JS only.")
external interface HTMLUListElement : HTMLElement {
    var compact: Boolean
    var type: String
}

@Deprecated("JS only.")
external interface HTMLLIElement : HTMLElement {
    var value: Int
    var type: String
}

@Deprecated("JS only.")
external interface HTMLDListElement : HTMLElement {
    var compact: Boolean
}

@Deprecated("JS only.")
external interface HTMLDivElement : HTMLElement {
    var align: String
}

@Deprecated("JS only.")
external interface HTMLDataElement : HTMLElement {
    var value: String
}

@Deprecated("JS only.")
external interface HTMLTimeElement : HTMLElement {
    var dateTime: String
}

@Deprecated("JS only.")
external interface HTMLSpanElement : HTMLElement {
}

@Deprecated("JS only.")
external interface HTMLBRElement : HTMLElement {
    var clear: String
}
@Deprecated("JS only.")
external interface HTMLModElement : HTMLElement {
    var cite: String
    var dateTime: String
}

@Deprecated("JS only.")
external interface HTMLPictureElement : HTMLElement {
}

@Deprecated("JS only.")
external interface HTMLSourceElement : HTMLElement {
    var src: String
    var type: String
    var srcset: String
    var sizes: String
    var media: String
}

@Deprecated("JS only.")
external interface HTMLImageElement : HTMLElement, TexImageSource {
    var alt: String
    var src: String
    var srcset: String
    var sizes: String
    var crossOrigin: String?
    var useMap: String
    var isMap: Boolean
    var width: Int
    var height: Int
    val naturalWidth: Int
    val naturalHeight: Int
    val complete: Boolean
    val currentSrc: String
    var referrerPolicy: String
    var name: String
    var lowsrc: String
    var align: String
    var hspace: Int
    var vspace: Int
    var longDesc: String
    var border: String
    val x: Int
    val y: Int
}

external interface Image {
    // TODO
}

@Deprecated("JS only.")
external interface HTMLIFrameElement : HTMLElement {
    var src: String
    var srcdoc: String
    var name: String
    val sandbox: DOMTokenList
    var allowFullscreen: Boolean
    var allowUserMedia: Boolean
    var width: String
    var height: String
    var referrerPolicy: String
    val contentDocument: Document?
    val contentWindow: Window?
    var align: String
    var scrolling: String
    var frameBorder: String
    var longDesc: String
    var marginHeight: String
    var marginWidth: String
    fun getSVGDocument(): Document?
}

@Deprecated("JS only.")
external interface HTMLEmbedElement : HTMLElement {
    var src: String
    var type: String
    var width: String
    var height: String
    var align: String
    var name: String
    fun getSVGDocument(): Document?
}

@Deprecated("JS only.")
external interface Window : EventTarget {
    // TODO
}

@Deprecated("JS only.")
external interface HTMLObjectElement : HTMLElement {
    var data: String
    var type: String
    var typeMustMatch: Boolean
    var name: String
    var useMap: String
    val form: HTMLFormElement?
    var width: String
    var height: String
    val contentDocument: Document?
    val contentWindow: Window?
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    var align: String
    var archive: String
    var code: String
    var declare: Boolean
    var hspace: Int
    var standby: String
    var vspace: Int
    var codeBase: String
    var codeType: String
    var border: String
    fun getSVGDocument(): Document?
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
}

@Deprecated("JS only.")
external interface HTMLParamElement : HTMLElement {
    var name: String
    var value: String
    var type: String
    var valueType: String
}

@Deprecated("JS only.")
external interface HTMLTitleElement : HTMLElement {
    var text: String
}

@Deprecated("JS only.")
external interface HTMLVideoElement : HTMLMediaElement, TexImageSource {
    var width: Int
    var height: Int
    val videoWidth: Int
    val videoHeight: Int
    var poster: String
    var playsInline: Boolean
}

external interface Audio {
    // TODO
}

@Deprecated("JS only.")
external interface HTMLTrackElement : HTMLElement {
    var kind: String
    var src: String
    var srclang: String
    var label: String
    var default: Boolean
    val readyState: Short
    val track: Any
}

@Deprecated("JS only.")
external interface HTMLMapElement : HTMLElement {
    var name: String
    val areas: HTMLCollection
}

@Deprecated("JS only.")
external interface HTMLAreaElement : HTMLElement, HTMLHyperlinkElementUtils {
    var alt: String
    var coords: String
    var shape: String
    var target: String
    var download: String
    var ping: String
    var rel: String
    val relList: DOMTokenList
    var referrerPolicy: String
    var noHref: Boolean
}

@Deprecated("JS only.")
external interface HTMLTableElement : HTMLElement {
    var caption: HTMLTableCaptionElement?
    var tHead: HTMLTableSectionElement?
    var tFoot: HTMLTableSectionElement?
    val tBodies: HTMLCollection
    val rows: HTMLCollection
    var align: String
    var border: String
    var frame: String
    var rules: String
    var summary: String
    var width: String
    var bgColor: String
    var cellPadding: String
    var cellSpacing: String
    fun createCaption(): HTMLTableCaptionElement
    fun deleteCaption()
    fun createTHead(): HTMLTableSectionElement
    fun deleteTHead()
    fun createTFoot(): HTMLTableSectionElement
    fun deleteTFoot()
    fun createTBody(): HTMLTableSectionElement
    fun insertRow(index: Int): HTMLTableRowElement
    fun deleteRow(index: Int)
}

@Deprecated("JS only.")
external interface HTMLTableCaptionElement : HTMLElement {
    var align: String
}

@Deprecated("JS only.")
external interface HTMLTableColElement : HTMLElement {
    var span: Int
    var align: String
    var ch: String
    var chOff: String
    var vAlign: String
    var width: String
}

@Deprecated("JS only.")
external interface HTMLTableSectionElement : HTMLElement {
    val rows: HTMLCollection
    var align: String
    var ch: String
    var chOff: String
    var vAlign: String
    fun insertRow(index: Int): HTMLElement
    fun deleteRow(index: Int)
}

@Deprecated("JS only.")
external interface HTMLTableRowElement : HTMLElement {
    val rowIndex: Int
    val sectionRowIndex: Int
    val cells: HTMLCollection
    var align: String
    var ch: String
    var chOff: String
    var vAlign: String
    var bgColor: String
    fun insertCell(index: Int): HTMLElement
    fun deleteCell(index: Int)
}

@Deprecated("JS only.")
external interface HTMLTableCellElement : HTMLElement {
    var colSpan: Int
    var rowSpan: Int
    var headers: String
    val cellIndex: Int
    var scope: String
    var abbr: String
    var align: String
    var axis: String
    var height: String
    var width: String
    var ch: String
    var chOff: String
    var noWrap: Boolean
    var vAlign: String
    var bgColor: String
}

@Deprecated("JS only.")
external interface HTMLFormElement : HTMLElement, ItemArrayLike<Element> {
    var acceptCharset: String
    var action: String
    var autocomplete: String
    var enctype: String
    var encoding: String
    var method: String
    var name: String
    var noValidate: Boolean
    var target: String
    val elements: HTMLFormControlsCollection
    override val length: Int
    fun submit()
    fun reset()
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
}

@Deprecated("JS only.")
external interface HTMLFormControlsCollection : HTMLCollection

@Deprecated("JS only.")
external interface HTMLLabelElement : HTMLElement {
    val form: HTMLFormElement?
    var htmlFor: String
    val control: HTMLElement?
}

@Deprecated("JS only.")
external interface FileList : ItemArrayLike<File> {
    override val length: Int
    override fun item(index: Int): File?
}
@Deprecated("JS only.")
external interface File : Blob {
    val name: String
    val lastModified: Int
}

@Deprecated("JS only.")
external interface Blob {
    val size: Int
    val type: String
    val isClosed: Boolean
    fun slice(start: Int?, end: Int?, contentType: String?): Blob
    fun close()
}

@Deprecated("JS only.")
external interface HTMLInputElement : HTMLElement {
    var accept: String
    var alt: String
    var autocomplete: String
    var autofocus: Boolean
    var defaultChecked: Boolean
    var checked: Boolean
    var dirName: String
    var disabled: Boolean
    val form: HTMLFormElement?
    val files: FileList?
    var formAction: String
    var formEnctype: String
    var formMethod: String
    var formNoValidate: Boolean
    var formTarget: String
    var height: Int
    var indeterminate: Boolean
    var inputMode: String
    val list: HTMLElement?
    var max: String
    var maxLength: Int
    var min: String
    var minLength: Int
    var multiple: Boolean
    var name: String
    var pattern: String
    var placeholder: String
    var readOnly: Boolean
    var required: Boolean
    var size: Int
    var src: String
    var step: String
    var type: String
    var defaultValue: String
    var value: String
    var valueAsDate: Any?
    var valueAsNumber: Double
    var width: Int
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    val labels: NodeList
    var selectionStart: Int?
    var selectionEnd: Int?
    var selectionDirection: String?
    var align: String
    var useMap: String
    fun stepUp(n: Int)
    fun stepDown(n: Int)
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
    fun select()
    fun setRangeText(replacement: String)
    fun setRangeText(replacement: String, start: Int, end: Int, selectionMode: Any)
    fun setSelectionRange(start: Int, end: Int, direction: String)
}

@Deprecated("JS only.")
external interface NodeList : ItemArrayLike<Node> {
    override val length: Int
    override fun item(index: Int): Node?
}

@Deprecated("JS only.")
external interface HTMLButtonElement : HTMLElement {
    var autofocus: Boolean
    var disabled: Boolean
    val form: HTMLFormElement?
    var formAction: String
    var formEnctype: String
    var formMethod: String
    var formNoValidate: Boolean
    var formTarget: String
    var name: String
    var type: String
    var value: String
    var menu: HTMLMenuElement?
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    val labels: NodeList
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
}

@Deprecated("JS only.")
external interface HTMLSelectElement : HTMLElement {
    var autocomplete: String
    var autofocus: Boolean
    var disabled: Boolean
    val form: HTMLFormElement?
    var multiple: Boolean
    var name: String
    var required: Boolean
    var size: Int
    val type: String
    val options: HTMLOptionsCollection
    var length: Int
    val selectedOptions: HTMLCollection
    var selectedIndex: Int
    var value: String
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    val labels: NodeList
    fun item(index: Int): Element?
    fun namedItem(name: String): HTMLOptionElement?
    fun add(element: Any, before: Any?)
    fun remove(index: Int)
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
}

external interface HTMLOptionsCollection : HTMLCollection {
    override var length: Int
    var selectedIndex: Int
    fun add(element: Any, before: Any?)
    fun remove(index: Int)
}

@Deprecated("JS only.")
external interface HTMLCollection : ItemArrayLike<Element> {
    override val length: Int
    override fun item(index: Int): Element?
    fun namedItem(name: String): Element?
}

@Deprecated("JS only.")
external interface HTMLDataListElement : HTMLElement {
    val options: HTMLCollection
}

@Deprecated("JS only.")
external interface HTMLOptGroupElement : HTMLElement {
    var disabled: Boolean
    var label: String
}

@Deprecated("JS only.")
external interface HTMLOptionElement : HTMLElement {
    var disabled: Boolean
    val form: HTMLFormElement?
    var label: String
    var defaultSelected: Boolean
    var selected: Boolean
    var value: String
    var text: String
    val index: Int
}

@Deprecated("JS only.")
external interface HTMLTextAreaElement : HTMLElement {
    var autocomplete: String
    var autofocus: Boolean
    var cols: Int
    var dirName: String
    var disabled: Boolean
    val form: HTMLFormElement?
    var inputMode: String
    var maxLength: Int
    var minLength: Int
    var name: String
    var placeholder: String
    var readOnly: Boolean
    var required: Boolean
    var rows: Int
    var wrap: String
    val type: String
    var defaultValue: String
    var value: String
    val textLength: Int
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    val labels: NodeList
    var selectionStart: Int?
    var selectionEnd: Int?
    var selectionDirection: String?
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
    fun select()
    fun setRangeText(replacement: String)
    fun setRangeText(replacement: String, start: Int, end: Int, selectionMode: Any)
    fun setSelectionRange(start: Int, end: Int, direction: String)
}

@Deprecated("JS only.")
external interface HTMLKeygenElement : HTMLElement {
    var autofocus: Boolean
    var challenge: String
    var disabled: Boolean
    val form: HTMLFormElement?
    var keytype: String
    var name: String
    val type: String
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    val labels: NodeList
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
}

@Deprecated("JS only.")
external interface HTMLOutputElement : HTMLElement {
    val htmlFor: DOMTokenList
    val form: HTMLFormElement?
    var name: String
    val type: String
    var defaultValue: String
    var value: String
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    val labels: NodeList
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
}

@Deprecated("JS only.")
external interface HTMLProgressElement : HTMLElement {
    var value: Double
    var max: Double
    val position: Double
    val labels: NodeList
}

@Deprecated("JS only.")
external interface HTMLMeterElement : HTMLElement {
    var value: Double
    var min: Double
    var max: Double
    var low: Double
    var high: Double
    var optimum: Double
    val labels: NodeList
}

@Deprecated("JS only.")
external interface HTMLFieldSetElement : HTMLElement {
    var disabled: Boolean
    val form: HTMLFormElement?
    var name: String
    val type: String
    val elements: HTMLCollection
    val willValidate: Boolean
    val validity: ValidityState
    val validationMessage: String
    fun checkValidity(): Boolean
    fun reportValidity(): Boolean
    fun setCustomValidity(error: String)
}

@Deprecated("JS only.")
external interface HTMLLegendElement : HTMLElement {
    val form: HTMLFormElement?
    var align: String
}

@Deprecated("JS only.")
external interface ValidityState {
    val valueMissing: Boolean
    val typeMismatch: Boolean
    val patternMismatch: Boolean
    val tooLong: Boolean
    val tooShort: Boolean
    val rangeUnderflow: Boolean
    val rangeOverflow: Boolean
    val stepMismatch: Boolean
    val badInput: Boolean
    val customError: Boolean
    val valid: Boolean
}

@Deprecated("JS only.")
external interface HTMLDetailsElement : HTMLElement {
    var open: Boolean
}

@Deprecated("JS only.")
external interface HTMLMenuElement : HTMLElement {
    var type: String
    var label: String
    var compact: Boolean
}

@Deprecated("JS only.")
external interface HTMLMenuItemElement : HTMLElement {
    var type: String
    var label: String
    var icon: String
    var disabled: Boolean
    var checked: Boolean
    var radiogroup: String
    var default: Boolean
}

@Deprecated("JS only.")
external interface RelatedEventInit : EventInit {
    var relatedTarget: EventTarget?
}

@Deprecated("JS only.")
external interface EventInit {
    var bubbles: Boolean?
    var cancelable: Boolean?
    var composed: Boolean?
}

@Deprecated("JS only.")
external interface HTMLDialogElement : HTMLElement {
    var open: Boolean
    var returnValue: String
    fun show(anchor: Any)
    fun showModal(anchor: Any)
    fun close(returnValue: String)
}

@Deprecated("JS only.")
external interface HTMLScriptElement : HTMLElement {
    var src: String
    var type: String
    var charset: String
    var async: Boolean
    var defer: Boolean
    var crossOrigin: String?
    var text: String
    var nonce: String
    var event: String
    var htmlFor: String
}

@Deprecated("JS only.")
external interface HTMLTemplateElement : HTMLElement {
    val content: DocumentFragment
}

@Deprecated("JS only.")
external interface HTMLSlotElement : HTMLElement {
    var name: String
    fun assignedNodes(options: AssignedNodesOptions): Array<Node>
}

@Deprecated("JS only.")
external interface AssignedNodesOptions {
    var flatten: Boolean?
}

@Deprecated("JS only.")
external interface HTMLCanvasElement : HTMLElement, TexImageSource {
    var width: Int
    var height: Int
    fun getContext(contextId: String, vararg arguments: Any?): RenderingContext?
    fun toDataURL(type: String, quality: Any?): String
    fun toBlob(callback: (Any?) -> Unit, type: String, quality: Any?)
}

@Deprecated("JS only.")
external interface RenderingContext {
    // TODO
}

@Deprecated("JS only.")
external interface CanvasRenderingContext2DSettings {
    var alpha: Boolean?
}

@Deprecated("JS only.")
external interface CanvasRenderingContext2D : CanvasState, CanvasTransform, CanvasCompositing, CanvasImageSmoothing, CanvasFillStrokeStyles, CanvasShadowStyles, CanvasFilters, CanvasRect, CanvasDrawPath, CanvasUserInterface, CanvasText, CanvasDrawImage, CanvasHitRegion, CanvasImageData, CanvasPathDrawingStyles, CanvasTextDrawingStyles, CanvasPath, RenderingContext {
    val canvas: HTMLCanvasElement
}

@Deprecated("JS only.")
external interface CanvasState {
    fun save()
    fun restore()
}

@Deprecated("JS only.")
external interface CanvasTransform {
    fun scale(x: Double, y: Double)
    fun rotate(angle: Double)
    fun translate(x: Double, y: Double)
    fun transform(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double)
    fun getTransform(): DOMMatrix
    fun setTransform(a: Double, b: Double, c: Double, d: Double, e: Double, f: Double)
    fun setTransform(transform: Any?)
    fun resetTransform()
}

@Deprecated("JS only.")
external interface DOMMatrixReadOnly {
    val a: Double
    val b: Double
    val c: Double
    val d: Double
    val e: Double
    val f: Double
    val m11: Double
    val m12: Double
    val m13: Double
    val m14: Double
    val m21: Double
    val m22: Double
    val m23: Double
    val m24: Double
    val m31: Double
    val m32: Double
    val m33: Double
    val m34: Double
    val m41: Double
    val m42: Double
    val m43: Double
    val m44: Double
    val is2D: Boolean
    val isIdentity: Boolean
    fun translate(tx: Double, ty: Double, tz: Double?): DOMMatrix
    fun scale(scale: Double, originX: Double?, originY: Double?): DOMMatrix
    fun scale3d(scale: Double, originX: Double?, originY: Double?, originZ: Double?): DOMMatrix
    fun scaleNonUniform(scaleX: Double, scaleY: Double?, scaleZ: Double?, originX: Double?, originY: Double?, originZ: Double?): DOMMatrix
    fun rotate(angle: Double, originX: Double?, originY: Double?): DOMMatrix
    fun rotateFromVector(x: Double, y: Double): DOMMatrix
    fun rotateAxisAngle(x: Double, y: Double, z: Double, angle: Double): DOMMatrix
    fun skewX(sx: Double): DOMMatrix
    fun skewY(sy: Double): DOMMatrix
    fun multiply(other: DOMMatrix): DOMMatrix
    fun flipX(): DOMMatrix
    fun flipY(): DOMMatrix
    fun inverse(): DOMMatrix
    fun transformPoint(point: Any?): Any
    fun toFloat32Array(): Any
    fun toFloat64Array(): Any
}

@Deprecated("JS only.")
external interface DOMMatrix : DOMMatrixReadOnly {
    override var a: Double
    override var b: Double
    override var c: Double
    override var d: Double
    override var e: Double
    override var f: Double
    override var m11: Double
    override var m12: Double
    override var m13: Double
    override var m14: Double
    override var m21: Double
    override var m22: Double
    override var m23: Double
    override var m24: Double
    override var m31: Double
    override var m32: Double
    override var m33: Double
    override var m34: Double
    override var m41: Double
    override var m42: Double
    override var m43: Double
    override var m44: Double
    fun multiplySelf(other: DOMMatrix): DOMMatrix
    fun preMultiplySelf(other: DOMMatrix): DOMMatrix
    fun translateSelf(tx: Double, ty: Double, tz: Double?): DOMMatrix
    fun scaleSelf(scale: Double, originX: Double?, originY: Double?): DOMMatrix
    fun scale3dSelf(scale: Double, originX: Double?, originY: Double?, originZ: Double?): DOMMatrix
    fun scaleNonUniformSelf(scaleX: Double, scaleY: Double?, scaleZ: Double?, originX: Double?, originY: Double?, originZ: Double?): DOMMatrix
    fun rotateSelf(angle: Double, originX: Double?, originY: Double?): DOMMatrix
    fun rotateFromVectorSelf(x: Double, y: Double): DOMMatrix
    fun rotateAxisAngleSelf(x: Double, y: Double, z: Double, angle: Double): DOMMatrix
    fun skewXSelf(sx: Double): DOMMatrix
    fun skewYSelf(sy: Double): DOMMatrix
    fun invertSelf(): DOMMatrix
    fun setMatrixValue(transformList: String): DOMMatrix
}

@Deprecated("JS only.")
external interface CanvasCompositing {
    var globalAlpha: Double
    var globalCompositeOperation: String
}

@Deprecated("JS only.")
external interface CanvasImageSmoothing {
    var imageSmoothingEnabled: Boolean
    var imageSmoothingQuality: Any
}

@Deprecated("JS only.")
external interface CanvasFillStrokeStyles {
    var strokeStyle: Any?
    var fillStyle: Any?
    fun createLinearGradient(x0: Double, y0: Double, x1: Double, y1: Double): CanvasGradient
    fun createRadialGradient(x0: Double, y0: Double, r0: Double, x1: Double, y1: Double, r1: Double): CanvasGradient
    fun createPattern(image: Any?, repetition: String): CanvasPattern?
}

@Deprecated("JS only.")
external interface CanvasShadowStyles {
    var shadowOffsetX: Double
    var shadowOffsetY: Double
    var shadowBlur: Double
    var shadowColor: String
}

@Deprecated("JS only.")
external interface CanvasFilters {
    var filter: String
}

@Deprecated("JS only.")
external interface CanvasRect {
    fun clearRect(x: Double, y: Double, w: Double, h: Double)
    fun fillRect(x: Double, y: Double, w: Double, h: Double)
    fun strokeRect(x: Double, y: Double, w: Double, h: Double)
}

@Deprecated("JS only.")
external interface CanvasDrawPath {
    fun beginPath()
    fun fill(fillRule: String)
    fun fill(path: Path2D, fillRule: String)
    fun stroke()
    fun stroke(path: Path2D)
    fun clip(fillRule: String)
    fun clip(path: Path2D, fillRule: String)
    fun resetClip()
    fun isPointInPath(x: Double, y: Double, fillRule: String): Boolean
    fun isPointInPath(path: Path2D, x: Double, y: Double, fillRule: String): Boolean
    fun isPointInStroke(x: Double, y: Double): Boolean
    fun isPointInStroke(path: Path2D, x: Double, y: Double): Boolean
}

@Deprecated("JS only.")
external interface CanvasUserInterface {
    fun drawFocusIfNeeded(element: Element)
    fun drawFocusIfNeeded(path: Path2D, element: Element)
    fun scrollPathIntoView()
    fun scrollPathIntoView(path: Path2D)
}

@Deprecated("JS only.")
external interface CanvasText {
    fun fillText(text: String, x: Double, y: Double, maxWidth: Double)
    fun strokeText(text: String, x: Double, y: Double, maxWidth: Double)
    fun measureText(text: String): TextMetrics
}

@Deprecated("JS only.")
external interface CanvasDrawImage {
    fun drawImage(image: Any?, dx: Double, dy: Double)
    fun drawImage(image: Any?, dx: Double, dy: Double, dw: Double, dh: Double)
    fun drawImage(image: Any?, sx: Double, sy: Double, sw: Double, sh: Double, dx: Double, dy: Double, dw: Double, dh: Double)
}

@Deprecated("JS only.")
external interface CanvasHitRegion {
    fun addHitRegion(options: HitRegionOptions)
    fun removeHitRegion(id: String)
    fun clearHitRegions()
}

@Deprecated("JS only.")
external interface CanvasImageData {
    fun createImageData(sw: Double, sh: Double): ImageData
    fun createImageData(imagedata: ImageData): ImageData
    fun getImageData(sx: Double, sy: Double, sw: Double, sh: Double): ImageData
    fun putImageData(imagedata: ImageData, dx: Double, dy: Double)
    fun putImageData(imagedata: ImageData, dx: Double, dy: Double, dirtyX: Double, dirtyY: Double, dirtyWidth: Double, dirtyHeight: Double)
}

@Deprecated("JS only.")
external interface CanvasPathDrawingStyles {
    var lineWidth: Double
    var lineCap: Any
    var lineJoin: Any
    var miterLimit: Double
    var lineDashOffset: Double
    fun setLineDash(segments: Array<Double>)
    fun getLineDash(): Array<Double>
}

@Deprecated("JS only.")
external interface CanvasTextDrawingStyles {
    var font: String
    var textAlign: Any
    var textBaseline: Any
    var direction: Any
}

@Deprecated("JS only.")
external interface CanvasPath {
    fun closePath()
    fun moveTo(x: Double, y: Double)
    fun lineTo(x: Double, y: Double)
    fun quadraticCurveTo(cpx: Double, cpy: Double, x: Double, y: Double)
    fun bezierCurveTo(cp1x: Double, cp1y: Double, cp2x: Double, cp2y: Double, x: Double, y: Double)
    fun arcTo(x1: Double, y1: Double, x2: Double, y2: Double, radius: Double)
    fun arcTo(x1: Double, y1: Double, x2: Double, y2: Double, radiusX: Double, radiusY: Double, rotation: Double)
    fun rect(x: Double, y: Double, w: Double, h: Double)
    fun arc(x: Double, y: Double, radius: Double, startAngle: Double, endAngle: Double, anticlockwise: Boolean)
    fun ellipse(x: Double, y: Double, radiusX: Double, radiusY: Double, rotation: Double, startAngle: Double, endAngle: Double, anticlockwise: Boolean)
}

@Deprecated("JS only.")
external interface CanvasGradient {
    fun addColorStop(offset: Double, color: String)
}

@Deprecated("JS only.")
external interface CanvasPattern {
    fun setTransform(transform: Any?)
}

@Deprecated("JS only.")
external interface TextMetrics {
    val width: Double
    val actualBoundingBoxLeft: Double
    val actualBoundingBoxRight: Double
    val fontBoundingBoxAscent: Double
    val fontBoundingBoxDescent: Double
    val actualBoundingBoxAscent: Double
    val actualBoundingBoxDescent: Double
    val emHeightAscent: Double
    val emHeightDescent: Double
    val hangingBaseline: Double
    val alphabeticBaseline: Double
    val ideographicBaseline: Double
}

@Deprecated("JS only.")
external interface HitRegionOptions {
    var path: Path2D?
    var fillRule: Any?
    var id: String?
    var parentID: String?
    var cursor: String?
    var control: Element?
    var label: String?
    var role: String?
}

@Deprecated("JS only.")
external interface TexImageSource

@Deprecated("JS only.")
external interface ImageData : TexImageSource {
    val width: Int
    val height: Int
    val data: Any
}

@Deprecated("JS only.")
external interface Path2D : CanvasPath {
    fun addPath(path: Path2D, transform: Any?)
    override fun closePath()
    override fun moveTo(x: Double, y: Double)
    override fun lineTo(x: Double, y: Double)
    override fun quadraticCurveTo(cpx: Double, cpy: Double, x: Double, y: Double)
    override fun bezierCurveTo(cp1x: Double, cp1y: Double, cp2x: Double, cp2y: Double, x: Double, y: Double)
    override fun arcTo(x1: Double, y1: Double, x2: Double, y2: Double, radius: Double)
    override fun arcTo(x1: Double, y1: Double, x2: Double, y2: Double, radiusX: Double, radiusY: Double, rotation: Double)
    override fun rect(x: Double, y: Double, w: Double, h: Double)
    override fun arc(x: Double, y: Double, radius: Double, startAngle: Double, endAngle: Double, anticlockwise: Boolean /* */)
    override fun ellipse(x: Double, y: Double, radiusX: Double, radiusY: Double, rotation: Double, startAngle: Double, endAngle: Double, anticlockwise: Boolean /* */)
}

@Deprecated("JS only.")
external interface Touch {
    val region: String?
}

@Deprecated("JS only.")
external interface ImageBitmapRenderingContext {
    val canvas: HTMLCanvasElement
    fun transferFromImageBitmap(bitmap: Any?)
}

@Deprecated("JS only.")
external interface ImageBitmapRenderingContextSettings {
    var alpha: Boolean?
}

@Deprecated("JS only.")
external interface HTMLHtmlElement : HTMLElement {
    var version: String
}