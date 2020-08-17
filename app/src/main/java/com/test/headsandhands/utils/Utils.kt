package com.test.headsandhands.utils

import android.app.Activity
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.toast(any: Any?) = Toast.makeText(this.requireContext(), any.toString(), Toast.LENGTH_SHORT).show()

fun logd(any: Any?) = Log.d("DEBUG", any.toString())

fun Activity.hideSoftKeyboard() {
    currentFocus?.let {
        val inputMethodManager = ContextCompat.getSystemService(this, InputMethodManager::class.java)!!
        inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
    }
}