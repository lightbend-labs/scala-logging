// ###########
// Subprojects
// ###########

lazy val scalaLoggingSlf4j = Project("scala-logging-slf4j", file("scala-logging-slf4j"))

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
