package by.gomel.marseille.feature.main.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.main.R
import by.gomel.marseille.feature.main.domain.setupWithNavController
import kotlinx.android.synthetic.main.fragment_main_flow.*


class MainFlowFragment : BaseFragment(), OnBackPressedCallback {

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.addOnBackPressedCallback(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View
            = inflater.inflate(R.layout.fragment_main_flow, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (savedInstanceState == null) setupBottomNavigationBar()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupBottomNavigationBar()
    }

    override fun onDestroy() {
        activity?.removeOnBackPressedCallback(this)
        super.onDestroy()
    }

    private fun setupBottomNavigationBar() {
        currentNavController = bottom_navigation_view.setupWithNavController(
                navGraphIds = listOf(
                    R.navigation.service_tab_nav_graph,
                    R.navigation.goods_tab_nav_graph,
                    R.navigation.about_tab_nav_graph
                ),
                fragmentManager = childFragmentManager,
                containerId = R.id.main_nav_host_container,
                intent = activity?.intent
            )
    }

    override fun handleOnBackPressed(): Boolean
            = if (isResumed) currentNavController?.value?.navigateUp() ?: false else false

}