package com.example.retrofit

import android.util.Log
import com.example.retrofit.data.model.PercentageModel

class LoveCalculatorPresenter {

    private var contract: LoveCalculatorContract? = null
    private var model = LoveCalculatorModel()

    fun attachLoveCalcContract(contract: LoveCalculatorContract) {
        this.contract = contract
    }

    fun onResultClicked(firstName: String, secondName: String) {
        model.fetchData(firstName, secondName, object : LoveCalculatorCallback {
            override fun onSuccess(percentageModel: PercentageModel) {
                contract?.showResult(percentageModel)
                Log.d("Presenter", "onSuccess: $percentageModel")
            }

            override fun onFailure(message: String) {
                contract?.errorToast(message)
            }
        })
    }
}