package com.natevaughan.koach

import com.natevaughan.koach.cli.Action
import com.natevaughan.koach.cli.getAction
import com.natevaughan.koach.cli.parseNewSet
import com.natevaughan.koach.demo.distanceReport
import com.natevaughan.koach.workout.Workout
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDate
import java.util.*

/**
 * Created by nate on 6/26/17
 */
class Application {
    fun start() {

        val log: Logger = LoggerFactory.getLogger(javaClass)

        log.info("Application startup")

        val scanner = Scanner(System.`in`)
        var next = Action.VIEW
        var input: List<String>

        val workout = Workout()

        while (next != Action.QUIT) {
            input = scanner.next().split(" ")
            next = try {
                getAction(input[0])
            } catch (e: Exception) {
                log.warn("error parsing input: ${e.message}")
                println("bad input, please try again")
                throw e
            }

            when (next) {
                Action.VIEW -> {
                    println(distanceReport(workout))
                    println(workout.toString())
                }
                Action.QUIT -> println("goodbye")
                Action.SET -> {
                    try {
                        workout.activities.add(parseNewSet(scanner))
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
}