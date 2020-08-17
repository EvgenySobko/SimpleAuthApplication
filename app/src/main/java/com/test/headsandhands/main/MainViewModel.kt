package com.test.headsandhands.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.headsandhands.api.ApiFactory
import com.test.headsandhands.entities.Location
import com.test.headsandhands.entities.Weather
import com.test.headsandhands.utils.logd
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job()

    val temperature = MutableLiveData<Double>()

    private val apiFactory = ApiFactory.service

    fun checkAccuracy(email: String, password: String): Boolean {
        return (email.contains("@")
                && password.contains(Regex("[A-Z]"))
                && password.contains(Regex("[a-z]"))
                && password.contains(Regex("[0-9]"))
                && password.length > 5)
    }

    fun getWeather() {
        launch {
            runCatching { apiFactory.getCurrentWeather() }.onSuccess {
                temperature.postValue(it.getTemperature())
            }.onFailure {
                logd(it)
            }
        }
    }
}