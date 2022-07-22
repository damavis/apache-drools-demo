package com.damavis.drools

import asset.expected.getPrice
import asset.raw.{getFacts, getRules}
import com.damavis.drools.entity.{Facts, Rule}
import com.damavis.drools.repository.{DataRepository, KieRepository, KieRepositoryImpl}
import org.scalamock.scalatest.MockFactory
import org.scalatest.flatspec.AnyFlatSpec

import java.time.LocalDate

class PipelineTest extends AnyFlatSpec with MockFactory {

  private val kieRepository: KieRepository       = new KieRepositoryImpl
  private val rules: Seq[Rule]                   = getRules
  private val fakeDataRepository: DataRepository = mock[DataRepository]
  private val pipeline: Pipeline                 = new Pipeline(fakeDataRepository, kieRepository)

  "If high demand" should "increase price by 10" in {
    val date: LocalDate = LocalDate.parse("2022-01-01")
    val facts: Facts    = getFacts(date)
    val price: Int      = getPrice(date)

    (fakeDataRepository.getRules _).expects().returning(rules)
    (fakeDataRepository.getFacts _).expects(date).returning(facts)
    (fakeDataRepository.writePrice _).expects(*) onCall { data: Facts =>
      assert(data.Price.equals(price))
      ()
    }

    pipeline.run(date)
  }

  "If high demand and date 2022-01-02" should "increase price by 10 and then reduce by 3" in {
    val date: LocalDate = LocalDate.parse("2022-01-02")
    val facts: Facts    = getFacts(date)
    val price: Int      = getPrice(date)

    (fakeDataRepository.getRules _).expects().returning(rules)
    (fakeDataRepository.getFacts _).expects(date).returning(facts)
    (fakeDataRepository.writePrice _).expects(*) onCall { data: Facts =>
      assert(data.Price.equals(price))
      ()
    }

    pipeline.run(date)
  }
}
