fun part1(input: List<String>): Long {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

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

fun part2(input: List<String>): Long {
    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()
    val pairs = hashMapOf<Int, Int>()

    for (line in input) {
        val tokens = line.split("\\s+".toRegex())
        left.add(tokens[0].toInt())
        right.add(tokens[1].toInt())
        pairs[tokens[0].toInt()] = 0
    }

    for (number_1 in left) {
        for (number_2 in right) {
            if (number_1 == number_2) {
                pairs[number_1] = pairs[number_1]!! + 1
            }
        }
    }

    println(pairs)
    var sum: Long = 0
    for (keys in pairs.keys) {
        sum += keys * pairs[keys]!!
    }
    return sum
}

fun main() {
    val input = readInput("day1_quiz")
    print("Solution: ${part2(input)}")
}