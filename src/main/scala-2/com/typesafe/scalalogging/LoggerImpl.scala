package com.typesafe.scalalogging

import org.slf4j.Marker
class LoggerImpl {

  // Error

  def error(message: String): Unit = macro LoggerMacro.errorMessage

  def error(message: String, cause: Throwable): Unit = macro LoggerMacro.errorMessageCause

  def error(message: String, args: Any*): Unit = macro LoggerMacro.errorMessageArgs

  def error(marker: Marker, message: String): Unit = macro LoggerMacro.errorMessageMarker

  def error(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.errorMessageCauseMarker

  def error(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.errorMessageArgsMarker

  def whenErrorEnabled(body: Unit): Unit = macro LoggerMacro.errorCode

  // Warn

  def warn(message: String): Unit = macro LoggerMacro.warnMessage

  def warn(message: String, cause: Throwable): Unit = macro LoggerMacro.warnMessageCause

  def warn(message: String, args: Any*): Unit = macro LoggerMacro.warnMessageArgs

  def warn(marker: Marker, message: String): Unit = macro LoggerMacro.warnMessageMarker

  def warn(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.warnMessageCauseMarker

  def warn(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.warnMessageArgsMarker

  def whenWarnEnabled(body: Unit): Unit = macro LoggerMacro.warnCode

  // Info

  def info(message: String): Unit = macro LoggerMacro.infoMessage

  def info(message: String, cause: Throwable): Unit = macro LoggerMacro.infoMessageCause

  def info(message: String, args: Any*): Unit = macro LoggerMacro.infoMessageArgs

  def info(marker: Marker, message: String): Unit = macro LoggerMacro.infoMessageMarker

  def info(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.infoMessageCauseMarker

  def info(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.infoMessageArgsMarker

  def whenInfoEnabled(body: Unit): Unit = macro LoggerMacro.infoCode

  // Debug

  def debug(message: String): Unit = macro LoggerMacro.debugMessage

  def debug(message: String, cause: Throwable): Unit = macro LoggerMacro.debugMessageCause

  def debug(message: String, args: Any*): Unit = macro LoggerMacro.debugMessageArgs

  def debug(marker: Marker, message: String): Unit = macro LoggerMacro.debugMessageMarker

  def debug(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.debugMessageCauseMarker

  def debug(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.debugMessageArgsMarker

  def whenDebugEnabled(body: Unit): Unit = macro LoggerMacro.debugCode

  // Trace

  def trace(message: String): Unit = macro LoggerMacro.traceMessage

  def trace(message: String, cause: Throwable): Unit = macro LoggerMacro.traceMessageCause

  def trace(message: String, args: Any*): Unit = macro LoggerMacro.traceMessageArgs

  def trace(marker: Marker, message: String): Unit = macro LoggerMacro.traceMessageMarker

  def trace(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.traceMessageCauseMarker

  def trace(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.traceMessageArgsMarker

  def whenTraceEnabled(body: Unit): Unit = macro LoggerMacro.traceCode
}