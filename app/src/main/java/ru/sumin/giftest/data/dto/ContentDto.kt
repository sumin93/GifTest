package ru.sumin.giftest.data.dto

import com.google.gson.annotations.SerializedName

class ContentDto {
    @SerializedName("id")
    val id = 0

    @SerializedName("description")
    val description: String? = null

    @SerializedName("votes")
    val votes = 0

    @SerializedName("author")
    val author: String? = null

    @SerializedName("date")
    val date: String? = null

    @SerializedName("gifURL")
    val gifURL: String? = null

    @SerializedName("gifSize")
    val gifSize = 0

    @SerializedName("previewURL")
    val previewURL: String? = null

    @SerializedName("videoURL")
    val videoURL: String? = null

    @SerializedName("videoPath")
    val videoPath: String? = null

    @SerializedName("videoSize")
    val videoSize = 0

    @SerializedName("type")
    val type: String? = null

    @SerializedName("width")
    val width: String? = null

    @SerializedName("height")
    val height: String? = null

    @SerializedName("commentsCount")
    val commentsCount = 0

    @SerializedName("fileSize")
    val fileSize = 0

    @SerializedName("canVote")
    val canVote = false
}
