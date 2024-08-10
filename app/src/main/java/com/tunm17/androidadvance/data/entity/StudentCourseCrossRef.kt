package com.tunm17.androidadvance.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "student_course_cross_ref",
    primaryKeys = ["student_id_ref", "course_id_ref"],
    foreignKeys = [
        ForeignKey(entity = Student::class, parentColumns = ["student_id"], childColumns = ["student_id_ref"], ),
        ForeignKey(entity = Course::class, parentColumns = ["course_id"], childColumns = ["course_id_ref"])
    ],
    indices = [
        Index(value = ["student_id_ref"]),
        Index(value = ["course_id_ref"])
    ]
)

data class StudentCourseCrossRef(
    @ColumnInfo(name = "student_id_ref") val studentId: Int,
    @ColumnInfo(name = "course_id_ref") val courseId: Int,
)
