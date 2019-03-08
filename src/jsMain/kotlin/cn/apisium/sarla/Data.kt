package cn.apisium.sarla

import cn.apisium.sarla.nodes.NodeBlock
import cn.apisium.sarla.utils.NativeArray


actual class Data <T: Any> actual constructor(actual val data: T) {
    val cache = js("{}")
    val nodes = NativeArray<NodeBlock>()

    actual operator fun invoke() = data
}
