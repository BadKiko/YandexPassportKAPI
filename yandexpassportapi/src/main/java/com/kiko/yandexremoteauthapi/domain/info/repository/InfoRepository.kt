package com.kiko.yandexremoteauthapi.domain.info.repository

import com.kiko.yandexremoteauthapi.data.info.remote.dto.InfoResponseEntity
import com.skydoves.sandwich.ApiResponse

interface InfoRepository {
    suspend fun getInfo(token: String): ApiResponse<InfoResponseEntity>
}