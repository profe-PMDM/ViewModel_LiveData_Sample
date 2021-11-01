package es.jesuitas.dam.ejemploviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle

import es.jesuitas.dam.ejemploviewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateLikeTextView()
        updateProgressBar()
        
        binding.likeButton.setOnClickListener{
            viewModel.increaseLikes()
            updateLikeTextView()
            updateProgressBar()
        }
    }

    private fun updateLikeTextView() {
        binding.likes.text = viewModel.likeCount.toString()
    }

    private fun updateProgressBar() {
        binding.progressBar.progress = viewModel.likeCount
    }
}