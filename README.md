# Scala Logging #

Scala Logging is a **convenient** and **performant** logging library wrapping [SLF4J](http://www.slf4j.org).

It's convenient, because you can simply call log methods without checking whether the respective log level is enabled:

```
logger.debug(s"Some $expensive message!")
```

It's performant, because thanks to Scala macros the *check-enabled-idiom* is applied, just like writing this more involved code:

```
if (logger.isDebugEnabled) logger.debug(s"Some $expensive message!")
```

## Prerequisites ##

* Java 6 or higher
* Scala 2.11
* Logging backend compatible with SLF4J, e.g. [Logback](http://logback.qos.ch)

If you are looking for a version compatible with Scala 2.10, check out Scala Logging 2.x.

## Getting Scala Logging ##

Scala Logging is published to Sonatype OSS and Maven Central:

- Group id / organization: *com.typesafe.scala-logging*
- Artifact id / name: *scala-logging*
- Latest version is 3.0.0

The following example shows how to add a dependency to the latest version of Scala Logging to your sbt build definition:

```
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.0.0"
```

## Using Scala Logging ##

The `Logger` class from the `com.typesafe.scalalogging` package wraps an underlying SLF4J logger. Hence, in order to create a `Logger`, you have to pass a SLF4J logger to the `apply` factory method defined in the `Logger` companion object:

```
val logger = Logger(LoggerFactory.getLogger("name"))
```

The `LazyLogging` and `StrictLogging` traits from the `com.typesafe.scalalogging` package define the `logger` member as a lazy or strict value respectively. In both cases the underlying SLF4J logger is named according to the class into which these traits are mixed:

```
class MyClass extends LazyLogging {
  logger.debug("This is very convenient ;-)")
}
```

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Before we can accept pull requests, you will need to agree to the [Typesafe Contributor License Agreement](http://www.typesafe.com/contribute/cla) online, using your GitHub account.

## License ##

This code is open source software licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).
