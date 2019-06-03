package by.gomel.marseille.feature.goods

import by.gomel.marseille.feature.goods.domain.GoodsShoppingCart
import by.gomel.marseille.feature.goods.domain.GetGoodsCategoriesUseCase
import by.gomel.marseille.feature.goods.domain.GetGoodsUseCase
import by.gomel.marseille.feature.goods.navigation.GoodsFlowCoordinator
import by.gomel.marseille.feature.goods.navigation.IGoodsFlowCoordinator
import by.gomel.marseille.feature.goods.presentation.cart.CartContract
import by.gomel.marseille.feature.goods.presentation.cart.CartItemContract
import by.gomel.marseille.feature.goods.presentation.cart.CartItemPresenter
import by.gomel.marseille.feature.goods.presentation.cart.CartPresenter
import by.gomel.marseille.feature.goods.presentation.category.GoodsCategoryContract
import by.gomel.marseille.feature.goods.presentation.category.GoodsCategoryPresenter
import by.gomel.marseille.feature.goods.presentation.detail.GoodsDetailContract
import by.gomel.marseille.feature.goods.presentation.detail.GoodsDetailPresenter
import by.gomel.marseille.feature.goods.presentation.list.GoodsListContract
import by.gomel.marseille.feature.goods.presentation.list.GoodsListPresenter
import org.koin.dsl.module.module


object GoodsKoinDi {

    val modules = arrayOf(goodsModule)

}

private val goodsModule = module {
    single { GoodsShoppingCart() }
    single { GetGoodsCategoriesUseCase(get()) }
    single { GetGoodsUseCase(get()) }
    single { GoodsFlowCoordinator(getProperty("goodsNavController")) as IGoodsFlowCoordinator }

    factory { GoodsCategoryPresenter(get()) as GoodsCategoryContract.Presenter }
    factory { GoodsListPresenter(get()) as GoodsListContract.Presenter }
    factory { CartPresenter(get()) as CartContract.Presenter }
    factory { GoodsDetailPresenter(get()) as GoodsDetailContract.Presenter }
    factory { CartItemPresenter(get()) as CartItemContract.Presenter }

}