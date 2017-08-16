package com.natevaughan.koach.workout

import com.natevaughan.koach.workout.interval.Activity
import com.natevaughan.koach.workout.interval.Distance
import com.natevaughan.koach.workout.interval.Time

/**
 * Created by nate on 7/20/17
 */
data class SimpleActivity(override val activity: Activity, override val distance: Distance, val time: Time) : WorkoutActivity {
    override fun toString(): String = "$activity $distance $time"
}