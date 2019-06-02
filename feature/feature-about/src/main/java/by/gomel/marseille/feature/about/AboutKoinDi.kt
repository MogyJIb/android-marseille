package by.gomel.marseille.feature.about

import by.gomel.marseille.feature.about.navigation.AboutFlowCoordinator
import by.gomel.marseille.feature.about.navigation.IAboutFlowCoordinator
import org.koin.dsl.module.module


object AboutKoinDi {

    val modules = arrayOf(aboutModule)

}

private val aboutModule = module {
    single { AboutFlowCoordinator(getProperty("aboutNavController")) as IAboutFlowCoordinator }
}