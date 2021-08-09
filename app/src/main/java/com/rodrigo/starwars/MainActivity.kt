package com.rodrigo.starwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.rodrigo.starwars.databinding.ActivityMainBinding
import com.rodrigo.starwars.viewModel.StarWarsFactory
import com.rodrigo.starwars.viewModel.StarWarsViewModel

class MainActivity : AppCompatActivity() {

    private val starWarsApp by lazy {
        application as StarWarsApplication
    }

    private val starWarsFactory : StarWarsFactory by lazy {
        StarWarsFactory(starWarsApp.repository)
    }

    private val starWarsViewModel : StarWarsViewModel by viewModels{
        starWarsFactory
    }

    private var _binding : ActivityMainBinding ?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            viewModel = starWarsViewModel
            lifecycleOwner = this@MainActivity
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}