package by.gomel.marseille.feature.goods.presentation.cart

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.CartDto


interface CartContract {

    interface View : BaseContract.View {
        fun updateCartDtoList(services: List<CartDto>)
        fun updateTotalAmount(amount: String)
    }

    interface Presenter : BaseContract.Presenter {
        fun onClearButtonClicked()
        fun onItemDeleteButtonClicked(cardDto: CartDto)
        fun initData()
    }

}