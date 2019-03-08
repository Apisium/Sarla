package cn.apisium.sarla.utils

object Utils {
    var assign = js("""'assign' in Object && Object.assign.toString().indexOf('native') !== -1
        ? Object.assign : function assign (a, b) { for (var k in b) a[k] = b[k] }""")
}