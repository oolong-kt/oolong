[oolong](../index.md) / [oolong](index.md) / [Update](./-update.md)

# Update

`typealias Update<Model, Msg> = (msg: `[`Msg`](-update.md#Msg)`, model: `[`Model`](-update.md#Model)`) -> `[`Next`](-next.md)`<`[`Model`](-update.md#Model)`, `[`Msg`](-update.md#Msg)`>` [(source)](https://github.com/oolong-kt/oolong/tree/master/oolong/src/commonMain/kotlin/oolong/types.kt#L33)

Creates a next state and side-effects from a message and current state

### Parameters

`msg` - the message to interpret

`model` - the current state