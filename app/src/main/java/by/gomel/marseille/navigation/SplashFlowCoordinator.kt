package by.gomel.marseille.navigation

import androidx.navigation.NavController
import by.gomel.marseille.R
import by.gomel.marseille.feature.splash.navigation.ISplashFlowCoordinator


class SplashFlowCoordinator(
    private val navController: NavController
) : ISplashFlowCoordinator {

    override fun navigateUp(): Boolean = navController.navigateUp()
    override fun toMainScreen() = navController.navigate(R.id.action_splash_to_main)

}