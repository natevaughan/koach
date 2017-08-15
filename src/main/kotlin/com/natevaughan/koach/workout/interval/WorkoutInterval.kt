package com.natevaughan.koach.workout.interval

/**
 * Created by nate on 7/20/17.
 */
data class WorkoutInterval(val activity: Activity, val distance: Distance, val timeEach: Time) {
    override fun toString(): String = "$activity $distance $timeEach"
}