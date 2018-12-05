package com.codeadvent.test.solutions

import org.junit.jupiter.api.Test

class Day4 {
    private fun fileAsString(resourcePath: String) = this.javaClass::class.java.getResource(resourcePath).readText()
    private val values = fileAsString("/Day4Part1.txt").split("\n")

    private fun extractTime(s: String) = if (s.substring(12, 14).toInt() > 0) 0 else s.substring(15, 17).toInt()
    private fun extractId(s: String) = s.substringAfter('#').filter { c -> c.isDigit() }.toInt()

    fun populateValues(): MutableMap<Int, List<Int>> {
        val map = mutableMapOf<Int, List<Int>>()
        var id = 0
        var start = 0

        values.sorted().forEach { s ->
            when {
                s.contains("Guard") -> id = extractId(s)
                s.contains("asleep") -> start = extractTime(s)
                else -> map.merge(id, (start until extractTime(s)).toList()) { id, min -> id + min }
            }
        }

        return map
    }

    @Test
    fun `Day 4 - Part 1`() {
        val map = populateValues()

        val guard = map.maxBy { it.value.size }
        println(guard)
        println(guard!!.value.sorted().groupBy { it }.maxBy { it.value.size }?.key)
    }

    @Test
    fun `Day 4 - Part 2`() {
        val map = populateValues()
        val guard = map.flatMap { entry ->
            entry.value.map {
                entry to it
            }
        }.groupBy { it }.maxBy { it.value.size }?.key

        println("${guard!!.first} \n${guard.second}")
    }
}
