package by.gomel.marseille.feature.splash.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.splash.R
import by.gomel.marseille.feature.splash.navigation.ISplashFlowCoordinator
import org.koin.android.ext.android.inject


class SplashFlowFragment : BaseFragment(), SplashContract.View {

    override val presenter: SplashContract.Presenter by inject()
    override val coordinator: ISplashFlowCoordinator by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_splash_flow, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.initData()
    }

    override fun onDataLoadFinished() = coordinator.toMainScreen()

}