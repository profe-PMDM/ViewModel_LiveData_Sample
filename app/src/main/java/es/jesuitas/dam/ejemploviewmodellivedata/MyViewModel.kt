package es.jesuitas.dam.ejemploviewmodellivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {

    private val _likeCount = MutableLiveData<Int>(0)
    val likeCount: LiveData<Int>
        get() = _likeCount

    fun increaseLikes() {
        if (_likeCount.value!! < 100) {
            _likeCount.value = _likeCount.value!! + 1
        }
    }
}