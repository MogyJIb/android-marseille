package by.gomel.marseille.feature.order

import by.gomel.marseille.feature.order.domain.ValidateEmailUseCase
import by.gomel.marseille.feature.order.domain.ValidateNameUseCase
import by.gomel.marseille.feature.order.domain.ValidateOrderInteractor
import by.gomel.marseille.feature.order.domain.ValidatePhoneUseCase
import by.gomel.marseille.feature.order.presentation.dialog.OrderDialogPresenter
import by.gomel.marseille.feature.order.presentation.dialog.OrderDiaogContract
import org.koin.dsl.module.module


object OrderKoinDi {

    val modules = arrayOf(orderModule)

}

private val orderModule = module(override = true) {
    single { ValidateEmailUseCase() }
    single { ValidatePhoneUseCase() }
    single { ValidateNameUseCase() }
    single { ValidateOrderInteractor(get(), get(), get()) }

    factory { OrderDialogPresenter(get(), get()) as OrderDiaogContract.Presenter }
}