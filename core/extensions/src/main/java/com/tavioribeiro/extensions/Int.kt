package core.extensions

import android.content.res.Resources

fun Int?.orZero() = this ?: 0

val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()
