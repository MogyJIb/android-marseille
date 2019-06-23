package by.gomel.marseille.feature.order.presentation.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import by.gomel.marseille.core.base.utils.hideErrorOnTextChange
import by.gomel.marseille.core.base.view.BaseDialogFragment
import by.gomel.marseille.feature.order.R
import kotlinx.android.synthetic.main.dialog_order.*
import kotlinx.android.synthetic.main.dialog_order.email_edit_text
import kotlinx.android.synthetic.main.dialog_order.email_input_layout
import kotlinx.android.synthetic.main.dialog_order.name_edit_text
import kotlinx.android.synthetic.main.dialog_order.name_input_layout
import kotlinx.android.synthetic.main.dialog_order.phone_edit_text
import kotlinx.android.synthetic.main.dialog_order.phone_input_layout
import org.koin.android.ext.android.inject


class OrderDialogFragment : BaseDialogFragment(), DialogInterface, OrderDiaogContract.View {

    override val presenter: OrderDiaogContract.Presenter by inject()

    var leftButtonListener: DialogInterface.OnClickListener? = null
    var rightButtonListener: DialogInterface.OnClickListener? = null

    companion object {
        @JvmStatic fun newInstance() = OrderDialogFragment()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.Widget_AppTheme_Dialog)
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.dialog_order, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button_left.setOnClickListener {
            leftButtonListener?.run {
                onClick(this@OrderDialogFragment, DialogInterface.BUTTON_NEGATIVE)
            }
            dismiss()
        }

        button_right.setOnClickListener {
            if (!presenter.validate(name_edit_text.text, email_edit_text.text, phone_edit_text.text))
                return@setOnClickListener

            rightButtonListener?.run {
                onClick(this@OrderDialogFragment, DialogInterface.BUTTON_POSITIVE)
            }
            dismiss()
        }

        name_input_layout.hideErrorOnTextChange()
        email_input_layout.hideErrorOnTextChange()
        phone_input_layout.hideErrorOnTextChange()
    }

    override fun onDestroy() {
        leftButtonListener = null
        rightButtonListener = null
        super.onDestroy()

    }

    override fun cancel() = dismiss()

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