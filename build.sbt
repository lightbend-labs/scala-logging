import com.typesafe.sbt.osgi.SbtOsgi._
import com.typesafe.sbt.SbtScalariform
import com.typesafe.sbt.SbtScalariform.ScalariformKeys
import com.typesafe.sbt.osgi.SbtOsgi

import scalariform.formatter.preferences.{AlignSingleLineCaseStatements, DoubleIndentClassDeclaration}

enablePlugins(SbtOsgi)

name := "scala-logging"
organization := "com.typesafe.scala-logging"
licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
homepage := Some(url("https://github.com/typesafehub/scala-logging"))
scalaVersion := Version.scala
crossScalaVersions := Version.crossScala
scalacOptions ++= List(
  "-unchecked",
  "-deprecation",
  "-language:_",
  "-encoding", "UTF-8"
)

osgiSettings

OsgiKeys.bundleSymbolicName := s"com.typesafe.scalalogging"
OsgiKeys.exportPackage := Seq(s"com.typesafe.scalalogging.*;version=${version.value}")

packageBin in Runtime <<= OsgiKeys.bundle
packagedArtifact in (Compile, packageBin) <<= (artifact in (Compile, packageBin), OsgiKeys.bundle).identityMap

unmanagedSourceDirectories in Compile := List((scalaSource in Compile).value)
unmanagedSourceDirectories in Test := List((scalaSource in Test).value)

releaseVersionBump := sbtrelease.Version.Bump.Minor
releaseCrossBuild := true
releasePublishArtifactsAction := PgpKeys.publishSigned.value

SbtScalariform.scalariformSettings

ScalariformKeys.preferences := ScalariformKeys.preferences.value
  .setPreference(AlignSingleLineCaseStatements, true)
  .setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
  .setPreference(DoubleIndentClassDeclaration, true)

libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value)

initialCommands := """|import com.typesafe.scalalogging._
                      |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin

publishTo <<= isSnapshot(isSnapshot => Some(if (isSnapshot) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging))
publishArtifact in Test := false
pomIncludeRepository := (_ => false)
pomExtra :=
  <scm>
    <url>https://github.com/typesafehub/scala-logging</url>
    <connection>scm:git:git://github.com/typesafehub/scala-logging.git</connection>
  </scm>
    <developers>
      <developer>
        <id>hseeberger</id>
        <name>Heiko Seeberger</name>
        <url>http://heikoseeberger.de</url>
      </developer>
      <developer>
        <id>analytically</id>
        <name>Mathias Bogaert</name>
        <url>http://twitter.com/analytically</url>
      </developer>
    </developers>