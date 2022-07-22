package com.damavis.drools.entity

case class Rule(
    Name: String,
    DemandLowerBound: String,
    DemandUpperBound: String,
    DateLowerBound: String,
    DateUpperBound: String,
    PriceChange: Int
)
