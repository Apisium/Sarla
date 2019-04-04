# Sarla [![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu) [![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)

A new and lightweight frontend framework built on Kotlin.

## Features

- Dirty check and minimize patch
- Old IE support
- JVM(SSR only) and WASM support
- Slice patch (Fibers)
- Lightweight
- Plugin system

## Hello World?

```kotlin
fun main() {
    render {
        +"Hello World!"
    }
}
```

## Functional Component

```kotlin
val helloWorld = sarla {
    var times = data(0)
    h {
        button({ onClick = { times++ } }) { +"Click me!" }
        div(0) {
            +"You clicked ${times()} times"
        }
    }
}
```

## Author

Shirasawa - Apisium

## License

[Anti 996](./LICENSE)
