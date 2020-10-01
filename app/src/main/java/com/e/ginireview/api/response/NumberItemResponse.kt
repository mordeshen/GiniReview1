package com.e.ginireview.api.response

import com.e.ginireview.model.NumberModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NumberItemResponse(
    @Expose
    @SerializedName("number")
    val number: Int? = null
) {
    fun toNumber(): NumberModel {
        return NumberModel(
            number,
            false
        )
    }

}