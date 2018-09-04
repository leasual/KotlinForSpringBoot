package com.geekdroid.demo.core.response

data class ResponseResult<T>(
       var code: Int,
       var message: String,
       var data: T?
)