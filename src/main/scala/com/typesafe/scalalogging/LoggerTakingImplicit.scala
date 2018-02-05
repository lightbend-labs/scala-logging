package com.typesafe.scalalogging

import org.slf4j.{ Marker, Logger => Underlying }

trait CanLog[A] {
  def logMessage(originalMsg: String, a: A): String
  def afterLog(a: A): Unit = ()
}

@SerialVersionUID(957385465L)
final class LoggerTakingImplicit[A] private[scalalogging] (val underlying: Underlying)(implicit val canLogEv: CanLog[A]) extends Serializable {

  // Error

  def error(message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.errorMessage[A]

  def error(message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.errorMessageCause[A]

  def error(message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.errorMessageArgs[A]

  def error(marker: Marker, message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.errorMessageMarker[A]

  def error(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.errorMessageCauseMarker[A]

  def error(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.errorMessageArgsMarker[A]

  // Warn

  def warn(message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.warnMessage[A]

  def warn(message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.warnMessageCause[A]

  def warn(message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.warnMessageArgs[A]

  def warn(marker: Marker, message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.warnMessageMarker[A]

  def warn(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.warnMessageCauseMarker[A]

  def warn(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.warnMessageArgsMarker[A]

  // Info

  def info(message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.infoMessage[A]

  def info(message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.infoMessageCause[A]

  def info(message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.infoMessageArgs[A]

  def info(marker: Marker, message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.infoMessageMarker[A]

  def info(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.infoMessageCauseMarker[A]

  def info(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.infoMessageArgsMarker[A]

  // Debug

  def debug(message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.debugMessage[A]

  def debug(message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.debugMessageCause[A]

  def debug(message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.debugMessageArgs[A]

  def debug(marker: Marker, message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.debugMessageMarker[A]

  def debug(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.debugMessageCauseMarker[A]

  def debug(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.debugMessageArgsMarker[A]

  // Trace

  def trace(message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.traceMessage[A]

  def trace(message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.traceMessageCause[A]

  def trace(message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.traceMessageArgs[A]

  def trace(marker: Marker, message: String)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.traceMessageMarker[A]

  def trace(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.traceMessageCauseMarker[A]

  def trace(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LoggerTakingImplicitMacro.traceMessageArgsMarker[A]

}
