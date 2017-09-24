package com.natevaughan.koach

import com.natevaughan.koach.sandbox.SumAndCount
import com.natevaughan.koach.sandbox.sumAndCount
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by nate on 7/6/17
 */
class FoldTest {

    @Test
    fun testKotlinFold() {
        val values = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        val result: SumAndCount = values.fold(SumAndCount(0.0, 0), ::sumAndCount)
        assertTrue(result.sum == 15.0)
        assertTrue(result.count == 5L)
    }
}