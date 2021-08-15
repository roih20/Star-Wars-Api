package com.rodrigo.starwars.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    @GET("people")
    suspend fun getAllPeople(): Results



}