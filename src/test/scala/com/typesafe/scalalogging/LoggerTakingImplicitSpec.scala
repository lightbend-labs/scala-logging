package com.typesafe.scalalogging

import org.mockito.scalatest.IdiomaticMockito
import org.scalatest.{ Matchers, WordSpec }
import org.slf4j.{ Logger => Underlying }

class LoggerTakingImplicitSpec
  extends WordSpec
  with Matchers
  with IdiomaticMockito
  with Varargs {

  case class CorrelationId(value: String)

  // Error

  "Calling error with a message" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(msg)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.error(logMsg) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled returns false)
      import f._
      logger.error(msg)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.error(*) wasNever called
    }
  }

  "Calling error with a message and cause" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(msg, cause)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.error(logMsg, cause) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled returns false)
      import f._
      logger.error(msg, cause)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.error(*, any[Object]) wasNever called
    }
  }

  "Calling error with a message and parameters" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(msg, arg1)
      underlying.error(logMsg, arg1) was called
      logger.error(msg, arg1, arg2)
      underlying.error(logMsg, forceVarargs(arg1, arg2): _*) was called
      logger.error(msg, arg1, arg2, arg3)
      underlying.error(logMsg, arg1, arg2, arg3) was called
      canLogCorrelationId.logMessage(msg, correlationId) wasCalled threeTimes
      canLogCorrelationId.afterLog(correlationId) wasCalled threeTimes
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled returns false)
      import f._
      logger.error(msg, arg1)
      underlying.error(logMsg, arg1) wasNever called
      logger.error(msg, arg1, arg2)
      underlying.error(logMsg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.error(msg, arg1, arg2, arg3)
      underlying.error(logMsg, arg1, arg2, arg3) wasNever called
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
    }
  }

  // Warn

  "Calling warn with a message" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(msg)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.warn(logMsg) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled returns false)
      import f._
      logger.warn(msg)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.warn(*) wasNever called
    }
  }

  "Calling warn with a message and cause" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(msg, cause)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.warn(logMsg, cause) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled returns false)
      import f._
      logger.warn(msg, cause)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.warn(*, any[Object]) wasNever called
    }
  }

  "Calling warn with a message and parameters" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(msg, arg1)
      underlying.warn(logMsg, arg1) was called
      logger.warn(msg, arg1, arg2)
      underlying.warn(logMsg, forceVarargs(arg1, arg2): _*) was called
      logger.warn(msg, arg1, arg2, arg3)
      underlying.warn(logMsg, arg1, arg2, arg3) was called
      canLogCorrelationId.logMessage(msg, correlationId) wasCalled threeTimes
      canLogCorrelationId.afterLog(correlationId) wasCalled threeTimes
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled returns false)
      import f._
      logger.warn(msg, arg1)
      underlying.warn(logMsg, arg1) wasNever called
      logger.warn(msg, arg1, arg2)
      underlying.warn(logMsg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.warn(msg, arg1, arg2, arg3)
      underlying.warn(logMsg, arg1, arg2, arg3) wasNever called
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
    }
  }

  // Info

  "Calling info with a message" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(msg)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.info(logMsg) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled returns false)
      import f._
      logger.info(msg)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.info(*) wasNever called
    }
  }

  "Calling info with a message and cause" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(msg, cause)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.info(logMsg, cause) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled returns false)
      import f._
      logger.info(msg, cause)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.info(*, any[Object]) wasNever called
    }
  }

  "Calling info with a message and parameters" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(msg, arg1)
      underlying.info(logMsg, arg1) was called
      logger.info(msg, arg1, arg2)
      underlying.info(logMsg, forceVarargs(arg1, arg2): _*) was called
      logger.info(msg, arg1, arg2, arg3)
      underlying.info(logMsg, arg1, arg2, arg3) was called
      canLogCorrelationId.logMessage(msg, correlationId) wasCalled threeTimes
      canLogCorrelationId.afterLog(correlationId) wasCalled threeTimes
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled returns false)
      import f._
      logger.info(msg, arg1)
      underlying.info(logMsg, arg1) wasNever called
      logger.info(msg, arg1, arg2)
      underlying.info(logMsg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.info(msg, arg1, arg2, arg3)
      underlying.info(logMsg, arg1, arg2, arg3) wasNever called
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
    }
  }

  // Debug

  "Calling debug with a message" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(msg)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.debug(logMsg) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled returns false)
      import f._
      logger.debug(msg)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.debug(*) wasNever called
    }
  }

  "Calling debug with a message and cause" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(msg, cause)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.debug(logMsg, cause) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled returns false)
      import f._
      logger.debug(msg, cause)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.debug(*, any[Object]) wasNever called
    }
  }

  "Calling debug with a message and parameters" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(msg, arg1)
      underlying.debug(logMsg, arg1) was called
      logger.debug(msg, arg1, arg2)
      underlying.debug(logMsg, forceVarargs(arg1, arg2): _*) was called
      logger.debug(msg, arg1, arg2, arg3)
      underlying.debug(logMsg, arg1, arg2, arg3) was called
      canLogCorrelationId.logMessage(msg, correlationId) wasCalled threeTimes
      canLogCorrelationId.afterLog(correlationId) wasCalled threeTimes
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled returns false)
      import f._
      logger.debug(msg, arg1)
      underlying.debug(logMsg, arg1) wasNever called
      logger.debug(msg, arg1, arg2)
      underlying.debug(logMsg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.debug(msg, arg1, arg2, arg3)
      underlying.debug(logMsg, arg1, arg2, arg3) wasNever called
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
    }
  }

  // Trace

  "Calling trace with a message" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(msg)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.trace(logMsg) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled returns false)
      import f._
      logger.trace(msg)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.trace(*) wasNever called
    }
  }

  "Calling trace with a message and cause" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(msg, cause)
      canLogCorrelationId.logMessage(msg, correlationId) was called
      canLogCorrelationId.afterLog(correlationId) was called
      underlying.trace(logMsg, cause) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled returns false)
      import f._
      logger.trace(msg, cause)
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
      underlying.trace(*, any[Object]) wasNever called
    }
  }

  "Calling trace with a message and parameters" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(msg, arg1)
      underlying.trace(logMsg, arg1) was called
      logger.trace(msg, arg1, arg2)
      underlying.trace(logMsg, forceVarargs(arg1, arg2): _*) was called
      logger.trace(msg, arg1, arg2, arg3)
      underlying.trace(logMsg, arg1, arg2, arg3) was called
      canLogCorrelationId.logMessage(msg, correlationId) wasCalled threeTimes
      canLogCorrelationId.afterLog(correlationId) wasCalled threeTimes
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled returns false)
      import f._
      logger.trace(msg, arg1)
      underlying.trace(logMsg, arg1) wasNever called
      logger.trace(msg, arg1, arg2)
      underlying.trace(logMsg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.trace(msg, arg1, arg2, arg3)
      underlying.trace(logMsg, arg1, arg2, arg3) wasNever called
      canLogCorrelationId.logMessage(*, *) wasNever called
      canLogCorrelationId.afterLog(*) wasNever called
    }
  }

  def fixture(p: Underlying => Unit) =
    new {
      implicit val correlationId = CorrelationId("corrId")
      implicit val canLogCorrelationId =
        mock[CanLog[CorrelationId]](withSettings.lenient())
      val msg = "msg"
      val cause = new RuntimeException("cause")
      val arg1 = "arg1"
      val arg2 = new Integer(1)
      val arg3 = "arg3"
      val logMsg = "corrId - msg"
      val underlying = mock[org.slf4j.Logger]
      p(underlying)
      canLogCorrelationId.logMessage(*, *) returns logMsg
      val logger = Logger.takingImplicit[CorrelationId](underlying)
    }
}
