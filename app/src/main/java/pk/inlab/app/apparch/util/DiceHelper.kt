package pk.inlab.app.apparch.util

import kotlin.random.Random


class DiceHelper {

    // equivalent to static methods in java
    companion object {

        //Get random number between 1 and 6
        public fun getDie(): Int {
            return Random.nextInt(1, 7)
        }

    }

}