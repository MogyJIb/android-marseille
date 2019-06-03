package by.gomel.marseille.feature.service.presentation.category

import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.feature.service.domain.GetServiceCategoriesUseCase
import by.gomel.marseille.feature.service.domain.ServiceShoppingCart
import io.reactivex.rxkotlin.plusAssign


class ServiceCategoryPresenter(
        private val getServiceCategoriesUseCase: GetServiceCategoriesUseCase,
        private val cart: ServiceShoppingCart
) : BasePresenter<ServiceCategoryContract.View>(), ServiceCategoryContract.Presenter {

    override fun loadCategories() {
        disposables += getServiceCategoriesUseCase.getCategoriesFilteredByNameAsync()
            .subscribe(
                { categories -> view?.updateCategories(categories) },
                this::handleError
            )
    }

    override fun clearCart() {
        cart.clear()
        view?.updateCartData(null, null, 0.0)
    }

    override fun loadCartData() {
        val services =
            if (cart.cartDtoList.isEmpty())
                null
            else
                cart.cartDtoList.joinToString(separator = ", ") { it.name }

        val employee = cart.employee?.name

        view?.updateCartData(services, employee, cart.amount.value ?: 0.0)
    }

}