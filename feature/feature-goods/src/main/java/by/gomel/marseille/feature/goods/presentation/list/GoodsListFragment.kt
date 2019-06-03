package by.gomel.marseille.feature.goods.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DividerItemDecoration
import by.gomel.marseille.core.base.utils.addItemDecoration
import by.gomel.marseille.core.base.utils.getArgument
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.feature.goods.R
import by.gomel.marseille.feature.goods.presentation.BaseGoodsFragment
import kotlinx.android.synthetic.main.fragment_goods_list.*
import org.koin.android.ext.android.inject


class GoodsListFragment : BaseGoodsFragment(), GoodsListContract.View {

    override val presenter: GoodsListContract.Presenter by inject()

    private lateinit var goodsAdapter: GoodsAdapter

    companion object {
        @JvmStatic
        fun newInstance(category: GoodsCategory) = GoodsListFragment().apply {
            arguments = bundleOf("category" to category)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_goods_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goodsAdapter = GoodsAdapter().apply { onClickListener = coordinator::toDetail }

        goods_recycler_view.apply {
            adapter = goodsAdapter
            addItemDecoration(DividerItemDecoration.VERTICAL, R.drawable.list_divider)
        }

        getArgument<GoodsCategory>("category")?.apply {
            setTitle(title)
            presenter.initGoods(this)
        }
    }

    override fun updateGoods(goods: List<Goods>) = goodsAdapter.updateItems(goods.toMutableList())
    override fun isShowBackButton() = true

}