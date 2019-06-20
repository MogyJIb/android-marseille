package by.gomel.marseille.feature.order.presentation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import by.gomel.marseille.core.base.view.BaseFragment


abstract class BaseOrderFragment : BaseFragment() {

    private val orderFragment
        get() = parentFragment as? OrderFlowFragment ?: parentFragment?.parentFragment as? OrderFlowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        orderFragment ?: throw IllegalStateException("${this::class.java} - expected parent:orderFragment," +
                " but found parent:$parentFragment and it's parent:${parentFragment?.parentFragment}")
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderFragment?.run { if (isShowBackButton()) showBackButton() else hideBackButton() }
    }

    protected fun showToolbarMenu(@MenuRes menu: Int, onClick: (item: MenuItem) -> Boolean)
            = orderFragment?.showToolbarMenu(menu, onClick)
    protected fun setTitle(@StringRes title: Int) = orderFragment?.setTitle(title)
    protected fun setTitle(title: String) = orderFragment?.setTitle(title)

    protected open fun isShowBackButton() = false

}