package com.example.retrofit.data.model

import com.google.gson.annotations.SerializedName

data class PercentageModel(
    @SerializedName("fname")
    val fname: String,
    @SerializedName("sname")
    val sname: String,
    @SerializedName("percentage")
    val percentage: Int,
    @SerializedName("result")
    val result: String
)

