package com.kiko.yandexpassportkapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kiko.yandexpassportkapi.ui.theme.YandexPassportKAPITheme
import com.kiko.yandexremoteauthapi.YandexPassportClient
import com.kiko.yandexremoteauthapi.data.common.InfoYandexPassportState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YandexPassportKAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    var value by remember { mutableStateOf("check") }

                    val yandexPassportClient = YandexPassportClient.create()

                    LaunchedEffect(true) {
                        yandexPassportClient.getInfo("y0_AgAAAAAkkR4XAAG8XgAAAADwHTGzoikrhz_MTeOFC8NnaLu5urTONKU").let {
                            when (it) {
                                is InfoYandexPassportState.Error -> {
                                    value = it.message
                                }
                                is InfoYandexPassportState.Success -> {
                                    value = it.data.firstName
                                }

                                InfoYandexPassportState.Idle -> {
                                    value = "load"
                                }
                            }
                        }
                    }

                    Text(value)
                }
            }
        }
    }
}
