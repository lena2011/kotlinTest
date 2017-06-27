package com.kotlin.test

import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Administrator on 2017/6/27.
 */
class  ForecastDbHelper(): ManagedSQLiteOpenHelper(AppContext.instance,ForecastDbHelper.DB_NAME,null,ForecastDbHelper.DB_VERSION) {
    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance: ForecastDbHelper by lazy {
            ForecastDbHelper()
        }//lazy表示真的被调用才会被创建
    }

    object CityForecastTable {
        val NAME = "CityForecast"
        val ID = "_id"
        val CITY = "city"
        val COUNTRY = "country"
    }

    object DayForecastTable {
        val NAME = "DayForecast"
        val ID = "_id"
        val DATE = "date"
        val DESCRIPTION = "description"
        val HIGH = "high"
        val LOW = "low"
        val ICON_URL = "iconUrl"
        val CITY_ID = "cityId"
    }
    override fun onCreate(p0: SQLiteDatabase?) {
        p0!!.createTable(CityForecastTable.NAME, true,
                Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
                Pair(CityForecastTable.CITY, TEXT),
                Pair(CityForecastTable.COUNTRY, TEXT))
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}