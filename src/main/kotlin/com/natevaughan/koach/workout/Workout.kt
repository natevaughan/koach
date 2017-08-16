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
        var i = 0
        val sb = StringBuilder("Workout $localDate \n")
        activities.forEach { ++i;
            sb.append("Set ").append(i).append(":").append("  $it\n") }
        return sb.toString()
    }
}


interface WorkoutActivity {
    val activity: Activity
    val distance: Distance
}