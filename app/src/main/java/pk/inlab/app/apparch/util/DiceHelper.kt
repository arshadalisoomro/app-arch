package pk.inlab.app.apparch.util

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random


class DiceHelper {

    // equivalent to static methods in java
    companion object {

        //var newInt:Int = 0

        //Get random number between 1 and 6
        public fun getDie(): Int {
            return Random.nextInt(1, 7)
        }

//        fun sumUpDice(context: Application, valueInt: Int?): String? {
//
//            valueInt  += valueInt!!
//            return "Your score is $valueInt"
//        }

    }

}