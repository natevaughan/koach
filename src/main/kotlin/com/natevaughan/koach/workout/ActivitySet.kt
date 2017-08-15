package com.natevaughan.koach.workout

import com.natevaughan.koach.workout.interval.Activity
import com.natevaughan.koach.workout.interval.Distance
import com.natevaughan.koach.workout.interval.Time

/**
 * Created by nate on 7/6/17
 */
class ActivitySet(val activity: Activity, val distance: Distance, val intervalTimeEach: Time, val completionTimes: Array<Time>) {

    val totalTime : Time
        get() {
            return Time(intervalTimeEach.seconds * completionTimes.size)
        }


    val totalDistance : Distance
        get() {
            return Distance(distance.distance * completionTimes.size, distance.distanceUnit)
        }

    override fun toString(): String = "$activity $distance $intervalTimeEach x ${completionTimes.size}"
}