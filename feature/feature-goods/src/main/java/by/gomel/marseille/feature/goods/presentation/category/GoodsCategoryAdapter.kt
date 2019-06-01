package by.gomel.marseille.feature.goods.presentation.category

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import by.gomel.marseille.core.base.view.BaseRecyclerViewAdapter
import by.gomel.marseille.core.base.view.BaseViewHolder
import by.gomel.marseille.data.models.GoodsCategory
import by.gomel.marseille.feature.goods.R
import kotlinx.android.synthetic.main.goods_category_item.view.*


class GoodsCategoryAdapter : BaseRecyclerViewAdapter<GoodsCategory, GoodsCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsCategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.goods_category_item, parent, false)
        return GoodsCategoryViewHolder(itemView)
    }

}


class GoodsCategoryViewHolder(
        itemView: View
) : BaseViewHolder<GoodsCategory>(itemView) {

    private val nameTV = itemView.name_text_view

    override fun onDataBinded(data: GoodsCategory) { nameTV.text = data.title }

}