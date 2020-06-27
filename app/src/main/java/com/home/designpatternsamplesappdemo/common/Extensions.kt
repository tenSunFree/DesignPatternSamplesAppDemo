package com.home.designpatternsamplesappdemo.common

import android.app.Activity
import android.content.Intent

internal inline fun <reified T> Activity.navigateTo(noinline intentExtras: ((Intent) -> Unit)? = null) {
    val intent = Intent(this, T::class.java)
    intentExtras?.run { intentExtras(intent) }
    startActivity(intent)
}