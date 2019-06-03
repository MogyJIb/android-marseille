package by.gomel.marseille.feature.service.presentation.list

import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.domain.GetServiceUseCase
import by.gomel.marseille.feature.service.presentation.employee.EmployeeListContract
import io.reactivex.rxkotlin.plusAssign


class ServiceListPresenter(
        private val getServiceUseCase: GetServiceUseCase
) : BasePresenter<ServiceListContract.View>(), ServiceListContract.Presenter {

    override fun initService(category: ServiceCategory) {
        disposables += getServiceUseCase.getServiceFilteredByNameAsync(category)
            .subscribe(
                { service -> view?.updateServices(service) },
                this::handleError
            )
    }

}