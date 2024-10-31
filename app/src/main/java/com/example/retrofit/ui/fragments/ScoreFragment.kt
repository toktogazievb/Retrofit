package com.example.retrofit.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.retrofit.LoveCalculatorContract
import com.example.retrofit.LoveCalculatorPresenter
import com.example.retrofit.R
import com.example.retrofit.data.model.PercentageModel
import com.example.retrofit.databinding.FragmentScoreBinding
import com.example.retrofit.ui.activity.MainActivity

class ScoreFragment : Fragment(), LoveCalculatorContract {

    private val binding by lazy {
        FragmentScoreBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAgain.setOnClickListener { findNavController().navigateUp() }
        val presenter = (activity as MainActivity).getPresenter()
        presenter.attachLoveCalcContract(this)
    }

    override fun showResult(percentageModel: PercentageModel)= with(binding){
        Log.d("ScoreFragment", "showResult: $percentageModel")
        txtFirstName.text = percentageModel.fname
        txtSecondName.text = percentageModel.sname
        txtPercentage.text = percentageModel.percentage.toString() + "%"
        txtResult.text = percentageModel.result
    }

    override fun errorToast(message: String) {
    }
}