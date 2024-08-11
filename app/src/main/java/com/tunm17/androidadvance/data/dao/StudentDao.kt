package com.tunm17.androidadvance.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.tunm17.androidadvance.data.entity.Student
import com.tunm17.androidadvance.data.entity.StudentAndContactInfo
import com.tunm17.androidadvance.data.entity.StudentWithCourses
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single

/**
 * DAO (data access object): methods that offer abstract access to your app's database
 * By default, all queries must be executed on a separate thread.
 * Details:
 *  - DAO
 *  - Async query: https://developer.android.com/training/data-storage/room/async-queries
 */
@Dao
interface StudentDao {

    @Query("SELECT * FROM student WHERE student_id = :studentId")
    fun getStudentById(studentId: Int): Single<Student>

    @Query("SELECT * FROM student")
    fun getAllStudents(): Maybe<List<Student>>

    @Insert
    fun insert(student: Student): Single<Long>

    @Transaction
    @Query("SELECT * FROM student WHERE student_id = :studentId")
    fun getStudentAndContactInfo(studentId: Int): Single<StudentAndContactInfo?>

}