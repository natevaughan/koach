package com.natevaughan.koach.demo

import java.util.*

/**
 * Created by nate on 7/23/17
 */

fun maint(args: Array<String>) {
    val binaryReps = TreeMap<Char, String>()
    for (char in 'A'..'z') {
        binaryReps[char] = Integer.toBinaryString(char.toInt())
    }

    for ((ch, bin) in binaryReps) {
        println("$ch = $bin")
    }
}

fun recognize(c: Char): String = when(c) {
    in 'a' .. 'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know..."
}

fun main(args: Array<String> ) {
    println(recognize('r'))
    println(recognize('7'))
}