package com.damavis.drools.entity

import java.time.LocalDate

class Facts(
    Demand: Int,
    Date: LocalDate,
    var Price: Int
) {

  // Getters
  def getDemand: Int  = Demand
  def getDate: String = Date.toString
  def getPrice: Int   = Price

  // Setters
  def setPrice(price: Int): Unit = this.Price = price

}
