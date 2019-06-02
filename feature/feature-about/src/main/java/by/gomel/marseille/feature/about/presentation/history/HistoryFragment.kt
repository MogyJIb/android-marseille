package by.gomel.marseille.feature.about.presentation.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.feature.about.R


class HistoryFragment : BaseFragment() {

    companion object {
        @JvmStatic fun newInstance() = HistoryFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_history, container, false)

}