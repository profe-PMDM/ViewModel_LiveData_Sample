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
        binding.lifecycleOwner = this  // use Fragment.viewLifecycleOwner for fragments
        
        binding.likeButton.setOnClickListener{
            viewModel.increaseLikes()
        }
    }
}