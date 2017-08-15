package com.natevaughan.koach

import com.natevaughan.koach.cli.Action
import com.natevaughan.koach.cli.getAction
import com.natevaughan.koach.cli.parseNewSet
import com.natevaughan.koach.workout.ActivitySet
import com.natevaughan.koach.workout.Workout
import com.natevaughan.koach.workout.interval.*
//import org.springframework.boot.SpringApplication
//import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

/**
 * Created by nate on 6/26/17
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var next = Action.VIEW
    var activeSet = ActivitySet(arrayOf(WorkoutInterval(Activity.BIKE, Distance(1600.0, DistanceUnit.METERS), Time(2,30))));
    var input: List<String>

    val workout = Workout(arrayListOf(activeSet))

    while (next != Action.QUIT) {
        input = scanner.next().split(" ")
        next = try {
            getAction(input[0])
        } catch (e: Exception) {
            println("error parsing input: ${e.message}")
            throw e
        }

        when (next) {
            Action.VIEW -> println(workout.toString())
            Action.QUIT -> println("goodbye")
            Action.SET -> {
                try {
                    activeSet = parseNewSet(scanner)
                    workout.activitySets.add(activeSet)
                } catch (e: Exception) {
                    println("Error creating new set: ${e.message}")
                }
            }
            else -> {
                println("todo")
            }
        }
    }
}

//@SpringBootApplication
//class Application {
//    fun main(args: Array<String>) {
//        SpringApplication.run(Application, args)
//    }
//}