package by.gomel.marseille.feature.goods.presentation.cart

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.GoodsCartDto
import by.gomel.marseille.feature.goods.domain.GoodsShoppingCart


class CartItemPresenter(
        connectionReceiver: ConnectionReceiver,
        private val shoppingCart: GoodsShoppingCart
) : BasePresenter<CartItemContract.View>(connectionReceiver), CartItemContract.Presenter {

    override fun updateCartWithItem(cardDto: GoodsCartDto) {
        shoppingCart.update(cardDto)
    }

    override fun onItemDeleteButtonClicked(cardDto: GoodsCartDto) {
        shoppingCart.remove(cardDto)
    }

}
