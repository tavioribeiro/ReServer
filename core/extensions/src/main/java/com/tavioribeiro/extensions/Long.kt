package core.extensions

import android.content.res.Resources

fun Long?.orZero() = this ?: 0
