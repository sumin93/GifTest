package ru.sumin.giftest.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*
import ru.sumin.giftest.R
import ru.sumin.giftest.presentation.model.MainViewState

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.screenState.observe(this, Observer {
            buttonPrev.isEnabled = it.previousButtonEnabled
            textViewGifDescription.text = ""
            when (it) {
                is MainViewState.ShowState -> {
                    textViewGifDescription.text = it.gifToShow.description
                    Glide.with(this)
                        .addDefaultRequestListener(object : RequestListener<Any> {
                            override fun onLoadFailed(
                                e: GlideException?,
                                model: Any?,
                                target: Target<Any>?,
                                isFirstResource: Boolean
                            ): Boolean {
                                showError()
                                return false
                            }

                            override fun onResourceReady(
                                resource: Any?,
                                model: Any?,
                                target: Target<Any>?,
                                dataSource: DataSource?,
                                isFirstResource: Boolean
                            ): Boolean {
                                hideError()
                                hideProgress()
                                return false
                            }
                        })
                        .load(it.gifToShow.gifURL)
                        .into(imageViewGif)
                }
                is MainViewState.ProgressState -> {
                    showProgress()
                }
                is MainViewState.ErrorState -> {
                    showError()
                }
            }
        })
        buttonNext.setOnClickListener { viewModel.showNextGif() }
        buttonPrev.setOnClickListener { viewModel.showPreviousGif() }
    }

    private fun showProgress() {
        viewProgress.visibility = View.VISIBLE
        textViewError.visibility = View.GONE
    }

    private fun hideProgress() {
        viewProgress.visibility = View.GONE
    }

    private fun showError() {
        viewProgress.visibility = View.GONE
        textViewError.visibility = View.VISIBLE
    }

    private fun hideError() {
        textViewError.visibility = View.GONE
    }
}
