package com.kiko.yandexremoteauthapi.di.networking

import com.kiko.yandexremoteauthapi.YandexPassportClient
import com.kiko.yandexremoteauthapi.constants.YandexPassportConstants
import com.kiko.yandexremoteauthapi.data.remote.interceptor.YandexPassportUrlInterceptor
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