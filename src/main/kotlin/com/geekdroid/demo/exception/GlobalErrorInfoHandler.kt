package com.geekdroid.demo.exception

import com.geekdroid.demo.core.response.Response
import com.geekdroid.demo.core.response.ResponseResult
import com.geekdroid.demo.exception.constants.GlobalErrorEnum
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestController
@RestControllerAdvice
class GlobalErrorInfoHandler {
    /**
     * 统一处理业务逻辑错误
     */
    @ExceptionHandler(value = [GlobalErrorInfoException::class])
    fun errorHandlerOver2Json(request: HttpServletRequest, exception: GlobalErrorInfoException): ResponseResult<Any> {
        return Response.makeErrorResponse(null, exception.enum.code, exception.enum.message)
    }

    /**
     * 统一处理验证错误
     */
    @ExceptionHandler(value = [GlobalValidErrorException::class])
    fun validErrorHandlerOver2Json(request: HttpServletRequest, exception: GlobalValidErrorException): ResponseResult<Any> {
        return Response.makeErrorResponse(null, exception.code, exception.message ?: "参数错误")
    }
}