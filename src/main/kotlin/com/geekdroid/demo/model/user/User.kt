package com.geekdroid.demo.model.user

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "gk_user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0L,
        var userName: String = "",
        var nickName: String = "",
        var password: String = ""
) : Serializable