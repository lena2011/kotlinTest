package com.kotlin.test

import android.content.Context
import android.view.View

/**
 * Created by Administrator on 2017/6/23.
 */
  class ViewExtensions{
    val View.ctx:Context
    get() = context

}