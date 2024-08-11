package com.tunm17.androidadvance

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.tunm17.androidadvance.data.StudentDatabase
import com.tunm17.androidadvance.data.dao.StudentWithCoursesDao
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.data.repository.CourseRepositoryImpl
import com.tunm17.androidadvance.data.repository.SchoolRepositoryImpl
import com.tunm17.androidadvance.data.repository.StudentCourseCrossRefRepositoryImpl
import com.tunm17.androidadvance.data.repository.StudentRepositoryImpl
import com.tunm17.androidadvance.presentation.StudentViewModelFactory
import com.tunm17.androidadvance.presentation.ui.StudentViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var studentViewModel: StudentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = StudentDatabase.getDatabase(this)
        val schoolRepository = SchoolRepositoryImpl(database.schoolDao())
        val courseRepository = CourseRepositoryImpl(database.courseDao())
        val studentRepository = StudentRepositoryImpl(database.studentDao(), database.studentWithCoursesDao())
        val studentCourseCrossRefRepository = StudentCourseCrossRefRepositoryImpl(database.studentCourseCrossRefDao())

        studentViewModel = ViewModelProvider(
            this,
            StudentViewModelFactory(
                schoolRepository,
                courseRepository,
                studentRepository,
                studentCourseCrossRefRepository
            )
        ).get(StudentViewModel::class.java)

        // Example of inserting a school
        val school = School(name = "Example School")
        studentViewModel.insertSchool(school)
            .subscribe(
                { id -> Log.v("tunm1", "Insert school successfully. received id: $id")  },
                { error -> Log.v("tunm1", "Error. $error") }
            )
    }
}