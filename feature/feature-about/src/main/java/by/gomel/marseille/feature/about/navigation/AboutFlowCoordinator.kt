package by.gomel.marseille.feature.about.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory


class AboutFlowCoordinator(
        private val navController: NavController
) : IAboutFlowCoordinator {

    override fun navigateUp(): Boolean = navController.navigateUp()

}