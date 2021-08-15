package com.rodrigo.starwars.api

data class Results (
    var count: Int,
    var next: String?,
    var previous: String?,
    var results: ArrayList<StarWarsPeople>

)