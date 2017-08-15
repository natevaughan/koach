package com.natevaughan.koach.demo

import com.natevaughan.koach.workout.Workout
import com.natevaughan.koach.workout.interval.Activity
import com.natevaughan.koach.workout.interval.Distance
import org.omg.PortableInterceptor.ACTIVE

/**
 * Created by nate on 7/23/17
 */
fun distanceReport(workout: Workout) : String {
    val sb = StringBuilder()
    val swim = ActivitySummary(Activity.SWIM)
    val run = ActivitySummary(Activity.RUN)
    val bike = ActivitySummary(Activity.BIKE)
    for (set in workout.activitySets) {
        for (interval in set.intervals) {
            when (interval.activity) {
                Activity.BIKE -> bike.totalDistance += interval.distance.metersEquivalent
                Activity.RUN -> run.totalDistance += interval.distance.metersEquivalent
                Activity.SWIM -> swim.totalDistance += interval.distance.metersEquivalent
            }
        }
    }

    sb.append(swim).append(bike).append(run)
    return sb.toString()
}


data class ActivitySummary(val activity: Activity, var totalDistance: Double = 0.0) {
    override fun toString(): String {
        return "Total ${activity} distance: ${totalDistance}m\n"
    }
}