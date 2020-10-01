package com.e.ginireview.repo

import androidx.lifecycle.LiveData
import com.e.ginireview.api.RetrofitBuilder
import com.e.ginireview.api.response.NumbersListResponse
import com.e.kotlinexample.ui.main.state.MainViewState
import com.e.kotlinexample.util.ApiSuccessResponse
import com.e.kotlinexample.util.DataState
import com.e.kotlinexample.util.GenericApiResponse

object Repository {
    fun getNumbers(): LiveData<DataState<MainViewState>> {
        return object : NetworkBoundResource<NumbersListResponse, MainViewState>() {

            override fun handleApiSuccessResponse(response: ApiSuccessResponse<NumbersListResponse>) {
                result.value = DataState.data(
                    null,
                    MainViewState(
                        numbers = response.body.numbersToList()
                    )
                )
            }

            override fun createCall(): LiveData<GenericApiResponse<NumbersListResponse>> {
                return RetrofitBuilder.apiService.getNumbers()
            }

        }.asLiveData()
    }
}