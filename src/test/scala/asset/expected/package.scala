package asset

import java.time.LocalDate

package object expected {
  def getPrice(date: LocalDate): Int = {
    val expected: Map[String, Int] = Map(
      "2022-01-01" -> 60,
      "2022-01-02" -> 47
    )
    expected(date.toString)
  }
}
