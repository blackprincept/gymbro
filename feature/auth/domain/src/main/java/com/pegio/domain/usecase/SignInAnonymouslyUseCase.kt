package com.pegio.domain.usecase

import com.pegio.domain.repository.AuthRepository
import javax.inject.Inject

class SignInAnonymouslyUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke() = authRepository.signInAnonymously()
}