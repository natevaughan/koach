package com.natevaughan.koach.workout

import com.natevaughan.koach.workout.interval.Activity
import com.natevaughan.koach.workout.interval.Distance
import com.natevaughan.koach.workout.interval.Time
import com.natevaughan.koach.workout.interval.WorkoutInterval

/**
 * Created by nate on 7/6/17
 */
class ActivitySet(val activity: Activity, val distance: Distance, val timeEach: Time) {

    val totalSeconds : Long
        get() {
            // todo: make me more kotlin
            var sum = 0L
//            intervals.forEach { sum += it.timeEach.totalSeconds }
            return sum
        }


    override fun toString(): String = "$activity $distance $timeEach"
}