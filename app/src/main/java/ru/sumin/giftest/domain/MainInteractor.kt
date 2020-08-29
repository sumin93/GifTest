package ru.sumin.giftest.domain

import io.reactivex.Single
import ru.sumin.giftest.data.GifsRepositoryImpl
import ru.sumin.giftest.domain.entity.GifEntity

class MainInteractor {
    private val gifsRepository = GifsRepositoryImpl()

    fun getLastGifs(pageNumber: Int): Single<List<GifEntity>> {
        return gifsRepository.getLastGifs(pageNumber)
    }
}
