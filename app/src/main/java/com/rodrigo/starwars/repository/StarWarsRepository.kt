package com.rodrigo.starwars.repository

import com.rodrigo.starwars.api.API
import com.rodrigo.starwars.api.Results
import com.rodrigo.starwars.api.StarWarsPeople
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class StarWarsRepository(private val API: API) {


    suspend fun getCharacters(): Response<Results> {
        return withContext(Dispatchers.IO){
            API.service.getAllPeople()
        }
    }
}