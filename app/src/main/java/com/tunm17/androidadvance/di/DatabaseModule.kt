package com.tunm17.androidadvance.di

import android.app.Application
import androidx.room.Room
import com.tunm17.androidadvance.data.StudentDatabase
import com.tunm17.androidadvance.data.dao.ContactInfoDao
import com.tunm17.androidadvance.data.dao.CourseDao
import com.tunm17.androidadvance.data.dao.SchoolDao
import com.tunm17.androidadvance.data.dao.StudentCourseCrossRefDao
import com.tunm17.androidadvance.data.dao.StudentDao
import com.tunm17.androidadvance.data.dao.StudentWithCoursesDao
import com.tunm17.androidadvance.data.repository.CourseRepositoryImpl
import com.tunm17.androidadvance.domain.repository.CourseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideStudentDatabase(application: Application): StudentDatabase {
        return Room.databaseBuilder(application, StudentDatabase::class.java, "student_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideStudentDao(db: StudentDatabase): StudentDao {
        return db.studentDao()
    }

    @Provides
    @Singleton
    fun provideCourseDao(db: StudentDatabase): CourseDao {
        return db.courseDao()
    }

    @Provides
    @Singleton
    fun provideSchoolDao(db: StudentDatabase): SchoolDao {
        return db.schoolDao()
    }

    @Provides
    @Singleton
    fun provideContactInfoDao(db: StudentDatabase): ContactInfoDao {
        return db.contactInfoDao()
    }

    @Provides
    @Singleton
    fun provideStudentWithCoursesDao(db: StudentDatabase): StudentWithCoursesDao {
        return db.studentWithCoursesDao()
    }

    @Provides
    @Singleton
    fun provideStudentCourseCrossRefDao(db: StudentDatabase): StudentCourseCrossRefDao {
        return db.studentCourseCrossRefDao()
    }
}