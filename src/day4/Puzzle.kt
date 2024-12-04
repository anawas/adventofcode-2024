package day4

import utilities.readInput

class Puzzle {
    private fun getSearchPatterns(lineLength: Int): HashMap<String, List<Int>> {
        val patternLength = "XMAS".length
        val patterns: HashMap<String, List<Int>> = hashMapOf()
        patterns["leftright"]  = listOf(0, 1, 2, 3)
        patterns["rightleft"]  = listOf(3, 2, 1, 0)
        patterns["topbottom"] = listOf(0, 1 * lineLength, 2 * lineLength, 3 * lineLength)
        patterns["bottomtop"]  = listOf(3 * lineLength, 2 * lineLength, 1 * lineLength, 0)
        patterns["topleftbottomright"] = listOf(0, 1 * lineLength + 1, 2 * lineLength + 2, 3 * lineLength + 3)
        patterns["bottomlefttopright"] = listOf(3*lineLength, 2 * lineLength + 1, 1 * lineLength + 2, 3)
        patterns["toprightbottomleft"] = listOf(3, lineLength +2, 2 * lineLength + 1, 3 * lineLength + 0)
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

        var pattern = searchPattern["leftright"]!!
        var totalSum = 0

        var counter = 0
        for (i in 0 until lineLength-3) {
            for (j in 0 until numOfLines) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }

        totalSum += counter
        println("Found ${counter}x in leftright ")

        pattern = searchPattern["rightleft"]!!
        counter = 0
        for (i in 0 until lineLength-3) {
            for (j in 0 until numOfLines) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }
        totalSum += counter
        println("Found ${counter}x in rightleft ")

        pattern = searchPattern["topbottom"]!!
        counter = 0
        for (i in 0 until lineLength) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }
        totalSum += counter
        println("Found ${counter}x in topbottom")

        pattern = searchPattern["bottomtop"]!!
        counter = 0
        for (i in 0 until lineLength) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength
                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }

        totalSum += counter
        println("Found ${counter}x in bottomtop")

        pattern = searchPattern["topleftbottomright"]!!
        counter = 0
        for (i in 0 until lineLength-3) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }

        totalSum += counter
        println("Found ${counter}x in topleftbottomright")

        pattern = searchPattern["bottomlefttopright"]!!
        counter = 0
        for (i in 0 until lineLength-3) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }

        totalSum += counter
        println("Found ${counter}x in bottomlefttopright")

        pattern = searchPattern["toprightbottomleft"]!!
        counter = 0
        for (i in 0 until lineLength- 3) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }

        totalSum += counter
        println("Found ${counter}x in toprightbottomleft")

        pattern = searchPattern["bottomrighttopleft"]!!
        counter = 0
        for (i in 0 until lineLength-3) {
            for (j in 0 until numOfLines-3) {
                val letters = CharArray(4)
                val index = i + j * lineLength

                for (k in pattern.indices) {
                    letters[k] = charArray[index + pattern[k]]
                }
                val word = String(letters)
                if (word == "XMAS") {
                    ++counter
                }
            }
        }

        totalSum += counter
        println("Found ${counter}x in bottomrightttopleft")

        return totalSum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    val quiz = Puzzle()
    val input = readInput("day4_puzzle")
    println("Soultion: ${quiz.part1(input)}")
}