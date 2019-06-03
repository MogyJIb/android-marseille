package by.gomel.marseille.feature.service.presentation.employee

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.ServiceCategory


interface EmployeeListContract {

    interface View : BaseContract.View {
        fun updateEmployees(employees: List<Employee>)
        fun onSelectEmployeeSuccess()
    }

    interface Presenter : BaseContract.Presenter {
        fun initEmployees(category: ServiceCategory)
        fun selectEmployee(employee: Employee)
    }

}