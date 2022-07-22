val droolsVersion = "7.73.0.Final"

val kieDependencies = Seq(
  "org.kie" % "kie-api"      % droolsVersion,
  "org.kie" % "kie-ci"       % droolsVersion,
  "org.kie" % "kie-internal" % droolsVersion
)

val droolsDependencies = Seq(
  "org.drools" % "drools-core"           % droolsVersion,
  "org.drools" % "drools-compiler"       % droolsVersion,
  "org.drools" % "drools-mvel"           % droolsVersion,
  "org.drools" % "drools-traits"         % droolsVersion,
  "org.drools" % "drools-decisiontables" % droolsVersion
)

val testDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.2.12" % Test,
  "org.scalamock" %% "scalamock" % "5.2.0"  % Test
)

lazy val settings = Seq(
  name := "apache-drools-demo",
  organization := "com.damavis.drools",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.16",
  libraryDependencies ++= kieDependencies ++ droolsDependencies ++ testDependencies,
  Test / fork := false,
  Test / parallelExecution := false
)

lazy val root = (project in file("."))
  .settings(settings)
