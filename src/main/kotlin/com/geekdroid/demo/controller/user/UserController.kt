package com.geekdroid.demo.controller.user

import com.geekdroid.demo.core.ResponseResult
import com.geekdroid.demo.model.user.User
import com.geekdroid.demo.service.user.IUserService
import com.github.pagehelper.PageInfo
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@Api(description = "用户信息")
class UserController {

    @Autowired
    lateinit var userService: IUserService

    @ApiOperation(value = "创建用户", notes = "用户名唯一")
    @PostMapping("/createUserInfo")
    fun createUser(@RequestBody user: User): ResponseResult<User> {
        return userService.createUser(user)
    }

    @ApiOperation(value = "获取用户信息", notes = "用户Id")
    @GetMapping("/getUserInfo")
    fun getUserInfo(@RequestParam(value = "id", required = true) id: Long): ResponseResult<User> {
        return userService.getUserById(id)
    }

    @ApiOperation(value = "更新用户信息", notes = "用户Id, 用户信息json")
    @PostMapping("/updateUserInfo/{id}")
    fun updateUserInfo(@PathVariable id: Long, @RequestBody user: User): ResponseResult<User> {
        return userService.updateUserInfo(id, user)
    }

    @ApiOperation(value = "创建用户", notes = "用户名唯一")
    @GetMapping("/getAllUser")
    fun getAllUser(): ResponseResult<List<User>> {
        return userService.selectAll()
    }

    @ApiOperation(value = "分页获取用户列表", notes = "第几页page， 每页个数size")
    @GetMapping("/getUserList")
    fun getUserList(@RequestParam(value = "page", required = false, defaultValue = "1") page: Int,
                    @RequestParam(value = "size", required = false, defaultValue = "10") size: Int): ResponseResult<PageInfo<User>> {
        return userService.getUserListByPage(page, size)
    }
}