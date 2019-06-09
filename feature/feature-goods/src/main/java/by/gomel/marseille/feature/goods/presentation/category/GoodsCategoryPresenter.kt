package by.gomel.marseille.feature.goods.presentation.category

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.feature.goods.domain.GetGoodsCategoriesUseCase
import io.reactivex.rxkotlin.plusAssign


class GoodsCategoryPresenter(
        connectionReceiver: ConnectionReceiver,
        private val getServiceCategoriesUseCase: GetGoodsCategoriesUseCase
) : BasePresenter<GoodsCategoryContract.View>(connectionReceiver),
    GoodsCategoryContract.Presenter {

    override fun initData() {
        disposables += getServiceCategoriesUseCase.getCategoriesFilteredByNameAsync()
            .subscribe(
                { categories -> view?.updateCategories(categories) },
                this::handleError
            )
    }

}