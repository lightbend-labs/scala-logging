// ###########
// Subprojects
// ###########

lazy val scalaLoggingMacros =
  Project("scala-logging-macros", file("scala-logging-macros"))

lazy val scalaLoggingApi =
  Project("scala-logging-api", file("scala-logging-api")) dependsOn scalaLoggingMacros

lazy val scalaLoggingSlf4j =
  Project("scala-logging-slf4j", file("scala-logging-slf4j")) dependsOn scalaLoggingApi

// ##############
// Build settings
// ##############

shellPrompt in ThisBuild := (state => s"${Project.extract(state).currentRef.project}> ")

// #########################
// Settings for root project
// #########################

Common.settings

publishArtifact := false

unmanagedSourceDirectories in Compile := Nil

unmanagedSourceDirectories in Test := Nil

unmanagedResourceDirectories in Compile := Nil

unmanagedResourceDirectories in Test := Nil
