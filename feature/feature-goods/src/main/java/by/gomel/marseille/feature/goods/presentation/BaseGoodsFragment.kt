package by.gomel.marseille.feature.goods.presentation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.goods.navigation.IGoodsFlowCoordinator
import org.koin.android.ext.android.inject

abstract class BaseGoodsFragment : BaseFragment() {

    override val coordinator: IGoodsFlowCoordinator by inject()
    private val goodsFragment
        get() = parentFragment as? GoodsFlowFragment ?: parentFragment?.parentFragment as? GoodsFlowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        goodsFragment ?: throw IllegalStateException("${this::class.java} - expected parent:goodsFragment," +
                " but found parent:$parentFragment and it's parent:${parentFragment?.parentFragment}")
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goodsFragment?.run { if (isShowBackButton()) showBackButton() else hideBackButton() }
    }

    protected fun showToolbarMenu(@MenuRes menu: Int, onClick: (item: MenuItem) -> Boolean)
            = goodsFragment?.showToolbarMenu(menu, onClick)
    protected fun setTitle(@StringRes title: Int) = goodsFragment?.setTitle(title)
    protected fun setTitle(title: String) = goodsFragment?.setTitle(title)

    protected fun showCart() = goodsFragment?.showCart()
    protected fun hideCart() = goodsFragment?.hideCart()

    protected open fun isShowBackButton() = false

}