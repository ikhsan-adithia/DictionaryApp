package com.example.dictionaryapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionaryapp.domain.model.Word

@Dao
interface WordDao {

    @Query("SELECT * FROM Word WHERE word = :word")
    suspend fun getCachedWord(word: String): List<Word>

    @Query("DELETE FROM Word WHERE word LIKE '%' || :word || '%'")
    suspend fun deleteCachedWord(word: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun cacheWord(words: List<Word>)
}