package com.kiko.yandexpassportapi.data.info.remote.api

import com.kiko.yandexpassportapi.data.info.remote.dto.InfoResponseEntity
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface InfoApi {
    @POST("info")
    @FormUrlEncoded
    fun getInfo(
        @Field("oauth_token") token: String
    ): Call<InfoResponseEntity>
}