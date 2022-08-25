package com.example.dictionaryapp.domain.model

import com.google.gson.annotations.SerializedName

data class Meaning(

    @field:SerializedName("synonyms")
    val synonyms: List<String>,

    @field:SerializedName("partOfSpeech")
    val partOfSpeech: String,

    @field:SerializedName("antonyms")
    val antonyms: List<String>,

    @field:SerializedName("definitions")
    val definitions: List<Definition>
)
