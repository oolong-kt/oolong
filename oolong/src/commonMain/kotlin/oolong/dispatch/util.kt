package oolong.dispatch

import oolong.Dispatch

/**
 * Contramap from [Dispatch] of [A] to [Dispatch] of [B]
 *
 * `contramap` can be used to map a dispatch function from a parent `Msg` to a child `Msg`. A typical use for
 * `contramap` is compositional screen management.
 *
 * Example:
 *
 * ```kotlin
 * sealed class Props {
 *     data class Home(val props: HomeProps): Props()
 *     data class Settings(val props: SettingsProps): Props()
 * }
 *
 * sealed class Msg {
 *     data class Home(val msg: HomeMsg) : Msg()
 *     data class Settings(val msg: SettingsMsg) : Msg()
 * }
 *
 * val render: Render<Msg, Props> = { props: Props, dispatch: Dispatch<Msg> ->
 *     when (props) {
 *         is Props.Home -> {
 *             homeRender(props.props, contramap(dispatch, Msg::Home))
 *         }
 *         is Props.Settings -> {
 *             settingsRender(props.props, contramap(dispatch, Msg::Settings))
 *         }
 *     }
 * }
 * ```
 */
fun <A : Any, B : Any> contramap(dispatch: Dispatch<A>, f: (B) -> A): Dispatch<B> =
    { b -> dispatch(f(b)) }
