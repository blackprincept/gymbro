package com.pegio.feed.presentation.screen.createpost.state

import android.net.Uri

data class CreatePostUiState(

    // Loading
    val isLoading: Boolean = false,

    // Main
    val imageUri: Uri? = null,

    // Compose State
    val postText: String = ""
)