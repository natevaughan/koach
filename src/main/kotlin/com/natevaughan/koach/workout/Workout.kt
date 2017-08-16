package com.natevaughan.koach.workout

import com.natevaughan.koach.workout.interval.Activity
import com.natevaughan.koach.workout.interval.Distance
import java.time.LocalDate
import kotlin.collections.ArrayList

/**
 * Created by nate on 7/6/17
 */
class Workout (val localDate: LocalDate = LocalDate.now()) {

    val activities: ArrayList<WorkoutActivity> = ArrayList()

    override fun toString(): String {
        var i = 1
        val sb = StringBuilder("Workout $localDate \n")
        sb.append("Set ")
        sb.append(i).append(":")
        activities.forEach { ++i; sb.append("  $it") }
        return sb.toString()
    }
}


interface WorkoutActivity {
    val activity: Activity
    val distance: Distance
}