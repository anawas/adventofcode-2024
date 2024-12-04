package day4

import utilities.readInput

class Puzzle {
    private fun getSearchPatterns(lineLength: Int): HashMap<String, List<Int>> {
        val patterns: HashMap<String, List<Int>> = hashMapOf()
        patterns["leftright"]  = listOf(0, 1, 2, 3)
        patterns["rightleft"]  = listOf(3, 2, 1, 0)
        patterns["topbottom"] = listOf(0, 1 * lineLength, 2 * lineLength, 3 * lineLength)
        patterns["bottomtop"]  = listOf(3 * lineLength, 2 * lineLength, 1 * lineLength, 0)
        patterns["topleftbottomright"] = listOf(0, 1 * lineLength + 1, 2 * lineLength + 2, 3 * lineLength + 3)
        patterns["bottomlefttopright"] = listOf(3*lineLength, 2 * lineLength + 1, 1 * lineLength + 2, 3)
        patterns["toprightbottomleft"] = listOf(3, lineLength + 2, 2 * lineLength + 1, 3 * lineLength + 0)
        patterns["bottomrighttopleft"] = listOf(3*lineLength+3, 2 * lineLength + 2, 1 * lineLength + 1, 0)
        return patterns
    }

    fun part1(input: List<String>): Int {
        val lineLength: Int = input[0].length
        var puzzle = ""
        var numOfLines = 0

        for (line in input) {
            puzzle += line
            ++numOfLines
        }

        val charArray: CharArray = puzzle.toCharArray()
        val searchPattern = getSearchPatterns(lineLength)
        var totalSum = 0

        // First we search horizontally
        var patterns = listOf(searchPattern["leftright"]!!, searchPattern["rightleft"]!!)
        var counter = 0
        for (i in 0 until lineLength-3) {
            for (j in 0 until numOfLines) {
                val letters = CharArray(4)
                val index = i + j * lineLength
                for (pattern in patterns) {
                    for (k in pattern.indices) {
                        letters[k] = charArray[index + pattern[k]]
                    }
                    val word = String(letters)
                    if (word == "XMAS") {
                        ++counter
                    }
                }
            }
        }

        totalSum += counter
        println("Found ${counter}x in horizontal search")

        // Next search vertically
        patterns = listOf(searchPattern["topbottom"]!!, searchPattern["bottomtop"]!!)
        counter = 0
        for (i in 0 until lineLength) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (pattern in patterns) {
                    for (k in pattern.indices) {
                        letters[k] = charArray[index + pattern[k]]
                    }
                    val word = String(letters)
                    if (word == "XMAS") {
                        ++counter
                    }
                }
            }
        }
        totalSum += counter
        println("Found ${counter}x in vertical search")

        // now we search diagonally, There are 4 diagonals!
        patterns = listOf(
            searchPattern["topleftbottomright"]!!,
            searchPattern["bottomlefttopright"]!!,
            searchPattern["toprightbottomleft"]!!,
            searchPattern["bottomrighttopleft"]!!)

        counter = 0
        for (i in 0 until lineLength-3) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (pattern in patterns) {
                    for (k in pattern.indices) {
                        letters[k] = charArray[index + pattern[k]]
                    }
                    val word = String(letters)
                    if (word == "XMAS") {
                        ++counter
                    }
                }
            }
        }
        totalSum += counter
        println("Found ${counter}x on diagonals")
        return totalSum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    val quiz = Puzzle()
    val input = readInput("day4_puzzle")
    println("Solution: ${quiz.part1(input)}")
}