package by.gomel.marseille.feature.order.domain

import by.gomel.marseille.feature.order.R


class ValidateNameUseCase {

    operator fun invoke(
            text: CharSequence?,
            onSuccess: () -> Unit = {},
            onError: (errorRes: Int) -> Unit = {}
    ): Boolean
        = if (text == null || text.isEmpty()) {
            onError(R.string.empty_name_error)
            false
        } else {
            onSuccess()
            true
        }

}