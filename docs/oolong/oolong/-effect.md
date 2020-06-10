[oolong](../index.md) / [oolong](index.md) / [Effect](./-effect.md)

# Effect

(common) `typealias Effect<Msg> = suspend CoroutineScope.(dispatch: `[`Dispatch`](-dispatch.md)`<Msg>) -> `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?` [(source)](https://github.com/oolong-kt/oolong/tree/main/oolong/src/commonMain/kotlin/oolong/types.kt#L17)

Runs a side-effect away from the runtime

### Parameters

`dispatch` - the dispatch function