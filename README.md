# Scala Logging #

Scala Logging is a **convenient** and **performant** logging library wrapping logging libraries like [SLF4J](http://www.slf4j.org) and potentially others.

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
* Scala 2.11 or Scala 2.10
* Logging backend compatible with SLF4J, e.g. [Logback](http://logback.qos.ch)

## Getting Scala Logging ##

Scala Logging is published to Sonatype OSS and Maven Central:

- Group id / organization: *com.typesafe.scala-logging*
- Module (artifact id / name): *scala-logging-slf4j* for the SLF4J-backed implementation
- Latest release version is 2.1.2
  
The following example shows how to add a dependency to the latest version of Scala Logging to your sbt build definition:

```
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"
```

## Using Scala Logging ##
The `com.typesafe.scalalogging.slf4j` package contains the following members:

The `Logger` class wraps an underlying SLF4J logger and provides methods like `error`, `info`, etc. In order to create a `Logger`, you have to pass a SLF4J logger to the `apply` factory method defined in the `Logger` companion object:

```
val logger = Logger(LoggerFactory getLogger "name")
```

The `Logging` trait declares the `logger` member of type `Logger`, i.e. requires the class, into which this trait is mixed, to define a `Logger`.

The `LazyLogging` and `StrictLogging` traits implement the `Logging`. They define the `logger` member as a lazy or strict value respectively. In both cases the underlying SLF4J logger is named like the class into which these traits are mixed:

```
class MyClass extends LazyLogging {
  logger.debug("This is very convenient ;-)")
}
```

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Before we can accept pull requests, you will need to agree to the [Typesafe Contributor License Agreement](http://www.typesafe.com/contribute/cla) online, using your GitHub account.

## License ##

This code is open source software licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).
