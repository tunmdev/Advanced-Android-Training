package com.tunm17.androidadvance.data.repository

import com.tunm17.androidadvance.data.dao.CourseDao
import com.tunm17.androidadvance.data.entity.Course
import com.tunm17.androidadvance.domain.repository.CourseRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val courseDao: CourseDao
): CourseRepository {
    override fun insertCourse(course: Course): Single<Long> {
        return courseDao.insertCourse(course)
    }

    override fun getCourseById(courseId: Int): Single<Course> {
        return courseDao.getCourseById(courseId)
    }

    override fun getAllCourses(): Maybe<List<Course>> {
        return courseDao.getAllCourses()
    }
}