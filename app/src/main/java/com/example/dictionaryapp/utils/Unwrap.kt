package com.example.dictionaryapp.utils

import com.example.dictionaryapp.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

inline fun <reified T> unwrap(jsonParser: JsonParser, crossinline apiCall: suspend () -> T): Flow<Result<T>> =
    flow {
        emit(Result.Loading())
        try {
            val data = apiCall()
            emit(Result.Success(data))
        } catch (e: HttpException) {
            emit(Result.Error(
                data = jsonParser.fromJson<T>(e.response()?.errorBody()?.charStream().toString(), T::class.java),
                uiText = when {
                    e.code() == 503 -> {
                        UiText.StringResource(R.string.server_maintenance, MessageTypeEnum.ERROR)
                    }
                    (500..550).contains(e.code()) -> {
                        UiText.StringResource(R.string.server_error, MessageTypeEnum.ERROR)
                    }
                    else -> {
                        UiText.StringResource(R.string.cannot_retrieve_data, MessageTypeEnum.ERROR)
                    }
                }
            ))
            e.printStackTrace()
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
            emit(Result.Error(uiText = UiText.StringResource(R.string.timeout_error, MessageTypeEnum.ERROR)))
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Result.Error(uiText = UiText.StringResource(R.string.network_error, MessageTypeEnum.ERROR)))
        }
    }