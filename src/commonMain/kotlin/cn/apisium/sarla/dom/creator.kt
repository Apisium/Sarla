@file:Suppress("DEPRECATION")

package cn.apisium.sarla.dom

expect inline fun createNodeElement(type: String): Element
expect inline fun createFragmentElement(): DocumentFragment
expect inline fun createStringElement(str: String): Text
expect inline fun createCommentElement(): Comment
expect inline fun getElementById(id: String): Element?
