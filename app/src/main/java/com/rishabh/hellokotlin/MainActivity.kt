package com.rishabh.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dayOfWeek()

        gettingStatementValue()

        wishTheKotlin(Calendar.getInstance().get(Calendar.HOUR_OF_DAY).toString())

        getFortuneCookie("")

        multipleCookies()

        Log.d(TAG, ".......................................................................")

        Log.d(TAG, canAddFish(10.0, listOf(3, 3, 3)).toString())
        Log.d(TAG, canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false).toString())
        Log.d(TAG, canAddFish(9.0, listOf(1, 1, 3), 3).toString())
        Log.d(TAG, canAddFish(10.0, listOf(), 7, true).toString())

        Log.d(TAG, ".......................................................................")

        filterTest()

        Log.d(TAG, ".......................................................................")

        lambdaTest()

        randomTest()

        rollingTheDice()

        buildTheAquarium()


    }

    private fun buildTheAquarium() {

        val aquarium = Aquarium()
        aquarium.length = 10
        aquarium.width = 12
        aquarium.height = 2

        Log.d(TAG, "aquarium volume = ${aquarium.volume}")
        Log.d(TAG, "aquarium funVolume = ${aquarium.funVolume}")

        Log.d(TAG, ".......................................................................")

    }

    private fun rollingTheDice() {
        val rollTheDice = { from: Int, to: Int -> (Math.random() * (to - from) + from + 1).toInt()}
        Log.d(TAG, rollTheDice(0, 12).toString())
        Log.d(TAG, rollTheDice(0, 12).toString())
        Log.d(TAG, rollTheDice(0, 12).toString())
        Log.d(TAG, rollTheDice(0, 12).toString())
        Log.d(TAG, rollTheDice(0, 12).toString())


    }

    private fun randomTest() {
        val random1 = Math.random()
        val random2 = { Math.random() }

        Log.d(TAG, random1.toString())
        Log.d(TAG, random2().toString())

        Log.d(TAG, random1.toString())
        Log.d(TAG, random2().toString())

        Log.d(TAG, random1.toString())
        Log.d(TAG, random2().toString())

        Log.d(TAG, ".......................................................................")
    }

    private fun lambdaTest() {
        val lambda = { Log.d(TAG, "lambdaTest") }
        lambda()

        val waterFilter: (Int, Int) -> Int = { dirty, water -> dirty * 100 / water }
        Log.d(TAG, waterFilter(10, 100).toString())

        val dirty = updateDirty(90, 100, waterFilter)
        val dirtyAfterFeed = updateDirty(90, 100, ::feedFish)

        Log.d(TAG, dirty.toString())
        Log.d(TAG, dirtyAfterFeed.toString())

        Log.d(TAG, ".......................................................................")
    }

    private fun feedFish(food: Int, water: Int): Int {
        return food.times(10).div(100)
    }


    fun updateDirty(dirty: Int, water: Int, operation: (Int, Int) -> Int): Int {
        return operation(dirty, water)
    }


    private fun filterTest() {
        val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

        val filteredList = spices.filter { it.contains("curry") }

        Log.d(TAG, filteredList.sortedBy { it.length }.toString())
        Log.d(TAG, filteredList.reversed().toString())
        Log.d(TAG, spices.filter { it.startsWith('c').and(it.endsWith('e')) }.toString())
        Log.d(TAG, spices.take(3).filter { it.startsWith('c') }.toString())
        Log.d(TAG, spices.sortedBy { it }.reversed().toString())

    }


    private fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations:
    Boolean = true): Boolean {
        return (tankSize.times(if (hasDecorations) 0.8 else 1.0).toInt() - currentFish.sum()) >= fishSize
    }

    private fun multipleCookies() {
        val fortuneList = getFortuneList()
        for (i in 1..10) {
            val index = (Math.random() * fortuneList.size).toInt()
            if (fortuneList[index].contains("Take it easy")) {
                Log.d(TAG, "Take it easy!!")
                break
            } else {
                Log.d(TAG, fortuneList[index])
            }
        }
    }

    private fun getFortuneCookie(birthDate: String) {
        val fortuneList = getFortuneList()
        val birthDateInt = birthDate.toIntOrNull()

        Log.d(TAG, fortuneList[birthDateInt?.rem(fortuneList.size) ?: 1])
    }

    private fun getFortuneList(): List<String> {
        return listOf(
                "You will have a great day!",
                "Things will go well for you today.",
                "Enjoy a wonderful day of success.",
                "Be humble and all will turn out well.",
                "Today is a good day for exercising restraint.",
                "Take it easy and enjoy life!",
                "Treasure your friends because they are your greatest fortune."
        )
    }

    private fun wishTheKotlin(hour: String) {
        val hourInt = hour.toInt()
        Log.d(TAG, if (hourInt in (0..12)) "Good Morning, Kotlin" else "Good Evening, Kotlin")
    }

    private fun gettingStatementValue() {
        val isUnit = println("Random Text!")
        Log.d(TAG, isUnit.toString())

        val temperature = Math.random().times(50).toInt()
        val isHot = temperature > 30

        val environment = "The ambiance is ${if (isHot) "cool" else "hot"}"
        Log.d(TAG, environment)
    }


    private fun dayOfWeek() {
        Log.d(TAG, "What day is it today?")

        val day = getDayOfWeek()

        Log.d(TAG, day)
        Log.d(TAG, System.currentTimeMillis().toString())
    }

    private fun getDayOfWeek(): String {
        var day = ""

        when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            1 -> day = "Sunday"
            2 -> day = "Monday"
            3 -> day = "Tuesday"
            4 -> day = "Wednesday"
            5 -> day = "Thursday"
            6 -> day = "Friday"
            7 -> day = "Saturday"
        }
        return day
    }


}
