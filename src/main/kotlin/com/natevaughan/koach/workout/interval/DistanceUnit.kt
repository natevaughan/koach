package com.natevaughan.koach.workout.interval

/**
 * Created by nate on 7/20/17
 */
enum class DistanceUnit(val metersConversion: Double, val abbrev: String) {
    METERS(1.0, "m"),
    MILES(1599.8, "mi"),
    YARDS(0.91, "y");
}