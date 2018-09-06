package com.geekdroid.demo.core.response

/**
 * 常规错误code定义
 */
enum class ResponseCode(val code: Int){
    /** 请求成功 */
    SUCCESS(0),
    /** 请求失败 */
    FAIL(400),
    /** 未验证 */
    UNAUTHORIZED(401),
    /** 服务器内部错误 */
    INTERNAL_SERVER_ERROR(500)
}