package by.gomel.marseille.feature.goods.presentation.cart

import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.CartDto
import by.gomel.marseille.feature.goods.domain.ShoppingCart


class CartItemPresenter(
    private val shoppingCart: ShoppingCart
) : BasePresenter<CartItemContract.View>(), CartItemContract.Presenter {

    override fun updateCartWithItem(cardDto: CartDto) {
        shoppingCart.update(cardDto)
    }

    override fun onItemDeleteButtonClicked(cardDto: CartDto) {
        shoppingCart.remove(cardDto)
    }

}
