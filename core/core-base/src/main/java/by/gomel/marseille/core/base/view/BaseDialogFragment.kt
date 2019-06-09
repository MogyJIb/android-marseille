package by.gomel.marseille.core.base.view

import androidx.fragment.app.DialogFragment
import by.gomel.marseille.core.base.utils.toast

abstract class BaseDialogFragment : DialogFragment(), BaseContract.View {

    override fun showError(message: String) = context?.toast(message) ?: Unit

}