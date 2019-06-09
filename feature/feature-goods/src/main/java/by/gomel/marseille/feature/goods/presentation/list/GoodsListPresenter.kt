package by.gomel.marseille.feature.goods.presentation.list

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.feature.goods.domain.GetGoodsUseCase
import io.reactivex.rxkotlin.plusAssign


class GoodsListPresenter(
        connectionReceiver: ConnectionReceiver,
        private val getGoodsUseCase: GetGoodsUseCase
) : BasePresenter<GoodsListContract.View>(connectionReceiver), GoodsListContract.Presenter {

    override fun initGoods(category: GoodsCategory) {
        disposables += getGoodsUseCase.getGoodsFilteredByNameAsync(category)
            .subscribe({
                    goods -> view?.updateGoods(goods)
            }, this::handleError)
    }

}