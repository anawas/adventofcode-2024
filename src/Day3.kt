class Day3 {
    fun part1(input: List<String>): Int {
        val operationRegex: Regex = """mul\(\d+,\d+\)""".toRegex()
        val argumentRegex: Regex = """\d+,\d+""".toRegex()
        for (line in input) {
            for (operation in operationRegex.findAll(line)) {
                val arguments = argumentRegex.findAll(operation.value)
                for (args in arguments)
                    println(args.value)
            }

        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}
fun main() {
    val quiz = Day3()
    val input = readInput("day3_test")
    check(quiz.part1(input) == 1)
}