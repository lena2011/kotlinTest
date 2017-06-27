package com.kotlin.test

import com.kotlin.test.domain.Command
import com.kotlin.test.domain.ForecastDataMapper
import com.kotlin.test.domain.ForecastList

/**
 * Created by Administrator on 2017/6/23.
 */
class  RequestForecastCommand(private val zipCode:String):Command<ForecastList>{
    override fun execute(): ForecastList {
        val  forecastRequest=Request(zipCode)
        return  ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}