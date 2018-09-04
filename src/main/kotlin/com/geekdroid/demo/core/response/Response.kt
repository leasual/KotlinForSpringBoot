package com.geekdroid.demo.core.response
object Response {
    fun <T> makeOkResponse(data: T?): ResponseResult<T> {
        return ResponseResult(ResponseCode.SUCCESS.code, "success", data)
    }

    fun <T> makeErrorResponse(data: T?, message: String = "fail", code: Int = ResponseCode.FAIL.code): ResponseResult<T> {
        return ResponseResult(code, message, data)
    }
}