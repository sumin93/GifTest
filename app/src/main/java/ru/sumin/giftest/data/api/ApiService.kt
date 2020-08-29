package ru.sumin.giftest.data.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.sumin.giftest.data.dto.ResultDto

interface ApiService {

    @GET("$PATH_LATEST{pageNumber}$PATH_GET_JSON")
    fun getLastGifs(
        @Path("pageNumber") pageNumber: Int = 0
    ): Single<ResultDto>

    companion object {
        private const val PATH_LATEST = "latest/"
        private const val PATH_GET_JSON = "?json=true"
    }
}
