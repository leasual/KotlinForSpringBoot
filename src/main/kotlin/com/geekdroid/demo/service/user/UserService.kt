package com.geekdroid.demo.service.user

import com.geekdroid.demo.core.Response
import com.geekdroid.demo.core.ResponseCode
import com.geekdroid.demo.core.ResponseResult
import com.geekdroid.demo.model.user.User
import com.geekdroid.demo.repository.user.UserMapper
import com.geekdroid.demo.repository.user.UserRepository
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
            ResponseResult(201, "用户已存在", null)
        }else {
            userRepository.save(user)
            Response.makeOkResponse(User(
                    userName = user.userName,
                    nickName = user.nickName,
                    password = user.password
            ))
        }
    }

    override fun getUser(userId: Long): ResponseResult<User> {
        return ResponseResult(ResponseCode.SUCCESS.code, "success", userRepository.findById(userId).get())
    }
}