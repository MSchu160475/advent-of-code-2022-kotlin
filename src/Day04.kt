fun main() {
    fun part1(input: List<String>): Int {
       return input.fold(0) { acc, cs ->

            val sections = cs.split(",")
                .map { section -> section.split("-").map { it.toInt() } }
                .map { Pair(it[0], it[1]) }
                .sortedByDescending { it.second - it.first }

            if (sections[1].first in sections[0].first .. sections[0].second
                && sections[1].second in sections[0].first .. sections[0].second) acc + 1 else acc

        }
    }


    fun part2(input: List<String>): Int {
        return input.fold(0) { acc, cs ->

            val sections = cs.split(",")
                .map { section -> section.split("-").map { it.toInt() } }
                .map { Pair(it[0], it[1]) }
                .map { (it.first..it.second).toList().toIntArray() }

            val intersectedArea = sections[0].intersect(sections[1].toSet())

            if (intersectedArea.isNotEmpty()) acc + 1 else acc

        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
