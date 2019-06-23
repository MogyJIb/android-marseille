package by.gomel.marseille.feature.goods.presentation.cart

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import by.gomel.marseille.core.base.view.BaseRecyclerViewAdapter
import by.gomel.marseille.core.base.view.BaseViewHolder
import by.gomel.marseille.data.models.GoodsCartDto
import by.gomel.marseille.feature.goods.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cart_list_item.view.*
import org.koin.standalone.inject


class CartAdapter : BaseRecyclerViewAdapter<GoodsCartDto, CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_list_item, parent, false)
        return CartViewHolder(itemView) { item: GoodsCartDto -> removeItem(item) }
    }

    class CartViewHolder(
            itemView: View,
            private val onRemove: (item: GoodsCartDto) -> Unit
    ) : BaseViewHolder<GoodsCartDto>(itemView) {

        private val presenter: CartItemContract.Presenter by inject()

        private val isAdd = itemView.is_add_check_box
        private val goodsName = itemView.goods_name
        private val goodsPrice = itemView.goods_price
        private val counter = itemView.counter_text_view
        private val incrementButton = itemView.button_increment_counter
        private val decrementButton = itemView.button_decrement_counter
        private val iconIV = itemView.goods_icon
        private val removeButton = itemView.remove_goods_button

        override fun onDataBinded(data: GoodsCartDto) {
            isAdd.isChecked = data.checked
            isAdd.setOnCheckedChangeListener { _, isChecked ->
                data.checked = isChecked
                presenter.updateCartWithItem(data)
            }
            goodsName.text = data.goods.name
            updateCount()

            incrementButton.setOnClickListener {
                data.count++
                updateCount()
            }

            decrementButton.setOnClickListener {
                if (data.count > 1) {
                    data.count--
                    updateCount()
                }
            }

            removeButton.setOnClickListener {
                presenter.onItemDeleteButtonClicked(data)
                onRemove(data)
            }

            runCatching {
                Glide.with(itemView)
                    .load(data.goods.imageUrl)
                    .into(iconIV)
            }

        }

        private fun updateCount() {
            goodsPrice.text = "${data.totalPrice} BYN"
            counter.text = data.count.toString()
            presenter.updateCartWithItem(data)
        }

    }
}