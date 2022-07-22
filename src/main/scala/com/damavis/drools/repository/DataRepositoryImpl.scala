package com.damavis.drools.repository
import com.damavis.drools.entity.{Facts, Rule}
import java.time.LocalDate

class DataRepositoryImpl extends DataRepository {

  override def getRules: Seq[Rule] = ???

  override def getFacts(date: LocalDate): Facts = ???

  override def writePrice(price: Facts): Unit = ???

}
