package es.jesuitas.dam.ejemploviewmodellivedata

import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    private var _likeCount: Int = 0
    val likeCount: Int
        get() = _likeCount

    fun increaseLikes() {
        if (_likeCount < 100) {
            _likeCount++
        }
    }
}