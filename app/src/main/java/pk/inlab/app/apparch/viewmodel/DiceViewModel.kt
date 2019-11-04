package pk.inlab.app.apparch.viewmodel

import android.app.Application
import pk.inlab.app.apparch.util.DiceHelper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class DiceViewModel(app: Application): AndroidViewModel(app) {

    val valueInt = MutableLiveData<Int>()
    val sum = MutableLiveData<Int>()

    init {
        valueInt.value = 0
        sum.value = 0
    }

    fun rollDice(){
        valueInt.value = DiceHelper.getDie()
        // checking null safety
        sum.value = sum.value?.plus(valueInt.value!!)
    }

}

