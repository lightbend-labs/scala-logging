package com.typesafe.scalalogging

import com.typesafe.scalalogging.{LoggerMacro2, LoggerMacro3}

import org.slf4j.{Marker, Logger as Underlying }

trait LoggerImpl {
  def underlying: Underlying

  import scala.language.experimental.macros

  // Error

  def error(message: String): Unit = macro LoggerMacro2.errorMessage
  inline def error(inline message: String): Unit = ${LoggerMacro3.errorMessage('underlying, 'message)}

  def error(message: String, cause: Throwable): Unit = macro LoggerMacro2.errorMessageCause
  inline def error(inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.errorMessageCause('underlying, 'message, 'cause)}

  def error(message: String, args: Any*): Unit = macro LoggerMacro2.errorMessageArgs
  inline def error(inline message: String, inline args: Any*): Unit = ${LoggerMacro3.errorMessageArgs('underlying, 'message, 'args)}

  def error(marker: Marker, message: String): Unit = macro LoggerMacro2.errorMessageMarker
  inline def error(inline marker: Marker, inline message: String): Unit = ${LoggerMacro3.errorMessageMarker('underlying, 'marker, 'message)}

  def error(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro2.errorMessageCauseMarker
  inline def error(inline marker: Marker, inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.errorMessageCauseMarker('underlying, 'marker, 'message, 'cause)}

  def error(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro2.errorMessageArgsMarker
  inline def error(inline marker: Marker, inline message: String, inline args: Any*): Unit = ${LoggerMacro3.errorMessageArgsMarker('underlying, 'marker, 'message, 'args)}

  def whenErrorEnabled(body: Unit): Unit = macro LoggerMacro2.errorCode
  inline def whenErrorEnabled(inline body: Unit): Unit = ${LoggerMacro3.errorCode('underlying, 'body)}

  // Warn

  def warn(message: String): Unit = macro LoggerMacro2.warnMessage
  inline def warn(inline message: String): Unit = ${LoggerMacro3.warnMessage('underlying, 'message)}

  def warn(message: String, cause: Throwable): Unit = macro LoggerMacro2.warnMessageCause
  inline def warn(inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.warnMessageCause('underlying, 'message, 'cause)}

  def warn(message: String, args: Any*): Unit = macro LoggerMacro2.warnMessageArgs
  inline def warn(inline message: String, inline args: Any*): Unit = ${LoggerMacro3.warnMessageArgs('underlying, 'message, 'args)}

  def warn(marker: Marker, message: String): Unit = macro LoggerMacro2.warnMessageMarker
  inline def warn(inline marker: Marker, inline message: String): Unit = ${LoggerMacro3.warnMessageMarker('underlying, 'marker, 'message)}

  def warn(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro2.warnMessageCauseMarker
  inline def warn(inline marker: Marker, inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.warnMessageCauseMarker('underlying, 'marker, 'message, 'cause)}

  def warn(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro2.warnMessageArgsMarker
  inline def warn(inline marker: Marker, inline message: String, inline args: Any*): Unit = ${LoggerMacro3.warnMessageArgsMarker('underlying, 'marker, 'message, 'args)}

  def whenWarnEnabled(body: Unit): Unit = macro LoggerMacro2.warnCode
  inline def whenWarnEnabled(inline body: Unit): Unit = ${LoggerMacro3.warnCode('underlying, 'body)}

  // Info

  def info(message: String): Unit = macro LoggerMacro2.infoMessage
  inline def info(inline message: String): Unit = ${LoggerMacro3.infoMessage('underlying, 'message)}
  
  def info(message: String, cause: Throwable): Unit = macro LoggerMacro2.infoMessageCause
  inline def info(inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.infoMessageCause('underlying, 'message, 'cause)}

  def info(message: String, args: Any*): Unit = macro LoggerMacro2.infoMessageArgs
  inline def info(inline message: String, inline args: Any*): Unit = ${LoggerMacro3.infoMessageArgs('underlying, 'message, 'args)}

  def info(marker: Marker, message: String): Unit = macro LoggerMacro2.infoMessageMarker
  inline def info(inline marker: Marker, inline message: String): Unit = ${LoggerMacro3.infoMessageMarker('underlying, 'marker, 'message)}

  def info(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro2.infoMessageCauseMarker
  inline def info(inline marker: Marker, inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.infoMessageCauseMarker('underlying, 'marker, 'message, 'cause)}

  def info(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro2.infoMessageArgsMarker
  inline def info(inline marker: Marker, inline message: String, inline args: Any*): Unit = ${LoggerMacro3.infoMessageArgsMarker('underlying, 'marker, 'message, 'args)}

  def whenInfoEnabled(body: Unit): Unit = macro LoggerMacro2.infoCode
  inline def whenInfoEnabled(inline body: Unit): Unit = ${LoggerMacro3.infoCode('underlying, 'body)}

  // Debug

  def debug(message: String): Unit = macro LoggerMacro2.debugMessage
  inline def debug(inline message: String): Unit = ${LoggerMacro3.debugMessage('underlying, 'message)}

  def debug(message: String, cause: Throwable): Unit = macro LoggerMacro2.debugMessageCause
  inline def debug(inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.debugMessageCause('underlying, 'message, 'cause)}

  def debug(message: String, args: Any*): Unit = macro LoggerMacro2.debugMessageArgs
  inline def debug(inline message: String, inline args: Any*): Unit = ${LoggerMacro3.debugMessageArgs('underlying, 'message, 'args)}

  def debug(marker: Marker, message: String): Unit = macro LoggerMacro2.debugMessageMarker
  inline def debug(inline marker: Marker, inline message: String): Unit = ${LoggerMacro3.debugMessageMarker('underlying, 'marker, 'message)}

  def debug(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro2.debugMessageCauseMarker
  inline def debug(inline marker: Marker, inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.debugMessageCauseMarker('underlying, 'marker, 'message, 'cause)}

  def debug(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro2.debugMessageArgsMarker
  inline def debug(inline marker: Marker, inline message: String, inline args: Any*): Unit = ${LoggerMacro3.debugMessageArgsMarker('underlying, 'marker, 'message, 'args)}

  def whenDebugEnabled(body: Unit): Unit = macro LoggerMacro2.debugCode
  inline def whenDebugEnabled(inline body: Unit): Unit = ${LoggerMacro3.debugCode('underlying, 'body)}

  // Trace

  def trace(message: String): Unit = macro LoggerMacro2.traceMessage
  inline def trace(inline message: String): Unit = ${LoggerMacro3.traceMessage('underlying, 'message)}

  def trace(message: String, cause: Throwable): Unit = macro LoggerMacro2.traceMessageCause
  inline def trace(inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.traceMessageCause('underlying, 'message, 'cause)}

  def trace(message: String, args: Any*): Unit = macro LoggerMacro2.traceMessageArgs
  inline def trace(inline message: String, inline args: Any*): Unit = ${LoggerMacro3.traceMessageArgs('underlying, 'message, 'args)}

  def trace(marker: Marker, message: String): Unit = macro LoggerMacro2.traceMessageMarker
  inline def trace(inline marker: Marker, inline message: String): Unit = ${LoggerMacro3.traceMessageMarker('underlying, 'marker, 'message)}

  def trace(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro2.traceMessageCauseMarker
  inline def trace(inline marker: Marker, inline message: String, inline cause: Throwable): Unit = ${LoggerMacro3.traceMessageCauseMarker('underlying, 'marker, 'message, 'cause)}

  def trace(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro2.traceMessageArgsMarker
  inline def trace(inline marker: Marker, inline message: String, inline args: Any*): Unit = ${LoggerMacro3.traceMessageArgsMarker('underlying, 'marker, 'message, 'args)}

  def whenTraceEnabled(body: Unit): Unit = macro LoggerMacro2.traceCode
  inline def whenTraceEnabled(inline body: Unit): Unit = ${LoggerMacro3.traceCode('underlying, 'body)}
}