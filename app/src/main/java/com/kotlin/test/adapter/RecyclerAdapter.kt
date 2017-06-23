package com.kotlin.test.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kotlin.test.domain.Forecast
import com.kotlin.test.domain.ForecastList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*
import org.jetbrains.anko.find
import test.kotlin.com.kotlin.R

/**
 * Created by Administrator on 2017/6/23.
 */
class RecyclerAdapter(val items: ForecastList,val  itemClick: onItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0!!.context).inflate(R.layout.item_layout, p0, false),itemClick )
    }

    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
        p0!!.bindForecast(items[p1])

    }


    override fun getItemCount(): Int {
        return items.dailyForecast.size
    }


    class ViewHolder(view: View, val itemClick: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val iconView: ImageView
        val dateView: TextView
        val descriptionView: TextView
        val maxTemp: TextView
        val minTemp: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemp = view.find(R.id.maxTemperature)
            minTemp = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                //todo 图片
                Picasso.with(itemView.context).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemp.text = "${high.toString()}"
                minTemp.text = "${low.toString()}"
                itemView.setOnClickListener {
                    itemClick(forecast)
                }
            }
        }
    }

    interface onItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}