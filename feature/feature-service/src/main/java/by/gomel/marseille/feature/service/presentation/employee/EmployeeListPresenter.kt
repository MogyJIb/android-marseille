package by.gomel.marseille.feature.service.presentation.employee

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.domain.GetEmployeeUseCase
import by.gomel.marseille.feature.service.domain.GetServiceUseCase
import by.gomel.marseille.feature.service.domain.ServiceShoppingCart
import io.reactivex.rxkotlin.plusAssign


class EmployeeListPresenter(
        connectionReceiver: ConnectionReceiver,
        private val getEmployeeUseCase: GetEmployeeUseCase,
        private val serviceShoppingCart: ServiceShoppingCart
) : BasePresenter<EmployeeListContract.View>(connectionReceiver), EmployeeListContract.Presenter {

    override fun initEmployees(category: ServiceCategory) {
        disposables += getEmployeeUseCase.getEmployeeFilteredByNameAsync(category)
            .subscribe(
                { goods -> view?.updateEmployees(goods) },
                this::handleError
            )
    }

    override fun selectEmployee(employee: Employee) {
        serviceShoppingCart.employee = employee
        view?.onSelectEmployeeSuccess()
    }

}