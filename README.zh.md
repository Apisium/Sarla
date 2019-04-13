# Sarla 📜 [![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu) [![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)

一个由 `Kotlin` 构建的轻量前端框架.

[English](./README.md)

## 特性

- 数据脏检查及最小化更新视图
- 支持低版本 `IE`
- 支持 `JVM (Java)` 服务端渲染和 `Wasm`
- 视图更新分片处理 (类似 `React - Fibers` )
- 轻量化 (只有不到 **10kb**)
- 自带全局状态管理
- 插件系统

## 最简单的例子?

```kotlin
fun main() {
    render {
        +"你好, 世界!"
        awesome()
    }
}
```

## 函数化组件

```kotlin
val 你好世界 = sarla {
    var 点击次数 = data(0)
    h {
        button {
            events { onClick = { 点击次数++ } }
            +"点我!"
        }
        div(0) {
            +"你已经点击了: ${点击次数()} 次."
        }
    }
}
```

## 作者

Shirasawa - Apisium

## 协议

[Anti 996](./LICENSE)
