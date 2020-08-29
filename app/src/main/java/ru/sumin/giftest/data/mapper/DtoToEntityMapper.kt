package ru.sumin.giftest.data.mapper

import ru.sumin.giftest.data.dto.ContentDto
import ru.sumin.giftest.domain.entity.GifEntity

class DtoToEntityMapper {
    fun map(dto: ContentDto): GifEntity {
        return GifEntity(
            id = dto.id,
            gifURL = dto.gifURL,
            previewURL = dto.previewURL,
            description = dto.description
        )
    }
}
