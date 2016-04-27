import sbt._

object Version {
  val logback   = "1.1.7"
  val mockito   = "1.10.19"
  val scala     = "2.11.8"
  val crossScala = List(scala, "2.12.0-M4")
  val scalaTest = "2.2.6"
  val slf4j     = "1.7.21"
}

object Library {
  val logbackClassic = "ch.qos.logback" %  "logback-classic" % Version.logback
  val mockitoAll     = "org.mockito"    %  "mockito-all"     % Version.mockito
  val scalaReflect   = "org.scala-lang" % "scala-reflect"    % Version.scala
  val scalaTest      = "org.scalatest"  %% "scalatest"       % Version.scalaTest
  val slf4jApi       = "org.slf4j"      %  "slf4j-api"       % Version.slf4j
}

object Dependencies {

  import Library._

  val scalaLogging = List(
    scalaReflect,
    slf4jApi,
    logbackClassic % "test",
    mockitoAll     % "test",
    scalaTest      % "test"
  )
}
