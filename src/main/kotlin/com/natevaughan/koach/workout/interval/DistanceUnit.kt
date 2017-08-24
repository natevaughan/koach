package com.natevaughan.koach.workout.interval

import java.text.DecimalFormat

/**
 * Created by nate on 7/20/17
 */
enum class DistanceUnit(val metersConversion: Double, val abbrev: String, format: String) {
    METERS(1.0, "m", "#.##"),
    MILES(1599.8, "mi", "#"),
    YARDS(0.91, "y", "#.##");

    val decimalFormat: DecimalFormat = DecimalFormat(format)
}