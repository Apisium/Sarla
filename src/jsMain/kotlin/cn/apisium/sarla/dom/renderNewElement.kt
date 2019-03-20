package cn.apisium.sarla.dom

private val assign = js("""'assign' in Object && Object.assign.toString().indexOf('native') !== -1
        ? Object.assign : function assign (a, b) { for (var k in b) a[k] = b[k] }""")

@Suppress("UNUSED_PARAMETER", "DEPRECATION")
internal fun renderNewElement(attr: Any?, type: String, eventProxy: dynamic): Element {
    val elm = createNodeElement(type)
    @Suppress("UNUSED_VARIABLE")
    val ass = assign
    js("""
        var unset = true
        if (attr == null);
        else if (typeof attr === 'string') elm.className = attr
        else for (var name in attr) switch (name) {
            case 'key': case 'renderFunc': break
            case 'className': elm.className = attr.className; break
            case 'innerHTML': elm.innerHTML = attr.innerHTML; break
            case 'style': if(!('styleText' in attr)) ass(elm.style, attr.style); break
            case 'styleText': elm.style.styleText = attr.styleText; break
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
    return elm
}