# Sarla

A new lightweight frontend framework built on Kotlin.

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

[MIT](./LICENSE)
