package com.geekdroid.demo.exception.constants


/**
 * 错误枚举定义
 */
enum class GlobalErrorEnum(val code: Int, val message: String) {

    /************************ 用户相关 ************************/
    USER_NOT_EXIST(1001, "用户不存在"),
    USER_ALREADY_EXIST(1002, "用户已存在")
}