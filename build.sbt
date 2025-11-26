// basics

name := "scala-logging"
crossScalaVersions := Seq("3.3.5", "2.11.12", "2.12.20", "2.13.18")
scalaVersion := crossScalaVersions.value.head
ThisBuild / versionScheme := Some("early-semver")
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-encoding", "UTF-8",
  "-Ywarn-unused"
)
incOptions := incOptions.value.withLogRecompileOnMacro(false)
val isScala3 = Def.setting {
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 != 2)
}
libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value, isScala3.value)
initialCommands := """|import com.typesafe.scalalogging._
                      |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin

// OSGi

enablePlugins(SbtOsgi)
osgiSettings
OsgiKeys.bundleSymbolicName := "com.typesafe.scala-logging"
OsgiKeys.privatePackage := Seq()
OsgiKeys.exportPackage := Seq("com.typesafe.scalalogging*")

// publishing

organization := "com.typesafe.scala-logging"
licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
homepage := Some(url("https://github.com/lightbend/scala-logging"))
Test / publishArtifact := false
pomIncludeRepository := (_ => false)
scmInfo := Some(
  ScmInfo(url("https://github.com/lightbend/scala-logging"), "scm:git:git@github.com:lightbend/scala-logging.git")
)
developers := List(
  Developer(
    id = "hseeberger",
    name = "Heiko Seeberger",
    email = "",
    url = url("http://heikoseeberger.de")
  ),
  Developer(
    id = "analytically",
    name = "Mathias Bogaert",
    email = "",
    url = url("http://twitter.com/analytically")
  )
)
