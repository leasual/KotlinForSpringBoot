package com.geekdroid.demo.repository.user

import com.geekdroid.demo.model.user.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

    @Select("select * from user where user_name = #{userName}")
    fun findUserByName(@Param("userName") userName: String): User?
}