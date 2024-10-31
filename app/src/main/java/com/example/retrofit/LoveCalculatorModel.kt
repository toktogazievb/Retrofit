package com.example.retrofit

import android.util.Log
import com.example.retrofit.data.Services.RetrofitService
import com.example.retrofit.data.model.PercentageModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorModel {

    fun fetchData(firstName: String, secondName: String, callback: LoveCalculatorCallback) {
        RetrofitService.api.fetchPercentage(
            firstName = firstName,
            secondName = secondName,
            host = "love-calculator.p.rapidapi.com",
            key = "13db8c0c9fmsh0e8b65404615b3ap1035a5jsn85bfe5faab5c"
        ).enqueue(object : Callback<PercentageModel> {
            override fun onResponse(
                call: Call<PercentageModel>,
                response: Response<PercentageModel?>
            ) {
                if (response.body() != null && response.isSuccessful) {
                    callback.onSuccess(
                        percentageModel = PercentageModel(
                            fname = response.body()!!.fname,
                            sname = response.body()!!.sname,
                            result = response.body()!!.result,
                            percentage = response.body()!!.percentage
                        )
                    )
                }
            }

            override fun onFailure(call: Call<PercentageModel>, t: Throwable) {
                callback.onFailure(t.localizedMessage ?: "Unknown")
            }
        })
    }
}