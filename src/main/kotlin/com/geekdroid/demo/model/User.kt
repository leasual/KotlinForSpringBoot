package com.geekdroid.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0L,
        var userName: String = "",
        var nickName: String = "",
        var password: String = ""
)