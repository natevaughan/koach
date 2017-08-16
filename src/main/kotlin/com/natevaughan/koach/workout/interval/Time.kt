package com.natevaughan.koach.workout.interval

/**
 * Created by nate on 7/2/17
 */
data class Time(val seconds: Long) {

    constructor(minutes: Long, seconds: Long) : this(minutes * 60 + seconds)

    val minutes: Long
        get() {
            return (seconds / 60.0).toLong()
        }

    override fun toString() : String {
        return "$minutes:${if ((seconds % 60) < 10) "0" + (seconds % 60).toString() else (seconds % 60).toString()}"
    }
}