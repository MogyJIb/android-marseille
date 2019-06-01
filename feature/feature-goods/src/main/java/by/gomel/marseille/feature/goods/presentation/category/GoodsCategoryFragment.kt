package by.gomel.marseille.feature.goods.presentation.category


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.feature.goods.R
import by.gomel.marseille.feature.goods.presentation.BaseGoodsFragment
import kotlinx.android.synthetic.main.fragment_goods_category.*
import org.koin.android.ext.android.inject


class GoodsCategoryFragment : BaseGoodsFragment(),
    GoodsCategoryContract.View {

    override val presenter: GoodsCategoryContract.Presenter by inject()

    private lateinit var productCategoryAdapter: GoodsCategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View
        = inflater.inflate(R.layout.fragment_goods_category, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTitle("Продукция")

        /* Init adapter and set up recycler view */
        productCategoryAdapter = GoodsCategoryAdapter()
        productCategoryAdapter.onClickListener = coordinator::toGoodsCategory

        category_recycler_view.adapter = productCategoryAdapter

        presenter.initData()
    }

    override fun updateCategories(categories: List<GoodsCategory>)
            = productCategoryAdapter.updateItems(categories.toMutableList())

}