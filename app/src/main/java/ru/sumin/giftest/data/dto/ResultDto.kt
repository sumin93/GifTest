package ru.sumin.giftest.data.dto

import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("result")
    val result: List<ContentDto>? = null,

    @SerializedName("totalCount")
    val totalCount: Int = 0
)
