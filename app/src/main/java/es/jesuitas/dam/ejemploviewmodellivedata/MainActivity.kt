package es.jesuitas.dam.ejemploviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import androidx.lifecycle.Observer

import es.jesuitas.dam.ejemploviewmodellivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewModel = viewModel
        
        binding.likeButton.setOnClickListener{
            viewModel.increaseLikes()
        }

        val linkCount_Observer = Observer<Int> { newValue ->
            binding.likes.text = newValue.toString()
            binding.progressBar.progress = newValue
        }

        viewModel.likeCount.observe(this,linkCount_Observer)

    }
}