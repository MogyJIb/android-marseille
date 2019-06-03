package by.gomel.marseille.feature.goods.presentation.cart

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.GoodsCartDto


interface CartContract {

    interface View : BaseContract.View {
        fun updateCartDtoList(services: List<GoodsCartDto>)
        fun updateTotalAmount(amount: String)
    }

    interface Presenter : BaseContract.Presenter {
        fun onClearButtonClicked()
        fun onItemDeleteButtonClicked(cardDto: GoodsCartDto)
        fun initData()
    }

}