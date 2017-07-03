package com.kotlin.test

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
 * Created by Administrator on 2017/6/27.
 */
class  ForecastDbHelper(context: Context=AppContext.instance): ManagedSQLiteOpenHelper(context,ForecastDbHelper.DB_NAME,null,ForecastDbHelper.DB_VERSION) {
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
         CityForecastTable.ID to INTEGER+ PRIMARY_KEY,
               CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to  TEXT)

        p0.createTable(DayForecastTable.NAME,true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(CityForecastTable.NAME,true)
        db?.dropTable(DayForecastTable.NAME,true)
        onCreate(db)
    }
}