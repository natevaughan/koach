package com.natevaughan.koach.demo

/**
 * Created by nate on 7/23/17
 */

interface Expr
class Sum(val left: Expr, val right: Expr): Expr
data class Num(val num: Int): Expr
class Mult(val left: Expr, val right: Expr) : Expr

fun eval(expr: Expr) : Int =
    when (expr) {
        is Num -> {
            println("leaf ${expr.num}")
            expr.num
        }
        is Sum -> {
            val left = eval(expr.left)
            val right = eval(expr.right)
            println("$left + $right")
            left + right
        }
        is Mult -> {
            val left = eval(expr.left)
            val right = eval(expr.right)
            println("$left * $right")
            left * right
        }
        else -> {
            throw IllegalArgumentException("unknown Expr: ${expr.javaClass.simpleName}")
        }
    }


fun main(args: Array<String>) {
    println(eval(Sum(Num(1), Sum(Num(2),Mult(Num(10), Num(11))))))
}