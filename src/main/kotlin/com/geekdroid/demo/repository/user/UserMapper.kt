package com.geekdroid.demo.repository.user

import com.geekdroid.demo.model.user.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface UserMapper {

    @Select("select * from gk_user where user_name = #{userName}")
    fun findUserByName(@Param("userName") userName: String): User?

    @Select("select * from gk_user")
    fun findAllUser(): List<User>?
}