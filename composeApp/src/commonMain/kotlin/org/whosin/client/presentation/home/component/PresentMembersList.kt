package org.whosin.client.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.whosin.client.presentation.home.mock.PresentMember
import org.whosin.client.presentation.home.mock.sampleUsers

@Composable
fun PresentMembersList(
    presentMemberList: List<PresentMember> = listOf(),
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            presentMemberList.forEach {
                PresentMembersItem(presentMemberNickName = it.nickname, isMe = it.isMe)
            }
        }

        Spacer(Modifier.height(20.dp))
    }
}

@Preview
@Composable
fun PresentMembersListPreview() {
    Box(modifier = Modifier.background(Color.White).padding(16.dp)) {
        PresentMembersList(presentMemberList = sampleUsers)
    }
}