package com.geekdroid.demo.controller.user

import com.geekdroid.demo.core.ResponseResult
import com.geekdroid.demo.model.user.User
import com.geekdroid.demo.service.user.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var userService: IUserService

    @PostMapping("/createUserInfo")
    fun createUser(@RequestBody user: User): ResponseResult<User> {
        return userService.createUser(user)
    }

    @GetMapping("/getUserInfo")
    fun getUserInfo(@RequestParam(value = "id", required = true) id: Long): ResponseResult<User> {
        return userService.getUser(id)
    }

    @PostMapping("/updateUserInfo/{id}")
    fun updateUserInfo(@PathVariable id: Long, @RequestBody user: User) {
        //userRepository.save(user.copy(id = id))
    }

}