package com.geekdroid.demo.exception

import com.geekdroid.demo.exception.constants.GlobalErrorEnum

/**
 * 自定义全局错误
 */
class GlobalErrorInfoException(val enum: GlobalErrorEnum) : Exception() {
}