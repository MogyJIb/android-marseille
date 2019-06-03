package by.gomel.marseille.feature.service.presentation.list

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory


interface ServiceListContract {

    interface View : BaseContract.View {
        fun updateServices(services: List<Service>)
    }

    interface Presenter : BaseContract.Presenter {
        fun initService(category: ServiceCategory)
    }

}