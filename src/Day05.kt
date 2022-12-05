import java.util.ArrayDeque

fun main() {
    fun part1(input: List<String>): String {

        val separatorLine = input.indexOf("")
        val stackLine = separatorLine - 1

        val crates = input.subList(0, stackLine).reversed().fold(ArrayList<ArrayDeque<String>>(3)) { acc, crate ->

            val match = Regex("""([\s\[\]A-Z]{3}).?""").findAll(crate)!!

            match.toList().map { it.groupValues[1] }
                .map { it.replace("[", "") }
                .map { it.replace("]", "") }
                .forEachIndexed { index, s ->

                    if (acc.getOrNull(index) == null) {
                        acc.add(ArrayDeque())
                    }

                    if (s.trim().isNotEmpty()) {
                        acc[index].push(s)
                    }

                }
            acc

        }

        val result = input.subList(separatorLine + 1, input.lastIndex + 1).fold("") { acc, ops ->

            // move 1 from 2 to 1
            val match = Regex("""move (\d\d?) from (\d) to (\d)""").find(ops)!!

            val (amount, from, to) = match.destructured

            val fromStack = crates[from.toInt() - 1]
            val toSack = crates[to.toInt() - 1]

            for (i in 1..amount.toInt()) {
                val crate = fromStack.pop()
                toSack.push(crate)
            }

            crates.map { if (it.isEmpty()) "" else it.peek() }.joinToString(separator = "")

        }

        return result
    }

    fun part2(input: List<String>): String {

        val separatorLine = input.indexOf("")
        val stackLine = separatorLine - 1


        val stacks = input.subList(0, stackLine).fold(ArrayList<MutableList<String>>(3)) { acc, crate ->

            val match = Regex("""([\s\[\]A-Z]{3}).?""").findAll(crate)!!

            match.toList().map { it.groupValues[1] }
                .map { it.replace("[", "") }
                .map { it.replace("]", "") }
                .forEachIndexed { index, s ->

                    if (acc.getOrNull(index) == null) {
                        acc.add(ArrayList())
                    }

                    if (s.trim().isNotEmpty()) {
                        acc[index].add(s)
                    }

                }
            acc

        }

        val result = input.subList(separatorLine + 1, input.lastIndex + 1).fold("") { acc, ops ->
            
            // move 1 from 2 to 1
            val match = Regex("""move (\d\d?) from (\d) to (\d)""").find(ops)!!

            val (amount, from, to) = match.destructured

            val fromStack = stacks[from.toInt() - 1]
            val toSack = stacks[to.toInt() - 1]

            if (amount.toInt() == 1) {
                val crate = fromStack.removeFirst()
                toSack.add(0, crate)
            } else {
                val crates = fromStack.take(amount.toInt())
                stacks[from.toInt() - 1] = fromStack.subList(amount.toInt(),fromStack.size)
                toSack.addAll(0, crates)

            }

            stacks.map { if (it.isEmpty()) "" else it.first() }.joinToString(separator = "")

        }

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
