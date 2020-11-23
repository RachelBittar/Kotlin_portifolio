package bittar.rachel.shoesstores.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailsViewModelFactory(private val finalimage: Int, private val finalshoes: String, private val finaprice: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(finalimage, finalshoes, finaprice) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}