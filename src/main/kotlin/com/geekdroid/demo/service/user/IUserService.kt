package com.geekdroid.demo.service.user

import com.geekdroid.demo.core.ResponseResult
import com.geekdroid.demo.model.user.User

interface IUserService {

    fun createUser(user: User): ResponseResult<User>
    fun getUser(userId: Long): ResponseResult<User>
}