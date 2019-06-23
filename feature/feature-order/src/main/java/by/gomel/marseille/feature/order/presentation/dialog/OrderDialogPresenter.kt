package by.gomel.marseille.feature.order.presentation.dialog

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.view.BasePresenter
import by.gomel.marseille.feature.order.domain.ValidateOrderInteractor


class OrderDialogPresenter(
        connectionReceiver: ConnectionReceiver,
        private val validateOrderInteractor: ValidateOrderInteractor
) : BasePresenter<OrderDiaogContract.View>(connectionReceiver), OrderDiaogContract.Presenter {
    
    override fun validate(name: CharSequence?, email: CharSequence?, phone: CharSequence?) 
        = validateOrderInteractor(
            name = name, onNameError = { view?.showNameError(it) },
            email = email, onEmailError = { view?.showEmailError(it) },
            phone = phone, onPhoneError = { view?.showPhoneError(it) }
        )

}