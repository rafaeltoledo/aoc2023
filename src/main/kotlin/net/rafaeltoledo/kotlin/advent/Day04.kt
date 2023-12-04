package net.rafaeltoledo.kotlin.advent

import kotlin.math.pow

class Day04 {

  fun invoke(input: List<String>): Int {
    val cards = input.map { it.toScratchCard() }

    return cards
      .map { card -> card.numbers.filter { card.winningNumbers.contains(it) } }
      .sumOf { it.size.calculateCardValue() }
  }

  fun invoke2(input: List<String>): Int {
    val cards = input.map { it.toScratchCard() }

    val cardCounter = cards.associate { it.identifier to 1 }.toMutableMap()

    cards
      .forEachIndexed { index, card ->
        val id = index + 1
        val multiplier = cardCounter[id] ?: 1
        val extras = card.numbers.filter { card.winningNumbers.contains(it) }.count()

        for (i in 0 until extras) {
          val targetId = id + (i + 1)
          cardCounter[targetId]?.let { current ->
            cardCounter[targetId] = current + multiplier
          }
        }
      }

    return cardCounter.toList().sumOf { it.second }
  }
}

private fun Int.calculateCardValue(): Int {
  return 2.0.pow((this - 1).toDouble()).toInt()
}

private fun String.toScratchCard(): ScratchCard {
  val parts = split(":")

  val identifier = parts.first().replace("Card", "").trim().toInt()

  val content = parts.last().split("|")
  val winningNumbers =
    content.first().split(" ").filter { it.isNotEmpty() }.map { it.trim().toInt() }
  val numbers = content.last().split(" ").filter { it.isNotEmpty() }.map { it.trim().toInt() }

  return ScratchCard(identifier, numbers, winningNumbers)
}

data class ScratchCard(
  val identifier: Int,
  val numbers: List<Int>,
  val winningNumbers: List<Int>,
)
