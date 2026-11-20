package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalStudentDao {
    @Query("SELECT * FROM local_bookmarks WHERE userId = :userId ORDER BY createdAtMillis DESC")
    fun observeBookmarks(userId: String): Flow<List<LocalBookmarkEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertBookmark(bookmark: LocalBookmarkEntity)

    @Query("DELETE FROM local_bookmarks WHERE id = :id AND userId = :userId")
    suspend fun deleteBookmark(id: String, userId: String)

    @Query("SELECT * FROM local_progress WHERE userId = :userId")
    fun observeProgress(userId: String): Flow<List<LocalProgressEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProgress(progress: LocalProgressEntity)

    @Query("SELECT * FROM local_test_history WHERE userId = :userId ORDER BY createdAtMillis DESC")
    fun observeTestHistory(userId: String): Flow<List<LocalTestResultEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTestResult(result: LocalTestResultEntity)
}
