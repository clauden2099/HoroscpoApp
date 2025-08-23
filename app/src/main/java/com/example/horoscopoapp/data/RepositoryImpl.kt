package com.example.horoscopoapp.data

import android.util.Log
import com.example.horoscopoapp.data.network.HoroscopeApeService
import com.example.horoscopoapp.domain.Repository
import com.example.horoscopoapp.domain.model.PredictionModel
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApeService) : Repository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        //Peticion Retrofit
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("aris","Ha ocurrido un error ${it.message}") }
        return null
    }

}