package com.natevaughan.koach.sandbox

/**
 * Created by nate on 9/24/17
 */
fun sumAndCount(acc: SumAndCount, value: Double): SumAndCount {
    return SumAndCount(acc.sum + value, acc.count + 1);

}


data class SumAndCount(val sum: Double, val count: Long)