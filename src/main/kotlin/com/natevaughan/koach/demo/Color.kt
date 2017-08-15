package com.natevaughan.koach.demo

import org.apache.tomcat.util.buf.HexUtils

/**
* Created by nate on 7/23/17
*/
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0),
    PURPLE(65, 0, 165),
    ORANGE(255, 165, 0);

    fun rgb(): Int = (r * 256 + g) * 256 + b
    fun rgbHexString(): String = HexUtils.toHexString(byteArrayOf(r.toByte(), g.toByte(), b.toByte()))
}









