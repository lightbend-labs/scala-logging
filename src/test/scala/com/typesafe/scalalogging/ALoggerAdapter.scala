package com.typesafe.scalalogging

import org.slf4j.Marker

/**
 * this is a ugly ugly hack.
 * we wanted Logger and LoggerTakingConstructorArg to both implement ALogger.
 * this allows library modules to use ALogger and only later get an instance of logger from mixin, thus supporting
 * several execution modes, one in context, another without context, as the library is used.
 * unfortunately, once the base member is of type ALogger trait, the macros are not invoked properly and we reach the
 * default implementation in the trait.
 * therefore, as a workaround, we add these adapters that make Logger and LoggerTakingConstructorArg into an ALogger,
 */
object ALoggerAdapter {

  def apply[A](wrapped: LoggerTakingConstructorArg[A]) = new LoggerTakingConstructorArgAsALoggerWrapper[A](wrapped)
  def apply(wrapped: Logger) = new LoggerAsALoggerWrapper(wrapped)

}

class LoggerAsALoggerWrapper(wrapped: Logger) extends ALogger {

  override def error(message: String): Unit = wrapped.error(message)
  override def error(message: String, cause: Throwable): Unit = wrapped.error(message, cause)
  override def error(message: String, args: Any*): Unit = wrapped.error(message, args)
  override def error(marker: Marker, message: String): Unit = wrapped.error(marker, message)
  override def error(marker: Marker, message: String, cause: Throwable): Unit = wrapped.error(marker, message, cause)
  override def error(marker: Marker, message: String, args: Any*): Unit = wrapped.error(marker, message, args)

  override def warn(message: String): Unit = wrapped.warn(message)
  override def warn(message: String, cause: Throwable): Unit = wrapped.warn(message, cause)
  override def warn(message: String, args: Any*): Unit = wrapped.warn(message, args)
  override def warn(marker: Marker, message: String): Unit = wrapped.warn(marker, message)
  override def warn(marker: Marker, message: String, cause: Throwable): Unit = wrapped.warn(marker, message, cause)
  override def warn(marker: Marker, message: String, args: Any*): Unit = wrapped.warn(marker, message, args)

  override def info(message: String): Unit = wrapped.info(message)
  override def info(message: String, cause: Throwable): Unit = wrapped.info(message, cause)
  override def info(message: String, args: Any*): Unit = wrapped.info(message, args)
  override def info(marker: Marker, message: String): Unit = wrapped.info(marker, message)
  override def info(marker: Marker, message: String, cause: Throwable): Unit = wrapped.info(marker, message, cause)
  override def info(marker: Marker, message: String, args: Any*): Unit = wrapped.info(marker, message, args)

  override def debug(message: String): Unit = wrapped.debug(message)
  override def debug(message: String, cause: Throwable): Unit = wrapped.debug(message, cause)
  override def debug(message: String, args: Any*): Unit = wrapped.debug(message, args)
  override def debug(marker: Marker, message: String): Unit = wrapped.debug(marker, message)
  override def debug(marker: Marker, message: String, cause: Throwable): Unit = wrapped.debug(marker, message, cause)
  override def debug(marker: Marker, message: String, args: Any*): Unit = wrapped.debug(marker, message, args)

  override def trace(message: String): Unit = wrapped.trace(message)
  override def trace(message: String, cause: Throwable): Unit = wrapped.trace(message, cause)
  override def trace(message: String, args: Any*): Unit = wrapped.trace(message, args)
  override def trace(marker: Marker, message: String): Unit = wrapped.trace(marker, message)
  override def trace(marker: Marker, message: String, cause: Throwable): Unit = wrapped.trace(marker, message, cause)
  override def trace(marker: Marker, message: String, args: Any*): Unit = wrapped.trace(marker, message, args)
}

class LoggerTakingConstructorArgAsALoggerWrapper[A](wrapped: LoggerTakingConstructorArg[A]) extends ALogger {

  override def error(message: String): Unit = wrapped.error(message)
  override def error(message: String, cause: Throwable): Unit = wrapped.error(message, cause)
  override def error(message: String, args: Any*): Unit = wrapped.error(message, args)
  override def error(marker: Marker, message: String): Unit = wrapped.error(marker, message)
  override def error(marker: Marker, message: String, cause: Throwable): Unit = wrapped.error(marker, message, cause)
  override def error(marker: Marker, message: String, args: Any*): Unit = wrapped.error(marker, message, args)

  override def warn(message: String): Unit = wrapped.warn(message)
  override def warn(message: String, cause: Throwable): Unit = wrapped.warn(message, cause)
  override def warn(message: String, args: Any*): Unit = wrapped.warn(message, args)
  override def warn(marker: Marker, message: String): Unit = wrapped.warn(marker, message)
  override def warn(marker: Marker, message: String, cause: Throwable): Unit = wrapped.warn(marker, message, cause)
  override def warn(marker: Marker, message: String, args: Any*): Unit = wrapped.warn(marker, message, args)

  override def info(message: String): Unit = wrapped.info(message)
  override def info(message: String, cause: Throwable): Unit = wrapped.info(message, cause)
  override def info(message: String, args: Any*): Unit = wrapped.info(message, args)
  override def info(marker: Marker, message: String): Unit = wrapped.info(marker, message)
  override def info(marker: Marker, message: String, cause: Throwable): Unit = wrapped.info(marker, message, cause)
  override def info(marker: Marker, message: String, args: Any*): Unit = wrapped.info(marker, message, args)

  override def debug(message: String): Unit = wrapped.debug(message)
  override def debug(message: String, cause: Throwable): Unit = wrapped.debug(message, cause)
  override def debug(message: String, args: Any*): Unit = wrapped.debug(message, args)
  override def debug(marker: Marker, message: String): Unit = wrapped.debug(marker, message)
  override def debug(marker: Marker, message: String, cause: Throwable): Unit = wrapped.debug(marker, message, cause)
  override def debug(marker: Marker, message: String, args: Any*): Unit = wrapped.debug(marker, message, args)

  override def trace(message: String): Unit = wrapped.trace(message)
  override def trace(message: String, cause: Throwable): Unit = wrapped.trace(message, cause)
  override def trace(message: String, args: Any*): Unit = wrapped.trace(message, args)
  override def trace(marker: Marker, message: String): Unit = wrapped.trace(marker, message)
  override def trace(marker: Marker, message: String, cause: Throwable): Unit = wrapped.trace(marker, message, cause)
  override def trace(marker: Marker, message: String, args: Any*): Unit = wrapped.trace(marker, message, args)
}