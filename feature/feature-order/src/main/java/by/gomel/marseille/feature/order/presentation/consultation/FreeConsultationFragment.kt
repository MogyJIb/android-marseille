package by.gomel.marseille.feature.order.presentation.consultation

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.core.base.utils.hideErrorOnTextChange
import by.gomel.marseille.core.base.utils.toast
import by.gomel.marseille.feature.order.R
import by.gomel.marseille.feature.order.presentation.BaseOrderFragment
import by.gomel.marseille.feature.order.presentation.dialog.OrderDiaogContract
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.dialog_order.*
import kotlinx.android.synthetic.main.fragment_free_consultation.*
import kotlinx.android.synthetic.main.fragment_free_consultation.email_edit_text
import kotlinx.android.synthetic.main.fragment_free_consultation.email_input_layout
import kotlinx.android.synthetic.main.fragment_free_consultation.name_edit_text
import kotlinx.android.synthetic.main.fragment_free_consultation.name_input_layout
import kotlinx.android.synthetic.main.fragment_free_consultation.phone_edit_text
import kotlinx.android.synthetic.main.fragment_free_consultation.phone_input_layout
import org.koin.android.ext.android.inject


class FreeConsultationFragment : BaseOrderFragment(), OrderDiaogContract.View {

    override val presenter: OrderDiaogContract.Presenter by inject()

    companion object {
        @JvmStatic fun newInstance() = FreeConsultationFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_free_consultation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Запись на бесплатную консультацию")
        buy_button.setOnClickListener {
            if (presenter.validate(name_edit_text.text, email_edit_text.text, phone_edit_text.text))
                context?.toast("Ваш заявка успешно отправлена, ожидайте обратной связи")
        }
        name_input_layout.hideErrorOnTextChange()
        email_input_layout.hideErrorOnTextChange()
        phone_input_layout.hideErrorOnTextChange()
    }

    override fun isShowBackButton(): Boolean = false

    override fun showEmailError(errorResId: Int)
        = email_input_layout.run {
            isErrorEnabled = true
            error = resources.getString(errorResId)
        }

    override fun showNameError(errorResId: Int)
        = name_input_layout.run {
            isErrorEnabled = true
            error = resources.getString(errorResId)
        }

    override fun showPhoneError(errorResId: Int)
        = phone_input_layout.run {
            isErrorEnabled = true
            error = resources.getString(errorResId)
        }

}

