package by.gomel.marseille.feature.about.presentation.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.gomel.marseille.core.base.utils.getArgument
import by.gomel.marseille.core.base.view.BaseFragment
import by.gomel.marseille.data.models.CompanyHistoryDto
import by.gomel.marseille.feature.about.R
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : BaseFragment() {

    companion object {
        @JvmStatic fun newInstance(historyDto: CompanyHistoryDto) = HistoryFragment().apply {
            arguments = bundleOf("historyDto" to historyDto)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_history, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArgument<CompanyHistoryDto>("historyDto")?.apply {
            //history_content.setText(content)
        }
    }

}