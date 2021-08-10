package com.rodrigo.starwars.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("people")
    suspend fun getAllPeople(): Response<Results>

}