package com.natevaughan.koach.demo

import com.natevaughan.koach.workout.Workout
import com.natevaughan.koach.workout.interval.Activity
import com.natevaughan.koach.workout.interval.Distance
import com.natevaughan.koach.workout.interval.DistanceUnit
import net.logstash.logback.argument.StructuredArguments
import net.logstash.logback.argument.StructuredArguments.entries
import net.logstash.logback.argument.StructuredArguments.fields
import org.slf4j.LoggerFactory
import java.time.LocalDate

/**
 * Created by nate on 7/23/17
 */
fun distanceReport(workout: Workout) : String {
    val log = LoggerFactory.getLogger(object{}::class.java)

    val sb = StringBuilder()
    val swim = ActivitySummary(Activity.SWIM)
    val run = ActivitySummary(Activity.RUN)
    val bike = ActivitySummary(Activity.BIKE)
    for (workoutActivity in workout.activities) {
        when (workoutActivity.activity) {
            Activity.BIKE -> bike.totalDistance += workoutActivity.distance.metersEquivalent
            Activity.RUN -> run.totalDistance += workoutActivity.distance.metersEquivalent
            Activity.SWIM -> swim.totalDistance += workoutActivity.distance.metersEquivalent
        }
    }

    sb.append(swim).append(bike).append(run)
    log.info("{}", entries(mapOf(
            Pair("swim", fields(swim)),
            Pair("bike", fields(bike)),
            Pair("run", fields(run))
    )))

    return sb.toString()
}


data class ActivitySummary(val activity: Activity, var totalDistance: Double = 0.0) {
    override fun toString(): String {
        val normalizedDistance = when {
            totalDistance > 1599.7 -> Distance(totalDistance / DistanceUnit.MILES.metersConversion, DistanceUnit.MILES)
            else -> Distance(totalDistance, DistanceUnit.METERS)
        }

        return "Total ${activity} distance: ${normalizedDistance}\n"
    }
}