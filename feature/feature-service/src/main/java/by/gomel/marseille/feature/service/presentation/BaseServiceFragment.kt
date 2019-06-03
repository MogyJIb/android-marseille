package by.gomel.marseille.feature.service.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.service.navigation.IServiceFlowCoordinator
import org.koin.android.ext.android.inject


abstract class BaseServiceFragment : BaseFragment() {

    override val coordinator: IServiceFlowCoordinator by inject()
    private val serviceFragment
        get() = parentFragment as? ServiceFlowFragment ?: parentFragment?.parentFragment as? ServiceFlowFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        serviceFragment ?: throw IllegalStateException("${this::class.java} - expected parent:serviceFragment," +
                " but found parent:$parentFragment and it's parent:${parentFragment?.parentFragment}")
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        serviceFragment?.run { if (isShowBackButton()) showBackButton() else hideBackButton() }
    }

    protected fun setTitle(@StringRes title: Int) = serviceFragment?.setTitle(title)
    protected fun setTitle(title: String) = serviceFragment?.setTitle(title)

    protected open fun isShowBackButton() = false

}