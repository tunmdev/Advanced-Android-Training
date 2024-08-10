package com.tunm17.androidadvance.data.entity

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (
    tableName = "contact_info",
    foreignKeys = [
        ForeignKey(entity = Student::class, parentColumns = ["student_id"], childColumns = ["student_contact_id"], onDelete = ForeignKey.CASCADE ),
    ],
    indices = [
        Index(value = ["student_contact_id"]),
    ]
)
data class ContactInfo(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "contact_info_id") val contactInfoId: Int = 0,
    val email: String,
    @ColumnInfo(name = "student_contact_id") val studentContactId: Int // 1-1 relationship
)
