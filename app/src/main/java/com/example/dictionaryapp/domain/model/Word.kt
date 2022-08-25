package com.example.dictionaryapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Word(

	@PrimaryKey
	val id: Long? = null,

	@field:SerializedName("word")
	val word: String,

	@field:SerializedName("phonetic")
	val phonetic: String,

	@field:SerializedName("meanings")
	val meanings: List<Meaning>,
)
