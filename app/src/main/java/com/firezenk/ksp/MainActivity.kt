package com.firezenk.ksp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.async

import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.util.*

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thu 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList : RecyclerView = find(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        async() {
            Request("https://github.com/FireZenk/KotlinSampleProject").run()
            uiThread {
                toast("Request performed")
            }
        }

        val f1 = Forecast(Date(), 27.5f, "Shiny day")
        val f2 = f1.copy(temperature = 30f)

        val (date, temperature, details) = f1

        Log.d(javaClass.simpleName, "$date $temperature $details")
    }
}
