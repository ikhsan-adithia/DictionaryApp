package com.example.dictionaryapp.presentation

import com.example.dictionaryapp.domain.model.Word

data class DictionaryState(
    val words: List<Word> = emptyList(),
    val isLoading: Boolean = false
)
