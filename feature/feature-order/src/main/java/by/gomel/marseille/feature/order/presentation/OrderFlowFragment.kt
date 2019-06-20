package by.gomel.marseille.feature.order.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.MenuRes
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.order.R
import kotlinx.android.synthetic.main.fragment_order_flow.*


class OrderFlowFragment : BaseFragment(), OnBackPressedCallback {

    private val navController by lazy {
        childFragmentManager.findFragmentById(R.id.order_nav_host_fragment)?.findNavController()!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.addOnBackPressedCallback(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_order_flow, container, false)

    override fun onDestroy() {
        activity?.removeOnBackPressedCallback(this)
        super.onDestroy()
    }

    override fun handleOnBackPressed(): Boolean = if (isResumed) navController?.navigateUp() ?: false else false

}

val OrderFlowFragment.isBackButtonVisible
    get() = order_toolbar.navigationIcon != null

fun OrderFlowFragment.showBackButton() {
    if (isBackButtonVisible) return
    order_toolbar.run {
        setNavigationIcon(R.drawable.icon_back)
        setNavigationOnClickListener { activity?.onBackPressed() }
    }
}

fun OrderFlowFragment.hideBackButton() {
    if (!isBackButtonVisible) return
    order_toolbar.run{
        navigationIcon = null
        setNavigationOnClickListener(null)
    }
}

fun OrderFlowFragment.showToolbarMenu(@MenuRes menu: Int, onClick: (item: MenuItem) -> Boolean) {
    hideToolbarMenu()
    order_toolbar.run {
        inflateMenu(menu)
        setOnMenuItemClickListener { onClick(it) }
    }
}

fun OrderFlowFragment.hideToolbarMenu() = order_toolbar.menu.clear()
fun OrderFlowFragment.setTitle(@StringRes title: Int) = order_toolbar.setTitle(title)
fun OrderFlowFragment.setTitle(title: String) = order_toolbar.setTitle(title)