class Day3 {
    fun part1(input: List<String>): Int {
        val operationRegex: Regex = """mul\(\d+,\d+\)""".toRegex()
        val argumentRegex: Regex = """\d+,\d+""".toRegex()
        var sum: Int = 0
        for (line in input) {
            for (operation in operationRegex.findAll(line)) {
                val arguments = argumentRegex.findAll(operation.value)
                for (matchResult in arguments) {
                    val args = matchResult.value.split(",")
                    sum += args[0].toInt() * args[1].toInt()
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    val quiz = Day3()
    val input = readInput("day3_puzzle")
    println("Solution: ${quiz.part1(input)}")
}