package com.codeadvent.test.solutions

import org.junit.jupiter.api.Test

class Day1 {
    private fun fileAsString(resourcePath: String) = this.javaClass::class.java.getResource(resourcePath).readText()

    @Test
    fun `Day 1 - Part 1`() {
        val values = fileAsString("/Day1Part1.txt").split("\n")
        println(values.asSequence().map { x -> x.toInt() }.sum())
    }

    @Test
    fun `Day 1 - Part 2`() {
        val values = fileAsString("/Day1Part1.txt").split("\n").map { it.toInt() }
        val x = mutableListOf<Int>()
        var freq = 0

        while (true) { values.forEach { freq += it; if (check(x, freq)) return } }
    }
}

fun check(x: MutableList<Int>, freq: Int): Boolean {
    val bool = x.contains(freq)
    if (bool) println(freq)
    x.add(freq)
    return bool
}