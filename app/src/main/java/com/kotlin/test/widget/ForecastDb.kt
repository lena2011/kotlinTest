package com.kotlin.test.widget

import com.kotlin.test.ForecastDbHelper
import com.kotlin.test.domain.ForecastDataMapper

/**
 * Created by Administrator on 2017/7/3.
 */
class  ForecastDb(val forecastDbHelper: ForecastDbHelper=ForecastDbHelper.instance,
                  val  dataMapper:ForecastDataMapper=ForecastDataMapper() ){

}