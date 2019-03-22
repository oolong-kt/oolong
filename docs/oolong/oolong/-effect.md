[oolong](../index.md) / [oolong](index.md) / [Effect](./-effect.md)

# Effect

`typealias Effect<Msg> = (dispatch: `[`Dispatch`](-dispatch.md)`<`[`Msg`](-effect.md#Msg)`>) -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/types.kt#L15)

Runs a side-effect away from the runtime

### Parameters

`dispatch` - the dispatch function