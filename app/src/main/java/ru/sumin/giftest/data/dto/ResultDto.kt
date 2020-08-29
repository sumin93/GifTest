package ru.sumin.giftest.data.dto

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class ResultDto {
    @SerializedName("result")
    @Expose
    val result: List<ContentDto?>? = null

    @SerializedName("totalCount")
    @Expose
    val totalCount = 0
}
