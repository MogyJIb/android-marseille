package by.gomel.marseille.feature.service.navigation

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.ServiceCategory


interface IServiceFlowCoordinator : BaseContract.Coordinator {

    fun backToCategory(): Boolean
    fun toEmployeeList(category: ServiceCategory)
    fun toServices(category: ServiceCategory)

}