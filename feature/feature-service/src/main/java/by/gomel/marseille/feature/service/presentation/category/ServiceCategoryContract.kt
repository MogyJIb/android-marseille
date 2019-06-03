package by.gomel.marseille.feature.service.presentation.category

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.ServiceCategory


interface ServiceCategoryContract {

    interface View : BaseContract.View {
        fun updateCategories(categories: List<ServiceCategory>)
        fun updateCartData(services: String?, employee: String?, amount: Double)
    }

    interface Presenter : BaseContract.Presenter {
        fun loadCategories()
        fun loadCartData()
        fun clearCart()
    }

}