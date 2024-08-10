package com.tunm17.androidadvance.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class Course(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "course_id") val courseId: Int = 0,
    val name: String,
)