package com.special.robinhood.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int) {
    this.supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    this.supportFragmentManager.inTransaction { replace(frameId, fragment) }
}