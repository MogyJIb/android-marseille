package by.gomel.marseille.core.base.view

import android.util.Log


interface BaseContract {

    interface Presenter {
        fun<T : Any> bind(view: T)
        fun unbind()
        fun handleError(error: Throwable) {
            Log.e(this::class.java.simpleName, error.message, error)
            error.printStackTrace()
        }
    }

    interface View

    interface Coordinator {
        fun navigateUp(): Boolean
    }

}