package com.tunm17.androidadvance.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school")
data class School(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "school_id") val schoolId: Int = 0,
    val name: String
)