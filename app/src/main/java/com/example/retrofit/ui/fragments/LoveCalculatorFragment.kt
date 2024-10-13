package com.example.retrofit.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.retrofit.R
import com.example.retrofit.databinding.FragmentLoveCalculatorBinding

class LoveCalculatorFragment : Fragment() {

    private val binding by lazy { FragmentLoveCalculatorBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHistory.setOnClickListener{
            findNavController().navigate(R.id.historyFragment)
        }
    }
}