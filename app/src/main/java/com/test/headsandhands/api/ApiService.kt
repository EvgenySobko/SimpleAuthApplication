package com.test.headsandhands.api

import com.test.headsandhands.entities.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather?")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double? = 59.939034,
        @Query("lon") longitude: Double? = 30.315787,
        @Query("APPID") appid: String = "479f4c3a4051df749007df0c10a7a1b6"
    ): Response
}