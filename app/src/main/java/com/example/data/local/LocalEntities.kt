package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "local_bookmarks")
data class LocalBookmarkEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val itemType: String,
    val targetId: String,
    val classLevel: Int,
    val title: String,
    val subtitle: String,
    val createdAtMillis: Long = System.currentTimeMillis()
)

@Entity(tableName = "local_progress")
data class LocalProgressEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val chapterId: String,
    val classLevel: Int,
    val completedSectionsCsv: String,
    val masteryPercent: Int,
    val updatedAtMillis: Long = System.currentTimeMillis()
)

@Entity(tableName = "local_test_history")
data class LocalTestResultEntity(
    @PrimaryKey val id: String,
    val userId: String,
    val testTitle: String,
    val testMode: String,
    val classLevel: Int,
    val totalQuestions: Int,
    val correctCount: Int,
    val wrongCount: Int,
    val skippedCount: Int,
    val percentage: Int,
    val durationSeconds: Int,
    val createdAtMillis: Long = System.currentTimeMillis()
)
