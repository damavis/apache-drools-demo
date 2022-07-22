package asset

import com.damavis.drools.entity.{Facts, Rule}

import java.time.LocalDate

package object raw {
  def getRules: Seq[Rule] = {
    Seq(
      Rule(
        Name = "Increase 10 if high demand",
        DemandLowerBound = "90",
        DemandUpperBound = null,
        DateLowerBound = null,
        DateUpperBound = null,
        PriceChange = 10
      ),
      Rule(
        Name = "Reduce 3 if date is 2022-01-02",
        DemandLowerBound = null,
        DemandUpperBound = null,
        DateLowerBound = "2022-01-02",
        DateUpperBound = "2022-01-02",
        PriceChange = -3
      )
    )
  }

  def getFacts(date: LocalDate): Facts = {
    val allFacts: Seq[Facts] = Seq(
      new Facts(
        Demand = 95,
        Date = LocalDate.parse("2022-01-01"),
        Price = 50
      ),
      new Facts(
        Demand = 95,
        Date = LocalDate.parse("2022-01-02"),
        Price = 40
      )
    )
    allFacts.find(_.getDate == date.toString).get
  }
}
