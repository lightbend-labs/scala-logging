ThisBuild / scalaVersion := "3.0.2"
val scala213 = "2.13.8"

lazy val scalalogging2 = project
  .settings(
    name := "scala-logging2",
    scalaVersion := scala213,
    libraryDependencies ++= Dependencies.scalaLogging(scala213, false)
  )

lazy val scalalogging3 = project
  .settings(
    name := "scala-logging3",
    scalaVersion := "3.0.2",
    libraryDependencies ++= Dependencies.scalaLogging("3.0.2", true)
  )

lazy val scalalogging = project
  .dependsOn(scalalogging2, scalalogging3)
  .settings(
    name := "scala-logging",
    scalaVersion := "3.0.2",
    libraryDependencies ++= Dependencies.scalaLogging("3.0.2", true),
  )

lazy val app2 = project
  .dependsOn(scalalogging)
  .settings(
    name := "app2",
    scalaVersion := scala213,
    scalacOptions := Seq("-Ytasty-reader"),
    libraryDependencies ++= Dependencies.scalaLogging(scala213, false),
    libraryDependencies += Library.logbackClassic
  )

lazy val app3 = project
  .dependsOn(scalalogging)
  .settings(
    name := "app3",
    libraryDependencies ++= Dependencies.scalaLogging("3.0.2", true),
    libraryDependencies += Library.logbackClassic
  )