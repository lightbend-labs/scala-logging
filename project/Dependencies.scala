import sbt._

object Version {
  val logback   = "1.2.12"
  val mockito   = "3.2.10.0"
  val scalaTest = "3.2.17"
  val slf4j     = "1.7.36"
}

object Library {
  val logbackClassic                     = "ch.qos.logback"    %  "logback-classic" % Version.logback
  val mockitoScala                       = "org.scalatestplus" %% "mockito-3-4"     % Version.mockito
  def scalaReflect(scalaVersion: String) = "org.scala-lang"    %  "scala-reflect"   % scalaVersion
  val scalaTest                          = "org.scalatest"     %% "scalatest"       % Version.scalaTest
  val slf4jApi                           = "org.slf4j"         %  "slf4j-api"       % Version.slf4j
}

object Dependencies {
  import Library._

  def scalaLogging(scalaVersion: String, isScala3: Boolean) = {
    List(scalaReflect(scalaVersion)).filter(_ => !isScala3) ++
      List(
        slf4jApi,
        logbackClassic % "test",
        mockitoScala   % "test",
        scalaTest      % "test"
      )
  }
}
