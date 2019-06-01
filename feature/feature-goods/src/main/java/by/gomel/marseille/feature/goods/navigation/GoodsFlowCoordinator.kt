package by.gomel.marseille.feature.goods.navigation

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.feature.goods.R


class GoodsFlowCoordinator(
        private val navController: NavController
) : IGoodsFlowCoordinator {

    override fun navigateUp(): Boolean = navController.navigateUp()

    override fun toDetail(goods: Goods)
        = navController.navigate(R.id.action_goods_list_to_details, bundleOf("goods" to goods))

    override fun toGoodsCategory(category: GoodsCategory)
        = navController.navigate(R.id.action_category_to_goods, bundleOf("category" to category))

    override fun toCart() = navController.navigate(R.id.action_to_cart)

}