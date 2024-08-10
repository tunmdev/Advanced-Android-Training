package com.tunm17.androidadvance.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.tunm17.androidadvance.data.entity.StudentWithCourses
import io.reactivex.Single

@Dao
interface StudentWithCoursesDao {
    @Transaction
    @Query("SELECT * FROM student WHERE student_id = :studentId")
    fun getStudentWithCourses(studentId: Int): Single<StudentWithCourses>

    @Transaction
    @Query("SELECT * FROM student")
    fun getAllStudentsWithCourses(): Single<List<StudentWithCourses>>
}