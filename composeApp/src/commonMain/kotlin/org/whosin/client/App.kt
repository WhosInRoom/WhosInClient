package org.whosin.client

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.whosin.client.core.navigation.WhosInNavGraph
import ui.theme.WhosInTheme

@Composable
@Preview
fun App() {
    WhosInTheme {
        val navController = rememberNavController()

        WhosInNavGraph(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxSize(),
            navController = navController
        )
    }
}