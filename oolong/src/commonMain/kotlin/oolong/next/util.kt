package oolong.next

import oolong.Next
import oolong.effect.map

/**
 * Map from [Next] of [A] and [B] to [Next] of [C] and [D]
 *
 * `bimap` can be used to map an init or update function from a child `Next` to a parent `Next`. A typical use for
 * `bimap` is compositional screen management.
 *
 * Example:
 *
 * ```kotlin
 * sealed class Model {
 *     data class Home(val model: HomeModel): Model()
 *     data class Settings(val model: SettingsModel): Model()
 * }
 *
 * sealed class Msg {
 *     data class Home(val msg: HomeMsg) : Msg()
 *     data class Settings(val msg: SettingsMsg) : Msg()
 * }
 *
 * val update: Update<Model, Msg> = { msg: Msg, model: Model ->
 *     when (msg) {
 *         is Msg.Home -> {
 *             when (model) {
 *                 is Model.Home -> bimap(
 *                     homeUpdate(msg.msg, model.model),
 *                     Model::Home,
 *                     Msg::Home
 *                 )
 *                 else -> model to none()
 *             }
 *         }
 *         is Msg.Settings -> {
 *             when (model) {
 *                 is Model.Settings -> bimap(
 *                     settingsUpdate(msg.msg, model.model),
 *                     Model::Settings,
 *                     Msg::Settings
 *                 )
 *                 else -> model to none()
 *             }
 *         }
 *     }
 * }
 */
fun <A : Any, B : Any, C : Any, D : Any> bimap(next: Next<A, B>, fa: (A) -> C, fb: (B) -> D): Next<C, D> =
    fa(next.first) to map(next.second, fb)
