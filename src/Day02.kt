import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        return input.count { line ->
            val pairs = line.split(" ")
                .map { it.toInt() }
                .zipWithNext()
            val isIncreasing = pairs.all { (a, b) -> a < b && abs(a - b) <= 3 }
            val isDecreasing = pairs.all { (a, b) -> a > b && abs(a - b) <= 3 }
            isIncreasing || isDecreasing
        }
    }

    fun part2(input: List<String>): Int {
        fun checkLineInOrder(list: List<Int>): Boolean {
            val pairs = list.zipWithNext()
            val isIncreasing = pairs.all { (a, b) -> a < b && abs(a - b) <= 3 }
            val isDecreasing = pairs.all { (a, b) -> a > b && abs(a - b) <= 3 }
            return isIncreasing || isDecreasing
        }
        fun checkLineInOrderRemovingValue(list: List<Int>): Boolean {
            for ((index, _) in list.withIndex()) {
                if (checkLineInOrder(list.filterIndexed { index2, _ -> index != index2 })) {
                    return true
                }
            }
            return false
        }
        return input.count { line ->
            val digits = line.split(" ").map { it.toInt() }
            checkLineInOrder(digits) || checkLineInOrderRemovingValue(digits)
        }
    }

    val input = readInput("Day02")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}