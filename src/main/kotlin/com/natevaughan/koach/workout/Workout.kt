package com.natevaughan.koach.workout

import java.time.LocalDate
import kotlin.collections.ArrayList

/**
 * Created by nate on 7/6/17
 */
class Workout (val localDate: LocalDate = LocalDate.now()) {

    val activitySets: ArrayList<ActivitySet> = ArrayList()

    override fun toString(): String {
        var i = 0
        val sb = StringBuilder("Workout $localDate \n")
        sb.append("Set ")
        sb.append(i).append(":")
        activitySets.forEach { ++i; sb.append("  $it") }
        return sb.toString()
    }
}