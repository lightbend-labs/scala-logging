import sbt._

object Version {
  val scala        = "2.11.0"
  val slf4j        = "1.7.7"
  val logback      = "1.1.2"
  val scalaTest    = "2.1.3"
  val mockito      = "1.9.5"
}

object Library {
  val scalaReflect   = "org.scala-lang" % "scala-reflect"    % Version.scala
  val slf4jApi       = "org.slf4j"      %  "slf4j-api"       % Version.slf4j
  val logbackClassic = "ch.qos.logback" %  "logback-classic" % Version.logback
  val scalaTest      = "org.scalatest"  %% "scalatest"       % Version.scalaTest
  val mockitoAll     = "org.mockito"    %  "mockito-all"     % Version.mockito
}

object Dependencies {

  import Library._

  val scalaLoggingApi = List(
  )

  val scalaLoggingSlf4j = List(
    scalaReflect,
    slf4jApi,
    scalaTest % "test",
    mockitoAll % "test",
    logbackClassic % "test"
  )
}
