package com.geekdroid.demo.core

enum class ResponseCode(val code: Int){
    SUCCESS(200),
    FAIL(400),
    UNAUTHORIZED(401),
    INTERNAL_SERVER_ERROR(500)
}