import com.typesafe.sbt.osgi.SbtOsgi
import sbt._

enablePlugins(SbtOsgi)

organization := "com.typesafe.scala-logging"
name := "scala-logging"
licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
homepage := Some(url("https://github.com/lightbend/scala-logging"))
incOptions := incOptions.value.withLogRecompileOnMacro(false)
scalaVersion := Version.scala
crossScalaVersions := Version.crossScala
scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-encoding", "UTF-8"
)

osgiSettings

OsgiKeys.bundleSymbolicName := "com.typesafe.scala-logging"
OsgiKeys.privatePackage := Seq()
OsgiKeys.exportPackage := Seq("com.typesafe.scalalogging*")

releaseVersionBump := sbtrelease.Version.Bump.Minor
releaseCrossBuild := true
releasePublishArtifactsAction := PgpKeys.publishSigned.value

libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value)

initialCommands := """|import com.typesafe.scalalogging._
                      |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin

publishTo := {
  if (isSnapshot.value)
    Some(Opts.resolver.sonatypeSnapshots)
  else
    Some(Opts.resolver.sonatypeStaging)
}
publishArtifact in Test := false
pomIncludeRepository := (_ => false)

scmInfo := Some(
  ScmInfo(url("https://github.com/lightbend/scala-logging"), "scm:git:git@github.com:lightbend/scala-logging.git")
)