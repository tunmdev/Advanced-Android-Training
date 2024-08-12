package com.tunm17.androidadvance

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.tunm17.androidadvance.data.StudentDatabase
import com.tunm17.androidadvance.data.entity.School
import com.tunm17.androidadvance.data.repository.CourseRepositoryImpl
import com.tunm17.androidadvance.data.repository.SchoolRepositoryImpl
import com.tunm17.androidadvance.data.repository.StudentCourseCrossRefRepositoryImpl
import com.tunm17.androidadvance.data.repository.StudentRepositoryImpl
import com.tunm17.androidadvance.presentation.ui.StudentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val studentViewModel: StudentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val school = School(name = "Example School")
        studentViewModel.insertSchool(school)
            .subscribe(
                { id -> Log.v("tunm1", "Insert school successfully. received id: $id")  },
                { error -> Log.v("tunm1", "Error. $error") }
            )
    }
}