package com.typesafe.scalalogging

import org.mockito.ArgumentMatchers._
import org.mockito.Mockito._
import org.slf4j.{ Logger => Underlying }
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class LoggerTakingImplicitSpec extends AnyWordSpec with Matchers with Varargs {

  case class CorrelationId(value: String)

  // Error

  "Calling error with a message" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = true)
      import f._
      logger.error(msg)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).error(logMsg)
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = false)
      import f._
      logger.error(msg)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).error(anyString)
    }
  }

  "Calling error with a message and cause" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = true)
      import f._
      logger.error(msg, cause)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).error(logMsg, cause)
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = false)
      import f._
      logger.error(msg, cause)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).error(anyString, any[Object])
    }
  }

  "Calling error with a message and parameters" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = true)
      import f._
      logger.error(msg, arg1)
      verify(underlying).error(logMsg, arg1)
      logger.error(msg, arg1, arg2)
      verify(underlying).error(logMsg, forceVarargs(arg1, arg2): _*)
      logger.error(msg, arg1, arg2, arg3)
      verify(underlying).error(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, times(3)).logMessage(msg, correlationId)
      verify(canLogCorrelationId, times(3)).afterLog(correlationId)
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = false)
      import f._
      logger.error(msg, arg1)
      verify(underlying, never).error(logMsg, arg1)
      logger.error(msg, arg1, arg2)
      verify(underlying, never).error(logMsg, forceVarargs(arg1, arg2): _*)
      logger.error(msg, arg1, arg2, arg3)
      verify(underlying, never).error(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
    }
  }

  // Warn

  "Calling warn with a message" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = true)
      import f._
      logger.warn(msg)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).warn(logMsg)
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = false)
      import f._
      logger.warn(msg)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).warn(anyString)
    }
  }

  "Calling warn with a message and cause" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = true)
      import f._
      logger.warn(msg, cause)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).warn(logMsg, cause)
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = false)
      import f._
      logger.warn(msg, cause)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).warn(anyString, any[Object])
    }
  }

  "Calling warn with a message and parameters" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = true)
      import f._
      logger.warn(msg, arg1)
      verify(underlying).warn(logMsg, arg1)
      logger.warn(msg, arg1, arg2)
      verify(underlying).warn(logMsg, forceVarargs(arg1, arg2): _*)
      logger.warn(msg, arg1, arg2, arg3)
      verify(underlying).warn(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, times(3)).logMessage(msg, correlationId)
      verify(canLogCorrelationId, times(3)).afterLog(correlationId)
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = false)
      import f._
      logger.warn(msg, arg1)
      verify(underlying, never).warn(logMsg, arg1)
      logger.warn(msg, arg1, arg2)
      verify(underlying, never).warn(logMsg, forceVarargs(arg1, arg2): _*)
      logger.warn(msg, arg1, arg2, arg3)
      verify(underlying, never).warn(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
    }
  }

  // Info

  "Calling info with a message" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info(msg)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).info(logMsg)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = false)
      import f._
      logger.info(msg)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).info(anyString)
    }
  }

  "Calling info with a message and cause" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info(msg, cause)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).info(logMsg, cause)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = false)
      import f._
      logger.info(msg, cause)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).info(anyString, any[Object])
    }
  }

  "Calling info with a message and parameters" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info(msg, arg1)
      verify(underlying).info(logMsg, arg1)
      logger.info(msg, arg1, arg2)
      verify(underlying).info(logMsg, forceVarargs(arg1, arg2): _*)
      logger.info(msg, arg1, arg2, arg3)
      verify(underlying).info(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, times(3)).logMessage(msg, correlationId)
      verify(canLogCorrelationId, times(3)).afterLog(correlationId)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = false)
      import f._
      logger.info(msg, arg1)
      verify(underlying, never).info(logMsg, arg1)
      logger.info(msg, arg1, arg2)
      verify(underlying, never).info(logMsg, forceVarargs(arg1, arg2): _*)
      logger.info(msg, arg1, arg2, arg3)
      verify(underlying, never).info(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
    }
  }

  // Debug

  "Calling debug with a message" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = true)
      import f._
      logger.debug(msg)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).debug(logMsg)
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = false)
      import f._
      logger.debug(msg)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).debug(anyString)
    }
  }

  "Calling debug with a message and cause" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = true)
      import f._
      logger.debug(msg, cause)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).debug(logMsg, cause)
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = false)
      import f._
      logger.debug(msg, cause)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).debug(anyString, any[Object])
    }
  }

  "Calling debug with a message and parameters" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = true)
      import f._
      logger.debug(msg, arg1)
      verify(underlying).debug(logMsg, arg1)
      logger.debug(msg, arg1, arg2)
      verify(underlying).debug(logMsg, forceVarargs(arg1, arg2): _*)
      logger.debug(msg, arg1, arg2, arg3)
      verify(underlying).debug(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, times(3)).logMessage(msg, correlationId)
      verify(canLogCorrelationId, times(3)).afterLog(correlationId)
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = false)
      import f._
      logger.debug(msg, arg1)
      verify(underlying, never).debug(logMsg, arg1)
      logger.debug(msg, arg1, arg2)
      verify(underlying, never).debug(logMsg, forceVarargs(arg1, arg2): _*)
      logger.debug(msg, arg1, arg2, arg3)
      verify(underlying, never).debug(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
    }
  }

  // Trace

  "Calling trace with a message" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = true)
      import f._
      logger.trace(msg)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).trace(logMsg)
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = false)
      import f._
      logger.trace(msg)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).trace(anyString)
    }
  }

  "Calling trace with a message and cause" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = true)
      import f._
      logger.trace(msg, cause)
      verify(canLogCorrelationId).logMessage(msg, correlationId)
      verify(canLogCorrelationId).afterLog(correlationId)
      verify(underlying).trace(logMsg, cause)
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = false)
      import f._
      logger.trace(msg, cause)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
      verify(underlying, never).trace(anyString, any[Object])
    }
  }

  "Calling trace with a message and parameters" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = true)
      import f._
      logger.trace(msg, arg1)
      verify(underlying).trace(logMsg, arg1)
      logger.trace(msg, arg1, arg2)
      verify(underlying).trace(logMsg, forceVarargs(arg1, arg2): _*)
      logger.trace(msg, arg1, arg2, arg3)
      verify(underlying).trace(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, times(3)).logMessage(msg, correlationId)
      verify(canLogCorrelationId, times(3)).afterLog(correlationId)
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = false)
      import f._
      logger.trace(msg, arg1)
      verify(underlying, never).trace(logMsg, arg1)
      logger.trace(msg, arg1, arg2)
      verify(underlying, never).trace(logMsg, forceVarargs(arg1, arg2): _*)
      logger.trace(msg, arg1, arg2, arg3)
      verify(underlying, never).trace(logMsg, arg1, arg2, arg3)
      verify(canLogCorrelationId, never).logMessage(anyString, any[CorrelationId])
      verify(canLogCorrelationId, never).afterLog(any[CorrelationId])
    }
  }

  def fixture(p: Underlying => Boolean, isEnabled: Boolean) =
    new {
      implicit val correlationId = CorrelationId("corrId")
      implicit val canLogCorrelationId = mock(classOf[CanLog[CorrelationId]])
      val msg = "msg"
      val cause = new RuntimeException("cause")
      val arg1 = "arg1"
      val arg2 = Integer.valueOf(1)
      val arg3 = "arg3"
      val logMsg = "corrId - msg"
      val underlying = mock(classOf[org.slf4j.Logger])
      when(p(underlying)).thenReturn(isEnabled)
      when(canLogCorrelationId.logMessage(anyString(), any[CorrelationId])).thenReturn(logMsg)
      val logger = Logger.takingImplicit[CorrelationId](underlying)
    }
}
