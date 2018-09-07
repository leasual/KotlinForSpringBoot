package com.geekdroid.demo.controller.user

import com.geekdroid.demo.base.BaseController
import com.geekdroid.demo.core.response.ResponseResult
import com.geekdroid.demo.exception.GlobalValidErrorException
import com.geekdroid.demo.model.user.User
import com.geekdroid.demo.service.user.IUserService
import com.github.pagehelper.PageInfo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Api(tags = ["用户相关接口"], description = "用户信息")
@RequestMapping("/user")
class UserController : BaseController() {

    @Autowired
    lateinit var userService: IUserService

    @ApiOperation(value = "创建用户", notes = "用户名唯一")
    @PostMapping("/create")
    fun createUser(@Validated @RequestBody user: User, result: BindingResult): ResponseResult<User> {
        if (result.hasErrors()) {
            logger.error("create user error= ${result.allErrors[0].defaultMessage}")
            throw GlobalValidErrorException()
        }
        return userService.createUser(user)
    }

    @ApiOperation(value = "获取用户信息", notes = "用户Id")
    @GetMapping("/get")
    fun getUserInfo(@RequestParam(value = "id", required = true) id: Long): ResponseResult<User> {
        return userService.getUserById(id)
    }

    @ApiOperation(value = "更新用户信息", notes = "用户Id, 用户信息json")
    @PostMapping("/update/{id}")
    fun updateUserInfo(@PathVariable id: Long, @RequestBody user: User): ResponseResult<User> {
        return userService.updateUserInfo(id, user)
    }

    @ApiOperation(value = "创建用户", notes = "用户名唯一")
    @GetMapping("/getAll")
    fun getAllUser(): ResponseResult<List<User>> {
        return userService.selectAll()
    }

    @ApiOperation(value = "分页获取用户列表", notes = "第几页page， 每页个数size")
    @GetMapping("/getList")
    fun getUserList(@RequestParam(value = "page", required = false, defaultValue = "1") page: Int,
                    @RequestParam(value = "size", required = false, defaultValue = "10") size: Int): ResponseResult<PageInfo<User>> {
        return userService.getUserListByPage(page, size)
    }

    @ApiOperation(value = "删除用户", notes = "用户id")
    @PostMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseResult<User> {
        return userService.deleteUser(id)
    }
}