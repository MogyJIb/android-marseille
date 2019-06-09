package by.gomel.city.test.service

import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.domain.GetServiceCategoriesUseCase
import by.gomel.marseille.feature.service.domain.ServiceShoppingCart
import by.gomel.marseille.feature.service.presentation.category.ServiceCategoryContract
import by.gomel.marseille.feature.service.presentation.category.ServiceCategoryPresenter
import io.reactivex.Observable
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.*
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class ServiceCategoryPresenterTest {

    @Mock
    private lateinit var getServiceCategoriesUseCase: GetServiceCategoriesUseCase
    @Mock
    private lateinit var view: ServiceCategoryContract.View
    @Mock
    private lateinit var cart: ServiceShoppingCart

    private lateinit var presenter: ServiceCategoryContract.Presenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        presenter = ServiceCategoryPresenter(getServiceCategoriesUseCase, cart)
        presenter.bind(view)
    }

    @Test
    fun success_load_categories() {
        doReturn(Observable.just(listOf(ServiceCategory.MAGIC_WHITE)))
            .`when`(getServiceCategoriesUseCase).getCategoriesFilteredByNameAsync()

        presenter.loadCategories()

        verify(view).updateCategories(anyList())
    }

    @Test
    fun success_clear_cart() {
        presenter.clearCart()

        verify(cart).clear()
        verify(view).updateCartData(null, null, 0.0)
    }

}

