package com.natevaughan.koach.workout.interval

import java.text.NumberFormat

/**
 * Created by nate on 7/20/17
 */
data class Distance(val distance: Double, val distanceUnit: DistanceUnit) {

    val metersEquivalent: Double
        get() = distanceUnit.metersConversion * distance

    override fun toString(): String {
        return "${distanceUnit.decimalFormat.format(distance)}${distanceUnit.abbrev}"
    }
}