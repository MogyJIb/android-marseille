package by.gomel.marseille.feature.goods.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import by.gomel.marseille.core.base.utils.getArgument
import by.gomel.marseille.core.base.utils.toast
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.feature.goods.R
import by.gomel.marseille.feature.goods.presentation.BaseGoodsFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_goods_details.*
import org.koin.android.ext.android.inject


class GoodsDetailFragment : BaseGoodsFragment(), GoodsDetailContract.View {

    override val presenter: GoodsDetailContract.Presenter by inject()

    private lateinit var goods: Goods

    companion object {
        @JvmStatic fun newInstance(goods: Goods) = GoodsDetailFragment().apply {
            arguments = bundleOf("goods" to goods)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
            = inflater.inflate(R.layout.fragment_goods_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArgument<Goods>("goods")?.apply {
            goods = this
            setTitle(name)
            goods_description.text = description
            runCatching { Glide.with(this@GoodsDetailFragment).load(imageUrl).into(goods_icon) }
            goods_price.text = "$price BIN"
        }

        button_add_purchase.setOnClickListener {
            presenter.onAddToPurchaseClicked(goods)
        }
    }

    override fun onGoodsAdded() {
        context?.toast("\"${goods.name}\" добавлено в корзину")
    }

    override fun isShowBackButton(): Boolean = true

}