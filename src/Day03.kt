fun main() {
    fun part1(input: String): Int {
        val regex = Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)""")
        return regex.findAll(input).sumOf {
            it.groupValues[1].toInt() * it.groupValues[2].toInt()
        }
    }

    fun part2(input: String): Int {
        val regex = Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)|do\(\)|don't\(\)""")
        var toggle = true
        return regex.findAll(input).sumOf {
            if (it.groupValues[0] == "do()") {
                toggle = true
                0
            } else if (it.groupValues[0] == "don't()") {
                toggle = false
                0
            } else if (toggle) {
                it.groupValues[1].toInt() * it.groupValues[2].toInt()
            } else 0
        }
    }

    val input = readInput("Day03")
    println("Part 1: ${part1(input.joinToString())}")
    println("Part 2: ${part2(input.joinToString())}")
}