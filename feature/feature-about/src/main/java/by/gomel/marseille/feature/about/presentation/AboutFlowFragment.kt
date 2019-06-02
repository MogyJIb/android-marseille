package by.gomel.marseille.feature.about.presentation

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
import by.gomel.marseille.feature.about.R
import by.gomel.marseille.feature.about.navigation.IAboutFlowCoordinator
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject


class AboutFlowFragment : BaseFragment(), OnBackPressedCallback {

    private val navController by lazy {
        childFragmentManager.findFragmentById(R.id.about_nav_host_fragment)?.findNavController()!!
    }

    override val coordinator: IAboutFlowCoordinator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.addOnBackPressedCallback(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_about_flow, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getKoin().setProperty("aboutNavController", navController)
    }

    override fun onDestroy() {
        activity?.removeOnBackPressedCallback(this)
        super.onDestroy()
    }

    override fun handleOnBackPressed(): Boolean = if (isResumed) navController.navigateUp() ?: false else false

}