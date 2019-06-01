package by.gomel.marseille.data.models

import java.io.Serializable

data class CartDto(
    var goods: Goods,
    var checked: Boolean,
    var count: Int
) : Serializable {

    val totalPrice: Double
        get() = count * goods.price

}