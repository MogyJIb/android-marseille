package by.gomel.marseille

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.data.DataKoinDi
import by.gomel.marseille.feature.main.MainKoinDi
import by.gomel.marseille.feature.splash.SplashKoinDi
import by.gomel.marseille.feature.splash.navigation.ISplashFlowCoordinator
import by.gomel.marseille.navigation.SplashFlowCoordinator
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.Module
import org.koin.dsl.module.module


object KoinDi {

    val modules: List<Module> = listOf(
        appModule,
        *MainKoinDi.modules,
        *DataKoinDi.modules,
        *SplashKoinDi.modules
    )

}

private val appModule = module {
    single { SplashFlowCoordinator(getProperty("appNavController")) as ISplashFlowCoordinator }
    single { ConnectionReceiver(androidApplication()) }
}