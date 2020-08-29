package ru.sumin.giftest.presentation.model

import ru.sumin.giftest.domain.entity.GifEntity

sealed class MainViewState {

    data class ShowState(
        val gifToShow: GifEntity,
        val previousButtonEnabled: Boolean
    ) : MainViewState()

    data class ProgressState(
        val previousButtonEnabled: Boolean
    ) : MainViewState()

    data class ErrorState(
        val previousButtonEnabled: Boolean
    ) : MainViewState()
}

