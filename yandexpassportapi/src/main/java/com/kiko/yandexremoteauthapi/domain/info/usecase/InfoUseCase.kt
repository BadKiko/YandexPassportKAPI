package com.kiko.yandexremoteauthapi.domain.info.usecase

import com.kiko.yandexremoteauthapi.data.info.remote.dto.InfoResponseEntity
import com.kiko.yandexremoteauthapi.domain.info.repository.InfoRepository
import com.skydoves.sandwich.ApiResponse

class InfoUseCase(private val infoRepository: InfoRepository) {
    suspend fun getInfo(token: String): ApiResponse<InfoResponseEntity> {
        return infoRepository.getInfo(token)
    }
}