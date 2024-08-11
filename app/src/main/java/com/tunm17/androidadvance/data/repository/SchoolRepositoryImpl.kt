package com.tunm17.androidadvance.data.repository

import com.tunm17.androidadvance.data.dao.SchoolDao
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.domain.repository.SchoolRepository
import io.reactivex.Maybe
import io.reactivex.Single

class SchoolRepositoryImpl(private val schoolDao: SchoolDao) : SchoolRepository {
    override fun insertSchool(school: School): Single<Long> {
        return schoolDao.insertSchool(school)
    }

    override fun getSchoolById(schoolId: Int): Single<School> {
        return schoolDao.getSchoolById(schoolId)
    }

    override fun getAllSchools(): Maybe<List<School>> {
        return schoolDao.getAllSchools()
    }
}