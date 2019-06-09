package by.gomel.marseille.feature.service.presentation.list

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.feature.service.domain.GetServiceUseCase
import by.gomel.marseille.feature.service.domain.ServiceShoppingCart


class ServiceItemPresenter(
        connectionReceiver: ConnectionReceiver,
        private val getServiceUseCase: GetServiceUseCase,
        private val serviceShoppingCart: ServiceShoppingCart
) : BasePresenter<ServiceItemContract.View>(connectionReceiver), ServiceItemContract.Presenter {

    override fun checkServiceInCart(service: Service) = serviceShoppingCart.contain(service)

    override fun onChecked(service: Service, checked: Boolean) {
        if (checked) {
            serviceShoppingCart.add(service)
        } else {
            serviceShoppingCart.remove(service)
        }
    }

}