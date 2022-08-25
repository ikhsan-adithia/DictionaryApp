package com.example.dictionaryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionaryapp.domain.model.Word

@Database(
    entities = [Word::class],
    version = WordDatabase.versionDB
)
@TypeConverters(Converter::class)
abstract class WordDatabase: RoomDatabase() {
    abstract val dao: WordDao

    companion object {
        const val DB_NAME = "WordDatabase"
        const val versionDB = 1
    }
}