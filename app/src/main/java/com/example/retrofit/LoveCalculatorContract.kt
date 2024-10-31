package com.example.retrofit

import com.example.retrofit.data.model.PercentageModel

interface LoveCalculatorContract {

    fun showResult(percentageModel: PercentageModel)
    fun errorToast(message: String)
}

interface LoveCalculatorCallback {
    fun onSuccess(percentageModel: PercentageModel)
    fun onFailure(message: String)
}