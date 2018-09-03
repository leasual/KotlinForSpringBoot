package com.geekdroid.demo.core
object Response {
    fun <T> makeOkResponse(data: T?): ResponseResult<T> {
        return ResponseResult(ResponseCode.SUCCESS.code, "success", data)
    }

    fun <T> makeErrorResponse(data: T?): ResponseResult<T> {
        return ResponseResult(ResponseCode.FAIL.code, "fail", data)
    }
}