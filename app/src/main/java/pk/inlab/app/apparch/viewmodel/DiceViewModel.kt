package pk.inlab.app.apparch.viewmodel

import android.app.Application
import android.util.Log
import pk.inlab.app.apparch.util.DiceHelper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import pk.inlab.app.apparch.LOG_TAG

class DiceViewModel(app: Application): AndroidViewModel(app) {

    val valueInt = MutableLiveData<Int>()
    val sum = MutableLiveData<Int>()
    val isCont = MutableLiveData<Boolean>()

    init {
        valueInt.value = 0
        sum.value = 0
        isCont.value = true
    }

    fun rollDice(roundCounter: Int) {

        valueInt.value = DiceHelper.getDie()
        // checking null safety
        sum.value = sum.value?.plus(valueInt.value!!)

        // check if continue or not
        isCont.value = roundCounter != 6
    }

    fun resetValues() {
        sum.value = 0
        valueInt.value = 0
    }


}

