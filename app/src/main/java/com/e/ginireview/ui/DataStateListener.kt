package com.e.ginireview.ui

import com.e.kotlinexample.util.DataState

interface DataStateListener {
    fun onDataStateChange(dataState: DataState<*>?)
}