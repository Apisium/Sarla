@file:Suppress("UNUSED_PARAMETER", "DEPRECATION")

package cn.apisium.sarla.dom

import cn.apisium.sarla.nodes.HasAttr
import cn.apisium.sarla.nodes.NodeBlock

@Suppress("UNUSED")
private val assign = js("""'assign' in Object && Object.assign.toString().indexOf('native') !== -1
        ? Object.assign : function assign (a, b) { for (var k in b) a[k] = b[k] }""").unsafeCast<(Any, Any) -> Any>()

internal fun renderNewElement(_node: NodeBlock, eventProxy: (String) -> Unit): Element {
    val node = _node.unsafeCast<HasAttr<*, *>>()
    val elm = createNodeElement(node.type)
    node.className?.let { elm.className = it }
    node.attr?.let { patchAttr(it, elm) }
    node.style?.let { assign(elm.style, it) }
    node.event?.let { patchEvent(it, elm, eventProxy) }
    return elm
}

internal fun patchEvent(events: DOMEvents<*>, elm: Element, eventProxy: (String) -> Unit) {
    js("""
        elm.sarlaEvents = events
        for (var name in events) {
            if (name.substr(-7) === 'capture') name = name.substring(0, n.length - 7)
            eventProxy(name)
        }
    """)
}

internal fun patchOldAttr(attr: HTMLAttributes<*>, old: HTMLAttributes<*>, elm: Element) {
    js("for (var i in attr) if (attr[i] !== old[i]) elm.setAttribute(i, attr[i] || '')")
}

internal fun patchStyle(style: CSSProperties, old: CSSProperties, s: CSSProperties) {
    js("for (var i in style) if (style[i] !== old[i]) s[i] = style[i]")
}

internal fun clearStyle(style: CSSProperties, s: CSSProperties) { js("for (var i in style) s[i] = ''") }

internal fun patchAttr(attr: HTMLAttributes<*>, elm: Element) { js("for (var i in attr) if (attr[i]) elm.setAttribute(i, attr[i])") }

internal fun clearAttr(attr: HTMLAttributes<*>, elm: Element) { js("for (var i in attr) elm.removeAttribute()") }