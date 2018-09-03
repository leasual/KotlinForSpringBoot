package com.geekdroid.demo.repository.user

import com.geekdroid.demo.model.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}