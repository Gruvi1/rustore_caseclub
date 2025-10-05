package ru.nsu.rustore_caseclub.model.storage

import android.content.Context
import androidx.annotation.RawRes
import kotlinx.serialization.json.Json
import ru.nsu.rustore_caseclub.R
import ru.nsu.rustore_caseclub.model.AppInfo

class BadRepository(private val context: Context) {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    fun readAppsFromRaw(): List<AppInfo> {
        return try {
            val jsonString = readRawResourceAsString(R.raw.apps)
            json.decodeFromString<List<AppInfo>>(jsonString)
        }
        catch (_: Exception) {
            emptyList()
        }
    }

    private fun readRawResourceAsString(@RawRes resId: Int): String {
        return context.resources.openRawResource(resId)
            .bufferedReader()
            .use { it.readText() }
    }
}