package com.typesafe.scalalogging

import org.slf4j.{Marker, Logger => Underlying}

import scala.language.experimental.macros

/**
 * ALogger that takes some data A and uses it according to strategy CanLog[A] during every log operation.
 * Useful for logging things in a context, such as a request id, assuming it's available during construction time.
 * */
class LoggerTakingConstructorArg[A] private[scalalogging](val underlying: Underlying, val canLogEv: CanLog[A], val a: A) extends ALogger with Serializable with LogsAdditionalData[A] {

  // Error

  override def error(message: String): Unit = macro LoggerTakingConstructorArgMacro.errorMessage[A]

  override def error(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.errorMessageCause[A]

  override def error(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.errorMessageArgs[A]

  override def error(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.errorMessageMarker[A]

  override def error(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.errorMessageCauseMarker[A]

  override def error(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.errorMessageArgsMarker[A]

  // Warn

  override def warn(message: String): Unit = macro LoggerTakingConstructorArgMacro.warnMessage[A]

  override def warn(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.warnMessageCause[A]

  override def warn(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.warnMessageArgs[A]

  override def warn(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.warnMessageMarker[A]

  override def warn(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.warnMessageCauseMarker[A]

  override def warn(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.warnMessageArgsMarker[A]

  // Info

  override def info(message: String): Unit = macro LoggerTakingConstructorArgMacro.infoMessage[A]

  override def info(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.infoMessageCause[A]

  override def info(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.infoMessageArgs[A]

  override def info(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.infoMessageMarker[A]

  override def info(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.infoMessageCauseMarker[A]

  override def info(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.infoMessageArgsMarker[A]

  // Debug

  override def debug(message: String): Unit = macro LoggerTakingConstructorArgMacro.debugMessage[A]

  override def debug(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.debugMessageCause[A]

  override def debug(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.debugMessageArgs[A]

  override def debug(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.debugMessageMarker[A]

  override def debug(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.debugMessageCauseMarker[A]

  override def debug(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.debugMessageArgsMarker[A]

  // Trace

  override def trace(message: String): Unit = macro LoggerTakingConstructorArgMacro.traceMessage[A]

  override def trace(message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.traceMessageCause[A]

  override def trace(message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.traceMessageArgs[A]

  override def trace(marker: Marker, message: String): Unit = macro LoggerTakingConstructorArgMacro.traceMessageMarker[A]

  override def trace(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerTakingConstructorArgMacro.traceMessageCauseMarker[A]

  override def trace(marker: Marker, message: String, args: Any*): Unit = macro LoggerTakingConstructorArgMacro.traceMessageArgsMarker[A]

}
