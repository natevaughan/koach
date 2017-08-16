package com.natevaughan.koach.workout

import com.natevaughan.koach.workout.interval.Activity
import com.natevaughan.koach.workout.interval.Distance
import com.natevaughan.koach.workout.interval.Time

/**
 * Created by nate on 7/6/17
 */
class IntervalSet(override val activity: Activity, val distanceEach: Distance, val intervalTimeEach: Time, val completionTimes: Array<Time>) : WorkoutActivity {

    val totalTime : Time
        get() {
            return Time(intervalTimeEach.seconds * completionTimes.size)
        }


    override val distance: Distance
        get() {
            return Distance(distanceEach.distance * completionTimes.size, distanceEach.distanceUnit)
        }

    override fun toString(): String = "$activity $distanceEach $intervalTimeEach x ${completionTimes.size}"
}