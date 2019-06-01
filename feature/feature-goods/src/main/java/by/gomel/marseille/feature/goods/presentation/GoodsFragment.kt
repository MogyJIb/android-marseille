package by.gomel.marseille.feature.goods.presentation

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
import by.gomel.marseille.feature.goods.R
import by.gomel.marseille.feature.goods.navigation.IGoodsFlowCoordinator
import kotlinx.android.synthetic.main.fragment_goods.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject


class GoodsFragment : BaseFragment(), OnBackPressedCallback {

    private val navController by lazy {
        childFragmentManager.findFragmentById(R.id.goods_nav_host_fragment)?.findNavController()!!
    }

    override val coordinator: IGoodsFlowCoordinator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.addOnBackPressedCallback(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_goods, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getKoin().setProperty("goodsNavController", navController)
        cart_button.setOnClickListener { coordinator.toCart() }
    }

    override fun onDestroy() {
        activity?.removeOnBackPressedCallback(this)
        super.onDestroy()
    }

    override fun handleOnBackPressed(): Boolean = if (isResumed) navController?.navigateUp() ?: false else false

}

val GoodsFragment.isBackButtonVisible
    get() = goods_toolbar.navigationIcon != null

fun GoodsFragment.showBackButton() {
    if (isBackButtonVisible) return
    goods_toolbar.run {
        setNavigationIcon(R.drawable.icon_back)
        setNavigationOnClickListener { activity?.onBackPressed() }
    }
}

fun GoodsFragment.hideBackButton() {
    if (!isBackButtonVisible) return
    goods_toolbar.run{
        navigationIcon = null
        setNavigationOnClickListener(null)
    }
}

fun GoodsFragment.showToolbarMenu(@MenuRes menu: Int, onClick: (item: MenuItem) -> Boolean) {
    hideToolbarMenu()
    goods_toolbar.run {
        inflateMenu(menu)
        setOnMenuItemClickListener { onClick(it) }
    }
}

fun GoodsFragment.hideToolbarMenu() = goods_toolbar.menu.clear()
fun GoodsFragment.setTitle(@StringRes title: Int) = goods_toolbar.setTitle(title)
fun GoodsFragment.setTitle(title: String) = goods_toolbar.setTitle(title)

fun GoodsFragment.showCart() = cart_button.show()
fun GoodsFragment.hideCart() = cart_button.hide()