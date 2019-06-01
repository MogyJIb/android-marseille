package by.gomel.marseille.feature.goods.presentation.cart

import by.gomel.marseille.core.base.utils.async
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.CartDto
import by.gomel.marseille.feature.goods.domain.ShoppingCart
import io.reactivex.Observable
import io.reactivex.rxkotlin.plusAssign


class CartPresenter(
        private val shoppingCart: ShoppingCart
) : BasePresenter<CartContract.View>(), CartContract.Presenter {

    override fun initData() {
        disposables += Observable.just(shoppingCart.cartDtoList)
                .async()
                .subscribe({
                        cartDtoList -> view?.updateCartDtoList(cartDtoList)
                }, this::handleError)

        disposables += shoppingCart.amount
                .async()
                .subscribe({
                    amount -> view?.updateTotalAmount("$amount BIN")
                }, this::handleError)
    }

    override fun onClearButtonClicked() {
        shoppingCart.clear()
        view?.updateCartDtoList(shoppingCart.cartDtoList)
    }

    override fun onItemDeleteButtonClicked(cardDto: CartDto) {
        shoppingCart.remove(cardDto)
        view?.updateCartDtoList(shoppingCart.cartDtoList)
    }

}