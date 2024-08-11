package com.tunm17.androidadvance.data.repository

import com.tunm17.androidadvance.data.dao.StudentCourseCrossRefDao
import com.tunm17.androidadvance.data.entity.StudentCourseCrossRef
import com.tunm17.androidadvance.domain.repository.StudentCourseCrossRefRepository
import io.reactivex.Completable

class StudentCourseCrossRefRepositoryImpl(
    private val studentCourseCrossRefDao: StudentCourseCrossRefDao
) : StudentCourseCrossRefRepository {
    override fun insertStudentCourseCrossRef(crossRef: StudentCourseCrossRef): Completable {
        return studentCourseCrossRefDao.insertStudentCourseCrossRef(crossRef)
    }
}