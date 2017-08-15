package com.natevaughan.koach.workout.interval

/**
 * Created by nate on 7/2/17
 */
data class Time(val minutes: Long, val seconds: Long) {
    val SECONDS_PER_MINUTE = 60

    val totalSeconds: Long = minutes * SECONDS_PER_MINUTE + seconds

    override fun toString() : String {
        return "$minutes:${if (seconds < 10) "0" + seconds.toString() else seconds.toString()}"
    }
}