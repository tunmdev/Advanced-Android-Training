package com.tunm17.androidadvance.domain.repository

import com.tunm17.androidadvance.data.entity.Student
import com.tunm17.androidadvance.data.entity.StudentWithCourses
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface StudentRepository {
    fun insertStudent(student: Student): Single<Long>
    fun getStudentById(studentId: Int): Single<Student>
    fun getAllStudents(): Single<List<Student>>
    fun getStudentWithCourses(studentId: Int): Single<StudentWithCourses>
}