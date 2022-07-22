Apache Drools Demo with Scala and a Template
============================================

Objective
---------

This demo provides an example of using **Apache Drools**
to apply **business rules** in a given context with the
**scala** programming language and using Drools **templates**
(without spreadsheets). Such rule template can be found
at `src/main/resources/template.drl`.

Testing purpose
---------------

No main script is developed and the data repository
is left out without implementation. Instead, working
**tests** are provided. Therefore, this script can be
used for testing purposes and not for production
environments.

Demo use case: Tennis Court Price
---------------------------------

**Rules** are provided to set the **daily prices** of a tennis
court. The price depends on the **date** and on the
**market demand**, where the latter ranges from 0 to 100 (the
larger the number the larger  the demand). So, the
**facts** are the date and demand.

As in every Drools applications, the facts fire rules
which set variables, which in this demo is **price change**.

Run tests
---------

The tests can be run using the following SBT command:

```
sbt test
```
