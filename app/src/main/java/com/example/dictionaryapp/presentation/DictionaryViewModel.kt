package com.example.dictionaryapp.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionaryapp.domain.repository.DictionaryRepository
import com.example.dictionaryapp.presentation.utils.UiEvent
import com.example.dictionaryapp.utils.Result
import com.example.dictionaryapp.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val repository: DictionaryRepository
): ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> get() = _searchQuery

    private val _dictionaryState = mutableStateOf(DictionaryState())
    val dictionaryState: State<DictionaryState> get() = _dictionaryState

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> get() = _uiEvent

    private var searchJob: Job? = null
    fun onSearch(word: String) {
        _searchQuery.value = word

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500)
            repository.getWord(word)
                .onEach { result ->
                    when (result) {
                        is Result.Success -> {
                            _dictionaryState.value = dictionaryState.value.copy(
                                words = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Result.Error -> {
                            _dictionaryState.value = dictionaryState.value.copy(
                                words = result.data ?: emptyList(),
                                isLoading = false
                            )

                            _uiEvent.emit(UiEvent.ShowSnackbar(result.uiText ?: UiText.unknownError()))
                        }
                        is Result.Loading -> {
                            _dictionaryState.value = dictionaryState.value.copy(
                                words = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }
                .launchIn(this)
        }
    }
}