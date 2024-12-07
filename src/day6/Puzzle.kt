package day6

import utilities.readInput
import java.util.HashMap

class Puzzle {
    var mapWidth = 0
    var mapHeight = 0

    // We don't need to keep the whole map in memory. It
    // would be enough to store the positions of the obstacles.
    // But we want to get a visualization of the path later on.
    val map: MutableList<CharArray> = mutableListOf()

    /**
     * We need to now in which direction the guard is looking.
     * This will be its next step
     */
    enum class GuardFacingDirection {
        LEFT, RIGHT, UP, DOWN, NOWHERE
    }

    /**
     * Represents the guard in the room
     */
    inner class Guard (){
        var posX: Int = 0
        var posY: Int = 0
        var facingDirection: GuardFacingDirection = GuardFacingDirection.NOWHERE
        var steps = 0

        val guardSteps: MutableMap<GuardFacingDirection, IntArray> = mutableMapOf(
            GuardFacingDirection.UP to intArrayOf(-1, 0),
            GuardFacingDirection.DOWN to intArrayOf(1, 0),
            GuardFacingDirection.LEFT to intArrayOf(0, -1),
            GuardFacingDirection.RIGHT to intArrayOf(0, 1)
        )

        fun isLeavingMap(): Boolean {
            when (facingDirection) {
                GuardFacingDirection.UP -> {
                    if (posX + (guardSteps[facingDirection]?.get(0) ?: 0) < 0) return true
                }
                GuardFacingDirection.DOWN -> {
                    if (posX + (guardSteps[facingDirection]?.get(0) ?: 0) >= mapHeight) return true
                }
                GuardFacingDirection.LEFT -> {
                    if (posY + (guardSteps[facingDirection]?.get(1) ?: 0) < 0) return true
                }
                GuardFacingDirection.RIGHT -> {
                    if (posY + (guardSteps[facingDirection]?.get(1) ?: 0) >= mapWidth) return true
                }
                GuardFacingDirection.NOWHERE -> return true
            }
            return false
        }

        fun isObstacleAhead(): Boolean {
            if (map[posX+ (guardSteps[facingDirection]?.get(0) ?: 0)][posY+ (guardSteps[facingDirection]?.get(1) ?: 0)] != '#') {
                return false
            }
            return true
        }

        fun move():Boolean {
            if (isLeavingMap()) return false

            if (isObstacleAhead()) {
                when (facingDirection) {
                    GuardFacingDirection.UP    -> facingDirection = GuardFacingDirection.RIGHT
                    GuardFacingDirection.RIGHT -> facingDirection = GuardFacingDirection.DOWN
                    GuardFacingDirection.DOWN  -> facingDirection = GuardFacingDirection.LEFT
                    GuardFacingDirection.LEFT   -> facingDirection = GuardFacingDirection.UP
                    GuardFacingDirection.NOWHERE -> facingDirection = GuardFacingDirection.NOWHERE
                }
            }
            else {
                println("Guard position $posX, $posY")
                posX += guardSteps[facingDirection]!![0]
                posY += guardSteps[facingDirection]!![1]
                ++steps
                // The puzzle says distinct positions
                if (map[posX][posY] == 'X') {--steps}
                map[posX][posY] = 'X'
            }
            return true
        }
    }


    /**
     * This is for debugging purposes. It's helpful to
     * draw a map and visualize the path of the guard.
     */
    private fun plotMap(map: MutableList<CharArray>): Unit {
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

        val theGuard = Guard()
        for (i in input.indices) {
            map.add(input[i].toCharArray())
            val guardY = input[i].indexOf('^')
            if (guardY > -1) {
                theGuard.posX = i
                theGuard.posY = guardY
                theGuard.facingDirection = GuardFacingDirection.UP
            }
        }
        while(theGuard.move()) {}
        plotMap(map)
        return theGuard.steps
}

fun part2(input: List<String>): Int {
    return input.size
}
}
fun main() {
    val quiz = Puzzle()
    val input = readInput("day6_puzzle")
    //check(quiz.part1(input) == 10)
    println("Solution ${quiz.part1(input)}")
}