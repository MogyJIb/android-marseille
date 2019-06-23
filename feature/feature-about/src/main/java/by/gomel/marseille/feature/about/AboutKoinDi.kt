package by.gomel.marseille.feature.about

import by.gomel.marseille.feature.about.domain.GetAboutCompanyUseCase
import by.gomel.marseille.feature.about.navigation.AboutFlowCoordinator
import by.gomel.marseille.feature.about.navigation.IAboutFlowCoordinator
import by.gomel.marseille.feature.about.presentation.detail.DetailContract
import by.gomel.marseille.feature.about.presentation.detail.DetailPresenter
import org.koin.dsl.module.module


object AboutKoinDi {

    val modules = arrayOf(aboutModule)

}

private val aboutModule = module {
    single { AboutFlowCoordinator(getProperty("aboutNavController")) as IAboutFlowCoordinator }
    single { GetAboutCompanyUseCase(get()) }
    factory { DetailPresenter(get(), get()) as DetailContract.Presenter }
}