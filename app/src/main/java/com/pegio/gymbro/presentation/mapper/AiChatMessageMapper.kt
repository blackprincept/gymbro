package com.pegio.gymbro.presentation.mapper

import com.pegio.gymbro.domain.core.Mapper
import com.pegio.gymbro.domain.model.AiChatMessage
import com.pegio.gymbro.presentation.model.UiAiChatMessage
import javax.inject.Inject

class AiChatMessageMapper @Inject constructor(
) : Mapper<UiAiChatMessage, AiChatMessage> {
    override fun mapToDomain(data: UiAiChatMessage): AiChatMessage {
        return AiChatMessage(
            text = data.text,
            date = data.date,
            imageUri = data.imageUri,
            isFromUser = data.isFromUser
        )
    }

    override fun mapFromDomain(data: AiChatMessage): UiAiChatMessage {
        return UiAiChatMessage(
            text = data.text,
            date = data.date,
            imageUri = data.imageUri,
            isFromUser = data.isFromUser
        )
    }

}