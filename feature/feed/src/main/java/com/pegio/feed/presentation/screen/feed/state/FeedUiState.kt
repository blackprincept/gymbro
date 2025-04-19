package com.pegio.feed.presentation.screen.feed.state

import com.pegio.feed.presentation.model.UiPost
import com.pegio.common.presentation.model.UiUser

data class FeedUiState(

    // Loading
    val isLoading: Boolean = false,

    // Main
    val currentUser: UiUser = UiUser.DEFAULT,
    val relevantPosts: List<UiPost> = emptyList(),
    val endOfPostsReached: Boolean = false
)