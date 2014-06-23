import sbt._

object Version {
  val akka      = "2.3.3"
  val logback   = "1.1.2"
  val scala     = "2.11.1"
  val scalactic = "2.2.0"
  val scalaTest = "2.2.0"
}

object Library {
  val akkaActor      = "com.typesafe.akka" %% "akka-actor"      % Version.akka
  val akkaSlf4j      = "com.typesafe.akka" %% "akka-slf4j"      % Version.akka
  val akkaTestkit    = "com.typesafe.akka" %% "akka-testkit"    % Version.akka
  val logbackClassic = "ch.qos.logback"    %  "logback-classic" % Version.logback
  val scalactic      = "org.scalactic"     %% "scalactic"       % Version.scalactic
  val scalaTest      = "org.scalatest"     %% "scalatest"       % Version.scalaTest
}

object Dependencies {

  import Library._

  val scalaLogging = List(
    scalaTest % "test"
  )
}
