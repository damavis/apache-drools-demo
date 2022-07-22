package com.damavis.drools.repository

import com.damavis.drools.entity.{Facts, Rule}

import java.time.LocalDate

trait DataRepository {
  def getRules: Seq[Rule]
  def getFacts(date: LocalDate): Facts
  def writePrice(price: Facts): Unit
}
