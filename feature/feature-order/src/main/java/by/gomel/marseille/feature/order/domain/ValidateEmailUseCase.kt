package by.gomel.marseille.feature.order.domain

import android.util.Patterns
import by.gomel.marseille.feature.order.R


class ValidateEmailUseCase {

    operator fun invoke(
            text: CharSequence?,
            onSuccess: () -> Unit = {},
            onError: (errorRes: Int) -> Unit = {}
    ): Boolean
        = if (text == null || text.isEmpty()) {
            onError(R.string.empty_email_error)
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
            onError(R.string.wrong_email_error)
            false
        } else {
        onSuccess()
        true
    }

}