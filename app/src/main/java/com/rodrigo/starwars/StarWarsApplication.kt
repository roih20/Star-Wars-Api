package com.rodrigo.starwars

import android.app.Application
import com.rodrigo.starwars.api.API
import com.rodrigo.starwars.repository.StarWarsRepository

class StarWarsApplication: Application() {

    val repository by lazy {
        StarWarsRepository(API)
    }
}