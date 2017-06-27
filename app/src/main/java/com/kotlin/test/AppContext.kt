package com.kotlin.test

import android.app.Application
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

/**
 * Created by Administrator on 2017/6/27.
 */
class  AppContext:Application(){
    object DelegatesExt {
        fun <T> notNullSingleValue():
                ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
    }
    companion object{
          var instance:Application by DelegatesExt.notNullSingleValue()

    }

    override fun onCreate() {
        super.onCreate()
        instance=this
    }
}