package com.kiko.yandexpassportapi.domain.info.repository

import com.kiko.yandexpassportapi.data.info.remote.dto.InfoResponseEntity
import com.skydoves.sandwich.ApiResponse

interface InfoRepository {
    suspend fun getInfo(token: String): ApiResponse<InfoResponseEntity>
}