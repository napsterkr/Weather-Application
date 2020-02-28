package com.example.myassignment.dataModel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public data class ListEntity(
    @Expose
    @SerializedName("dt")
    var dt: Int,
    @Expose
    @SerializedName("main")
    var main: MainEntity,
    @Expose
    @SerializedName("weather")
    var weatherEntity: List<WeatherEntity>,
    @Expose
    @SerializedName("clouds")
    var clouds: CloudsEntity,
    @Expose
    @SerializedName("wind")
    var wind: WindEntity,
    @Expose
    @SerializedName("sys")
    var sys: SysEntity,
    @Expose
    @SerializedName("dt_txt")
    val dt_txt: String
)

public data class SysEntity(
    @Expose
    @SerializedName("pod")
    val pod: String
)


public data class WindEntity(
    @Expose
    @SerializedName("speed")
    val speed: Double,
    @Expose
    @SerializedName("deg")
    var deg: Double
)

public data class CloudsEntity(
    @Expose
    @SerializedName("all")
    var all: Int
)

public data class WeatherEntity(
    @Expose
    @SerializedName("id")
    var id: Int,
    @Expose
    @SerializedName("main")
    val main: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("icon")
    val icon: String
)

public data class MainEntity(
    @Expose
    @SerializedName("temp")
    val temp: Double,
    @Expose
    @SerializedName("feels_like")
    val feels_like: Double,
    @Expose
    @SerializedName("temp_min")
    val temp_min: Double,
    @Expose
    @SerializedName("temp_max")
    val temp_max: Double,
    @Expose
    @SerializedName("pressure")
    var pressure: Double,
    @Expose
    @SerializedName("sea_level")
    var sea_level: Double,
    @Expose
    @SerializedName("grnd_level")
    var grnd_level: Double,
    @Expose
    @SerializedName("humidity")
    var humidity: Double,
    @Expose
    @SerializedName("temp_kf")
    var temp_kf: Double
)