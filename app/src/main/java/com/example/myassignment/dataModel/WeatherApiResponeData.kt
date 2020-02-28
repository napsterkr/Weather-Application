package com.example.myassignment.dataModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*   {"city": {
"name": "Jalan Hospital Bhiwani",
"coord": {
    "lat": 28.8,
    "lon": 76.1916
},
"country": "IN",
"timezone": 19800,
"sunrise": 1582852953,
"sunset": 1582894420
}
}*/

data class WeatherApiResponeData(
    @Expose
    @SerializedName("cod") var cod: String,
    @Expose
    @SerializedName("message") var message: String,
    @Expose
    @SerializedName("cnt") var cnt: Int,
    @Expose
    @SerializedName("list") var list: List<ListEntity>?= ArrayList<ListEntity>() ,
    @Expose
    @SerializedName("city")
    var city: City
)

data class City(
    @Expose
    @SerializedName("name") var name: String,
    @Expose
    @SerializedName("coord") var coord: Coordinates,
    @Expose
    @SerializedName("country") var country: String,
    @Expose
    @SerializedName("timezone") var timezone: Long,
    @Expose
    @SerializedName("sunrise") var sunrise: Long,
    @Expose
    @SerializedName("sunset") var sunset: Long
)

data class Coordinates(
    @Expose
    @SerializedName("lat") var lat: Double,
    @Expose
    @SerializedName("lon") var lon: Double
)
