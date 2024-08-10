package com.tunm17.androidadvance.data.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Data entity: represent tables in your app's database.
 * Each instance of Word represents a row in a word table in the app's database.
 * 1. Anatomy of an @Entity
 *      By default, Room uses the class name as the database table name.
 *      If you want the table to have a different name, set the tableName property of the @Entity annotation.
 *  Details: https://developer.android.com/training/data-storage/room/defining-data
 */
@Entity(
    tableName = "student",
    foreignKeys = [
        ForeignKey(entity = School::class, parentColumns = ["school_id"], childColumns = ["school_study_id"], onDelete = ForeignKey.CASCADE ),
    ],
    indices = [
        Index(value = ["school_study_id"]),
    ]
)
data class Student(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "student_id") val studentId: Int = 0,
    @ColumnInfo(name = "student_name") val name: String,
    @ColumnInfo(name = "school_study_id") val schoolStudyId: Int
)
