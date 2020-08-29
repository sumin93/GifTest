package ru.sumin.giftest.presentation.model

import ru.sumin.giftest.domain.entity.GifEntity

sealed class MainViewState {

    class ShowState(
        val gifToShow: GifEntity,
        val previousButtonEnabled: Boolean
    ) : MainViewState()

    class ProgressState(
        val previousButtonEnabled: Boolean
    ) : MainViewState()

    class ErrorState(
        val previousButtonEnabled: Boolean
    ) : MainViewState()
}

