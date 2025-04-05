package com.pegio.gymbro.presentation.screen.createpost

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pegio.gymbro.presentation.components.TopAppBarContent

@Composable
fun CreatePostScreen() {
    Scaffold(
        topBar = { TopAppBarContent({ }, { }) },
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        CreatePostContent(
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}

@Composable
private fun CreatePostContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        HorizontalDivider()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FitnessCenter,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "Choose your workout")

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }

        TextField(
            value = "",
            onValueChange = { },
            label = { Text(text = "What's on your muscle?") },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CreatePostContentPreview() {
    CreatePostScreen()
}