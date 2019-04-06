import sbt._

object Version {
  val logback   = "1.2.3"
  val mockito   = "1.10.19"
  val scala     = "2.12.7"
  val crossScala = List(scala, "2.11.12", "2.13.0-RC1")
  val scalaTest = "3.0.6-SNAP6"  // only version available for 2.13.0-M4
  val slf4j     = "1.7.26"
}

object Library {
  val logbackClassic                     = "ch.qos.logback" %  "logback-classic" % Version.logback
  val mockitoAll                         = "org.mockito"    %  "mockito-all"     % Version.mockito
  def scalaReflect(scalaVersion: String) = "org.scala-lang" % "scala-reflect"    % scalaVersion
  val scalaTest                          = "org.scalatest"  %% "scalatest"       % Version.scalaTest
  val slf4jApi                           = "org.slf4j"      %  "slf4j-api"       % Version.slf4j
}

object Dependencies {
  import Library._

  def scalaLogging(scalaVersion: String) = List(
    scalaReflect(scalaVersion),
    slf4jApi,
    logbackClassic % "test",
    mockitoAll     % "test",
    scalaTest      % "test"
  )
}
