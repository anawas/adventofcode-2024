@file:Suppress("SameParameterValue", "unused")

package day7

import utilities.readInput
import kotlin.math.pow

class Puzzle {
    private fun getVariations(numOfOperators: Int): List<CharArray> {
        fun convertNumberToOperator(c: Char): Char {
            when (c) {
                '0' -> return '+'
                '1' -> return '*'
            }
            return ' '
        }

        val variationsList: MutableList<CharArray> = mutableListOf()

        val numOfVariations = 2.0.pow(numOfOperators.toDouble()).toInt()
        for (num in 0 until numOfVariations) {
            val operatorsList = CharArray(numOfOperators) {'0'}
            val op: CharArray = num.toString(radix = 2).toCharArray()
            op.copyInto(operatorsList, numOfOperators-op.size)
            variationsList.add(
                operatorsList.map { convertNumberToOperator(it) }.toCharArray()
            )
        }

        return variationsList
    }

    fun applyOperator(a: Long, b: Long, operator: Char): Long {
        when(operator) {
            '+' -> return a+b
            '*' -> return a*b
        }
        return 0
    }

    fun part1(input: List<String>): Long {
        var calibrationResult: Long = 0

        for (line in input) {
            var expectedResultFound = false
            var tokens = line.split(":")
            val expectedResult = tokens[0].trim().toLong()
            val numbers = tokens[1].trim().split("\\s+".toRegex()).map { it.toLong()}
            val numOfOperators = numbers.size - 1
            val variations: List<CharArray> = getVariations(numOfOperators)

            for (operator in variations) {
                var sum = numbers[0]
                for (i in 0 until numOfOperators) {
                    sum = applyOperator(sum, numbers[i+1], operator[i])
                }
                if (sum == expectedResult) {
                    expectedResultFound = true
                    break
                }
            }
            if (expectedResultFound) {
                println("Result $expectedResult found")
                calibrationResult += expectedResult
            }
        }

        return calibrationResult
    }


    fun part2(input: List<String>): Int {
        return input.size
    }
}
fun main() {
    val quiz = Puzzle()
    val input = readInput("day7_puzzle")
    //check(quiz.part1(input) == 9)
    println("Solution: ${quiz.part1(input)}")
}