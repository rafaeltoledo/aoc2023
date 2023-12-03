package net.rafaeltoledo.kotlin.advent

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day03Test : BaseTest() {

  override val day: String = "03"

  @Test
  fun `Sample data`() {
    val input = readInput("sample")

    val output = Day03().invoke(input)
    assertThat(output).isEqualTo(4361)
  }

  @Test
  fun `Edge case`() {
    val input = listOf(
      "....#",
      "...12",
      ".....",
    )

    val output = Day03().invoke(input)
    assertThat(output).isEqualTo(12)
  }

  @Test
  fun `Sample data increment`() {
    val input = readInput("sample")

    val output = Day03().invoke2(input)
    assertThat(output).isEqualTo(467835)
  }

  @Test
  fun `Real data`() {
    val input = readInput()

    val output = Day03().invoke(input)
    assertThat(output).isEqualTo(527364)
  }

  @Test
  fun `Real data increment`() {
    val input = readInput()

    val output = Day03().invoke2(input)
    assertThat(output).isEqualTo(79026871)
  }
}
