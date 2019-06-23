package by.gomel.marseille.feature.order.presentation.dialog

import by.gomel.marseille.core.base.view.BaseContract


interface OrderDiaogContract {

    interface View : BaseContract.View {
        fun showEmailError(errorResId: Int)
        fun showNameError(errorResId: Int)
        fun showPhoneError(errorResId: Int)
    }

    interface Presenter : BaseContract.Presenter {
        fun validate(name: CharSequence?, email: CharSequence?, phone: CharSequence?): Boolean
    }

}