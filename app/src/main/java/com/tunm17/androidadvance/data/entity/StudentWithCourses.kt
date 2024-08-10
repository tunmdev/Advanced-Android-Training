package com.tunm17.androidadvance.data.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class StudentWithCourses(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "student_id",
        entity = Course::class,
        entityColumn = "course_id",
        associateBy = Junction(
            StudentCourseCrossRef::class,
            parentColumn = "student_id_ref",
            entityColumn = "course_id_ref"
        )
    )
    val courses: List<Course>
)