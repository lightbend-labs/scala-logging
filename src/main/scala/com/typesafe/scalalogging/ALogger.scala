package com.typesafe.scalalogging

import org.slf4j.Marker

/**
 *
 * abstract class common for both Logger and LoggerTakingConstructorArg,
 * if you have a library that is sometimes used in a context - in which case you want to log the context,
 * but other times is used outside of a context in which case you want to log "normally", your base class can have a logger of this abstract type
*/
trait ALogger {

  // Error

  def error(message: String): Unit = {}

  def error(message: String, cause: Throwable): Unit = {}

  def error(message: String, args: Any*): Unit = {}

  def error(marker: Marker, message: String): Unit = {}

  def error(marker: Marker, message: String, cause: Throwable): Unit = {}

  def error(marker: Marker, message: String, args: Any*): Unit = {}

  // Warn

  def warn(message: String): Unit = {}

  def warn(message: String, cause: Throwable): Unit = {}

  def warn(message: String, args: Any*): Unit = {}

  def warn(marker: Marker, message: String): Unit = {}

  def warn(marker: Marker, message: String, cause: Throwable): Unit = {}

  def warn(marker: Marker, message: String, args: Any*): Unit = {}

  // Info

  def info(message: String): Unit = {}

  def info(message: String, cause: Throwable): Unit = {}

  def info(message: String, args: Any*): Unit = {}

  def info(marker: Marker, message: String): Unit = {}

  def info(marker: Marker, message: String, cause: Throwable): Unit = {}

  def info(marker: Marker, message: String, args: Any*): Unit = {}

  // Debug

  def debug(message: String): Unit = {}

  def debug(message: String, cause: Throwable): Unit = {}

  def debug(message: String, args: Any*): Unit = {}

  def debug(marker: Marker, message: String): Unit = {}

  def debug(marker: Marker, message: String, cause: Throwable): Unit = {}

  def debug(marker: Marker, message: String, args: Any*): Unit = {}

  // Trace

  def trace(message: String): Unit = {}

  def trace(message: String, cause: Throwable): Unit = {}

  def trace(message: String, args: Any*): Unit = {}

  def trace(marker: Marker, message: String): Unit = {}

  def trace(marker: Marker, message: String, cause: Throwable): Unit = {}

  def trace(marker: Marker, message: String, args: Any*): Unit = {}

}


