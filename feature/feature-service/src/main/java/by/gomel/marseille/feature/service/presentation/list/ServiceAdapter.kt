package by.gomel.marseille.feature.service.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.core.base.view.BaseRecyclerViewAdapter
import by.gomel.marseille.core.base.view.BaseViewHolder
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.feature.service.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.service_list_item.view.*
import org.koin.standalone.inject


class ServiceAdapter : BaseRecyclerViewAdapter<Service, ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_list_item, parent, false)
        return ServiceViewHolder(itemView)
    }
    
}


class ServiceViewHolder(
        itemView: View
) : BaseViewHolder<Service>(itemView), ServiceItemContract.View {

    private val presenter: ServiceItemContract.Presenter by inject()

    private val nameTV = itemView.service_name
    private val priceTV = itemView.service_price
    private val checkBox = itemView.check_box

    override fun onDataBinded(data: Service) {
        nameTV.text = data.name
        priceTV.text = "${data.price} BYN"
        checkBox.apply {
            isChecked = presenter.checkServiceInCart(data)
            setOnCheckedChangeListener { _, isChecked -> presenter.onChecked(data, isChecked) }
        }
    }

}