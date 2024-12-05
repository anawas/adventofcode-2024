package day5

import utilities.readInput

class Puzzle {
    data class PageOrderingRule(val firstPage: Int, val secondPage:Int)

    private fun getPageOrderingRules(input: List<String>): List<PageOrderingRule> {
        val orderingRules:MutableList<PageOrderingRule> = mutableListOf()
        for (line in input) {
            if (line.isBlank()) break
            val values = line.split("|")
            orderingRules.add(PageOrderingRule(values[0].toInt(), values[1].toInt()))
        }
        return orderingRules
    }

    private fun getProductionRules(input: List<String>, startIndex: Int): List<List<Int>> {
        val pageProductionList:MutableList<List<Int>> = mutableListOf()
        for (i in startIndex until input.size) {
            if (input[i].isBlank()) continue
            val production = input[i].split(",").map { it.trim().toInt() }
            pageProductionList.add(production)
        }
        return pageProductionList
    }

    fun part1(input: List<String>): Int {
        val orderingRules: List<PageOrderingRule> = getPageOrderingRules(input)
        val productionLists: List<List<Int>> = getProductionRules(input, orderingRules.size)
        println("Found ${orderingRules.size} page ordering rules")
        println("and ${productionLists.size} production rules")
        return orderingRules.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}

fun main() {
    val quiz = Puzzle()
    val input = readInput("day5_puzzle")
    check(quiz.part1(input) == 21)
}