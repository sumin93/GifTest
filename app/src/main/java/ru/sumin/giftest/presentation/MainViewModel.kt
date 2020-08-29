package ru.sumin.giftest.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import ru.sumin.giftest.domain.MainInteractor
import ru.sumin.giftest.domain.entity.GifEntity
import ru.sumin.giftest.presentation.model.MainViewState

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val mainInteractor = MainInteractor()
    private val compositeDisposable = CompositeDisposable()
    private val loadedGifs = mutableListOf<GifEntity>()
    private val screenStateMutableData = MutableLiveData<MainViewState>()

    private var lastIndex = 0
    private var lastPage = 0

    val screenState: LiveData<MainViewState> = screenStateMutableData

    init {
        Log.d("MainViewModel", "init")
    }

    fun showNextGif() {
        val prevButtonEnabled = lastIndex > 0
        screenStateMutableData.value = MainViewState.ProgressState(prevButtonEnabled)
        if (loadedGifs.size > lastIndex) {
            screenStateMutableData.value = MainViewState.ShowState(
                loadedGifs[lastIndex++],
                prevButtonEnabled
            )
        } else {
            val disposable = mainInteractor
                .getLastGifs(lastPage)
                .filter { it.isNotEmpty() }
                .subscribe({
                    loadedGifs.addAll(it)
                    screenStateMutableData.postValue(
                        MainViewState.ShowState(loadedGifs[lastIndex++], prevButtonEnabled)
                    )
                    lastPage++
                }, {
                    screenStateMutableData.postValue(MainViewState.ErrorState(prevButtonEnabled))
                })
            compositeDisposable.add(disposable)
        }
    }

    fun showPreviousGif() {
        if (lastIndex - 2 >= 0) {
            screenStateMutableData.value = MainViewState.ShowState(
                loadedGifs[lastIndex - 2],
                --lastIndex > 1
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
