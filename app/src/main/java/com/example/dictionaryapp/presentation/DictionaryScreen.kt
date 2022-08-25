package com.example.dictionaryapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionaryapp.presentation.utils.UiEvent
import com.example.dictionaryapp.ui.components.WordItem
import com.example.dictionaryapp.utils.asString
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DictionaryScreen() {
    val scaffoldState = rememberScaffoldState()
    val viewModel: DictionaryViewModel = hiltViewModel()
    val state = viewModel.dictionaryState.value

    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.uiText.asString(context), duration = SnackbarDuration.Short)
                }
            }
        }
    }
    
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.searchQuery.value,
                onValueChange = viewModel::onSearch,
                placeholder = {
                    Text(text = "Search word")
                }
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.words.size) { i ->
                    val word = state.words[i]
                    WordItem(word = word)
                }
            }
        }
    }
}