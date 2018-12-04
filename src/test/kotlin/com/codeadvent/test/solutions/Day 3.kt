package com.codeadvent.test.solutions

import org.junit.jupiter.api.Test

class Day3 {
    private fun fileAsString(resourcePath: String) = this.javaClass::class.java.getResource(resourcePath).readText()

    @Test
    fun `Day 3 - Part 1`() {
        val values = fileAsString("/Day3Part1.txt")
                .replace(" ", "").split("\n").map { it.split("@", ",", ":", "x") }

        val map = mutableMapOf<Pair<Int, Int>, Char>()

        values.forEach {
            (0 until it[3].toInt()).forEach { i ->
                (0 until it[4].toInt()).forEach { j -> mapValues(map, it[1].toInt() + i, it[2].toInt() + j) }
            }
        }

        println(map.values.count { it == 'x' })
    }

    @Test
    fun `Day 3 - Part 2`() {
        //val values = fileAsString("").split("\n")

    }
}

fun mapValues(map: MutableMap<Pair<Int, Int>, Char>, x: Int, y: Int) {
    if (map[Pair(x, y)] == 'o') map[Pair(x, y)] = 'x' else map[Pair(x, y)] = 'o'
}
