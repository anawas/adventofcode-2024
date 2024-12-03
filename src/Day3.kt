class Day3 {
    val operationRegex: Regex = """mul\(\d+,\d+\)""".toRegex()
    val doRegex: Regex = """do\(\)""".toRegex()
    val dontRegex: Regex = """don't\(\)""".toRegex()
    val argumentRegex: Regex = """\d+,\d+""".toRegex()

    fun part1(input: List<String>): Int {
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

    // These are the tokens we care about
    enum class OperationType { MUL, DO, DONT }

    // Helper class to store the tokens while parsing the memory
    data class Token(
        val operationTyp:OperationType,
        val token:String,
        val position:Int
    )

    fun part2(input: List<String>): Int {
        val tokenComparator = Comparator {
            token1: Token, token2: Token ->  token1.position.compareTo(token2.position)
        }
        val alignment = mutableListOf<Token>()
        // Memory is split in multiple lines. We combine them first
        var memory:String = ""
        for (line in input) {
            memory += line
        }

        for (operation in operationRegex.findAll(memory)) {
            alignment.add(Token(OperationType.MUL, operation.value, operation.range.first))
        }
        for (operation in dontRegex.findAll(memory)) {
            alignment.add(Token(OperationType.DONT, operation.value, operation.range.first))
        }
        for (operation in doRegex.findAll(memory)) {
            alignment.add(Token(OperationType.DO, operation.value, operation.range.first))
        }

        // sort the tokens with respect to their position in memory
        alignment.sortWith(tokenComparator)

        var sum: Int = 0
        var status:OperationType = OperationType.DO
        for (command in alignment) {
            println(command.token)
            if (command.operationTyp == OperationType.MUL) {
                if (status == OperationType.DO) {
                    val arguments = argumentRegex.findAll(command.token)
                    for (matchResult in arguments) {
                        val args = matchResult.value.split(",")
                        println(args)
                        sum += args[0].toInt() * args[1].toInt()
                    }
                }
            }
            if (command.operationTyp == OperationType.DO) {
                status = OperationType.DO
            }
            if (command.operationTyp == OperationType.DONT) {
                status = OperationType.DONT
            }
        }
        return sum
    }
}

fun main() {
    val quiz = Day3()
    val input = readInput("day3_puzzle")
    println("Solution: ${quiz.part2(input)}")
}