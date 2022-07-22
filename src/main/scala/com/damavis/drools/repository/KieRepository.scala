package com.damavis.drools.repository

import com.damavis.drools.entity.Rule
import org.kie.api.KieBase

trait KieRepository {
  def getKieBase(rules: Seq[Rule]): KieBase
}
