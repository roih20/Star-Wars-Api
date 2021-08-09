package com.rodrigo.starwars.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("people")
    suspend fun getAllPeople(): Response<Results>

}