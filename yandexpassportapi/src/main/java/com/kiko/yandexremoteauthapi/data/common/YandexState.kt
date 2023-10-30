package com.kiko.yandexremoteauthapi.data.common

import com.kiko.yandexremoteauthapi.data.info.remote.dto.InfoResponseEntity
import com.skydoves.sealedx.core.Extensive
import com.skydoves.sealedx.core.annotations.ExtensiveModel
import com.skydoves.sealedx.core.annotations.ExtensiveSealed

@ExtensiveSealed(
    models = [
        ExtensiveModel(type = InfoResponseEntity::class, name = "Info")
    ]
)
/**
 * Состояния возвращения результата
 */
sealed interface YandexPassportState {
    data class Success(val data: Extensive) : YandexPassportState
    data class Error(val message: String) : YandexPassportState
    data object Idle : YandexPassportState
}