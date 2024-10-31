package com.example.retrofit.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.retrofit.LoveCalculatorContract
import com.example.retrofit.LoveCalculatorPresenter
import com.example.retrofit.R
import com.example.retrofit.data.model.PercentageModel
import com.example.retrofit.databinding.FragmentLoveCalculatorBinding
import com.example.retrofit.ui.activity.MainActivity

class LoveCalculatorFragment : Fragment(), LoveCalculatorContract {

    private val binding by lazy { FragmentLoveCalculatorBinding.inflate(layoutInflater) }
    private val presenter by lazy {
        (activity as MainActivity).getPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setupListeners()
    }

    private fun init() {
        presenter.attachLoveCalcContract(this)
    }

    private fun setupListeners() {
        binding.btnCalculate.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val secondName = binding.etSecondName.text.toString()
            if (!(firstName.equals("")) && !(secondName.equals(""))) {
                binding.apply {
                    presenter.onResultClicked(firstName, secondName)
                    findNavController().navigate(R.id.action_loveCalculatorFragment_to_scoreFragment)
                    etFirstName.text?.clear()
                    etSecondName.text?.clear()
                }
            }else Toast.makeText(context, "Names are empty", Toast.LENGTH_LONG).show()
        }
    }

    override fun showResult(percentageModel: PercentageModel) {
    }

    override fun errorToast(message: String) {
    }
}