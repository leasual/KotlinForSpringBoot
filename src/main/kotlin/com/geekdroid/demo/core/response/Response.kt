package com.geekdroid.demo.core.response

/**
 * 统一生成返回数据
 */
object Response {
    /**
     * 构造请求成功返回数据
     */
    fun <T> makeOkResponse(data: T? = null): ResponseResult<T> {
        return ResponseResult(ResponseCode.SUCCESS.code, "success", data)
    }

    /**
     * 构造请求失败返回数据
     */
    fun makeErrorResponse(data: Any? = null, code: Int = ResponseCode.FAIL.code, message: String = "fail"): ResponseResult<Any> {
        return ResponseResult(code, message, data)
    }
}