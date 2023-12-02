package net.rafaeltoledo.kotlin.advent

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day02Test : BaseTest() {

  override val day: String = "02"

  @Test
  fun `Sample data`() {
    val input = readInput("sample")

    val output = Day02().invoke(input)
    assertThat(output).isEqualTo(8)
  }

  @Test
  fun `Sample data increment`() {
    val input = readInput("sample")

    val output = Day02().invoke2(input)
    assertThat(output).isEqualTo(2286)
  }

  @Test
  fun `Real data`() {
    val input = readInput()

    val output = Day02().invoke(input)
    assertThat(output).isEqualTo(2061)
  }

  @Test
  fun `Real data increment`() {
    val input = readInput()

    val output = Day02().invoke2(input)
    assertThat(output).isEqualTo(72596)
  }
}
