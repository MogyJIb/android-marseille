package by.gomel.marseille.core.base.utils

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.hideErrorOnTextChange() {
    this.editText?.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (this@hideErrorOnTextChange.isErrorEnabled)
                this@hideErrorOnTextChange.isErrorEnabled = false
        }
    })
}