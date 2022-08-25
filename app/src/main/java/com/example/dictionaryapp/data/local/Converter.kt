package com.example.dictionaryapp.data.local

import android.util.Log
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.domain.model.Meaning
import com.example.dictionaryapp.utils.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converter(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        val value = jsonParser.fromJson<List<Meaning>>(json, object : TypeToken<List<Meaning>>(){}.type) ?: emptyList()
        Log.e("fromMeaningsJson: ", value.toString())
        return value
    }


    @TypeConverter
    fun toJsonMeanings(meanings: List<Meaning>): String? {
        val value = jsonParser.toJson(meanings, object : TypeToken<List<Meaning>>(){}.type)
        Log.e("toJsonMeanings: ", value.toString())
        return value
    }
}