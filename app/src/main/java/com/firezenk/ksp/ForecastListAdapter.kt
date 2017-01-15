package com.firezenk.ksp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.firezenk.ksp.domain.ForecastList

class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecastList[position]) {
            holder.textView.text = "$date - $description $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecastList.size

    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)
}
