// basics

name := "scala-logging"
scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-encoding", "UTF-8",
  "-Ywarn-unused"
)
incOptions := incOptions.value.withLogRecompileOnMacro(false)
libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value, isDotty.value)
initialCommands := """|import com.typesafe.scalalogging._
                      |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin

unmanagedSourceDirectories in Compile ++= {
  val sourceDir = (sourceDirectory in Compile).value
  val extraFilesOpt = CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, _)) => Some(sourceDir / "scala-2.x")
    case Some((3, _)) => Some(sourceDir / "scala-3.x")
    case _ => None
  }
  extraFilesOpt.toSeq
}

// OSGi

import com.typesafe.sbt.osgi.SbtOsgi
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
