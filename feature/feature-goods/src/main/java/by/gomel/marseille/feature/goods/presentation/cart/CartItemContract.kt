package by.gomel.marseille.feature.goods.presentation.cart

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.GoodsCartDto


interface CartItemContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter {
        fun onItemDeleteButtonClicked(cardDto: GoodsCartDto)
        fun updateCartWithItem(cardDto: GoodsCartDto)
    }

}