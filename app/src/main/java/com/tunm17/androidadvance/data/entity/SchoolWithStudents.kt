package com.tunm17.androidadvance.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "school_id",
        entityColumn = "school_study_id"
    )
    val students: List<Student>
)
