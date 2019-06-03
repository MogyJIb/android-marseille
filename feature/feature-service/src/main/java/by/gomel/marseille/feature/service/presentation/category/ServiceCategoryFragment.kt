package by.gomel.marseille.feature.service.presentation.category


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import by.gomel.marseille.core.base.utils.bind
import by.gomel.marseille.core.base.utils.hide
import by.gomel.marseille.core.base.utils.show
import by.gomel.marseille.data.models.ServiceCategory
import by.gomel.marseille.feature.service.R
import by.gomel.marseille.feature.service.domain.init
import by.gomel.marseille.feature.service.presentation.BaseServiceFragment
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.fragment_service_category.*
import org.koin.android.ext.android.inject


class ServiceCategoryFragment : BaseServiceFragment(), ServiceCategoryContract.View {

    override val presenter: ServiceCategoryContract.Presenter by inject()

    private var selectedCategory: ServiceCategory? = null
    private var categories: List<ServiceCategory> = emptyList()
    private val pagerAdapter = ViewPagerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View
        = inflater.inflate(R.layout.fragment_service_category, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Услуги")

        categories_chip_group.setOnCheckedChangeListener { group, checkedId ->
            categories
                .find { it.title == group.bind<Chip>(checkedId).text }
                ?.let {
                    if (selectedCategory != it) {
                        selectedCategory = it
                        presenter.clearCart()
                    }
                }
        }

        if (categories.isEmpty()) {
            presenter.loadCategories()
        } else {
            initChips()
        }

        view_pager.adapter = pagerAdapter
        tab_layout.setupWithViewPager(view_pager)

        presenter.loadCartData()

        choose_service.setOnClickListener {
            selectedCategory?.run { coordinator.toServices(this) }
        }
        choose_employee.setOnClickListener {
            selectedCategory?.run { coordinator.toEmployeeList(this) }
        }

        clear_button.setOnClickListener { presenter.clearCart() }
    }

    override fun updateCategories(categories: List<ServiceCategory>) {
        this.categories = categories
        initChips()
    }

    private fun initChips() {
        categories_chip_group.init(
            categories.map { it.title },
            (selectedCategory ?: categories.first()).title
        )
    }

    override fun updateCartData(services: String?, employee: String?, amount: Double) {
        services_text_view.run {
            show()
            services?.let { text = it } ?: hide()
        }
        employees_text_view.run {
            show()
            employee?.let { text = it } ?: hide()
        }
        amount_text_view.text = amount.toString()
    }

}

class ViewPagerAdapter : PagerAdapter() {

    override fun isViewFromObject(view: View, obj: Any): Boolean = view == obj
    override fun getCount(): Int = 2

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(
            if (position == 0) R.layout.date_picker_layout else R.layout.time_picker_layout,
            container,
            false
        )
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any)
        = container.removeView(obj as View)

    override fun getPageTitle(position: Int): CharSequence = if (position == 0) "Дата" else "Время"

}