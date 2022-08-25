package com.example.dictionaryapp.data.remote

import com.example.dictionaryapp.domain.model.Word
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    @GET("api/v2/entries/en/{word}")
    suspend fun getWord(
        @Path("word") word: String
    ): List<Word>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev"
    }
}