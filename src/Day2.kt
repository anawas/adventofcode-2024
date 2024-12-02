class Day2 {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    val quiz = Day2()
    val input = readInput("day2_test")
    check(quiz.part1(input) == 6)
}