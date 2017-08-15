package com.natevaughan.koach.demo

/**
 * Created by nate on 7/20/17
 */


data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("alice"), Person("bob", 24))

    val oldest = persons.maxBy { it.age ?: 0 }

    println("oldest max was $oldest")
}