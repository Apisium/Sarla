@file:Suppress("UNUSED_PARAMETER", "DEPRECATION")

package cn.apisium.sarla.dom

import cn.apisium.sarla.nodes.HasAttr
import cn.apisium.sarla.nodes.NodeBlock

@Suppress("UNUSED")
private val assign = js("""'assign' in Object && Object.assign.toString().indexOf('native') !== -1
        ? Object.assign : function assign (a, b) { for (var k in b) a[k] = b[k] }""").unsafeCast<(Any, Any) -> Any>()
private val noListener = !js("'addEventListener' in window").unsafeCast<Boolean>()

internal fun renderNewElement(_node: NodeBlock, eventProxy: (String, Element) -> Unit): Element {
    val node = _node.unsafeCast<HasAttr<*, *>>()
    val elm = createNodeElement(node.type)
    node.className?.let { elm.className = it }
    node.event?.let { patchEvent(it, elm, eventProxy) }
    node.attr?.let { patchAttr(it, elm) }
    node.style?.let { assign(elm.style, it) }
    node.prop?.let { assign(elm, it) }
    return elm
}

internal fun patchEvent(events: DOMEvents<*>, elm: Element, eventProxy: (String, Element) -> Unit) {
    if (noListener) {
        val d = elm.asDynamic()
        var fn = events.onAbort
        if(fn == null) { if (d.onabort != null) d.onabort = null } else d.onabort = fn
        fn = events.onError
        if(fn == null) { if (d.onerror != null) d.onerror = null } else d.onerror = fn
        fn = events.onLoad
        if(fn == null) { if (d.onload != null) d.onload = null } else d.onload = fn
    }
    js("""
        elm.sarlaEvents = events
        for (var name in events) {
            if (name.substr(-7) === 'capture') name = name.substring(0, n.length - 7)
            eventProxy(name, elm)
        }
    """)
}

internal fun patchOldAttr(attr: HTMLAttributes<*>, old: HTMLAttributes<*>, elm: Element) {
    js("for (var i in attr) if (attr[i] !== old[i]) elm.setAttribute(i, attr[i] || '')")
}

internal fun patchStyle(style: CSSProperties, old: CSSProperties, s: CSSProperties) {
    js("for (var i in style) if (style[i] !== old[i]) s[i] = style[i]")
}

internal fun patchProp(prop: Props, old: Props, elm: Element) {
    js("for (var i in prop) if (prop[i] !== old[i]) elm[i] = prop[i]")
}

internal fun clearProp(prop: Props, elm: Element) { js("for (var i in prop) elm[i] = ''") }
internal fun clearStyle(style: CSSProperties, s: CSSProperties) { js("for (var i in style) s[i] = ''") }

internal fun patchAttr(attr: HTMLAttributes<*>, elm: Element) { js("for (var i in attr) if (attr[i]) elm.setAttribute(i, attr[i])") }

internal fun clearAttr(attr: HTMLAttributes<*>, elm: Element) { js("for (var i in attr) elm.removeAttribute()") }