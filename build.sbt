lazy val scalaLogging = project in file(".")

name := "scala-logging"

Common.settings

libraryDependencies ++= Dependencies.scalaLogging

initialCommands := """|import com.typesafe.scalalogging._
                      |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin
