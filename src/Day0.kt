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
    val input = readInput("day1_test")
    check(quiz.part1(input) == 6)
}