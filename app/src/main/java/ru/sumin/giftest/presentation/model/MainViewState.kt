package ru.sumin.giftest.presentation.model

import ru.sumin.giftest.domain.entity.GifEntity

sealed class MainViewState(
    open val previousButtonEnabled: Boolean
) {

    data class ShowState(
        val gifToShow: GifEntity,
        override val previousButtonEnabled: Boolean
    ) : MainViewState(previousButtonEnabled)

    data class ProgressState(
        override val previousButtonEnabled: Boolean
    ) : MainViewState(previousButtonEnabled)

    data class ErrorState(
        override val previousButtonEnabled: Boolean
    ) : MainViewState(previousButtonEnabled)
}

