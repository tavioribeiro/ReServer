package com.tavioribeiro.components

import android.util.Log

fun log(valor: Any?, tag: String? = null, cor: String? = null) {
    val tagToUse = tag ?: "MinhaTag"
    if (BuildConfig.DEBUG){
        if(cor == null) Log.i(tagToUse, (valor?.toString() ?: "null"))
        if(cor == "e") Log.e(tagToUse, (valor?.toString() ?: "null"))
        if(cor == "d") Log.d(tagToUse, (valor?.toString() ?: "null"))
        if(cor == "i") Log.i(tagToUse, (valor?.toString() ?: "null"))
    }
}