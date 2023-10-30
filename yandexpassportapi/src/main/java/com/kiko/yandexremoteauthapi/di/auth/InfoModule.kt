package com.kiko.yandexremoteauthapi.di.auth

import com.kiko.yandexremoteauthapi.data.info.remote.api.InfoApi
import com.kiko.yandexremoteauthapi.data.info.repository.InfoRepositoryImpl
import com.kiko.yandexremoteauthapi.domain.info.repository.InfoRepository
import retrofit2.Retrofit

object InfoModule {
    fun provideInfoApi(retrofit: Retrofit): InfoApi {
        return retrofit.create(InfoApi::class.java)
    }

    fun provideInfoRepository(
        infoApi: InfoApi
    ): InfoRepository {
        return InfoRepositoryImpl(infoApi)
    }
}