package cn.apisium.sarla

import cn.apisium.sarla.nodes.DataNodeBlock
import cn.apisium.sarla.utils.NativeSet

external interface Deadline {
    fun timeRemaining(): Int
}
external fun requestIdleCallback(callback: (Deadline) -> Unit)

@Suppress("NOTHING_TO_INLINE")
actual class Provider(actual val store: Data<*>) {
    val list = NativeSet<Data<*>>()
    val nodesList = NativeSet<DataNodeBlock>()

    init {
        requestIdleCallback(this::loop)
    }

    private fun loop(deadline: Deadline) {
        while (deadline.timeRemaining() > 0) {
            if (list.size > 0) list.forEach { it.nodes.forEach(nodesList::add) }
            if (nodesList.size > 0) nodesList.forEach {  }
        }
        requestIdleCallback(this::loop)
    }

    actual inline fun notify(data: Data<*>) {
        list.add(data)
    }

    actual inline fun notify(nodes: DataNodeBlock) {
        nodesList.add(nodes)
    }

    actual inline fun notify(sarla: Sarla) {
    }
}
