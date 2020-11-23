

package bittar.rachel.shoesstores.shoes


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import bittar.rachel.shoesstores.R


class ShoesListViewModel : ViewModel() {


    data class Shoes(val imageId: Int, val details: String, val price: Int)



    private val _shoe = MutableLiveData<Shoes>()
    val shoe: LiveData<Shoes>
        get() = _shoe

    private val _price = MutableLiveData<Int>()
    val price: LiveData<Int>
        get() = _price

    private val _image = MutableLiveData<Int>()
    val image: LiveData<Int>
        get() = _image

    private val _details = MutableLiveData<String>()
    val details: LiveData<String>
        get() = _details

    private val _eventGiveDetails = MutableLiveData<Boolean>()
    val eventGiveDetails: LiveData<Boolean>
        get() = _eventGiveDetails

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

   // private lateinit var wordList: MutableList<String>

    private lateinit var allShoes: MutableList<Shoes>

    init {

        resetListShoes()

        _price.value = allShoes.get(0).price
        _details.value = allShoes.get(0).details
        _image.value  =  allShoes.get(0).imageId

        Log.i("SListViewModelo init", _image.value.toString())
    }


    private fun resetListShoes() {

        allShoes = mutableListOf(
            Shoes(R.drawable.balet, "Ballet shoe", 10),
            Shoes(R.drawable.bluesport, "Blue Sport Sneakers", 5),
            Shoes(R.drawable.social, "Social", 20),
            Shoes(R.drawable.scarpin, "Scarpin", 50),
        )

        allShoes.shuffle()
    }

    private fun nextWord() {
        if (allShoes.isEmpty()) {
            resetListShoes()
        }

        _shoe.value = allShoes.removeAt(0)
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        nextWord()
        _image.value = (_shoe.value)?.imageId
    }

    fun onDetails() {
        _eventGiveDetails.value = true
        _price.value = (_shoe.value)?.price
        _details.value =(_shoe.value)?.details
        _image.value = (_shoe.value)?.imageId

      //  _eventGiveDetails.value = true
        Log.i("ShoesListViewModelooo", _image.value.toString())

    }


    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}

