package com.geekdroid.demo.exception

import com.geekdroid.demo.core.response.ResponseCode

/**
 * 自定义全局验证参数错误
 */
class GlobalValidErrorException(override val message: String? = "参数错误", val code: Int = ResponseCode.FAIL.code) : Exception() {
}