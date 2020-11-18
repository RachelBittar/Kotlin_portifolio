

package bittar.rachel.shoesstores.shoes


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoesListViewModel : ViewModel() {

    private val _shoe = MutableLiveData<String>()
    val shoe: LiveData<String>
        get() = _shoe


    private val _price = MutableLiveData<Int>()
    val price: LiveData<Int>
        get() = _price


    private val _eventGiveDetails = MutableLiveData<Boolean>()
    val eventGiveDetails: LiveData<Boolean>
        get() = _eventGiveDetails

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    private lateinit var wordList: MutableList<String>

    init {
        resetList()
        nextWord()
        _price.value = 0
       // _eventGiveDetails.value = true

    }

    private fun resetList() {
        wordList = mutableListOf(
            "Adidas Kampung",
            "Ballet shoe",
            "Pointe shoe",
            "Bast shoe",
            "Blucher shoe",
            "Boat shoe",
            "Brogan (shoes)",
            "Brogue shoe",
            "Brothel creeper",
            "Bucks",
            "Cantabrian albarcas",
            "Chelsea boot",
            "Chopine",
            "Chukka boot",
            "Climbing shoe",
            "Clog"
        )
        wordList.shuffle()
    }


    private fun nextWord() {
        if (wordList.isEmpty()) {
            resetList()
        }
        _shoe.value = wordList.removeAt(0)
    }

    /** Methods for buttons presses **/

    fun onSkip() {
      //  _price.value = (_price.value)?.minus(1)
        _price.value = (_price.value)?.plus(1)
        nextWord()
    }

    fun onDetails() {
        _price.value = (_price.value)?.plus(1)

        _eventGiveDetails.value = true
        Log.i("ShoesListViewModelooo", _eventGiveDetails.value.toString())

    }


    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}

