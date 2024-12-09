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

    fun part1(input: List<String>): Int {
        val numOfOperators = 1
        val variations: List<CharArray> = getVariations(numOfOperators)

        for (v in variations) {
            println(v)
        }
        return input.size
    }


    fun part2(input: List<String>): Int {
        return input.size
    }
}
fun main() {
    val quiz = Puzzle()
    val input = readInput("day7_test")
    check(quiz.part1(input) == 9)
}