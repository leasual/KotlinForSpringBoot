package com.geekdroid.demo.service.user

import com.geekdroid.demo.core.response.Response
import com.geekdroid.demo.core.response.ResponseResult
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

    override fun createUser(user: User): ResponseResult<User> {
        val dbUser = userMapper.findUserByName(user.userName)
        return if (dbUser != null && user.userName == dbUser.userName) {
            Response.makeErrorResponse(null, "用户已存在")
        }else {
            userRepository.save(user)
            return Response.makeOkResponse(User(
                    userName = user.userName,
                    nickName = user.nickName,
                    password = user.password
            ))
        }
    }

    override fun getUserById(userId: Long): ResponseResult<User> {
        return if (userRepository.existsById(userId)) {
            Response.makeOkResponse(userRepository.findById(userId).get())
        }else {
            Response.makeErrorResponse(null, "用户不存在")
        }
    }

    override fun selectAll(): ResponseResult<List<User>> {
        return Response.makeOkResponse(userRepository.findAll())
    }

    override fun getUserListByPage(page: Int, size: Int): ResponseResult<PageInfo<User>> {
        PageHelper.startPage<User>(page, size)
        val list = userMapper.findAllUser()
        return Response.makeOkResponse(PageInfo(list))
    }

    override fun updateUserInfo(id: Long, user: User): ResponseResult<User> {
        userRepository.save(user.copy(id = id))
        return Response.makeOkResponse(User(
                id = user.id,
                nickName = user.nickName,
                password = user.password,
                userName = user.userName
        ))
    }

    override fun deleteUser(id: Long): ResponseResult<Any> {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            Response.makeOkResponse(null)
        }else {
            Response.makeErrorResponse(null, "用户不存在")
        }
    }
}