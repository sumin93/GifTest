package ru.sumin.giftest.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import ru.sumin.giftest.R
import ru.sumin.giftest.presentation.model.MainViewState

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(
                MainViewModel::class.java
        )
        viewModel.screenState.observe(this, Observer {
            when (it) {
                is MainViewState.ShowState     -> {
                    Log.d(LOG_TAG, "ShowState: $it")
                }
                is MainViewState.ProgressState -> {
                    Log.d(LOG_TAG, "ProgressState: $it")
                }
                is MainViewState.ErrorState    -> {
                    Log.d(LOG_TAG, "ErrorState: $it")
                }
            }
        })
        buttonNext.setOnClickListener { viewModel.showNextGif() }
        buttonPrev.setOnClickListener { viewModel.showPreviousGif() }
    }

    private companion object {
        private const val LOG_TAG = "MainActivity"
    }
}
