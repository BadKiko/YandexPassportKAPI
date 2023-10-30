package com.kiko.yandexpassportapi.di.auth

import com.kiko.yandexpassportapi.data.info.remote.api.InfoApi
import com.kiko.yandexpassportapi.data.info.repository.InfoRepositoryImpl
import com.kiko.yandexpassportapi.domain.info.repository.InfoRepository
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