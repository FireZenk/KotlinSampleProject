package com.firezenk.ksp.domain

import com.firezenk.ksp.data.ResponseClasses
import java.text.DateFormat
import java.util.*

class ForecastDataMapper {

    fun convertFromDataModel(forecast: ResponseClasses.ForecastResult) : ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    fun convertForecastListToDomain(list: List<ResponseClasses.Forecast>): List<Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    fun convertForecastItemToDomain(forecast: ResponseClasses.Forecast): Forecast {
        return Forecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    fun convertDate(date: Long) : String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}
