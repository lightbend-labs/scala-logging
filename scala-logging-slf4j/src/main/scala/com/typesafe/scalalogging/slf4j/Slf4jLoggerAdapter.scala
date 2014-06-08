package com.typesafe.scalalogging.slf4j

/**
 * Adapter for SLF4J framework.
 * @param underlying SLF4J logger
 */
private class Slf4jLoggerAdapter(underlying: org.slf4j.Logger) extends com.typesafe.scalalogging.LoggerAdapter {

  // Error

  def isErrorEnabled: Boolean = underlying.isErrorEnabled

  def error(message: String): Unit = underlying.error(message)

  def error(message: String, arg0: AnyRef): Unit = underlying.error(message, arg0)

  def error(message: String, arg0: AnyRef, arg1: AnyRef): Unit = underlying.error(message, arg0, arg1: Any)

  def error(message: String, args: Seq[AnyRef]): Unit = underlying.error(message, args: _*)

  def error(message: String, cause: Throwable): Unit = underlying.error(message, cause)

  // Warn

  def isWarnEnabled: Boolean = underlying.isWarnEnabled

  def warn(message: String): Unit = underlying.warn(message)

  def warn(message: String, arg0: AnyRef): Unit = underlying.warn(message, arg0)

  def warn(message: String, arg0: AnyRef, arg1: AnyRef): Unit = underlying.warn(message, arg0, arg1: Any)

  def warn(message: String, args: Seq[AnyRef]): Unit = underlying.warn(message, args: _*)

  def warn(message: String, cause: Throwable): Unit = underlying.warn(message, cause)

  // Info

  def isInfoEnabled: Boolean = underlying.isInfoEnabled

  def info(message: String): Unit = underlying.info(message)

  def info(message: String, arg0: AnyRef): Unit = underlying.info(message, arg0)

  def info(message: String, arg0: AnyRef, arg1: AnyRef): Unit = underlying.info(message, arg0, arg1: Any)

  def info(message: String, args: Seq[AnyRef]): Unit = underlying.info(message, args: _*)

  def info(message: String, cause: Throwable): Unit = underlying.info(message, cause)

  // Debug

  def isDebugEnabled: Boolean = underlying.isDebugEnabled

  def debug(message: String): Unit = underlying.debug(message)

  def debug(message: String, arg0: AnyRef): Unit = underlying.debug(message, arg0)

  def debug(message: String, arg0: AnyRef, arg1: AnyRef): Unit = underlying.debug(message, arg0, arg1: Any)

  def debug(message: String, args: Seq[AnyRef]): Unit = underlying.debug(message, args: _*)

  def debug(message: String, cause: Throwable): Unit = underlying.debug(message, cause)

  // Trace

  def isTraceEnabled: Boolean = underlying.isTraceEnabled

  def trace(message: String): Unit = underlying.trace(message)

  def trace(message: String, arg0: AnyRef): Unit = underlying.trace(message, arg0)

  def trace(message: String, arg0: AnyRef, arg1: AnyRef): Unit = underlying.trace(message, arg0, arg1: Any)

  def trace(message: String, args: Seq[AnyRef]): Unit = underlying.trace(message, args: _*)

  def trace(message: String, cause: Throwable): Unit = underlying.trace(message, cause)

}
