package by.gomel.marseille.core.base.utils

import android.content.res.Resources


val Any.className: String
    get() = this::class.java.simpleName

fun<T> catch(action: () -> T) = runCatching { action() }.getOrNull()

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun String.emptyToNull() = if (this.isEmpty()) null else this

fun Boolean?.get() = this == true