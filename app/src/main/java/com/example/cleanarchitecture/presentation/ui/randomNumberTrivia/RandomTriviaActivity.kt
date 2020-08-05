package com.example.cleanarchitecture.presentation.ui.randomNumberTrivia

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.domain.commons.DataState
import com.example.cleanarchitecture.domain.entities.NumberTrivia
import com.example.cleanarchitecture.presentation.commons.BaseActivity
import com.example.cleanarchitecture.presentation.ui.concreteNumberTrivia.ConcreteTriviaActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_radnom_trivia.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RandomTriviaActivity : BaseActivity() {

    private val viewModel: RandomTriviaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radnom_trivia)

        viewModel.dataState.observe(this, Observer {
            hideProgressBar()
            when(it) {
                is DataState.Loading -> showProgressBar()
                is DataState.Success<NumberTrivia> -> textView.text = it.data.trivia
                is DataState.ErrorOccurred -> showErrorDialog(it.failure)
            }
        })

        button.setOnClickListener { startActivity(Intent(this, ConcreteTriviaActivity::class.java)) }
    }

    override fun onResume() {
        super.onResume()
        viewModel.mapEventToState(GetRandomNumberTriviaEvent)
    }
}