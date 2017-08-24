package com.natevaughan.koach.cli

import com.natevaughan.koach.workout.IntervalSet
import com.natevaughan.koach.workout.interval.*
import org.slf4j.LoggerFactory
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by nate on 7/20/17
 */

fun getAction(input: String) : Action {
    for (act : Action in Action.values()) {
        if (act.name.equals(input, true)) {
            return act
        }
    }

    throw RuntimeException("invalid getAction: $input")
}

fun parseNewSet(scanner: Scanner): IntervalSet {
    val log = LoggerFactory.getLogger(object{}::class.java)
    log.info("Creating new set")

    println("activity: [${Activity.values().joinToString(",")}]")
    val activity = Activity.valueOf(scanner.next().toUpperCase())
    println("distanceEach: [distanceEach:unit]")
    val distance = distance(scanner.next())
    println("time interval for each: [minutes:seconds]")
    val time = parseTime(scanner.next())
    println("please enter your intervals in the format [minutes:seconds]. Type END when done.")
    val times: ArrayList<Time> = ArrayList()
    var input: String = scanner.next()
    while ("END" != input.toUpperCase()) {
        times.add(parseTime(input))
        input = scanner.next()
    }
    println("set created.")
    return IntervalSet(activity, distance, time, times.toTypedArray())
}

fun distance(input: String): Distance {
    val parts = input.split(":")
    if (parts.size == 2) {
        return Distance(parts[0].toDouble(), parseDistanceUnit(parts[1]))
    }
    throw RuntimeException("Bad intervalTimeEach input: [$input] must conform to [minutes:seconds]")
}

fun parseTime(string: String): Time {
    val parts = string.split(":")
    if (parts.size == 2) {
        try {
            return Time(parts[0].toLong(), parts[1].toLong())
        } catch (e: NumberFormatException) {
            println("NumberFormatException: ${e.message}")
        }
    }
    throw RuntimeException("Bad intervalTimeEach input: [$string] must conform to [minutes:seconds]")
}


fun parseDistanceUnit(input: String) : DistanceUnit {
    for (unit: DistanceUnit in DistanceUnit.values()) {
        if (unit.abbrev.equals(input, true) || unit.name.equals(input, true)) {
            return unit
        }
    }
    throw RuntimeException("Invalid input: $input")
}