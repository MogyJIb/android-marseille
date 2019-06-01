package by.gomel.marseille.feature.goods.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.gomel.marseille.core.base.view.BaseRecyclerViewAdapter
import by.gomel.marseille.core.base.view.BaseViewHolder
import by.gomel.marseille.data.models.Goods
import by.gomel.marseille.feature.goods.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.goods_list_item.view.*


class GoodsAdapter : BaseRecyclerViewAdapter<Goods, GoodsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.goods_list_item, parent, false)
        return GoodsViewHolder(itemView)
    }
    
}


class GoodsViewHolder(
        itemView: View
) : BaseViewHolder<Goods>(itemView) {

    private val nameTV = itemView.goods_name
    private val priceTV = itemView.goods_price
    private val iconIV = itemView.goods_icon

    override fun onDataBinded(data: Goods) {
        nameTV.text = data.name
        priceTV.text = "${data.price} BIN"

        runCatching {
            Glide.with(itemView)
                .load(data.imageUrl)
                .into(iconIV)
        }
    }

}