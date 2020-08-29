package ru.sumin.giftest.data

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.sumin.giftest.data.api.ApiFactory
import ru.sumin.giftest.data.mapper.DtoToEntityMapper
import ru.sumin.giftest.domain.GifsRepository
import ru.sumin.giftest.domain.entity.GifEntity

class GifsRepositoryImpl : GifsRepository {

    private val dtoToEntityMapper = DtoToEntityMapper()
    private val apiService = ApiFactory.apiService

    override fun getLastGifs(pageNumber: Int): Single<List<GifEntity>> {
        return apiService
            .getLastGifs(pageNumber)
            .filter { it.result != null }
            .map { it.result!!.map { dtoToEntityMapper.map(it) } }
            .toSingle()
            .subscribeOn(Schedulers.io())
    }
}
