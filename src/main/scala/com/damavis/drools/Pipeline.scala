package com.damavis.drools

import com.damavis.drools.entity.{Facts, Rule}
import com.damavis.drools.repository.{DataRepository, KieRepository}
import org.kie.api.KieBase
import org.kie.api.runtime.KieSession

import java.time.LocalDate

class Pipeline(dataRepository: DataRepository, kieRepository: KieRepository) {
  def run(date: LocalDate): Unit = {
    val rules: Seq[Rule]       = dataRepository.getRules
    val kieBase: KieBase       = kieRepository.getKieBase(rules)
    val facts: Facts           = dataRepository.getFacts(date)
    val kieSession: KieSession = kieBase.newKieSession()

    kieSession.insert(facts)
    kieSession.fireAllRules()
    kieSession.dispose()

    dataRepository.writePrice(facts)
  }
}
