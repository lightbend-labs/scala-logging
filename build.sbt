import com.typesafe.sbt.osgi.SbtOsgi

enablePlugins(SbtOsgi)

organization := "com.typesafe.scala-logging"
name := "scala-logging"
licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))
homepage := Some(url("https://github.com/typesafehub/scala-logging"))
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