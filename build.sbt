lazy val scalaLogging = project in file(".")

name := "scala-logging"

Common.settings

libraryDependencies ++= Dependencies.scalaLogging

initialCommands := """|import com.typesafe.scala-logging.scalalogging._""".stripMargin
