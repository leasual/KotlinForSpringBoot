package com.geekdroid.demo.repository

import com.geekdroid.demo.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}