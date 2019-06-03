package by.gomel.marseille.core.base.utils

import android.view.View
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


inline fun <reified T : View> View.bind(@IdRes id: Int) = this.findViewById(id) as T

inline fun <reified T : View> Fragment.bindView(@IdRes id: Int)
        = lazy(LazyThreadSafetyMode.NONE) { this.view?.findViewById(id) as T }

inline fun <reified T : View> RecyclerView.ViewHolder.bindView(@IdRes id: Int)
        = lazy(LazyThreadSafetyMode.NONE) { this.itemView.findViewById(id) as T }


fun RecyclerView.addItemDecoration(orientation: Int, @DrawableRes res: Int)
        = addItemDecoration(
            DividerItemDecoration(context, orientation).apply { context.getDrawable(res)?.let { setDrawable(it) } }
        )

fun View.show() = this.apply { visibility = View.VISIBLE }
fun View.hide() = this.apply { visibility = View.GONE }