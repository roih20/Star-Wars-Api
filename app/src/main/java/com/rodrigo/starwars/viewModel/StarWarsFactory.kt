package com.rodrigo.starwars.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rodrigo.starwars.repository.StarWarsRepository
import java.lang.Exception

class StarWarsFactory(private val repository: StarWarsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StarWarsViewModel::class.java)){
            return StarWarsViewModel(repository) as T
        }
        throw Exception("Unknown ViewModel class")
    }
}