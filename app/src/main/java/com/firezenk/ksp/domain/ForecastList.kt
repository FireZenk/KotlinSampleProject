package com.firezenk.ksp.domain

data class ForecastList(val city: String, val country: String, var dailyForecastList: List<Forecast>)