package com.kiko.yandexpassportapi

import com.kiko.yandexpassportapi.constants.YandexPassportConstants
import com.kiko.yandexpassportapi.data.common.InfoYandexPassportState
import com.kiko.yandexpassportapi.di.auth.InfoModule
import com.kiko.yandexpassportapi.di.networking.RetrofitModule
import com.kiko.yandexpassportapi.domain.info.usecase.InfoUseCase
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.message
import retrofit2.Retrofit

/**
 * Основной класс библиотеки, представляет клиент паспорта в Yandex для получения основной информации пользователя
 *
 * @param baseUrl Адрес на Yandex OAuth
 */
class YandexPassportClient(
    val baseUrl: String = YandexPassportConstants.baseUrl
) {
    private lateinit var retrofit: Retrofit

    companion object {
        fun create(baseUrl: String = YandexPassportConstants.baseUrl): YandexPassportClient {
            val yandexRemoteAuth = YandexPassportClient(baseUrl)
            yandexRemoteAuth.retrofit =
                RetrofitModule.provideRetrofit(RetrofitModule.provideHttpClient(yandexRemoteAuth = yandexRemoteAuth))
            return yandexRemoteAuth
        }
    }

    suspend fun getInfo(token: String): InfoYandexPassportState {
        val infoApi = InfoModule.provideInfoApi(retrofit)
        val infoRepository = InfoModule.provideInfoRepository(infoApi)

        return InfoUseCase(infoRepository).getInfo(token).let {
            when (it) {
                is ApiResponse.Failure -> InfoYandexPassportState.Error(it.message())
                is ApiResponse.Success -> InfoYandexPassportState.Success(it.data)
            }
        }
    }
}