package com.rodrigo.starwars.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.starwars.api.Results
import com.rodrigo.starwars.api.StarWarsPeople
import com.rodrigo.starwars.repository.StarWarsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class StarWarsViewModel(private val repository: StarWarsRepository): ViewModel() {

    private var _loading = MutableLiveData(View.GONE)
    val loading: LiveData<Int?> get() = _loading
    var characterList = MutableLiveData<Results>()

    fun getCharacters(){
        _loading.value = View.VISIBLE
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                characterList.value = response
            }catch (error: HttpException){
                Log.d("Error", error.message())
            }finally {
                _loading.value = View.GONE
            }
        }
    }
}