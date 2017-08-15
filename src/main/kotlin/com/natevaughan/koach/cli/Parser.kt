package com.natevaughan.koach.cli

import com.natevaughan.koach.workout.ActivitySet
import com.natevaughan.koach.workout.interval.*
import java.util.*

/**
 * Created by nate on 7/20/17.
 */
fun parseInterval(input: String): WorkoutInterval {
    val parts = input.split(" ")
    val activity = activity(parts[0])

    return WorkoutInterval(activity, Distance(50.0, DistanceUnit.METERS), Time(2,30))
}

fun activity(input: String) : Activity {
    for (act : Activity in Activity.values()) {
        if (act.name.equals(input, true)) {
            return act
        }
    }

    throw RuntimeException("invalid activity: $input")
}

fun getAction(input: String) : Action {
    for (act : Action in Action.values()) {
        if (act.name.equals(input, true)) {
            return act
        }
    }

    throw RuntimeException("invalid getAction: $input")
}

fun parseNewSet(scanner: Scanner): ActivitySet {
    println("What type of set? ${Activity.values()}")

    when (activity(scanner.next())) {
        Activity.SWIM -> parseNewSwimSet(scanner)
        else -> {
            throw RuntimeException("Unrecognized Activity")
        }
    }

}

fun parseNewSwimSet(scanner: Scanner): ActivitySet {
    println("What was the distance?")
    val interval = scanner.next().toLong()
    println("How many repetitions?")
    val reps = scanner.next().toLong()
    println("How many minutes:seconds?")
    val time = parseTime(scanner.next())
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
    throw RuntimeException("Bad timeEach input: [$string] must conform to [minutes:seconds]")
}

fun parseNewBikeSet() {

}