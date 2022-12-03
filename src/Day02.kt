fun main() {
    fun part1(input: List<String>): Int {
        val game = RockPaperScissors()
        return input.map {
            game.score(it)
        }.sum()
    }

    fun part2(input: List<String>): Int {
        val game = RockPaperScissors()
        return input.map {
            game.scoreFake(it)
        }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

class RockPaperScissors {


    private val rules = mapOf(
        "A X" to 4,
        "A Y" to 8,
        "A Z" to 3,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 7,
        "C Y" to 2,
        "C Z" to 6
    )

    //Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock
    //A Rock, B Paper, C Scissors
    //X loose, Y draw, Z win
    private val fakeRules = mapOf(
        "A X" to 3,
        "A Y" to 4,
        "A Z" to 8,
        "B X" to 1,
        "B Y" to 5,
        "B Z" to 9,
        "C X" to 2,
        "C Y" to 6,
        "C Z" to 7


    )

    fun score(gamePlayerChoice: String): Int {

        return rules[gamePlayerChoice]!!

    }

    fun scoreFake(gamePlayerChoice: String): Int{
        return fakeRules[gamePlayerChoice]!!
    }

}
