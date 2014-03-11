import scalariform.formatter.preferences._

lazy val scalaLogging = Project(
  "scala-logging",
  file("."),
  settings = commonSettings ++ List(
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
  List(
    organization := "com.typesafe",
    version := Version.scalaLogging,
    scalaVersion := Version.scala,
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
      .setPreference(PreserveDanglingCloseParenthesis, true)
  )
