package com.e.ginireview.api.response

import com.e.ginireview.model.NumberModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NumbersListResponse(

    @Expose
    @SerializedName("numbers")
    var numbers: List<NumberItemResponse>
) {
    fun numbersToList(): List<NumberModel> {
        val numList: ArrayList<NumberModel> = ArrayList()
        var numCurrent: NumberModel
        for (numResponse in numbers) {
            numCurrent = numResponse.toNumber()
            for (numResponseToComparison in numbers) {
                if (numCurrent.number!! + numResponseToComparison.number!! == 0) {
                    numCurrent.isPairToResult0 = true
                }
            }
            numList.add(
                numCurrent
            )
        }
        return numList
    }
}