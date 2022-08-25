package com.example.dictionaryapp.utils

import android.content.Context
import androidx.annotation.StringRes
import com.example.dictionaryapp.R


sealed class UiText {
    data class StringResource(@StringRes val resId: Int, val type: MessageTypeEnum = MessageTypeEnum.NORMAL): UiText()
    data class DynamicString(val value: String, val type: MessageTypeEnum = MessageTypeEnum.NORMAL): UiText()

    companion object {
        fun unknownError() = StringResource(R.string.unknown_error, MessageTypeEnum.ERROR)
    }
}

fun UiText.asString(context: Context): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> context.getString(this.resId)
    }
}