package com.codeadvent.test.solutions

import org.junit.jupiter.api.Test

class Day2 {
    private fun fileAsString(resourcePath: String) = this.javaClass::class.java.getResource(resourcePath).readText()

    @Test
    fun `Day 2 - Part 1`() {
        val values = fileAsString("/Day2Part1.txt").split("\n")
        println(values.sumBy { countForString(it, 2) } * values.sumBy { countForString(it, 3) })
    }

    @Test
    fun `Day 2 - Part 2`() {
        val values = fileAsString("/Day2Part2.txt").split("\n")
        values.forEach { s -> values.forEach { almostMatch(s, it) } }
    }
}

fun countForString(s: String, amount: Int): Int {
    s.forEach { c -> if (s.count { x -> x == c } == amount) return 1 }
    return 0
}

fun almostMatch(a: String, b: String): Boolean {
    var i = -1
    a.forEachIndexed { index, c ->
        if (c != b[index]) if (i > -1) return false else i = index
    }

    when (i) {
        -1 -> return false
        else -> println(a.substring(0, i) + a.substring(i + 1, a.length))
    }

    return true
}