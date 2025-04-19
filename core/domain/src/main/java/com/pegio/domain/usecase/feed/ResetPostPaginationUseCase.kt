package com.pegio.domain.usecase.feed

import com.pegio.domain.repository.PostRepository
import javax.inject.Inject

class ResetPostPaginationUseCase @Inject constructor(private val postRepository: PostRepository) {
    operator fun invoke() = postRepository.resetPagination()
}