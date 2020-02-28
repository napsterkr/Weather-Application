package com.example.myassignment.interfaces

import com.example.myassignment.dataModel.WeatherApiResponeData
import retrofit2.Response
import retrofit2.http.GET

interface ToDoApi {
    //a864a9946bb06d4163ab0c95bf01e465
    //@GET("forecast?zip={zipCode},{countryCode}&appid={appId}")
    @GET("forecast?zip=122007,in&appid=a864a9946bb06d4163ab0c95bf01e465")
    suspend fun getWeatherData(
        /*@Query("zipCode") zipCode: Long, @Query("countryCode") countryCode: String, @Query(
            "appId"
        ) appId: String*/
    ): Response<WeatherApiResponeData>

}