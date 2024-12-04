package day1

import utilities.readInput

class Puzzle {
    fun part1(input: List<String>): Long {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        for (line in input) {
            val tokens = line.split("\\s+".toRegex())
            left.add(tokens[0].toInt())
            right.add(tokens[1].toInt())
        }
        left.sort()
        right.sort()

        var sum: Long = 0
        for (i in left.indices) {
            sum += Math.abs(left[i].toLong() - right[i])
        }

        return sum
    }

    fun part2(input: List<String>): Long {
        val left = hashMapOf<Int, Int>()
        val right = hashMapOf<Int, Int>()
        val pairs = hashMapOf<Int, Int>()

        for (line in input) {
            val tokens = line.split("\\s+".toRegex())
            if (!left.containsKey(tokens[0].toInt())) {
                left[tokens[0].toInt()] = 1
            } else {
                left[tokens[0].toInt()] = left[tokens[0].toInt()]!! + 1
            }
            if (!right.containsKey(tokens[1].toInt())) {
                right[tokens[1].toInt()] = 1
            } else {
                right[tokens[1].toInt()] = right[tokens[1].toInt()]!! + 1
            }
        }

        var sum: Long = 0
        for (value in left.keys) {
            if (right.containsKey(value)) {
                sum += left[value]!! * (value * right[value]!!)
            }
        }
        return sum
    }
}
fun main() {
    val quiz = Puzzle()
    val input = readInput("puzzle_test")
    check(input.size == 4)
}