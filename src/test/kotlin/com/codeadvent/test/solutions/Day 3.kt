package com.codeadvent.test.solutions

import org.junit.jupiter.api.Test

class Day3 {
    private fun fileAsString(resourcePath: String) = this.javaClass::class.java.getResource(resourcePath).readText()

    @Test
    fun `Day 3 - Part 1`() {
        val values = fileAsString("/Day3Part1.txt").replace(" ","")
                .split("\n").map {  it.split("@", ",", ":", "x") }
        values.forEach(::println)
    }

    @Test
    fun `Day 3 - Part 2`() {
        //val values = fileAsString("").split("\n")

    }
}

