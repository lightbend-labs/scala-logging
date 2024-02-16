// basics

val scala213 = "2.13.12"
val scala3 = "3.4.0"
val scala2 = Seq("2.11.12", "2.12.18", scala213)
val isScala3 = Def.setting {
  CrossVersion.partialVersion(scalaVersion.value).exists(_._1 != 2)
}

import com.typesafe.sbt.osgi.SbtOsgi
import sbt.url

lazy val root = (project in file(".")).aggregate(main, scala2macros)

lazy val main = (project in file("main"))
  .enablePlugins(SbtOsgi)
  .settings(
    name := "scala-logging",
    crossScalaVersions := Seq(scala3) ++ scala2,
    scalaVersion := crossScalaVersions.value.head,
    ThisBuild / versionScheme := Some("early-semver"),
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-encoding", "UTF-8",
      "-Ywarn-unused"
    ),
    incOptions := incOptions.value.withLogRecompileOnMacro(false),
    libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value, isScala3.value),
    initialCommands := """|import com.typesafe.scalalogging._
                          |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin
  ).settings(
    // OSGi

    osgiSettings
  ).settings(
    OsgiKeys.bundleSymbolicName := "com.typesafe.scala-logging",
    OsgiKeys.privatePackage := Seq(),
    OsgiKeys.exportPackage := Seq("com.typesafe.scalalogging*"),

    // publishing

    organization := "com.typesafe.scala-logging",
    sonatypeProfileName := "com.typesafe",
    licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("https://github.com/lightbend/scala-logging")),
    Test / publishArtifact := false,
    pomIncludeRepository := (_ => false),
    scmInfo := Some(
      ScmInfo(url("https://github.com/lightbend/scala-logging"), "scm:git:git@github.com:lightbend/scala-logging.git")
    ),
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

  )
  .dependsOn(scala2macros)

lazy val scala2macros = project
  .settings(
    name := "scala2macros",
    scalaVersion := scala213,
    crossScalaVersions := scala2,
    libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value, false),
  )
