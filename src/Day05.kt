import java.util.ArrayDeque

fun main() {
    fun part1(input: List<String>): String {

        val separatorLine = input.indexOf("")
        val lastCrateLine = separatorLine - 2
        val stackLine = separatorLine - 1


        val crates = input.subList(0, stackLine).reversed().fold(ArrayList<ArrayDeque<String>>(3)) { acc, crate ->

            val match = Regex("""([\s\[\]A-Z]{3}.?)""",).findAll(crate)!!

            match.toList().map { it.groupValues[1] }
                .map { it.replace("[", "") }
                .map { it.replace("]", "") }
                .forEachIndexed { index, s ->

                if (acc.getOrNull(index) == null) {
                    acc.add(ArrayDeque())
                }

                if (s.trim().isNotEmpty()){
                    acc[index].push(s)
                }

            }
            acc

        }



        println("Splitted $crates")


        val result = input.map { it.replace("""[\[\]]""".toRegex(), "") }

        println("Result $result")

        return ""
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == 0)

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
