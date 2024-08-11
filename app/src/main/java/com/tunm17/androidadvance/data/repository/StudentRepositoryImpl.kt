package com.tunm17.androidadvance.data.repository

import com.tunm17.androidadvance.data.dao.StudentDao
import com.tunm17.androidadvance.data.dao.StudentWithCoursesDao
import com.tunm17.androidadvance.data.entity.Student
import com.tunm17.androidadvance.data.entity.StudentWithCourses
import com.tunm17.androidadvance.domain.repository.StudentRepository
import io.reactivex.Single

class StudentRepositoryImpl(
    private val studentDao: StudentDao,
    private val studentWithCoursesDao: StudentWithCoursesDao
) : StudentRepository {
    override fun insertStudent(student: Student): Single<Long> {
        return studentDao.insert(student)
    }

    override fun getStudentById(studentId: Int): Single<Student> {
        return studentDao.getStudentById(studentId)
    }

    override fun getAllStudents(): Single<List<Student>> {
        return studentDao.getAllStudents()
    }

    override fun getStudentWithCourses(studentId: Int): Single<StudentWithCourses> {
        return studentWithCoursesDao.getStudentWithCourses(studentId)
    }
}