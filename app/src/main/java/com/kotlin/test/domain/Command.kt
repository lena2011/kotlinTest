package com.kotlin.test.domain

/**
 * Created by Administrator on 2017/6/23.
 */
interface  Command<T>{
    fun  execute():T
}