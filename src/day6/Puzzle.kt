package day6

import utilities.readInput

class Puzzle {
    private var mapWidth = 0
    private var mapHeight = 0
    private var guardPosition = IntArray(2)

    fun plotMap(map:MutableList<CharArray>):Unit {
        for (i in 0 until mapHeight) {
            for (j in 0 until mapWidth) {
                print(map[i][j])
            }
            println()
        }
    }

    fun part1(input: List<String>): Int {
        mapWidth = input[0].length
        mapHeight = input.size
        val map: MutableList<CharArray> = mutableListOf()

        for (i in input.indices) {
            map.add(input[i].toCharArray())
            val guardY = input[i].indexOf('^')
            if (guardY > -1) {
                guardPosition[0] = i
                guardPosition[1] = guardY
            }

        }
        plotMap(map)
        println("Guard is at ${guardPosition[0]}, ${guardPosition[1]}")
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}
fun main() {
    val quiz = Puzzle()
    val input = readInput("day6_test")
    check(quiz.part1(input) == 10)
}