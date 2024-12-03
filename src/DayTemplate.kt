import java.nio.file.NoSuchFileException
import kotlin.system.exitProcess

class Day0 {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    val quiz = Day0()
    try {
        val input = readInput("day2_puzzle")
        check(quiz.part1(input) == 6)
    } catch (e: NoSuchFileException) {
        println("ERROR -- Cannot read input")
        exitProcess(1)
    }
}