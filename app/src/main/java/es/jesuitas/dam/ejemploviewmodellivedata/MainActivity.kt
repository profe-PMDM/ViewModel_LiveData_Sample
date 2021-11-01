package es.jesuitas.dam.ejemploviewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.jesuitas.dam.ejemploviewmodellivedata.databinding.ActivityMainBinding

const val LIKE_COUNT = "Likes Count"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var likeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieving saved Likes Count
        if (savedInstanceState != null) {
            likeCount = savedInstanceState.getInt(LIKE_COUNT, 0)
            updateLikeTextView()
            updateProgressBar()
        }
        
        binding.likeButton.setOnClickListener{increaseLikes()}
    }

    private fun increaseLikes() {
        if (likeCount < 100) {
            likeCount++
            updateLikeTextView()
            updateProgressBar()
        } else {
            Toast.makeText(this, getString(R.string.max_likes_reached),
                Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun updateLikeTextView() {
        binding.likes.text = likeCount.toString()
    }

    private fun updateProgressBar() {
        binding.progressBar.progress = likeCount
    }

    // Saving likeCount value into Bundle object
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LIKE_COUNT, likeCount)
    }
}