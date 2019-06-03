package by.gomel.marseille.feature.goods.presentation.detail

import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.feature.goods.domain.GoodsShoppingCart


class GoodsDetailPresenter(
    private val shoppingCart: GoodsShoppingCart
) : BasePresenter<GoodsDetailContract.View>(), GoodsDetailContract.Presenter {

    override fun onAddToPurchaseClicked(goods: Goods) {
        shoppingCart.add(goods)
        view?.onGoodsAdded()
    }

}