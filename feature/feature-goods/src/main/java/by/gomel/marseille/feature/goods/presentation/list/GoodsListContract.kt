package by.gomel.marseille.feature.goods.presentation.list

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory


interface GoodsListContract {

    interface View : BaseContract.View {
        fun updateGoods(goods: List<Goods>)
    }

    interface Presenter : BaseContract.Presenter {
        fun initGoods(category: GoodsCategory)
    }

}