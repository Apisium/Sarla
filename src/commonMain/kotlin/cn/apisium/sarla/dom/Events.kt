@file:Suppress("DEPRECATION", "UNUSED")

package cn.apisium.sarla.dom

@Deprecated("JS only.")
external interface DataTransferItem {
    val kind: String
    val type: String
    fun getAsString(cb: ((String) -> Unit)?)
    fun getAsFile(): Any?
}

@Deprecated("JS only.")
external interface DataTransferItemList {
    val length: Int
    fun add(data: String, type: String): DataTransferItem?
    fun add(data: Any): DataTransferItem?
    fun remove(index: Int)
    fun clear()
}

@Deprecated("JS only.")
external interface DataTransfer {
    var dropEffect: String
    var effectAllowed: String
    val items: DataTransferItemList
    val types: Array<out String>
    val files: Any
    fun setDragImage(image: EventTarget, x: Int, y: Int)
    fun getData(format: String): String
    fun setData(format: String, data: String)
    fun clearData(format: String?)
}

external interface BaseSyntheticEvent<E, C, T> {
    val current: C
    val target: T
    val bubbles: Boolean
    val cancelable: Boolean
    val defaultPrevented: Boolean
    val eventPhase: Number
    val isTrusted: Boolean
    fun isDefaultPrevented(): Boolean
    fun isPropagationStopped(): Boolean
    fun persist()
    val timeStamp: Number
    val type: String
    var canceled: Boolean
    var returnValue: Boolean
}

external interface SyntheticEvent<T, E> : BaseSyntheticEvent<E, T, EventTarget>
typealias Event = SyntheticEvent<EventTarget, EventTarget>

external interface ClipboardEvent<T> : SyntheticEvent<T, ClipboardEvent<T>> {
    val clipboardData: DataTransfer
}

external interface CompositionEvent<T> : SyntheticEvent<T, CompositionEvent<T>> {
    val data: String
}

external interface DragEvent<T> : SyntheticEvent<T, DragEvent<T>> {
    val dataTransfer: DataTransfer
}

external interface PointerEvent<T> : SyntheticEvent<T, PointerEvent<T>> {
    val pointerId: Number
    val pressure: Number
    val tiltX: Number
    val tiltY: Number
    val width: Number
    val height: Number
    val pointerType: String
    val isPrimary: Boolean
}

external interface FocusEvent<T> : SyntheticEvent<T, FocusEvent<T>> {
    val relatedTarget: EventTarget
}

external interface FormEvent<T> : SyntheticEvent<T, FormEvent<T>> {
    val isComposing: Boolean
}
external interface InvalidEvent<T> : SyntheticEvent<T, InvalidEvent<T>>
external interface ChangeEvent<T> : SyntheticEvent<T, ChangeEvent<T>>
external interface KeyboardEvent<T> : SyntheticEvent<T, KeyboardEvent<T>> {
    val altKey: Boolean
    val charCode: Number
    val ctrlKey: Boolean
    fun getModifierState(key: String): Boolean
    val key: String
    val keyCode: Number
    val locale: String
    val location: Number
    val metaKey: Boolean
    val repeat: Boolean
    val shiftKey: Boolean
    val which: Number
}

external interface MouseEvent<T, E> : SyntheticEvent<T, MouseEvent<T, E>> {
    val altKey: Boolean
    val button: Number
    val buttons: Number
    val clientX: Number
    val clientY: Number
    val ctrlKey: Boolean
    fun getModifierState(key: String): Boolean
    val metaKey: Boolean
    val movementX: Number
    val movementY: Number
    val pageX: Number
    val pageY: Number
    val relatedTarget: EventTarget
    val screenX: Number
    val screenY: Number
    val shiftKey: Boolean
}

external interface TouchEvent<T> : SyntheticEvent<T, TouchEvent<T>> {
    val altKey: Boolean
    val changedTouches: Any
    val ctrlKey: Boolean
    fun getModifierState(key: String): Boolean
    val metaKey: Boolean
    val shiftKey: Boolean
    val targetTouches: Any
    val touches: Any
}

external interface UIEvent<T> : SyntheticEvent<T, UIEvent<T>> {
    val detail: Number
    val view: Any
}

external interface WheelEvent<T> : SyntheticEvent<T, WheelEvent<T>> {
    val deltaMode: Number
    val deltaX: Number
    val deltaY: Number
    val deltaZ: Number
}

external interface AnimationEvent<T> : SyntheticEvent<T, AnimationEvent<T>> {
    val animationName: String
    val elapsedTime: Number
    val pseudoElement: String
}

external interface TransitionEvent<T> : SyntheticEvent<T, TransitionEvent<T>> {
    val elapsedTime: Number
    val propertyName: String
    val pseudoElement: String
}
