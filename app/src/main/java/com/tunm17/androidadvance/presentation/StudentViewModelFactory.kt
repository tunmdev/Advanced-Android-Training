package com.tunm17.androidadvance.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tunm17.androidadvance.domain.repository.CourseRepository
import com.tunm17.androidadvance.domain.repository.SchoolRepository
import com.tunm17.androidadvance.domain.repository.StudentCourseCrossRefRepository
import com.tunm17.androidadvance.domain.repository.StudentRepository
import com.tunm17.androidadvance.presentation.ui.StudentViewModel

class StudentViewModelFactory(
    private val schoolRepository: SchoolRepository,
    private val courseRepository: CourseRepository,
    private val studentRepository: StudentRepository,
    private val studentCourseCrossRefRepository: StudentCourseCrossRefRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return StudentViewModel(
                schoolRepository,
                courseRepository,
                studentRepository,
                studentCourseCrossRefRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}