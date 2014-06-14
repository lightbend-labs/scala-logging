import sbt._

object Version {
  val scala        = List("2.11.0", "2.10.4")
  val slf4j        = "1.7.7"
  val logback      = "1.1.2"
  val scalaTest    = "2.1.3"
  val mockito      = "1.9.5"
}

object Library {
  val scalaReflect   = "org.scala-lang" % "scala-reflect"
  val slf4jApi       = "org.slf4j"      %  "slf4j-api"       % Version.slf4j
  val logbackClassic = "ch.qos.logback" %  "logback-classic" % Version.logback
  val scalaTest      = "org.scalatest"  %% "scalatest"       % Version.scalaTest
  val mockitoAll     = "org.mockito"    %  "mockito-all"     % Version.mockito
}

object Dependencies {

  import Library._

  def scalaLoggingSlf4jMacro(scalaVersion: String) = List (
    scalaReflect % scalaVersion,
    slf4jApi
  )

  val scalaLoggingSlf4j = List(
    slf4jApi,
    scalaTest % "test",
    mockitoAll % "test",
    logbackClassic % "test"
  )
}
