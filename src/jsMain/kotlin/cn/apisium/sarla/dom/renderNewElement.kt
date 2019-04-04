package cn.apisium.sarla.dom

@Suppress("UNUSED")
private val assign = js("""'assign' in Object && Object.assign.toString().indexOf('native') !== -1
        ? Object.assign : function assign (a, b) { for (var k in b) a[k] = b[k] }""").unsafeCast<(Any, Any) -> Any>()

@Suppress("UNUSED_PARAMETER", "DEPRECATION")
internal fun renderNewElement(attr: Any?, type: String, eventProxy: dynamic): Element {
    val elm = createNodeElement(type)
    patchAttr(attr, elm, eventProxy)
    return elm
}

@Suppress("UNUSED_PARAMETER", "DEPRECATION")
internal fun patchAttr(attr: Any?, elm: Element, eventProxy: dynamic) {
    @Suppress("UNUSED_VARIABLE")
    js("""
        var unset = true
        if (attr == null);
        else if (typeof attr === 'string') elm.className = attr
        else for (var name in attr) switch (name) {
            case 'key': break
            case 'className': elm.className = attr.className; break
            case 'innerHTML': elm.innerHTML = attr.innerHTML; break
            case 'style': if(!('styleText' in attr)) assign(elm.style, attr.style); break
            case 'styleText': elm.style.cssText = attr.styleText; break
            default:
                var value = attr[name]
                if (name in elm) elm[name] = value || ''
                else if (name[0] === 'o' && name[1] === 'n') {
                    if (unset) {
                        unset = false
                        elm.sarlaAttr = attr
                    }
                    attr[name] = null
                    attr[name = name.toLowerCase()] = value
                    if (name.substr(-7) === 'capture') name = name.substring(0, n.length - 7)
                    if (!root[name]) root[name] = eventProxy
                } else elm.setAttribute(name, value)
                value = null
        }
    """)
}