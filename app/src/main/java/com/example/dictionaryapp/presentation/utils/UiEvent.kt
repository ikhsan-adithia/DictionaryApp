package com.example.dictionaryapp.presentation.utils

import com.example.dictionaryapp.utils.UiText

sealed class UiEvent {
    data class ShowSnackbar(val uiText: UiText): UiEvent()
}
