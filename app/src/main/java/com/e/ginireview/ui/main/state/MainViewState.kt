package com.e.kotlinexample.ui.main.state

import com.e.ginireview.model.NumberModel


data class MainViewState(
    var numbers: List<NumberModel>? = null
)