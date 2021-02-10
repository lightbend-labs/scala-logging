import sbt._

object Version {
  val logback   = "1.2.3"
  val mockito   = "1.16.25"
  val scalaTest = "3.2.3"
  val slf4j     = "1.7.30"
}

object Library {
  val logbackClassic                     = "ch.qos.logback" %  "logback-classic"         % Version.logback
  val mockitoScala                       = "org.mockito"    %% "mockito-scala-scalatest" % Version.mockito
  def scalaReflect(scalaVersion: String) = "org.scala-lang" %  "scala-reflect"           % scalaVersion
  val scalaTest                          = "org.scalatest"  %% "scalatest"               % Version.scalaTest
  val slf4jApi                           = "org.slf4j"      %  "slf4j-api"               % Version.slf4j
}

object Dependencies {
  import Library._

  def scalaLogging(scalaVersion: String) = List(
    scalaReflect(scalaVersion),
    slf4jApi,
    logbackClassic % "test",
    mockitoScala   % "test",
    scalaTest      % "test"
  )
}
