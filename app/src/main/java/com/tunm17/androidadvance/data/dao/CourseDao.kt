package com.tunm17.androidadvance.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.tunm17.androidadvance.data.entity.Course
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.data.entity.SchoolWithStudents
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CourseDao {
    @Insert
    fun insertCourse(course: Course): Single<Long>

    @Query("SELECT * FROM course WHERE course_id = :courseId")
    fun getCourseById(courseId: Int): Single<Course>

    @Query("SELECT * FROM course")
    fun getAllCourses(): Single<List<Course>>
}