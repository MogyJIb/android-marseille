package by.gomel.marseille.feature.goods.presentation.detail

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.Goods


interface GoodsDetailContract {

    interface View : BaseContract.View {
        fun onGoodsAdded()
    }

    interface Presenter : BaseContract.Presenter {
        fun onAddToPurchaseClicked(goods: Goods)
    }

}