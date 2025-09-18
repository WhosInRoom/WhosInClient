package org.whosin.client

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.whosin.client.core.navigation.WhosInNavGraph
import org.whosin.client.presentation.dummy.DummyScreen

import whosinclient.composeapp.generated.resources.Res
import whosinclient.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        WhosInNavGraph(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            navController = navController
        )
        // Test용으로 남겨둔 코드, 추후 삭제 예정
        // 확인하려면 위의 코드는 주석처리하고 실행
//        DummyScreen()
    }
}