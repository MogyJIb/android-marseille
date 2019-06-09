package by.gomel.marseille.feature.service

import by.gomel.marseille.feature.service.domain.GetEmployeeUseCase
import by.gomel.marseille.feature.service.domain.GetServiceCategoriesUseCase
import by.gomel.marseille.feature.service.domain.GetServiceUseCase
import by.gomel.marseille.feature.service.domain.ServiceShoppingCart
import by.gomel.marseille.feature.service.navigation.IServiceFlowCoordinator
import by.gomel.marseille.feature.service.navigation.ServiceFlowCoordinator
import by.gomel.marseille.feature.service.presentation.category.ServiceCategoryContract
import by.gomel.marseille.feature.service.presentation.category.ServiceCategoryPresenter
import by.gomel.marseille.feature.service.presentation.employee.EmployeeListContract
import by.gomel.marseille.feature.service.presentation.employee.EmployeeListPresenter
import by.gomel.marseille.feature.service.presentation.list.ServiceItemContract
import by.gomel.marseille.feature.service.presentation.list.ServiceItemPresenter
import by.gomel.marseille.feature.service.presentation.list.ServiceListContract
import by.gomel.marseille.feature.service.presentation.list.ServiceListPresenter
import org.koin.dsl.module.module


object ServiceKoinDi {

    val modules = arrayOf(serviceModule)

}

private val serviceModule = module {
    single { ServiceFlowCoordinator(getProperty("serviceNavController")) as IServiceFlowCoordinator }
    single { ServiceShoppingCart() }
    single { GetEmployeeUseCase(get()) }
    single { GetServiceCategoriesUseCase(get()) }
    single { GetServiceUseCase(get()) }

    factory { ServiceListPresenter(get(), get()) as ServiceListContract.Presenter }
    factory { ServiceItemPresenter(get(),get(), get()) as ServiceItemContract.Presenter }
    factory { EmployeeListPresenter(get(),get(), get()) as EmployeeListContract.Presenter }
    factory { ServiceCategoryPresenter(get(),get(), get()) as ServiceCategoryContract.Presenter }
}