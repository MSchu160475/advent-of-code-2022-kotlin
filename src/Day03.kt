fun main() {
    fun part1(input: List<String>): Int {
        //ASCII A-Z 65-90 -38
        //ASCII a-z 97-122 -96

        return input.sumOf {
            val firstHalf = it.substring(0, (it.length / 2)).toCharArray()
            val secondHalf = it.substring(it.length / 2).toSet()

            firstHalf.intersect(secondHalf).map { it -> if (it.code in 65..90) it.code - 38 else it.code - 96 }
                .first()

        }

    }

    fun part2(input: List<String>): Int {

        //ASCII A-Z 65-90 -38
        //ASCII a-z 97-122 -96

        return input.chunked(3).map {
            it[0].toCharArray().intersect(it[1].toCharArray().intersect(it[2].toSet()))
                .map { it -> if (it.code in 65..90) it.code - 38 else it.code - 96 }
                .first()
        }.sum()

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
