package com.geekdroid.demo.model.user

import org.hibernate.validator.constraints.Range
import java.io.Serializable
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

/**
 * 用户信息实体类
 * 这里需要注意的是，当我们想要使用@Validated 进行参数验证时，在kotlin使用是需要使用@get:Pattern这种格式
 * 不然Spring无法获取对应的校验声明
 */
@Entity
@Table(name = "gk_user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0L,

        @get:Pattern(regexp = "^1([345789])\\d{9}$", message = "手机号码格式错误")
        @get:NotEmpty(message = "用户名不能为空")
        @get:NotNull(message = "用户名不能为空")
        var userName: String = "",

        var nickName: String?,

        @get:Range(min = 6, max = 18, message = "密码长度为6~18位")
        var password: String = ""
) : Serializable