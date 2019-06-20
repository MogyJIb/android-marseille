package by.gomel.marseille.feature.order.presentation.consultation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.feature.order.R
import by.gomel.marseille.feature.order.presentation.BaseOrderFragment


class FreeConsultationFragment : BaseOrderFragment() {

    companion object {
        @JvmStatic fun newInstance() = FreeConsultationFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_free_consultation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Запись на бесплатную консультацию")
    }

    override fun isShowBackButton(): Boolean = false

}