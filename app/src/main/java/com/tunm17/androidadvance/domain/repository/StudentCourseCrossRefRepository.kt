package com.tunm17.androidadvance.domain.repository

import com.tunm17.androidadvance.data.entity.StudentCourseCrossRef
import io.reactivex.Completable

interface StudentCourseCrossRefRepository {
    fun insertStudentCourseCrossRef(crossRef: StudentCourseCrossRef): Completable
}