package ru.nsu.rustore_caseclub.model.storage

import android.content.Context
import androidx.annotation.RawRes
import kotlinx.serialization.json.Json
import ru.nsu.rustore_caseclub.R
import ru.nsu.rustore_caseclub.model.AppInfo

class BadRepository(private val context: Context): Repository {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    private var appsCache: List<AppInfo>? = null

    private fun readAppsFromRaw(): List<AppInfo> {
        return appsCache ?: try {
            val jsonString = readRawResourceAsString(R.raw.apps)
            val apps = json.decodeFromString<List<AppInfo>>(jsonString)
            appsCache = apps
            apps
        }
        catch (_: Exception) {
            emptyList()
        }
    }

    override fun getList(): List<AppInfo> {
        return readAppsFromRaw();
    }

    override fun getAppById(id: String): AppInfo? {
        return readAppsFromRaw().find { it.id == id }
    }

    private fun readRawResourceAsString(@RawRes resId: Int): String {
        return context.resources.openRawResource(resId)
            .bufferedReader()
            .use { it.readText() }
    }
}