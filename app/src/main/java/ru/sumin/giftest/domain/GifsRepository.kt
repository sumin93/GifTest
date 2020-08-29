package ru.sumin.giftest.domain

import io.reactivex.Single
import ru.sumin.giftest.domain.entity.GifEntity

interface GifsRepository {

    fun getLastGifs(pageNumber: Int): Single<List<GifEntity>>
}
