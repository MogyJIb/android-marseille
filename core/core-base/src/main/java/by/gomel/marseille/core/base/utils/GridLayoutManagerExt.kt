package by.gomel.marseille.core.base.utils

import androidx.recyclerview.widget.GridLayoutManager


fun GridLayoutManager.fillLastItemMatchParent() = this.apply {
    spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
        override fun getSpanSize(position: Int): Int
                = if (position == itemCount - 1 && itemCount % spanCount == 1) spanCount else 1
    }
}