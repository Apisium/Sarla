@file:Suppress("DEPRECATION")

package cn.apisium.sarla.dom

import kotlin.browser.document
import kotlin.browser.window

@JsName("Array")
private external class JsArray <T> {
    val length: Int
    fun push(a: T)
    operator fun get(key: Int): T
}

private external interface MyTarget: HTMLElement {
    val sarlaEvents: dynamic
    val disabled: Boolean
}

private val input2change = js("{ text: null, password: null, search: null, url: null, email: null }")

@Suppress("NOTHING_TO_INLINE", "UNUSED_PARAMETER")
private inline fun isNotIn(r: dynamic, k: dynamic) = js("typeof r[k] === 'undefined'").unsafeCast<Boolean>()
@Suppress("NOTHING_TO_INLINE", "UNUSED_PARAMETER")
private inline fun isIn(r: dynamic, k: dynamic) = js("typeof r[k] === 'object'").unsafeCast<Boolean>()
@Suppress("NOTHING_TO_INLINE", "UNUSED_PARAMETER")
private inline fun iIn(r: dynamic, k: dynamic) = js("k in r").unsafeCast<Boolean>()

private val canPrevent = js("'Event' in window && 'preventDefault' in window.Event.prototype").unsafeCast<Boolean>()
private val hasListener = js("'addEventListener' in window").unsafeCast<Boolean>()

internal fun createEventProxy(root: Element): (String, Element) -> Unit {
    val handled = js("{}")

    val fixEvent: (Event?) -> Event = {
        val e = it ?: window.asDynamic().event.unsafeCast<Event>()
        @Suppress("SENSELESS_COMPARISON")
        if (e.target == null) e.asDynamic().target = e.asDynamic().srcElement
        if (!e.returnValue) e.returnValue = true
        when (e.type.toLowerCase()) {
            "wheel", "mousewheel", "dommousescroll" ->
                if (isNotIn(e, "deltaX")) js("e.deltaX = -e.wheelDeltaX || 0; e.deltaY = -e.wheelDeltaY || -e.wheelDelta || 0")
        }
        e
    }

    val handleFunc = f@ { _e: Event? ->
        val e = fixEvent(_e)
        var target = e.target.unsafeCast<MyTarget>()
        var type = "on" + e.type.toLowerCase()
        when (type) {
            "onmousewheel", "ondommousescroll" -> type = "onwheel"
            "onclick" -> if (target.disabled) return@f
        }
        val nodes = JsArray<Element>()
        val func = JsArray<(Event) -> Unit>()
        var unPrevent = true
        val typeC = type + "capture"

        while (target !== root && target !== document) {
            val handles = target.sarlaEvents
            if (handles != null) {
                if (!e.canceled) {
                    val fn = handles[type]
                    if (fn != null) {
                        e.asDynamic().current = target
                        try {
                            fn(e)
                        } catch (a: Exception) {
                            console.error(a)
                        }
                        if (unPrevent && !e.returnValue) {
                            unPrevent = false
                            if (canPrevent) e.asDynamic().preventDefault()
                        }
                    }
                }
                handles[typeC].unsafeCast<((Event) -> Unit)?>()?.let {
                    func.push(it)
                    nodes.push(target)
                }
            }
            target = target.parentNode.unsafeCast<MyTarget>()
        }
        e.canceled = false
        var i = nodes.length
        while (i-- != 0) {
            e.asDynamic().current = nodes[i]
            try { func[i](e) } catch (a: Exception) { console.error(a) }
            if (unPrevent && !e.returnValue) {
                unPrevent = false
                if (canPrevent) e.asDynamic().preventDefault()
            }
            if (e.canceled) break
        }
    }

    val handleInput: (Event?) -> Unit = f@ {
        val e = fixEvent(it)
        val target = e.target.asDynamic()
        val handles = target.sarlaEvents
        if (target.nodeName.unsafeCast<String>() != "INPUT" || handles == null) return@f
        e.asDynamic().current = target
        var fn = handles.oninput
        if (fn != null) {
            try { fn(e) } catch (a: Exception) { console.error(a) }
            if (!e.returnValue && canPrevent) e.asDynamic().preventDefault()
        }
        fn = handles.oninputcapture
        if (fn != null) {
            try { fn(e) } catch (a: Exception) { console.error(a) }
            if (!e.returnValue && canPrevent) e.asDynamic().preventDefault()
        }
        if (target.__0 == null && isIn(input2change, target.type)) {
            fn = handles.onchange
            if (fn != null) {
                try { fn(e) } catch (a: Exception) { console.error(a) }
                if (!e.returnValue && canPrevent) e.asDynamic().preventDefault()
            }
            fn = handles.onchangecapture
            if (fn != null) {
                try { fn(e) } catch (a: Exception) { console.error(a) }
                if (!e.returnValue && canPrevent) e.asDynamic().preventDefault()
            }
        }
    }

    val registerInput = {
        if (isNotIn(handled, "_2")) {
            handled._2 = null
            root.addEventListener("compositionstart", { e: dynamic -> e.target.__0 = true }, false)
            root.addEventListener("compositionend", { e: dynamic -> e.target.__0 = null }, false)
            root.asDynamic().oninput = { e: FormEvent<*> -> if (e.isComposing) window.setTimeout(handleInput, 0, e)
                else handleInput(e.unsafeCast<Event>()) }
        }
    }

    val handleErrorAndLoaded = { it: Event? ->
        val e = fixEvent(it)
        val target = e.target.asDynamic()
        val handles = target.sarlaEvents
        e.asDynamic().current = target
        val type = "on" + e.type.toLowerCase()
        var fn = handles[type]
        if (fn != null) {
            try { fn(e) } catch (a: Exception) { console.error(a) }
            if (!e.returnValue && canPrevent) e.asDynamic().preventDefault()
        }
        fn = handles[type + "capture"]
        if (fn != null) {
            try { fn(e) } catch (a: Exception) { console.error(a) }
            if (!e.returnValue && canPrevent) e.asDynamic().preventDefault()
        }
    }

    return { it, _ ->
        if (isNotIn(handled, it)) {
            when (it) {
                "oncompositionstart", "oncompositionend" ->
                    root.addEventListener(it.substring(2), handleFunc, false)
                "oninput" -> registerInput()
                "onchange" -> {
                    registerInput()
                    root.asDynamic().onchange = handleFunc
                }
                "onerror", "onload", "onabort" ->
                    if (hasListener) root.addEventListener(it.substring(2), handleErrorAndLoaded, true)
                "onwheel" -> when {
                    iIn(window, "onwheel") -> root.asDynamic().onwheel = handleFunc
                    iIn(window, "onmousewheel") -> root.asDynamic().onmousewheel = handleFunc
                    hasListener -> root.addEventListener("DOMMouseScroll", handleFunc, false)
                }
                else -> root.asDynamic()[it] = handleFunc
            }
            handled[it] = null
        }
    }
}