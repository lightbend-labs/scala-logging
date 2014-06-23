import sbt._

object Version {
  val logback   = "1.1.2"
  val mockito   = "1.9.5"
  val scala     = "2.11.1"
  val scalaTest = "2.2.0"
  val slf4j     = "1.7.7"
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
