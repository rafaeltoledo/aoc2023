package net.rafaeltoledo.kotlin.advent

class Day02 {

  val validRound = Round(red = 12, green = 13, blue = 14)

  fun invoke(input: List<String>): Int {
    val games = input.map { it.toGame() }

    return games.filter { it.isValid() }.sumOf { it.id }
  }

  fun invoke2(input: List<String>): Int {
    val games = input.map { it.toGame() }

    return games.map { it.rounds.optimal() }.sumOf { it.red * it.green * it.blue }
  }

  private fun Game.isValid(): Boolean {
    return rounds.map { it.isValid() }.reduce { acc, value -> acc && value }
  }

  private fun Round.isValid(): Boolean {
    return red <= validRound.red
      && blue <= validRound.blue
      && green <= validRound.green
  }

  private fun String.toGame(): Game {
    val parts = split(":")
    val id = parts.first().replace("Game ", "").toInt()
    val rounds = parts.last().split(";").map { it.toRound() }
    return Game(id = id, rounds = rounds)
  }

  private fun String.toRound(): Round {
    val parts = split(",").map { it.trim() }
    return Round(
      red = parts.findAndParse("red"),
      blue = parts.findAndParse("blue"),
      green = parts.findAndParse("green"),
    )
  }

  private fun List<String>.findAndParse(key: String): Int {
    return find { it.endsWith(key) }?.replace(key, "")?.trim()?.toInt() ?: 0
  }
}

private fun List<Round>.optimal(): Round {
  return Round(
    red = maxOf { it.red },
    green = maxOf { it.green },
    blue = maxOf { it.blue },
  )
}

data class Round(
  val red: Int,
  val blue: Int,
  val green: Int,
)

data class Game(
  val id: Int,
  val rounds: List<Round>,
)
