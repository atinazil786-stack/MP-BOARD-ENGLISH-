package com.example.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "mp_english_hub_prefs")

data class LocalUserSettings(
    val selectedClass: Int = 10,
    val darkMode: Boolean = false,
    val bilingualMode: Boolean = true,
    val dailyStreak: Int = 1,
    val lastQuizDate: String = "",
    val teacherPhotoBase64: String = ""
)

class LocalPreferences(private val context: Context) {
    private object Keys {
        val SELECTED_CLASS = intPreferencesKey("selected_class")
        val DARK_MODE = booleanPreferencesKey("dark_mode")
        val BILINGUAL_MODE = booleanPreferencesKey("bilingual_mode")
        val DAILY_STREAK = intPreferencesKey("daily_streak")
        val LAST_QUIZ_DATE = stringPreferencesKey("last_quiz_date")
        val TEACHER_PHOTO_BASE64 = stringPreferencesKey("teacher_photo_base64")
    }

    val settingsFlow: Flow<LocalUserSettings> = context.dataStore.data.map { prefs ->
        LocalUserSettings(
            selectedClass = prefs[Keys.SELECTED_CLASS] ?: 10,
            darkMode = prefs[Keys.DARK_MODE] ?: false,
            bilingualMode = prefs[Keys.BILINGUAL_MODE] ?: true,
            dailyStreak = prefs[Keys.DAILY_STREAK] ?: 1,
            lastQuizDate = prefs[Keys.LAST_QUIZ_DATE] ?: "",
            teacherPhotoBase64 = prefs[Keys.TEACHER_PHOTO_BASE64] ?: ""
        )
    }

    suspend fun setSelectedClass(classLevel: Int) {
        context.dataStore.edit { it[Keys.SELECTED_CLASS] = classLevel.coerceIn(9, 12) }
    }

    suspend fun setDarkMode(enabled: Boolean) {
        context.dataStore.edit { it[Keys.DARK_MODE] = enabled }
    }

    suspend fun setBilingualMode(enabled: Boolean) {
        context.dataStore.edit { it[Keys.BILINGUAL_MODE] = enabled }
    }

    suspend fun recordDailyQuizCompletion(todayIso: String, newStreak: Int) {
        context.dataStore.edit {
            it[Keys.LAST_QUIZ_DATE] = todayIso
            it[Keys.DAILY_STREAK] = newStreak
        }
    }

    suspend fun setTeacherPhotoBase64(base64: String) {
        context.dataStore.edit { it[Keys.TEACHER_PHOTO_BASE64] = base64 }
    }
}
