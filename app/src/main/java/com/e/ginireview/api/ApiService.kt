package com.e.ginireview.api

import androidx.lifecycle.LiveData
import com.e.ginireview.api.response.NumbersListResponse
import com.e.kotlinexample.util.GenericApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("8wJzytQX")
    fun getNumbers(): LiveData<GenericApiResponse<NumbersListResponse>>
}