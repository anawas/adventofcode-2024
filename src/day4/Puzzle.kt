package day4

import utilities.readInput

class Puzzle {
    fun getSearchPatterns(lineLength:Int): List<List<Int>> {
        val patternLength = "XMAS".length
        val patterns:List<List<Int>> = listOf(
            // left to right
            listOf(0,1,2,3),
            // right to left
            listOf(3,2,1,0),
            // top to bottom
            listOf(0*lineLength, 1*lineLength, 2*lineLength, 3*lineLength),
            //bottom to top
            listOf(3*lineLength, 2*lineLength, 1*lineLength, 0*lineLength),
            //top left to bottom right
            listOf(0*lineLength, 1*lineLength+1, 2*lineLength+2, 3*lineLength+3),
        )
        return  patterns
    }

    fun part1(input: List<String>): Int {
        val lineLength:Int = input[0].length
        var puzzle = ""
        for (line in input)
            puzzle += line

        val searchPattern = getSearchPatterns(lineLength)

        val charArray:CharArray = puzzle.toCharArray()
        for (i in 0 until charArray.lastIndex - 4) {
            val letters = CharArray(4)
            for (j in 0 until searchPattern[0].size) {
                letters[j] = charArray[i + searchPattern[0][j]]
            }

            val pattern = String(letters)
            if (pattern.equals("XMAS")) {
                println("Found")
            }
        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}
fun main() {
    val quiz = Puzzle()
    val input = readInput("day4_test")
    check(quiz.part1(input) == 10)
}