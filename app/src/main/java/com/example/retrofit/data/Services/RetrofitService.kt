package com.example.retrofit.data.Services

import com.example.retrofit.data.model.PercentageModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.create

object RetrofitService {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com/")
        .build()

    val service = retrofit.create<LoveApiService>()
}