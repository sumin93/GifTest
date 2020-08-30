package ru.sumin.giftest.presentation.model

import ru.sumin.giftest.domain.entity.GifEntity

sealed class MainViewState(
    val previousButtonEnabled: Boolean
) {

    class ShowState(
        val gifToShow: GifEntity,
        previousButtonEnabled: Boolean
    ) : MainViewState(previousButtonEnabled)

    class ProgressState(
        previousButtonEnabled: Boolean
    ) : MainViewState(previousButtonEnabled)

    class ErrorState(
        previousButtonEnabled: Boolean
    ) : MainViewState(previousButtonEnabled)
}

