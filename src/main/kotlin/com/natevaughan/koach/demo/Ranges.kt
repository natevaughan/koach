package com.natevaughan.koach.demo

/**
 * Created by nate on 8/15/17
 */
fun main(args: Array<String>) {
    println("foo" in "bar".."zap")
    for (c: Char in 'a'..'z') {
        println("$c : ${c in 'f'..'o'}")
    }
}