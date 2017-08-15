package com.natevaughan.koach.workout.interval

/**
 * Created by nate on 7/20/17
 */
data class Distance(val distance: Double, val distanceUnit: DistanceUnit) {
    val metersEquivalent: Double
        get() = distanceUnit.metersConversion * distance

    override fun toString(): String {
        return "$distance${distanceUnit.abbrev}"
    }
}