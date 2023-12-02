package net.rafaeltoledo.kotlin.advent

private val numbers = mapOf(
  "one" to 1,
  "two" to 2,
  "three" to 3,
  "four" to 4,
  "five" to 5,
  "six" to 6,
  "seven" to 7,
  "eight" to 8,
  "nine" to 9,
)

class Day01 {

  fun invoke(rawInput: String): Int {
    val lines = rawInput.split("\n").filter { it.isNotEmpty() }

    return lines.sumOf {
      "${
        it.findDigit(
          { str -> str.substring(1) },
          { first() },
          { startsWith(it) },
        )
      }${
        it.findDigit(
          { str -> str.substring(0, str.length - 1) },
          { last() },
          { endsWith(it) })
      }".toInt()
    }
  }
}

private fun String.findDigit(
  substring: (String) -> String,
  charPicker: String.() -> Char,
  stringEval: String.(String) -> Boolean
): String {
  var value = this
  do {
    if (value.isEmpty()) break

    val digit = value.findDigit({ charPicker() }, { stringEval(it) })
    if (digit == -1) value = substring(value)
    else return digit.toString()
  } while (true)

  return ""
}

private fun String.findDigit(
  charPicker: String.() -> Char,
  stringEval: String.(String) -> Boolean
): Int {
  if (isEmpty()) {
    return -1
  }

  if (charPicker().isDigit()) {
    return charPicker().digitToInt()
  }

  numbers.keys.forEach {
    if (stringEval(it)) return numbers.getOrDefault(it, -1)
  }

  return -1
}

