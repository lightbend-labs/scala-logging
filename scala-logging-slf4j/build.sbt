Common.settings

libraryDependencies ++= Dependencies.scalaLoggingSlf4j(scalaVersion.value)

unmanagedSourceDirectories in Compile += (sourceDirectory in Compile).value / s"scala_${scalaBinaryVersion.value}"
