fun part1(input: List<String>): Long {
    var left = mutableListOf<Int>()
    var right = mutableListOf<Int>()

    for (line in input) {
        val tokens = line.split("\\s+".toRegex())
        left.add(tokens[0].toInt())
        right.add(tokens[1].toInt())
    }
    left.sort()
    right.sort()

    var sum: Long = 0
    for (i in left.indices) {
        sum += Math.abs(left[i].toLong() - right[i])
    }

    return sum
}

fun part2(input: List<String>): Int {
    return input.size
}

fun main() {
    val input = readInput("day1_test")
    check(part1(input) == 11L)
}