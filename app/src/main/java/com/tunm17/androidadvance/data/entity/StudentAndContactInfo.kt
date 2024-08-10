package com.tunm17.androidadvance.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class StudentAndContactInfo(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "student_id",
        entityColumn = "student_contact_id"
    )
    val contactInfo: ContactInfo
)