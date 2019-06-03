package by.gomel.marseille.feature.service.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.core.base.utils.catch
import by.gomel.marseille.core.base.utils.getArgument
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.data.models.Service
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.R
import by.gomel.marseille.feature.service.presentation.BaseServiceFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_service_list.*
import org.koin.android.ext.android.inject


class ServiceListFragment : BaseServiceFragment(), ServiceListContract.View {

    override val presenter: ServiceListContract.Presenter by inject()

    private lateinit var serviceAdapter: ServiceAdapter

    companion object {
        @JvmStatic
        fun newInstance(category: ServiceCategory) = ServiceListFragment().apply {
            arguments = bundleOf("category" to category)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_service_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        serviceAdapter = ServiceAdapter()
        service_recycler_view.adapter = serviceAdapter

        getArgument<ServiceCategory>("category")?.apply {
            setTitle(title)
            
            presenter.initService(this)

            Glide.with(this@ServiceListFragment)
                .load(iconUrl)
                .into(service_category_icon)
        }

        save_button.setOnClickListener { coordinator.backToCategory() }
    }

    override fun updateServices(services: List<Service>) = serviceAdapter.updateItems(services.toMutableList())
    override fun isShowBackButton() = true

}