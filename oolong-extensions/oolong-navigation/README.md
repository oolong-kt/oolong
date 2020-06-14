# Navigation Component

A component that abstracts navigation.

Example usage:
```kotlin
class AppComponent(
    getItemById: GetItemById,
    getItemIdsByCategory: GetItemIdsByCategory,
    getUserById: GetUserById
) : NavComponent<Model, Msg, Props, Route>() {

    private val itemListUpdate = ItemListComponent.update(getItemById, getItemIdsByCategory)
    private val itemDetailUpdate = ItemDetailComponent.update(getItemById)
    private val userDetailUpdate = UserDetailComponent.update(getUserById)

    sealed class Route {
        object ItemList : Route()
        data class ItemDetail(val itemId: ItemId) : Route()
        data class UserDetail(val userId: UserId) : Route()
    }

    sealed class Model {
        data class ItemList(val model: ItemListComponent.Model) : Model()
        data class ItemDetail(val model: ItemDetailComponent.Model) : Model()
        data class UserDetail(val model: UserDetailComponent.Model) : Model()
    }

    sealed class Msg {
        data class ItemList(val msg: ItemListComponent.Msg) : Msg()
        data class ItemDetail(val msg: ItemDetailComponent.Msg) : Msg()
        data class UserDetail(val msg: UserDetailComponent.Msg) : Msg()
    }

    sealed class Props {
        object Uninitialized : Props()
        data class ItemList(val props: ItemListComponent.Props) : Props()
        data class ItemDetail(val props: ItemDetailComponent.Props) : Props()
        data class UserDetail(val props: UserDetailComponent.Props) : Props()
    }

    override val initRoute: (Route) -> Init<Model, Msg> =
        { route ->
            {
                when (route) {
                    Route.ItemList -> bimap(
                        ItemListComponent.init(),
                        Model::ItemList,
                        Msg::ItemList
                    )
                    is Route.ItemDetail -> bimap(
                        ItemDetailComponent.init(route.itemId)(),
                        Model::ItemDetail,
                        Msg::ItemDetail
                    )
                    is Route.UserDetail -> bimap(
                        UserDetailComponent.init(route.userId)(),
                        Model::UserDetail,
                        Msg::UserDetail
                    )
                }
            }
        }

    override val updateRoute: Update<Model, Msg> =
        { msg, model ->
            when (msg) {
                is Msg.ItemList -> when (model) {
                    is Model.ItemList -> bimap(
                        itemListUpdate(msg.msg, model.model),
                        Model::ItemList,
                        Msg::ItemList
                    )
                    else -> model to none()
                }
                is Msg.ItemDetail -> when (model) {
                    is Model.ItemDetail -> bimap(
                        itemDetailUpdate(msg.msg, model.model),
                        Model::ItemDetail,
                        Msg::ItemDetail
                    )
                    else -> model to none()
                }
                is Msg.UserDetail -> when (model) {
                    is Model.UserDetail -> bimap(
                        userDetailUpdate(msg.msg, model.model),
                        Model::UserDetail,
                        Msg::UserDetail
                    )
                    else -> model to none()
                }
            }
        }

    override val viewRoute: View<Model, Props> =
        { model ->
            when (model) {
                is Model.ItemList -> Props.ItemList(ItemListComponent.view(model.model))
                is Model.ItemDetail -> Props.ItemDetail(ItemDetailComponent.view(model.model))
                is Model.UserDetail -> Props.UserDetail(UserDetailComponent.view(model.model))
            }
        }
}
```
