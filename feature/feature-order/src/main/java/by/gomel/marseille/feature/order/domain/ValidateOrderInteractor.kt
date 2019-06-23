package by.gomel.marseille.feature.order.domain


class ValidateOrderInteractor(
        private val validateNameUseCase: ValidateNameUseCase,
        private val validatePhoneUseCase: ValidatePhoneUseCase,
        private val validateEmailUseCase: ValidateEmailUseCase
) {

    fun validateEmail(
            text: CharSequence?,
            onSuccess: () -> Unit = {},
            onError: (errorRes: Int) -> Unit = {}
    ): Boolean 
        = validateEmailUseCase(text, onSuccess, onError)

    fun validatePhone(
            text: CharSequence?,
            onSuccess: () -> Unit = {},
            onError: (errorRes: Int) -> Unit = {}
    ): Boolean 
        = validatePhoneUseCase(text, onSuccess, onError)

    fun validateName(
            text: CharSequence?,
            onSuccess: () -> Unit = {},
            onError: (errorRes: Int) -> Unit = {}
    ): Boolean 
        = validateNameUseCase(text, onSuccess, onError)

    operator fun invoke(
            name: CharSequence?, onNameError: (errorRes: Int) -> Unit,
            email: CharSequence?, onEmailError: (errorRes: Int) -> Unit,
            phone: CharSequence?, onPhoneError: (errorRes: Int) -> Unit
    ): Boolean 
        = validateName(name) { onNameError(it) } and 
            validateEmail(email) { onEmailError(it) } and 
            validatePhone(phone) { onPhoneError(it) }

}