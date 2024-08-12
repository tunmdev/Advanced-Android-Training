package com.tunm17.androidadvance.di

import com.tunm17.androidadvance.data.repository.CourseRepositoryImpl
import com.tunm17.androidadvance.data.repository.SchoolRepositoryImpl
import com.tunm17.androidadvance.data.repository.StudentCourseCrossRefRepositoryImpl
import com.tunm17.androidadvance.data.repository.StudentRepositoryImpl
import com.tunm17.androidadvance.domain.repository.CourseRepository
import com.tunm17.androidadvance.domain.repository.SchoolRepository
import com.tunm17.androidadvance.domain.repository.StudentCourseCrossRefRepository
import com.tunm17.androidadvance.domain.repository.StudentRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {

    @Binds
    abstract fun bindCourseRepository(
        courseRepositoryImpl: CourseRepositoryImpl
    ): CourseRepository

    @Binds
    abstract fun bindSchoolRepository(
        schoolRepositoryImpl: SchoolRepositoryImpl
    ): SchoolRepository

    @Binds
    abstract fun bindStudentRepository(
        studentRepositoryImpl: StudentRepositoryImpl
    ): StudentRepository

    @Binds
    abstract fun bindStudentCourseCrossRefRepository(
        studentCourseCrossRefRepositoryImpl: StudentCourseCrossRefRepositoryImpl
    ): StudentCourseCrossRefRepository
}