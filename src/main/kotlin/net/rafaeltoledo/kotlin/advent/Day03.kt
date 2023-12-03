package net.rafaeltoledo.kotlin.advent

class Day03 {

  fun invoke(input: List<String>): Int {
    val positioning = input.toPositioning()

    return positioning.filter { it.checkBoundaries(input) }.sumOf { it.number }
  }

  fun invoke2(input: List<String>): Int {
    val positioning = input.toPositioning()

    return positioning
      .map { it.fillAsteriskData(input) }
      .filter { it.symbolPosition != null }
      .groupBy { it.symbolPosition }
      .filter { it.value.size >= 2 }
      .map { it.value.first().number * it.value.last().number }
      .sum()
  }

  fun NumberPositioning.checkBoundaries(input: List<String>): Boolean {
    val lines = listOf(this.start.first - 1, this.start.first, this.start.first + 1).filter { it >= 0 }.filter { it <= input.size - 1 }
    val range = ((start.second - 1)..(end.second + 1)).toList().filter { it >= 0 }.filter { it <= input.first().length - 1 }

    lines.forEach {  line ->
      range.forEach {  column ->
        if (input.get(line).get(column).isValid()) {
          return true
        }
      }
    }

    return false
  }

  fun NumberPositioning.fillAsteriskData(input: List<String>): NumberPositioning {
    val lines = listOf(this.start.first - 1, this.start.first, this.start.first + 1).filter { it >= 0 }.filter { it <= input.size - 1 }
    val range = ((start.second - 1)..(end.second + 1)).toList().filter { it >= 0 }.filter { it <= input.first().length - 1 }

    lines.forEach { line ->
      range.forEach { column ->
        if (input.get(line).get(column).isAsterisk()) {
          return this.copy(
            symbolPosition = Pair(line, column),
          )
        }
      }
    }

    return this
  }
}

fun NumberPositioning.prettyPrint(input: List<String>) {
  val lines = listOf(this.start.first - 1, this.start.first, this.start.first + 1).filter { it >= 0 }.filter { it <= input.size - 1 }
  val range = ((start.second - 1)..(end.second + 1)).toList().filter { it >= 0 }.filter { it <= input.first().length - 1 }

  lines.forEach { line ->
    range.forEach {  column ->
      print(input.get(line).get(column))
    }
    println()
  }
  println()
}

private fun Char.isValid(): Boolean {
  return (!isDigit() && this != '.')
}

private fun Char.isAsterisk(): Boolean {
  return this == '*'
}

private fun List<String>.toPositioning(): List<NumberPositioning> {
  val list = mutableListOf<NumberPositioning>()

  this.forEachIndexed { line, value ->
    var tempStr = ""
    var startIndex = -1

    value.forEachIndexed { strIndex, char ->
      if (char.isDigit()) {
        tempStr += char
        if (startIndex == -1) {
          startIndex = strIndex
        }
      } else {
        if (tempStr.isNotEmpty()) {
          list.add(NumberPositioning(tempStr.toInt(), Pair(line, startIndex), Pair(line, strIndex - 1)))
        }
        tempStr = ""
        startIndex = -1
      }
    }

    if (tempStr.isNotEmpty()) {
      list.add(NumberPositioning(tempStr.toInt(), Pair(line, startIndex), Pair(line, value.length - 1)))
    }
  }

  return list.toList()
}

data class NumberPositioning(
  val number: Int,
  val start: Pair<Int, Int>,
  val end: Pair<Int, Int>,
  var symbolPosition: Pair<Int, Int>? = null,
)
