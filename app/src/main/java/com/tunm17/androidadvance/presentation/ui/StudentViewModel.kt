package com.tunm17.androidadvance.presentation.ui

import androidx.lifecycle.ViewModel
import com.tunm17.androidadvance.data.entity.Course
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.data.entity.Student
import com.tunm17.androidadvance.data.entity.StudentCourseCrossRef
import com.tunm17.androidadvance.data.entity.StudentWithCourses
import com.tunm17.androidadvance.domain.repository.CourseRepository
import com.tunm17.androidadvance.domain.repository.SchoolRepository
import com.tunm17.androidadvance.domain.repository.StudentCourseCrossRefRepository
import com.tunm17.androidadvance.domain.repository.StudentRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(
    private val schoolRepository: SchoolRepository,
    private val courseRepository: CourseRepository,
    private val studentRepository: StudentRepository,
    private val studentCourseCrossRefRepository: StudentCourseCrossRefRepository
) : ViewModel() {
    // School operations
    fun insertSchool(school: School): Single<Long> {
        return schoolRepository.insertSchool(school)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getSchoolById(schoolId: Int): Single<School> {
        return schoolRepository.getSchoolById(schoolId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getAllSchools(): Maybe<List<School>> {
        return schoolRepository.getAllSchools()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    // Course operations
    fun insertCourse(course: Course): Single<Long> {
        return courseRepository.insertCourse(course)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getCourseById(courseId: Int): Single<Course> {
        return courseRepository.getCourseById(courseId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getAllCourses(): Maybe<List<Course>> {
        return courseRepository.getAllCourses()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    // Student operations
    fun insertStudent(student: Student): Single<Long> {
        return studentRepository.insertStudent(student)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getStudentById(studentId: Int): Single<Student> {
        return studentRepository.getStudentById(studentId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getAllStudents(): Maybe<List<Student>> {
        return studentRepository.getAllStudents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getStudentWithCourses(studentId: Int): Single<StudentWithCourses> {
        return studentRepository.getStudentWithCourses(studentId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    // StudentCourseCrossRef operations
    fun insertStudentCourseCrossRef(crossRef: StudentCourseCrossRef): Completable {
        return studentCourseCrossRefRepository.insertStudentCourseCrossRef(crossRef)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}