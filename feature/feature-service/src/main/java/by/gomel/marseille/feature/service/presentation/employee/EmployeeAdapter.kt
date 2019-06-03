package by.gomel.marseille.feature.service.presentation.employee

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.core.base.view.BaseRecyclerViewAdapter
import by.gomel.marseille.core.base.view.BaseViewHolder
import by.gomel.marseille.data.models.Employee
import by.gomel.marseille.feature.service.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.employee_list_item.view.*


class EmployeeAdapter : BaseRecyclerViewAdapter<Employee, EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.employee_list_item, parent, false)
        return EmployeeViewHolder(itemView)
    }
    
}


class EmployeeViewHolder(
        itemView: View
) : BaseViewHolder<Employee>(itemView) {

    private val nameTV = itemView.employee_name
    private val positionTV = itemView.employee_position
    private val iconIV = itemView.employee_icon

    override fun onDataBinded(data: Employee) {
        nameTV.text = data.name
        positionTV.text = data.position

        runCatching {
            Glide.with(itemView)
                .load(data.imageUrl)
                .into(iconIV)
        }
    }

}