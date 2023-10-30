package com.kiko.yandexpassportapi.di.networking

import com.kiko.yandexpassportapi.YandexPassportClient
import com.kiko.yandexpassportapi.constants.YandexPassportConstants
import com.kiko.yandexpassportapi.data.remote.interceptor.YandexPassportUrlInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitModule {

    fun provideHttpClient(
        yandexRemoteAuth: YandexPassportClient
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(YandexPassportUrlInterceptor(yandexRemoteAuth))
            .build()
    }

    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(YandexPassportConstants.baseUrl)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}