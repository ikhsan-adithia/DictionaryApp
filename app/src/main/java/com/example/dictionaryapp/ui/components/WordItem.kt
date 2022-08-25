package com.example.dictionaryapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.dictionaryapp.domain.model.Word

@Composable
fun WordItem(
    word: Word,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = word.word)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = word.phonetic, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(18.dp))

        word.meanings.forEach { meaning ->
            Text(text = meaning.partOfSpeech)

            meaning.definitions.forEachIndexed { index, definition ->
                Text(text = "${index + 1} ${definition.definition}")
                definition.example?.let { example ->
                    Text(text = "eg: $example")
                }
            }
        }
    }
}