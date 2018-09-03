package com.geekdroid.demo.controller

import com.geekdroid.demo.model.User
import com.geekdroid.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    lateinit var userRepository: UserRepository

    @PostMapping("/createUserInfo")
    fun createUser(@RequestBody user: User): User {
        userRepository.save(user)
        return User(
                userName = user.userName,
                password = user.password,
                nickName = user.nickName
        )
    }

    @GetMapping("/getUserInfo")
    fun getUserInfo(@RequestParam(value = "id", required = true) id: Long): String {
        return userRepository.findById(id).toString()
    }

    @PostMapping("/updateUserInfo/{id}")
    fun updateUserInfo(@PathVariable id: Long, @RequestBody user: User) {
        userRepository.save(user.copy(id = id))
    }

}