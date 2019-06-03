package by.gomel.marseille.feature.service.domain

import android.content.Context
import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import by.gomel.marseille.feature.service.R
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup


fun ChipGroup.init(items: List<String>, checkedItem: String = items.first()) = items.forEach { item ->
    val chip = Chip(context).apply {
        id = View.generateViewId()
        text = item
        isCheckable = true
        isCheckedIconVisible = true
        chipBackgroundColor = chipBackground()
    }
    addView(chip)
    if (item == checkedItem) check(chip.id)
}

private fun Chip.chipBackground(): ColorStateList {
    val states = arrayOf(
        intArrayOf(android.R.attr.state_selected),
        intArrayOf()
    )

    val colors = intArrayOf(
        ContextCompat.getColor(context, R.color.chip_background_selected),
        ContextCompat.getColor(context, R.color.chip_background)
    )
    return ColorStateList(states, colors)
}