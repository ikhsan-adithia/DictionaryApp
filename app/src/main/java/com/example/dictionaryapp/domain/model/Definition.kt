package com.example.dictionaryapp.domain.model

import com.google.gson.annotations.SerializedName

data class Definition(

    @field:SerializedName("synonyms")
    val synonyms: List<String>,

    @field:SerializedName("antonyms")
    val antonyms: List<String>,

    @field:SerializedName("definition")
    val definition: String,

    @field:SerializedName("example")
    val example: String?
)
