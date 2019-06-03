package by.gomel.marseille.feature.service.presentation.employee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.gomel.marseille.core.base.utils.getArgument
import by.gomel.marseille.core.base.utils.toast
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.R
import by.gomel.marseille.feature.service.presentation.BaseServiceFragment
import kotlinx.android.synthetic.main.fragment_employee_list.*
import org.koin.android.ext.android.inject


class EmployeeListFragment : BaseServiceFragment(), EmployeeListContract.View {

    override val presenter: EmployeeListContract.Presenter by inject()

    private lateinit var employeeAdapter: EmployeeAdapter

    companion object {
        @JvmStatic
        fun newInstance(category: ServiceCategory) = EmployeeListFragment().apply {
            arguments = bundleOf("category" to category)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_employee_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        employeeAdapter = EmployeeAdapter().apply { onClickListener = presenter::selectEmployee }
        employee_recycler_view.adapter = employeeAdapter

        getArgument<ServiceCategory>("category")?.apply {
            setTitle(title)
            presenter.initEmployees(this)
        }
    }

    override fun updateEmployees(employees: List<Employee>)
        = employeeAdapter.updateItems(employees.toMutableList())

    override fun isShowBackButton() = true

    override fun onSelectEmployeeSuccess() {
        coordinator.backToCategory()
    }

}