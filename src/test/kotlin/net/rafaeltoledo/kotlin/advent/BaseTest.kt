package net.rafaeltoledo.kotlin.advent

import net.rafaeltoledo.kotlin.util.readContent

abstract class BaseTest {

  abstract val day: String

  fun readInput(variation: String = ""): List<String> {
    val filename = "$day${if (variation.isNotEmpty()) "." else ""}$variation.txt"
    val content = this::class.readContent(filename)
    return content.split("\n").filter { it.isNotEmpty() }
  }
}
