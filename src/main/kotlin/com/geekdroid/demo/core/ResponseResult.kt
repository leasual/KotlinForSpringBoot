package com.geekdroid.demo.core

data class ResponseResult<T>(
       var code: Int,
       var message: String,
       var data: T?
)