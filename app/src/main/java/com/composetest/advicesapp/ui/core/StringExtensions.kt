package com.composetest.advicesapp.ui.core

fun String?.allToUppercase(): String {
    return this?.uppercase() ?: ""
}

fun String?.allToLowercase(): String {
    return this?.lowercase() ?: ""
}