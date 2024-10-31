package com.example.retrofit.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import com.example.retrofit.LoveCalculatorPresenter
import com.example.retrofit.R
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.ui.fragments.LoveCalculatorFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navController by lazy {
        val navHostController =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navHostController.navController
    }
    private val presenter = LoveCalculatorPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        btnHome.setOnClickListener {
            navController.navigate(R.id.loveCalculatorFragment)
        }
        btnHistory.setOnClickListener {
            navController.navigate(R.id.historyFragment)
        }
    }

    fun getPresenter(): LoveCalculatorPresenter {
        return presenter
    }
}