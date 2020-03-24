package com.typesafe.scalalogging

import org.slf4j.{ Marker, Logger => Underlying }

import scala.language.experimental.macros

/**
 * ALogger that takes some data A and uses it according to strategy CanLog[A] during every log operation.
 * Useful for logging things in a context, such as a request id, assuming it's available during construction time.
 */
class LoggerTakingConstructorArg[A] private[scalalogging] (val underlying: Underlying, val canLogEv: CanLog[A], val a: A) extends Serializable with LogsAdditionalData[A] {

  // Error

  def error(message: String): Unit = macro LoggerTakingConstructorArgMacro.errorMessage[A]

  def error(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.errorMessageCause[A]

  def error(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.errorMessageArgs[A]

  def error(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.errorMessageMarker[A]

  def error(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.errorMessageCauseMarker[A]

  def error(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.errorMessageArgsMarker[A]

  // Warn

  def warn(message: String): Unit = macro LoggerTakingConstructorArgMacro.warnMessage[A]

  def warn(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.warnMessageCause[A]

  def warn(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.warnMessageArgs[A]

  def warn(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.warnMessageMarker[A]

  def warn(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.warnMessageCauseMarker[A]

  def warn(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.warnMessageArgsMarker[A]

  // Info

  def info(message: String): Unit = macro LoggerTakingConstructorArgMacro.infoMessage[A]

  def info(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.infoMessageCause[A]

  def info(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.infoMessageArgs[A]

  def info(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.infoMessageMarker[A]

  def info(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.infoMessageCauseMarker[A]

  def info(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.infoMessageArgsMarker[A]

  // Debug

  def debug(message: String): Unit = macro LoggerTakingConstructorArgMacro.debugMessage[A]

  def debug(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.debugMessageCause[A]

  def debug(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.debugMessageArgs[A]

  def debug(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.debugMessageMarker[A]

  def debug(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.debugMessageCauseMarker[A]

  def debug(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.debugMessageArgsMarker[A]

  // Trace

  def trace(message: String): Unit = macro LoggerTakingConstructorArgMacro.traceMessage[A]

  def trace(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.traceMessageCause[A]

  def trace(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.traceMessageArgs[A]

  def trace(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.traceMessageMarker[A]

  def trace(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.traceMessageCauseMarker[A]

  def trace(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.traceMessageArgsMarker[A]

}
