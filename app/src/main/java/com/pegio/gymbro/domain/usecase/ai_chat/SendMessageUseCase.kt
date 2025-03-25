package com.pegio.gymbro.domain.usecase.ai_chat

import com.pegio.gymbro.domain.core.DataError
import com.pegio.gymbro.domain.core.Resource
import com.pegio.gymbro.domain.model.AiChatRequest
import com.pegio.gymbro.domain.model.AiChatResponse
import com.pegio.gymbro.domain.model.AiMessage
import com.pegio.gymbro.domain.repository.ChatRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val chatRepository: ChatRepository
)  {

    suspend operator fun invoke(aiMessages: List<AiMessage>): Resource<AiChatResponse, DataError.Network> {
        val aiChatRequest = AiChatRequest(
            aiMessages = aiMessages
        )

        return chatRepository.sendMessage(aiChatRequest)
    }
}
