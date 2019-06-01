package by.gomel.marseille.core.base.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment(), BaseContract.View {

    protected open val presenter: BaseContract.Presenter? = null
    protected open val coordinator: BaseContract.Coordinator? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter?.bind(this)
    }

    override fun onDestroyView() {
        presenter?.unbind()
        super.onDestroyView()
    }

}