package com.kiko.yandexpassportapi.domain.info.usecase

import com.kiko.yandexpassportapi.data.info.remote.dto.InfoResponseEntity
import com.kiko.yandexpassportapi.domain.info.repository.InfoRepository
import com.skydoves.sandwich.ApiResponse

class InfoUseCase(private val infoRepository: InfoRepository) {
    suspend fun getInfo(token: String): ApiResponse<InfoResponseEntity> {
        return infoRepository.getInfo(token)
    }
}