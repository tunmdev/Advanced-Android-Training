package com.tunm17.androidadvance.domain.repository

import com.tunm17.androidadvance.data.entity.School
import io.reactivex.Single

interface SchoolRepository {
    fun insertSchool(school: School): Single<Long>
    fun getSchoolById(schoolId: Int): Single<School>
    fun getAllSchools(): Single<List<School>>
}