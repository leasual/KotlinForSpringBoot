package com.geekdroid.demo.service.user

import com.geekdroid.demo.core.ResponseResult
import com.geekdroid.demo.model.user.User
import com.github.pagehelper.PageInfo

interface IUserService {

    fun createUser(user: User): ResponseResult<User>
    fun getUserById(userId: Long): ResponseResult<User>
    fun selectAll(): ResponseResult<List<User>>
    fun getUserListByPage(page: Int, size: Int): ResponseResult<PageInfo<User>>
    fun updateUserInfo(id: Long, user: User): ResponseResult<User>
}