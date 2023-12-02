package net.rafaeltoledo.kotlin.advent

import com.google.common.truth.Truth.assertThat
import net.rafaeltoledo.kotlin.util.readContent
import org.junit.jupiter.api.Test

class Day01Test {

  private val file = "01"

  @Test
  fun `Sample data`() {
    val filename = "$file.sample.txt"
    val content = this::class.readContent(filename)

    assertThat(content).isNotEmpty()

    assertThat(Day01().invoke(content)).isEqualTo(142)
  }

  @Test
  fun `Step 2 sample data`() {
    val filename = "$file.increment.sample.txt"
    val content = this::class.readContent(filename)

    assertThat(content).isNotEmpty()

    assertThat(Day01().invoke(content)).isEqualTo(281)
  }

  @Test
  fun `Real data`() {
    val filename = "$file.txt"
    val content = this::class.readContent(filename)

    assertThat(content).isNotEmpty()

    assertThat(Day01().invoke(content)).isEqualTo(55358)
  }
}
