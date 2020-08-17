package com.test.headsandhands.entities

data class Response(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val location: Location,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
) {
    fun getTemperature() = main.temp - 273.15
}