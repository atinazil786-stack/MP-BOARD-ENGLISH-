package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        LocalBookmarkEntity::class,
        LocalProgressEntity::class,
        LocalTestResultEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppLocalDatabase : RoomDatabase() {
    abstract fun studentDao(): LocalStudentDao

    companion object {
        @Volatile
        private var INSTANCE: AppLocalDatabase? = null

        fun getInstance(context: Context): AppLocalDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppLocalDatabase::class.java,
                    "mp_english_hub_local.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
