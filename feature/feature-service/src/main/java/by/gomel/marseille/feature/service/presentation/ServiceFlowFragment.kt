package by.gomel.marseille.feature.service.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.service.R
import by.gomel.marseille.feature.service.navigation.IServiceFlowCoordinator
import kotlinx.android.synthetic.main.fragment_service_flow.*
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject


class ServiceFlowFragment : BaseFragment(), OnBackPressedCallback {

    private val navController by lazy {
        childFragmentManager.findFragmentById(R.id.service_nav_host_fragment)?.findNavController()!!
    }

    override val coordinator: IServiceFlowCoordinator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.addOnBackPressedCallback(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_service_flow, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getKoin().setProperty("serviceNavController", navController)
    }

    override fun onDestroy() {
        activity?.removeOnBackPressedCallback(this)
        super.onDestroy()
    }

    override fun handleOnBackPressed(): Boolean = if (isResumed) navController.navigateUp() else false

}

val ServiceFlowFragment.isBackButtonVisible
    get() = service_toolbar.navigationIcon != null

fun ServiceFlowFragment.showBackButton() {
    if (isBackButtonVisible) return
    service_toolbar.run {
        setNavigationIcon(R.drawable.icon_back)
        setNavigationOnClickListener { activity?.onBackPressed() }
    }
}

fun ServiceFlowFragment.hideBackButton() {
    if (!isBackButtonVisible) return
    service_toolbar.run{
        navigationIcon = null
        setNavigationOnClickListener(null)
    }
}

fun ServiceFlowFragment.setTitle(@StringRes title: Int) = service_toolbar.setTitle(title)
fun ServiceFlowFragment.setTitle(title: String) = service_toolbar.setTitle(title)
