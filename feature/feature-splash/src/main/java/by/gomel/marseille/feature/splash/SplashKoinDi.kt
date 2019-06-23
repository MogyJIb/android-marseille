package by.gomel.marseille.feature.splash

import by.gomel.marseille.feature.splash.presentation.SplashContract
import by.gomel.marseille.feature.splash.presentation.SplashPresenter
import org.koin.dsl.module.module


object SplashKoinDi {

    val modules = arrayOf(splashModule)

}

private val splashModule = module {
    factory { SplashPresenter(get(), get(), get(), get()) as SplashContract.Presenter }
}