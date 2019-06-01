package by.gomel.marseille.core.base.view

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.gomel.marseille.core.base.utils.OnClickListener
import by.gomel.marseille.core.base.utils.OnLongClickListener
import org.koin.standalone.KoinComponent


abstract class BaseRecyclerViewAdapter<T : Any, H : BaseViewHolder<T>> : RecyclerView.Adapter<H>() {

    var items: MutableList<T> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClickListener: OnClickListener<T>? = null
    var onLongClickListener: OnLongClickListener<T>? = null

    override fun onBindViewHolder(holder: H, position: Int) {
        holder.onClickListener = onClickListener
        holder.onLongClickListener = onLongClickListener
        holder.bindData(items[position])
    }

    override fun getItemCount() = items.size

    open fun updateItems(items: MutableList<T>) {
        val diffResult = DiffUtil.calculateDiff(DiffCallback(this.items, items))
        this.items = items
        diffResult.dispatchUpdatesTo(this)
    }

    open fun clearItems() {
        this.items = mutableListOf()
        notifyDataSetChanged()
    }

    open fun removeItem(item: T) {
        val position = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(position)
    }

    open fun addItem(item: T) {
        items.add(item)
        val position = items.indexOf(item)
        notifyItemInserted(position)
    }

    override fun onViewDetachedFromWindow(holder: H) {
        holder.release()
        super.onViewDetachedFromWindow(holder)
    }

    open fun release() {
        onClickListener = null
        onLongClickListener = null
    }

}


abstract class BaseViewHolder<T : Any>(
    itemView: View
) : RecyclerView.ViewHolder(itemView), BaseContract.View, KoinComponent {

    protected lateinit var data: T

    var onClickListener: OnClickListener<T>? = null
        set(value) {
            value?.let { listener ->
                itemView.setOnClickListener { listener(data) }
                field = listener
            }
        }

    var onLongClickListener: OnLongClickListener<T>? = null
        set(value) {
            value?.let { listener ->
                itemView.setOnLongClickListener { listener(data) }
                field = listener
            }
        }

    fun bindData(data: T) {
        this.data = data
        onDataBinded(data)
    }

    open fun release() {
        onClickListener = null
        onLongClickListener = null

        itemView.run {
            setOnClickListener(null)
            setOnLongClickListener(null)
        }
    }

    abstract fun onDataBinded(data: T)

}


class DiffCallback(
    private val oldItems: List<*>,
    private val newItems: List<*>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size
    override fun getNewListSize() = newItems.size

    override fun areContentsTheSame(oldPos: Int, newPos: Int) = (oldItems[oldPos] == newItems[newPos])
    override fun areItemsTheSame(oldPos: Int, newPos: Int) = (oldItems[oldPos] === newItems[newPos])

}
