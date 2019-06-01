package by.gomel.marseille.core.base.utils

import android.content.res.ColorStateList
import android.graphics.Color
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.util.*


fun ChipGroup.init(items: List<String>) {
    val rand = Random()
    val states = arrayOf(
        intArrayOf(android.R.attr.state_selected),
        intArrayOf()
    )
    val chipCheckedBackground = Color.argb(255, 74, 144, 226)

    items.forEach { item ->
        val chipBackground = Color.argb(30, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256))
        val chip = Chip(context).apply {
            text = item
            isCheckable = true
            isCheckedIconVisible = true
            chipBackgroundColor = ColorStateList(states, intArrayOf(chipCheckedBackground, chipBackground))
        }
        addView(chip)
    }
}