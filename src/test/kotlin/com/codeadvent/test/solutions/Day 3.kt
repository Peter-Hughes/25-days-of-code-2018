package com.codeadvent.test.solutions

import org.junit.jupiter.api.Test

class Day3 {
    private val values = fileAsString("/Day3Part1.txt")
            .replace(" ", "").split("\n").map { it.split("@", ",", ":", "x") }
    private val map = mutableMapOf<Pair<Int, Int>, Char>()

    private fun fileAsString(resourcePath: String) = this.javaClass::class.java.getResource(resourcePath).readText()
    private fun mapValues(x: Int, y: Int) = if (map[Pair(x, y)] != null) map[Pair(x, y)] = 'x' else map[Pair(x, y)] = 'o'

    private fun populateValues() {
        values.forEach {
            (0 until it[3].toInt()).forEach { i ->
                (0 until it[4].toInt()).forEach { j -> mapValues(it[1].toInt() + i, it[2].toInt() + j) }
            }
        }
    }

    @Test
    fun `Day 3 - Part 1`() {
        populateValues()
        println(map.values.count { it == 'x' })
    }

    @Test
    fun `Day 3 - Part 2`() {
        populateValues()

        values.forEach { s ->
            var x = true
            (0 until s[3].toInt()).forEach { i ->
                (0 until s[4].toInt()).forEach { if (x && map[Pair(s[1].toInt() + i, s[2].toInt() + it)] == 'x') x = false }
            }
            if(x) println(s[0])
        }

    }
}
