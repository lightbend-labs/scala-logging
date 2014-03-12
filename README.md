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

* Scala 2.11
* Logging backend compatible with SLF4J, e.g. [Logback](http://logback.qos.ch)

## Getting Scala Logging ##

Scala Logging is published to Sonatype OSS and Maven Central:

- Group id / organization: *com.typesafe.scala-logging*
- Modules (artifact id / name):
  - *scala-logging-api* if you just need the API
  - *scala-logging-slf4j* for the SLF4J-backed implementation
  
The following example shows how to add a dependency to the latest version of Scala Logging to your sbt build definition:

```
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.0.0"
```

## Using Scala Logging ##

### API ###

Scala Logging comes with a thin API layer, packaged in the *scala-logging-api* module, which is independent of a particular logging library. The `com.typesafe.scalalogging` package contains the following members:

The `Logger` trait declares abstract logging methods like `error`, `info`, etc.

The `Logging` trait declares the abstract `logger` member of type `Logger`, i.e. requires the class, into which this trait is mixed, to define a `Logger`.

### SLF4J-backed implementation ###

The implementation for SLF4J is packaged in the *scala-logging-slf4j* module. The `com.typesafe.scalalogging.slf4j` package contains the following members:

The `Logger` class implements the `Logger` trait from the API package. It wraps an underlying SLF4J logger. Hence, in order to create a `Logger`, you have to pass a SLF4J logger to the `apply` factory method defined in the `Logger` companion object:

```
val logger = Logger(LoggerFactory getLogger "name")
```

The `LazyLogging` and `StrictLogging` traits implement the `Logging` trait from the API package. They define the `logger` member as a lazy or strict value respectively. In both cases the underlying SLF4J logger is named like the class into which these traits are mixed:

```
class MyClass extends LazyLogging {
  logger.debug("This is very convenient ;-)")
}
```

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Before we can accept pull requests, you will need to agree to the [Typesafe Contributor License Agreement](http://www.typesafe.com/contribute/cla) online, using your GitHub account.

## License ##

This code is open source software licensed under the [Apache 2.0 License](http://www.apache.org/licenses/LICENSE-2.0.html).
