package com.tunm17.androidadvance.domain.repository

import com.tunm17.androidadvance.data.entity.Course
import io.reactivex.Single

interface CourseRepository {
    fun insertCourse(course: Course): Single<Long>
    fun getCourseById(courseId: Int): Single<Course>
    fun getAllCourses(): Single<List<Course>>
}