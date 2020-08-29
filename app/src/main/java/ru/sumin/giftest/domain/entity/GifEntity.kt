package ru.sumin.giftest.domain.entity

import com.google.gson.annotations.SerializedName

data class GifEntity(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("previewURL")
    val previewURL: String? = null,

    @SerializedName("gifURL")
    val gifURL: String? = null
)
