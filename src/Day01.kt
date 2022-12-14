fun main() {
    fun part1(input: List<String>): Int {
        return input.fold(mutableListOf(0)) { acc, calories ->
            if (calories.isNotEmpty()) {
                val lastIndex = acc.lastIndex
                acc[lastIndex] = acc[lastIndex] + calories.toInt()
            }else {
                acc.add(0)
            }
            acc

        }.max()
    }

    fun part2(input: List<String>): Int {
        return input.fold(mutableListOf(0)) { acc, calories ->
            if (calories.isNotEmpty()) {
                val lastIndex = acc.lastIndex
                acc[lastIndex] = acc[lastIndex] + calories.toInt()
            }else {
                acc.add(0)
            }
            acc

        }.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
