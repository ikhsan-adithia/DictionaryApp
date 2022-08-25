package com.example.dictionaryapp.di

import android.app.Application
import androidx.room.Room
import com.example.dictionaryapp.data.local.Converter
import com.example.dictionaryapp.data.local.WordDatabase
import com.example.dictionaryapp.data.remote.DictionaryApi
import com.example.dictionaryapp.data.repository.DictionaryRepositoryImpl
import com.example.dictionaryapp.domain.repository.DictionaryRepository
import com.example.dictionaryapp.utils.GsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDictionaryRepository(service: DictionaryApi, db: WordDatabase): DictionaryRepository =
        DictionaryRepositoryImpl(service = service, dao = db.dao, jsonParser = GsonParser(Gson()))

    @Provides
    @Singleton
    fun provideWordDatabase(app: Application): WordDatabase =
        Room.databaseBuilder(
            app,
            WordDatabase::class.java,
            WordDatabase.DB_NAME
        )
            .addTypeConverter(Converter(GsonParser(Gson())))
            .build()

    @Provides
    @Singleton
    fun provideDictionaryApi(): DictionaryApi =
        Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
}