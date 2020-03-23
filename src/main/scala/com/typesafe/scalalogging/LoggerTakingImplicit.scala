package com.typesafe.scalalogging

import org.slf4j.{ Marker, Logger => Underlying }
import scala.language.experimental.macros

trait CanLog[A] {
  def logMessage(originalMsg: String, a: A): String
  def afterLog(a: A): Unit = ()
}

@SerialVersionUID(957385465L)
class LoggerTakingImplicit[A] private[scalalogging] (val underlying: Underlying)(implicit val canLogEv: CanLog[A]) extends Serializable with LogsAdditionalData[A] {

  // Error

  def error(message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.errorMessage[A]

  def error(message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.errorMessageCause[A]

  def error(message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.errorMessageArgs[A]

  def error(marker: Marker, message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.errorMessageMarker[A]

  def error(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.errorMessageCauseMarker[A]

  def error(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.errorMessageArgsMarker[A]

  // Warn

  def warn(message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.warnMessage[A]

  def warn(message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.warnMessageCause[A]

  def warn(message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.warnMessageArgs[A]

  def warn(marker: Marker, message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.warnMessageMarker[A]

  def warn(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.warnMessageCauseMarker[A]

  def warn(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.warnMessageArgsMarker[A]

  // Info

  def info(message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.infoMessage[A]

  def info(message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.infoMessageCause[A]

  def info(message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.infoMessageArgs[A]

  def info(marker: Marker, message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.infoMessageMarker[A]

  def info(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.infoMessageCauseMarker[A]

  def info(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.infoMessageArgsMarker[A]

  // Debug

  def debug(message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.debugMessage[A]

  def debug(message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.debugMessageCause[A]

  def debug(message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.debugMessageArgs[A]

  def debug(marker: Marker, message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.debugMessageMarker[A]

  def debug(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.debugMessageCauseMarker[A]

  def debug(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.debugMessageArgsMarker[A]

  // Trace

  def trace(message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.traceMessage[A]

  def trace(message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.traceMessageCause[A]

  def trace(message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.traceMessageArgs[A]

  def trace(marker: Marker, message: String)(implicit a: A): Unit = macro LogsAdditionalDataMacro.traceMessageMarker[A]

  def trace(marker: Marker, message: String, cause: Throwable)(implicit a: A): Unit = macro LogsAdditionalDataMacro.traceMessageCauseMarker[A]

  def trace(marker: Marker, message: String, args: Any*)(implicit a: A): Unit = macro LogsAdditionalDataMacro.traceMessageArgsMarker[A]

}
