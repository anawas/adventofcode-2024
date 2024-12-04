package day2

import utilities.readInput
import java.nio.file.NoSuchFileException
import kotlin.system.exitProcess

class Puzzle {
    fun isIncreasing(reports: List<Int>): Boolean {
        for (i in 0 until reports.size-1) {
            if (reports[i] >= reports[i+1]) {
                return false
            }
            if (reports[i+1]-reports[i] > 3) {
                return false
            }
        }
        return true
    }

    fun isDecreasing(reports: List<Int>): Boolean {
        for (i in 0 until reports.size-1) {
            if (reports[i] <= reports[i+1]) {
                return false
            }
            if (reports[i]-reports[i+1] > 3) {
                return false
            }
        }
        return true
    }

    fun createSkipList(length: Int): MutableList<MutableList<Int>> {
        val indexList = mutableListOf<MutableList<Int>>()
        for (i in 0 until length) {
            val list = mutableListOf<Int>()
            for (j in 0 until length) {
                if (j == i) continue
                list.add(j)
            }
            indexList.add(list)
        }
        return indexList
    }

    fun part1(input: List<String>): Int {
        var safeReports = 0
        for (i in 0 until input.size) {
            val tokens = input[i].split("\\s+".toRegex()).map { Integer.parseInt(it) }
            if (isDecreasing(tokens) || isIncreasing(tokens)) {
                safeReports++
            }
        }
        return safeReports
    }

    fun part2(input: List<String>): Int {
        var safeReports = 0
        for (i in 0 until input.size) {
            val tokens = input[i].split("\\s+".toRegex()).map { Integer.parseInt(it) }
            if (isDecreasing(tokens) || isIncreasing(tokens)) {
                safeReports++
                continue
            }
            // Can we get a safe report when removing an index?
            val indexList = createSkipList(tokens.size)
            for (list in indexList) {
                val slicedList = tokens.slice(list)
                if (isDecreasing(slicedList) || isIncreasing(slicedList)) {
                    safeReports++
                    break
                }
            }
        }
        return safeReports
    }
}

fun main() {
    val quiz = Puzzle()
    try {
        val input = readInput("day2_puzzle")
        println("Safe reports: ${quiz.part2(input)}")
    } catch (e: NoSuchFileException) {
        println("ERROR -- Cannot read input")
        exitProcess(1)
    }
}