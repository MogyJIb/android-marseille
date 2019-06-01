package by.gomel.marseille.feature.goods.presentation.category

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.GoodsCategory


interface GoodsCategoryContract {

    interface View : BaseContract.View {
        fun updateCategories(categories: List<GoodsCategory>)
    }

    interface Presenter : BaseContract.Presenter {
        fun initData()
    }


}