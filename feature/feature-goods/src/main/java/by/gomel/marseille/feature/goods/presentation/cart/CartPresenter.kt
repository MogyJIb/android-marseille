package by.gomel.marseille.feature.goods.presentation.cart

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.GoodsCartDto
import by.gomel.marseille.feature.goods.domain.GoodsShoppingCart
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign


class CartPresenter(
        connectionReceiver: ConnectionReceiver,
        private val shoppingCart: GoodsShoppingCart
) : BasePresenter<CartContract.View>(connectionReceiver), CartContract.Presenter {

    override fun initData() {
        disposables += Observable.just(shoppingCart.cartDtoList)
                .async()
                .subscribe({
                        cartDtoList -> view?.updateCartDtoList(cartDtoList)
                }, this::handleError)

        disposables += shoppingCart.amount
                .async()
                .subscribe({
                    amount -> view?.updateTotalAmount("$amount BYN")
                }, this::handleError)
    }

    override fun onClearButtonClicked() {
        shoppingCart.clear()
        view?.updateCartDtoList(shoppingCart.cartDtoList)
    }

    override fun onItemDeleteButtonClicked(cardDto: GoodsCartDto) {
        shoppingCart.remove(cardDto)
        view?.updateCartDtoList(shoppingCart.cartDtoList)
    }

}