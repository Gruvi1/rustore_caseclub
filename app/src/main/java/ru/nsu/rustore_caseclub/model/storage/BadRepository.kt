import android.content.Context
import androidx.annotation.RawRes
import kotlinx.serialization.json.Json
import ru.nsu.rustore_caseclub.R
import ru.nsu.rustore_caseclub.model.AppInfo
import java.io.InputStream

class BadRepository(private val context: Context) {

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

     fun readAppsFromRaw(): List<AppInfo> {
        return try {
            val jsonString = readRawResourceAsString(R.raw.cats)
            json.decodeFromString<List<AppInfo>>(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun readRawResourceAsString(@RawRes resId: Int): String {
        return context.resources.openRawResource(resId)
            .bufferedReader()
            .use { it.readText() }
    }

    private fun getRawResourceStream(@RawRes resId: Int): InputStream {
        return context.resources.openRawResource(resId)
    }
}