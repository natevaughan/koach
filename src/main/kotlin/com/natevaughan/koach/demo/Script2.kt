package com.natevaughan.koach.demo

import com.natevaughan.koach.workout.ActivitySet
import com.natevaughan.koach.workout.Workout
import com.natevaughan.koach.workout.interval.*

/**
 * Created by nate on 7/20/17
 */

fun main(args: Array<String>) {

    val interval1 = WorkoutInterval(Activity.SWIM, Distance(100.0, DistanceUnit.METERS), Time(1,30))
    val interval2 = WorkoutInterval(Activity.SWIM, Distance(100.0, DistanceUnit.METERS), Time(1,29))
    val interval3 = WorkoutInterval(Activity.SWIM, Distance(100.0, DistanceUnit.METERS), Time(1,28))

    val swimSet = ActivitySet(arrayOf(interval1, interval2, interval3))

    val workout = Workout(arrayListOf(swimSet))

    println(distanceReport(workout))
}

fun oldMain(args: Array<String>) {
    println(Color.ORANGE.rgbHexString())
    println(mnemonic(Color.BLUE))
    println(mix(Color.BLUE,Color.YELLOW))
    println(mix(Color.BLUE,Color.ORANGE))
}

fun mnemonic(color: Color) : String {
    when (color) {
        Color.BLUE -> return "foo"
        Color.ORANGE -> return "bar"
        else -> {
            return "baz"
        }
    }
}
fun mix(color1: Color, color2: Color) : Color {
    when (setOf(color1, color2)) {
        setOf(Color.BLUE, Color.RED) -> return Color.PURPLE
        setOf(Color.RED, Color.YELLOW) -> return Color.ORANGE
        setOf(Color.BLUE, Color.YELLOW) -> return Color.GREEN
    }
    throw Exception("could not mix colors")
}