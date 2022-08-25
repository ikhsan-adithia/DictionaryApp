package com.example.dictionaryapp.data.repository

import com.example.dictionaryapp.data.local.WordDao
import com.example.dictionaryapp.data.remote.DictionaryApi
import com.example.dictionaryapp.domain.model.Word
import com.example.dictionaryapp.domain.repository.DictionaryRepository
import com.example.dictionaryapp.utils.JsonParser
import com.example.dictionaryapp.utils.Result
import com.example.dictionaryapp.utils.unwrap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DictionaryRepositoryImpl(
    private val service: DictionaryApi,
    private val dao: WordDao,
    private val jsonParser: JsonParser
): DictionaryRepository {

    override fun getWord(word: String): Flow<Result<List<Word>>> =
        unwrap(jsonParser) { service.getWord(word) }
            .map { result ->
                return@map when (result) {
                    is Result.Success -> {
                        result.data?.let { words ->
                            words.forEach { word ->
                                dao.deleteCachedWord(word.word)
                            }
                            dao.cacheWord(words)
                        }
                        val cachedWord = dao.getCachedWord(word)
                        Result.Success(data = cachedWord)
                    }
                    is Result.Error -> {
                        val cachedWord = dao.getCachedWord(word)
                        Result.Error(
                            data = cachedWord,
                            uiText = result.uiText
                        )
                    }
                    is Result.Loading -> {
                        val cachedWord = dao.getCachedWord(word)
                        Result.Loading(cachedWord)
                    }
                }
            }
}