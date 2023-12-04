package net.rafaeltoledo.kotlin.advent

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day04Test : BaseTest() {

  override val day: String = "04"

  @Test
  fun `Sample data`() {
    val input = readInput("sample")

    val output = Day04().invoke(input)
    assertThat(output).isEqualTo(13)
  }

  @Test
  fun `Sample data increment`() {
    val input = readInput("sample")

    val output = Day04().invoke2(input)
    assertThat(output).isEqualTo(30)
  }

  @Test
  fun `Real data`() {
    val input = readInput()

    val output = Day04().invoke(input)
    assertThat(output).isEqualTo(26914)
  }

  @Test
  fun `Real data increment`() {
    val input = readInput()

    val output = Day04().invoke2(input)
    assertThat(output).isEqualTo(13080971)
  }
}
