package com.kiko.yandexpassportapi.data.info.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class InfoResponseEntity(
    val birthday: String ? = null,
    @Json(name = "client_id") val clientId: String,
    @Json(name = "default_avatar_id") val defaultAvatarId: String,
    @Json(name = "default_email") val defaultEmail: String,
    @Json(name = "display_name") val displayName: String,
    val emails: List<String>,
    @Json(name = "first_name") val firstName: String,
    val id: String,
    @Json(name = "is_avatar_empty") val isAvatarEmpty: Boolean,
    @Json(name = "last_name") val lastName: String,
    val login: String,
    val psuid: String,
    @Json(name = "real_name") val realName: String ? = null,
    val sex: String? = null
)
