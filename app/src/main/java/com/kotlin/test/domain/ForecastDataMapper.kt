package com.kotlin.test.domain

import com.kotlin.test.Forecast
import com.kotlin.test.MapiForecastResult
import java.text.DateFormat
import java.util.*
import com.kotlin.test.domain.Forecast as ModelForecast
/**
 * Created by Administrator on 2017/6/23.
 */
class  ForecastDataMapper{

    fun convertFromDataModel(forecast: MapiForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }
         fun convertForecastListToDomain(list: List<Forecast>):
                List<ModelForecast> {
            return list.map { convertForecastItemToDomain(it) }
        }
        private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
            return ModelForecast(convertDate(forecast.dt),
                    forecast.weather[0].description, forecast.temp.max.toInt(),
                    forecast.temp.min.toInt(),generateUrl(forecast.weather[0].icon))
        }
        private fun convertDate(date: Long): String {
            val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
            return df.format(date * 1000)
        }

    fun generateUrl(iconCode:String):String="http://openweathermap.org/img/w/$iconCode.png"
}