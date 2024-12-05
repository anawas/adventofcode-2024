package day5

import utilities.readInput

class Puzzle {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}
fun main() {
    val quiz = Puzzle()
    val input = readInput("puzzle_test")
    check(quiz.part1(input) == 3)
}