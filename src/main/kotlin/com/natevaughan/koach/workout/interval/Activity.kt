package com.natevaughan.koach.workout.interval

/**
 * Created by nate on 7/20/17
 */
enum class Activity {
    SWIM,
    BIKE,
    RUN;

    fun parse(input: String) : Activity {
        for (act : Activity in Activity.values()) {
            if (act.name.equals(input, true)) {
                return act
            }
        }

        throw RuntimeException("Invalid activity: $input")
    }
}