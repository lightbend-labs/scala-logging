import sbtrelease.ReleaseStateTransformations._
import scalariform.formatter.preferences._

lazy val scalaLogging = Project(
  "scala-logging",
  file("."),
  settings = commonSettings ++ List(
    publishArtifact := false,
    unmanagedSourceDirectories in Compile := Nil,
    unmanagedSourceDirectories in Test := Nil,
    unmanagedResourceDirectories in Compile := Nil,
    unmanagedResourceDirectories in Test := Nil
  ),
  aggregate = List(scalaLoggingApi, scalaLoggingSlf4j)
)

lazy val scalaLoggingApi = Project(
  "scala-logging-api",
  file("scala-logging-api"),
  settings = commonSettings
)

lazy val scalaLoggingSlf4j = Project(
  "scala-logging-slf4j",
  file("scala-logging-slf4j"),
  settings = commonSettings ++ List(
    libraryDependencies ++= Dependencies.scalaLoggingSlf4j,
    initialCommands := """import com.typesafe.scalalogging._
                         |import com.typesafe.scalalogging.slf4j._""".stripMargin
  ),
  dependencies = List(scalaLoggingApi)
)

lazy val commonSettings =
  Project.defaultSettings ++
  scalariformSettings ++
  releaseSettings ++
  publishSettings ++
  List(
    organization := "com.typesafe.scala-logging",
    scalaVersion := Version.scala,
    crossScalaVersions := List(scalaVersion.value),
    scalacOptions ++= List(
      "-unchecked",
      "-deprecation",
      "-language:_",
      "-target:jvm-1.7",
      "-encoding", "UTF-8"
    ),
    ScalariformKeys.preferences := ScalariformKeys.preferences.value
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(PreserveDanglingCloseParenthesis, true),
    ReleaseKeys.versionBump := sbtrelease.Version.Bump.Minor,
    ReleaseKeys.releaseProcess := List(
      checkSnapshotDependencies,
      inquireVersions,
      runClean,
      runTest,
      setReleaseVersion,
      commitReleaseVersion,
      tagRelease,
      publishArtifacts.copy(action = publishSignedAction),
      setNextVersion,
      commitNextVersion,
      pushChanges
    )
  )

lazy val publishSettings =
  List(
    licenses := Seq("Apache 2.0 License" -> url("http://www.apache.org/licenses/LICENSE-2.0.html")),
    homepage := Some(url("https://github.com/typesafehub/scala-logging")),
    publishTo <<= isSnapshot(isSnapshot => Some(if (isSnapshot) Opts.resolver.sonatypeSnapshots else Opts.resolver.sonatypeStaging)),
    publishArtifact in Test := false,
    pomIncludeRepository := (_ => false),
    pomExtra :=
      <scm>
        <url>https://github.com/typesafehub/scala-logging</url>
        <connection>scm:git:git://github.com/typesafehub/scala-logging.git</connection>
      </scm>
      <developers>
        <developer>
          <id>hseeberger</id>
          <name>Heiko Seeberger</name>
          <url>http://heikoseeberger.name</url>
        </developer>
      </developers>
  )

def publishSignedAction(state: State) = {
  val extracted = Project.extract(state)
  val ref = extracted.get(thisProjectRef)
  extracted.runAggregated(PgpKeys.publishSigned in Global in ref, state)
}
