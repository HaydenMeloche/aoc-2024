import kotlin.collections.mutableMapOf
import kotlin.collections.unzip
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input
            .map { line ->
                val (left, right) = line.split(Regex("\\s+")).map { it.toInt() }
                left to right
            }.unzip()

        val sortedLeft = left.sorted()
        val sortedRight = right.sorted()

        return sortedLeft.zip(sortedRight).sumOf { (left, right) ->
            abs(right - left)
        }
    }

    fun part2(input: List<String>): Int {
        val leftList = mutableListOf<Int>()
        val rightMap = mutableMapOf<Int, Int>()
        input.forEach {
            val (left, right) = it.split(Regex("\\s+")).map { it.toInt() }
            leftList.add(left)
            rightMap[right] = rightMap.getOrDefault(right, 0) + 1
        }

        return leftList.sumOf { it * (rightMap[it] ?: 0) }
    }

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
