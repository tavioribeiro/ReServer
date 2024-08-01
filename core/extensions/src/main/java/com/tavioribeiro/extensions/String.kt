package core.extensions

import android.text.TextUtils
import android.util.Patterns.PHONE
import android.util.Patterns.EMAIL_ADDRESS
import android.webkit.URLUtil
import java.lang.Double.parseDouble

fun String.isValidEmail(): Boolean {
    return !TextUtils.isEmpty(this) && EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isPhoneNumber(): Boolean {
    return PHONE.matcher(this).matches()
}

fun String.isUrl(): Boolean {
    return URLUtil.isValidUrl(this)
}

fun String.isNumeric(): Boolean {
    return try {
        parseDouble(this)
        true
    } catch (nfe: NumberFormatException) {
        false
    }
}


fun String.normalizarString(input: String): String    //retorna uma string sem caracteres especiais, com _ no lugar de espaços e apenas letras minúsculas.
{
    val normalizedString = input.replace("[^a-zA-Z0-9 ]".toRegex(), "").lowercase();
    return normalizedString.replace(" ", "_");
}



fun String.abbreviateText(maxLength: Int): String {
    if (this.length <= maxLength) {
        return this
    }

    val periodPos = this.indexOf('.', maxLength)

    return if (periodPos != -1) {
        this.substring(0, periodPos + 1)
    } else {
        this
    }
}