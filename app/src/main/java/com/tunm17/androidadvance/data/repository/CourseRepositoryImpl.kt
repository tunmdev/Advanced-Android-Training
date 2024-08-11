package com.tunm17.androidadvance.data.repository

import com.tunm17.androidadvance.data.dao.CourseDao
import com.tunm17.androidadvance.data.entity.Course
import com.tunm17.androidadvance.domain.repository.CourseRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class CourseRepositoryImpl(private val courseDao: CourseDao): CourseRepository {
    override fun insertCourse(course: Course): Single<Long> {
        return courseDao.insertCourse(course)
    }

    override fun getCourseById(courseId: Int): Single<Course> {
        return courseDao.getCourseById(courseId)
    }

    override fun getAllCourses(): Single<List<Course>> {
        return courseDao.getAllCourses()
    }
}