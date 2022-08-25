package com.example.dictionaryapp.domain.repository

import com.example.dictionaryapp.domain.model.Word
import com.example.dictionaryapp.utils.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {

    fun getWord(word: String): Flow<Result<List<Word>>>
}