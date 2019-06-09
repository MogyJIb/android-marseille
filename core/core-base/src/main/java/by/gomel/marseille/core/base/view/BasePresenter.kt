package by.gomel.marseille.core.base.view

import by.gomel.marseille.core.base.utils.ConnectionReceiver
import by.gomel.marseille.core.base.utils.className
import io.reactivex.disposables.CompositeDisposable


abstract class BasePresenter<V : BaseContract.View>(
        private val connectionReceiver: ConnectionReceiver
) : BaseContract.Presenter {

    protected var view: V? = null
    protected lateinit var disposables: CompositeDisposable

    override fun<T : Any> bind(view: T) {
        @Suppress("UNCHECKED_CAST")
        this.view = view as? V
            ?: throw IllegalArgumentException("Bind illegal view:${view.className} in presenter:${this.className}")
        disposables = CompositeDisposable()
    }

    override fun unbind() {
        disposables.dispose()
        view = null
    }

    override fun handleError(error: Throwable) {
        super.handleError(error)

        if (!connectionReceiver.existInternetConnection())
            view?.showError("Интернет соединение отсутствует или потеряно, пожалуйста, проверьте настройки.")

    }

}