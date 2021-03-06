package bittar.rachel.shoesstores.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DetailsViewModel(finalImage: Int, finalShoes: String, finalPrice: Int) : ViewModel() {


    private val _finalImage = MutableLiveData<Int>()
    val finalImage: LiveData<Int>
        get() = _finalImage

    private val _finalShoes = MutableLiveData<String>()
    val fshoes: LiveData<String>
        get() = _finalShoes


    private val _finalprice = MutableLiveData<Int>()
    val fprice: LiveData<Int>
        get() = _finalprice

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        _finalShoes.value = finalShoes
        _finalprice.value = finalPrice
        _finalImage.value = finalImage


    }
    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun onPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}