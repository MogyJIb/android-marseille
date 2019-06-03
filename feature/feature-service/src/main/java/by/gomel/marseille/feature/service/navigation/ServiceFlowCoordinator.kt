package by.gomel.marseille.feature.service.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.R


class ServiceFlowCoordinator(
        private val navController: NavController
) : IServiceFlowCoordinator {

    override fun navigateUp(): Boolean = navController.navigateUp()

    override fun backToCategory()
        = navController.popBackStack(R.id.service_category_fragment, false)

    override fun toEmployeeList(category: ServiceCategory)
            = navController.navigate(R.id.action_category_to_employees, bundleOf("category" to category))

    override fun toServices(category: ServiceCategory)
            = navController.navigate(R.id.action_category_to_services, bundleOf("category" to category))

}