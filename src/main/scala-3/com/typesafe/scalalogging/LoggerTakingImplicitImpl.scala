package com.typesafe.scalalogging

import org.slf4j.{Marker, Logger as Underlying }

trait LoggerTakingImplicitImpl[A] {
  def underlying: Underlying
  implicit val canLogEv: CanLog[A]


  // Error

  inline def error(inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.errorMessage('underlying, 'canLogEv, 'message)('a)}

  inline def error(inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.errorMessageCause('underlying, 'canLogEv, 'message, 'cause)('a)}

  inline def error(inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.errorMessageArgs('underlying, 'canLogEv, 'message, 'args)('a)}

  inline def error(inline marker: Marker, inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.errorMessageMarker('underlying, 'canLogEv, 'marker, 'message)('a)}

  inline def error(inline marker: Marker, inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.errorMessageCauseMarker('underlying, 'canLogEv, 'marker, 'message, 'cause)('a)}

  inline def error(inline marker: Marker, inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.errorMessageArgsMarker('underlying, 'canLogEv, 'marker,'message, 'args)('a)}

  inline def whenErrorEnabled(inline body: Unit)(implicit inline a: A): Unit = ${LoggerTakingImplicitMacro.errorCode('underlying, 'canLogEv, 'body)('a)}

  // Warn

  inline def warn(inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.warnMessage('underlying, 'canLogEv, 'message)('a)}

  inline def warn(inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.warnMessageCause('underlying, 'canLogEv, 'message, 'cause)('a)}

  inline def warn(inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.warnMessageArgs('underlying, 'canLogEv, 'message, 'args)('a)}

  inline def warn(inline marker: Marker, inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.warnMessageMarker('underlying, 'canLogEv, 'marker, 'message)('a)}

  inline def warn(inline marker: Marker, inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.warnMessageCauseMarker('underlying, 'canLogEv, 'marker, 'message, 'cause)('a)}

  inline def warn(inline marker: Marker, inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.warnMessageArgsMarker('underlying, 'canLogEv, 'marker,'message, 'args)('a)}

  inline def whenWarnEnabled(inline body: Unit)(implicit inline a: A): Unit = ${LoggerTakingImplicitMacro.warnCode('underlying, 'canLogEv, 'body)('a)}



  // Info

  inline def info(inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.infoMessage('underlying, 'canLogEv, 'message)('a)}

  inline def info(inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.infoMessageCause('underlying, 'canLogEv, 'message, 'cause)('a)}

  inline def info(inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.infoMessageArgs('underlying, 'canLogEv, 'message, 'args)('a)}

  inline def info(inline marker: Marker, inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.infoMessageMarker('underlying, 'canLogEv, 'marker, 'message)('a)}

  inline def info(inline marker: Marker, inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.infoMessageCauseMarker('underlying, 'canLogEv, 'marker, 'message, 'cause)('a)}

  inline def info(inline marker: Marker, inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.infoMessageArgsMarker('underlying, 'canLogEv, 'marker,'message, 'args)('a)}

  inline def whenInfoEnabled(inline body: Unit)(implicit inline a: A): Unit = ${LoggerTakingImplicitMacro.infoCode('underlying, 'canLogEv, 'body)('a)}


  // Debug

  inline def debug(inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.debugMessage('underlying, 'canLogEv, 'message)('a)}

  inline def debug(inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.debugMessageCause('underlying, 'canLogEv, 'message, 'cause)('a)}

  inline def debug(inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.debugMessageArgs('underlying, 'canLogEv, 'message, 'args)('a)}

  inline def debug(inline marker: Marker, inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.debugMessageMarker('underlying, 'canLogEv, 'marker, 'message)('a)}

  inline def debug(inline marker: Marker, inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.debugMessageCauseMarker('underlying, 'canLogEv, 'marker, 'message, 'cause)('a)}

  inline def debug(inline marker: Marker, inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.debugMessageArgsMarker('underlying, 'canLogEv, 'marker,'message, 'args)('a)}

  inline def whenDebugEnabled(inline body: Unit)(implicit inline a: A): Unit = ${LoggerTakingImplicitMacro.debugCode('underlying, 'canLogEv, 'body)('a)}

  // Trace

  inline def trace(inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.traceMessage('underlying, 'canLogEv, 'message)('a)}

  inline def trace(inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.traceMessageCause('underlying, 'canLogEv, 'message, 'cause)('a)}

  inline def trace(inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.traceMessageArgs('underlying, 'canLogEv, 'message, 'args)('a)}

  inline def trace(inline marker: Marker, inline message: String)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.traceMessageMarker('underlying, 'canLogEv, 'marker, 'message)('a)}

  inline def trace(inline marker: Marker, inline message: String, inline cause: Throwable)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.traceMessageCauseMarker('underlying, 'canLogEv, 'marker, 'message, 'cause)('a)}

  inline def trace(inline marker: Marker, inline message: String, inline args: Any*)(implicit inline a: A): Unit =
    ${LoggerTakingImplicitMacro.traceMessageArgsMarker('underlying, 'canLogEv, 'marker,'message, 'args)('a)}

  inline def whenTraceEnabled(inline body: Unit)(implicit inline a: A): Unit = ${LoggerTakingImplicitMacro.traceCode('underlying, 'canLogEv, 'body)('a)}
}
