package by.gomel.marseille.feature.goods.navigation

import androidx.core.os.bundleOf
import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.feature.goods.R


interface IGoodsFlowCoordinator : BaseContract.Coordinator {

    fun toDetail(goods: Goods)
    fun toGoodsCategory(category: GoodsCategory)
    fun toCart()

}