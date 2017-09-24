package com.natevaughan.koach

import com.natevaughan.koach.sandbox.SumAndCount
import com.natevaughan.koach.sandbox.deDup
import com.natevaughan.koach.sandbox.sumAndCount
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by nate on 7/6/17
 */
class FoldTest {

    @Test
    fun testSumAndCountFold() {
        val values = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        val result: SumAndCount = values.fold(SumAndCount(0.0, 0), ::sumAndCount)
        assertTrue(result.sum == 15.0)
        assertTrue(result.count == 5L)
    }

    @Test
    fun testDedupFold() {
        val values = arrayOf(1L, 2L, 2L, 5L, 1L)
        val result: Array<Long> = values.fold(arrayOf(values.first()), ::deDup)
        assertTrue(result.size == 3)
    }
}