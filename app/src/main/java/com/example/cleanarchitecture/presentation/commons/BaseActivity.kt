package com.example.cleanarchitecture.presentation.commons

import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecture.domain.commons.Failure
import kotlinx.android.synthetic.main.activity_radnom_trivia.*

abstract class BaseActivity: AppCompatActivity() {

    fun showProgressBar() { progressBar?.visibility = View.VISIBLE }
    fun hideProgressBar() { progressBar?.visibility = View.GONE }
    fun showErrorDialog(failure: Failure) {
        Toast.makeText(this, failure.message, Toast.LENGTH_SHORT).show()
    }

}