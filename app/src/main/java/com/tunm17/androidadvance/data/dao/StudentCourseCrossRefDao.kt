package com.tunm17.androidadvance.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.tunm17.androidadvance.data.entity.Student
import com.tunm17.androidadvance.data.entity.StudentAndContactInfo
import com.tunm17.androidadvance.data.entity.StudentCourseCrossRef
import com.tunm17.androidadvance.data.entity.StudentWithCourses
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
@Dao
interface StudentCourseCrossRefDao {

    @Insert
    fun insertStudentCourseCrossRef(crossRef: StudentCourseCrossRef): Completable

    @Query("DELETE FROM student_course_cross_ref WHERE student_id_ref = :studentId AND course_id_ref = :courseId")
    fun deleteStudentCourseCrossRef(studentId: Int, courseId: Int): Completable

    @Query("SELECT * FROM student_course_cross_ref WHERE student_id_ref = :studentId")
    fun getCoursesForStudent(studentId: Int): Single<List<StudentCourseCrossRef>>

    @Query("SELECT * FROM student_course_cross_ref WHERE course_id_ref = :courseId")
    fun getStudentsForCourse(courseId: Int): Single<List<StudentCourseCrossRef>>

}