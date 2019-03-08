@file:Suppress("NOTHING_TO_INLINE", "DEPRECATION")

package cn.apisium.sarla.dom

import kotlin.browser.document

actual inline fun createNodeElement(type: String) = document.createElement(type).unsafeCast<Element>()
actual inline fun createFragmentElement() = document.createDocumentFragment().unsafeCast<DocumentFragment>()
actual inline fun createStringElement(str: String) = document.createTextNode(str).unsafeCast<Text>()
actual inline fun createCommentElement() = document.createComment("").unsafeCast<Comment>()
actual inline fun getElementById(id: String) = document.getElementById(id)?.unsafeCast<Element>()