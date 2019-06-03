package by.gomel.marseille.feature.service.presentation.list

import by.gomel.marseille.core.base.view.BaseContract
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory

interface ServiceItemContract {

    interface View : BaseContract.View {
    }

    interface Presenter : BaseContract.Presenter {
        fun checkServiceInCart(service: Service): Boolean
        fun onChecked(service: Service, checked: Boolean)
    }

}