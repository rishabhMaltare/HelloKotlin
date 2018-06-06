package com.rishabh.hellokotlin

/**
 * Created by Rishabh on 30-05-2018.
 */
class Aquarium {

    var length: Int = 10
    var height: Int = 20
    var width: Int = 30

    var volume: Int = length * width * height / 1000

    var funVolume: Int = 0
        get() {
            return length * width * height / 1000
        }

}
