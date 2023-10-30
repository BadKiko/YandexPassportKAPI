package com.kiko.yandexpassportapi.data.remote.interceptor

import com.kiko.yandexpassportapi.YandexPassportClient
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.Response
import java.io.IOException

/**
 * Интерцептор который вставляет меняет url адрес если под Yandex Client
 */
class YandexPassportUrlInterceptor(private val yandexRemoteAuth: YandexPassportClient) :
    Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Chain): Response {
        val originalRequest = chain.request()

        val newBaseUrl = yandexRemoteAuth.baseUrl

        val newRequest = originalRequest.newBuilder()
            .url("$newBaseUrl/${originalRequest.url.pathSegments.joinToString("/")}")
            .build()

        return chain.proceed(newRequest)
    }
}
