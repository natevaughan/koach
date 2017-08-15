package com.natevaughan.koach.workout

import java.util.*

/**
 * Created by nate on 7/6/17
 */
class Workout(val activitySets: ArrayList<ActivitySet>) {

    val totalSeconds : Long
        get() {
            // todo: make me more kotlin
            var sum = 0L
            activitySets.forEach { sum += it.totalSeconds }
            return sum
        }

    override fun toString(): String {
        var i = 0
        val sb = StringBuilder("Set ")
        sb.append(i).append(":")
        activitySets.forEach { ++i; sb.append("  $it") }
        return sb.toString()
    }
}