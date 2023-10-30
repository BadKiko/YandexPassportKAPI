package com.kiko.yandexremoteauthapi.data.info.remote.api

import com.kiko.yandexremoteauthapi.data.info.remote.dto.InfoResponseEntity
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface InfoApi {
    @POST("info")
    @FormUrlEncoded
    fun getInfo(
        @Field("oauth_token") token: String
    ): Call<InfoResponseEntity>
}