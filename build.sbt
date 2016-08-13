import com.typesafe.sbt.osgi.SbtOsgi._

lazy val scalaLogging = project in file(".")

name := "scala-logging"

Common.settings ++ defaultOsgiSettings ++ Seq(
  packageBin in Runtime <<= OsgiKeys.bundle,
  packagedArtifact in (Compile, packageBin) <<= (artifact in (Compile, packageBin), OsgiKeys.bundle).identityMap,
  OsgiKeys.exportPackage := Seq("com.typesafe.scalalogging")
)

libraryDependencies ++= Dependencies.scalaLogging(scalaVersion.value)

initialCommands := """|import com.typesafe.scalalogging._
                      |import org.slf4j.{ Logger => Underlying, _ }""".stripMargin
