package com.geekdroid.demo.service.user

import com.geekdroid.demo.core.response.Response
import com.geekdroid.demo.core.response.ResponseResult
import com.geekdroid.demo.exception.GlobalErrorInfoException
import com.geekdroid.demo.exception.constants.GlobalErrorEnum
import com.geekdroid.demo.model.user.User
import com.geekdroid.demo.repository.user.UserMapper
import com.geekdroid.demo.repository.user.UserRepository
import com.github.pagehelper.PageHelper
import com.github.pagehelper.PageInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService: IUserService {

    @Autowired
    lateinit var userMapper: UserMapper
    @Autowired
    lateinit var userRepository: UserRepository

    /**
     * 创建用户
     */
    override fun createUser(user: User): ResponseResult<User> {
        val dbUser = userMapper.findUserByName(user.userName!!)
        if (dbUser != null && user.userName == dbUser.userName) {
            throw GlobalErrorInfoException(GlobalErrorEnum.USER_ALREADY_EXIST)
        }
        val userResult = userRepository.save(user)
        return Response.makeOkResponse(userResult)
    }

    /**
     * 获取用户信息
     */
    override fun getUserById(userId: Long): ResponseResult<User> {
        if (!userRepository.existsById(userId)) {
            throw GlobalErrorInfoException(GlobalErrorEnum.USER_NOT_EXIST)
        }
        return Response.makeOkResponse(userRepository.findById(userId).get())
    }

    /**
     * 获取所有用户信息
     */
    override fun selectAll(): ResponseResult<List<User>> {
        return Response.makeOkResponse(userRepository.findAll())
    }

    /**
     * 分页获取用户信息
     */
    override fun getUserListByPage(page: Int, size: Int): ResponseResult<PageInfo<User>> {
        PageHelper.startPage<User>(page, size)
        val list = userMapper.findAllUser()
        return Response.makeOkResponse(PageInfo(list))
    }

    /**
     * 更新用户信息
     */
    override fun updateUserInfo(id: Long, user: User): ResponseResult<User> {
        if (!userRepository.existsById(id)) {
            throw GlobalErrorInfoException(GlobalErrorEnum.USER_NOT_EXIST)
        }
        val userResult = userRepository.save(user.copy(id = id))
        return Response.makeOkResponse(userResult)
    }

    /**
     * 删除用户信息
     */
    override fun deleteUser(id: Long): ResponseResult<User> {
        if (!userRepository.existsById(id)) {
            throw GlobalErrorInfoException(GlobalErrorEnum.USER_NOT_EXIST)
        }
        userRepository.deleteById(id)
        return Response.makeOkResponse()
    }
}