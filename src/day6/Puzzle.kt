package day6

import utilities.readInput
import java.util.HashMap

class Puzzle {
    private var mapWidth = 0
    private var mapHeight = 0
    private var guardPosition = IntArray(2)

    enum class GuardFacingDirection {
        LEFT, RIGHT, UP, DOWN, NOWHERE
    }

    val guardSteps:MutableMap<GuardFacingDirection, IntArray> = mutableMapOf(
        GuardFacingDirection.UP to intArrayOf(-1,0),
        GuardFacingDirection.DOWN to intArrayOf(1, 0),
        GuardFacingDirection.LEFT to intArrayOf(0, -1),
        GuardFacingDirection.RIGHT to intArrayOf(0, 1)
    )

    /**
     * This is for debugging purposes. It's helpful to
     * draw a map and visualize the path of the guard.
     */
    private fun plotMap(map:MutableList<CharArray>):Unit {
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

        // We don't need to keep the whole map in memory. It
        // would be enough to store the positions of the obstacles.
        // But we want to get a visualization of the path later on.
        val map: MutableList<CharArray> = mutableListOf()

        var guardIsFacing: GuardFacingDirection = GuardFacingDirection.NOWHERE
        for (i in input.indices) {
            map.add(input[i].toCharArray())
            val guardY = input[i].indexOf('^')
            if (guardY > -1) {
                guardPosition[0] = i
                guardPosition[1] = guardY
                guardIsFacing = GuardFacingDirection.UP
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