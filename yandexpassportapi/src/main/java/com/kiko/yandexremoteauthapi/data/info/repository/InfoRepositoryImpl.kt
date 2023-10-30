package com.kiko.yandexremoteauthapi.data.info.repository

import com.kiko.yandexremoteauthapi.data.info.remote.api.InfoApi
import com.kiko.yandexremoteauthapi.data.info.remote.dto.InfoResponseEntity
import com.kiko.yandexremoteauthapi.domain.info.repository.InfoRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.request
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class InfoRepositoryImpl(private val authApi: InfoApi) : InfoRepository {

    override suspend fun getInfo(token: String): ApiResponse<InfoResponseEntity> {
        while (true) {
            return suspendCoroutine { suspendCoroutine ->
                authApi.getInfo(
                    token
                ).request {
                    suspendCoroutine.resume(it)
                }
            }
        }
    }
}