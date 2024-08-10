package com.tunm17.androidadvance.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tunm17.androidadvance.data.dao.ContactInfoDao
import com.tunm17.androidadvance.data.dao.CourseDao
import com.tunm17.androidadvance.data.dao.SchoolDao
import com.tunm17.androidadvance.data.dao.StudentCourseCrossRefDao
import com.tunm17.androidadvance.data.dao.StudentDao
import com.tunm17.androidadvance.data.dao.StudentWithCoursesDao
import com.tunm17.androidadvance.data.entity.ContactInfo
import com.tunm17.androidadvance.data.entity.Course
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.data.entity.Student
import com.tunm17.androidadvance.data.entity.StudentCourseCrossRef

@Database(
    entities = [Student::class, Course::class, School::class, ContactInfo::class, StudentCourseCrossRef::class],
    version = 1,
    exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao
    abstract fun schoolDao(): SchoolDao
    abstract fun courseDao(): CourseDao
    abstract fun contactInfoDao(): ContactInfoDao
    abstract fun studentCourseCrossRefDao(): StudentCourseCrossRefDao
    abstract fun studentWithCoursesDao(): StudentWithCoursesDao

    companion object {
        @Volatile
        private var INSTANCE: StudentDatabase? = null

        fun getDatabase(context: Context): StudentDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, StudentDatabase::class.java, "student_db")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}