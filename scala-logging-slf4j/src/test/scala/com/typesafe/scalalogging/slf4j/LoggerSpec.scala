/*
 * Copyright 2014 Typesafe Inc. <http://www.typesafe.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.typesafe.scalalogging.slf4j

import org.slf4j.{ Logger => Underlying }
import org.mockito.ArgumentMatcher
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.scalatest.mock.MockitoSugar
import org.scalatest.{ ShouldMatchers, WordSpec }

class LoggerSpec extends WordSpec with ShouldMatchers with MockitoSugar {

  // Error

  "Calling error with a message" should {
    "call the underlying logger's error method if the error level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(true)
      val message = "error"
      logger.error(message)
      verify(underlying).error(message)
    }
    "not call the underlying logger's error method if the error level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(false)
      logger.error("error")
      verify(underlying, never).error(anyString)
    }
  }

  "Calling error with a message and cause" should {
    "call the underlying logger's error method if the error level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(true)
      val message = "error"
      val cause = new RuntimeException("cause")
      logger.error(message, cause)
      verify(underlying).error(message, cause)
    }
    "not call the underlying logger's error method if the error level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(false)
      logger.error("error", new RuntimeException("cause"))
      verify(underlying, never).error(anyString, anyObject)
    }
  }

  "Calling error with a message and parameters" should {
    "call the underlying logger's error method if the error level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(true)
      val message = "error"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.error(message, arg1)
      verify(underlying).error(message, arg1)
      logger.error(message, arg1, arg2)
      verify(underlying).error(message, arg1, arg2: Any)
      logger.error(message, arg1, arg2b)
      verify(underlying).error(message, arg1, arg2b: Any)
      logger.error(message, arg1, arg2b, arg3)
      verify(underlying).error(message, arg1, arg2b, arg3)
    }
    "not call the underlying logger's error method if the error level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(false)
      val message = "error"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.error(message, arg1)
      verify(underlying, never).error(anyString, anyObject)
      logger.error(message, arg1, arg2)
      verify(underlying, never).error(anyString, anyObject, anyObject: Any)
      logger.error(message, arg1, arg2b)
      verify(underlying, never).error(anyString, anyObject, anyObject: Any)
      logger.error(message, arg1, arg2b, arg3)
      verify(underlying, never).error(anyString, anyObject, anyObject, anyObject)
    }
  }

  // Warn

  "Calling warn with a message" should {
    "call the underlying logger's warn method if the warn level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isWarnEnabled).thenReturn(true)
      val message = "warn"
      logger.warn(message)
      verify(underlying).warn(message)
    }
    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isWarnEnabled).thenReturn(false)
      logger.warn("warn")
      verify(underlying, never).warn(anyString)
    }
  }

  "Calling warn with a message and cause" should {
    "call the underlying logger's warn method if the warn level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isWarnEnabled).thenReturn(true)
      val message = "warn"
      val cause = new RuntimeException("cause")
      logger.warn(message, cause)
      verify(underlying).warn(message, cause)
    }
    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isWarnEnabled).thenReturn(false)
      logger.warn("warn", new RuntimeException("cause"))
      verify(underlying, never).warn(anyString, anyObject)
    }
  }

  "Calling warn with a message and parameters" should {
    "call the underlying logger's warn method if the warn level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isWarnEnabled).thenReturn(true)
      val message = "warn"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.warn(message, arg1)
      verify(underlying).warn(message, arg1)
      logger.warn(message, arg1, arg2)
      verify(underlying).warn(message, arg1, arg2: Any)
      logger.warn(message, arg1, arg2b)
      verify(underlying).warn(message, arg1, arg2b: Any)
      logger.warn(message, arg1, arg2b, arg3)
      verify(underlying).warn(message, arg1, arg2b, arg3)
    }
    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isWarnEnabled).thenReturn(false)
      val message = "warn"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.warn(message, arg1)
      verify(underlying, never).warn(anyString, anyObject)
      logger.warn(message, arg1, arg2)
      verify(underlying, never).warn(anyString, anyObject, anyObject: Any)
      logger.warn(message, arg1, arg2b)
      verify(underlying, never).warn(anyString, anyObject, anyObject: Any)
      logger.warn(message, arg1, arg2b, arg3)
      verify(underlying, never).warn(anyString, anyObject, anyObject, anyObject)
    }
  }

  // Info

  "Calling info with a message" should {
    "call the underlying logger's info method if the info level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isInfoEnabled).thenReturn(true)
      val message = "info"
      logger.info(message)
      verify(underlying).info(message)
    }
    "not call the underlying logger's info method if the info level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isInfoEnabled).thenReturn(false)
      logger.info("info")
      verify(underlying, never).info(anyString)
    }
  }

  "Calling info with a message and cause" should {
    "call the underlying logger's info method if the info level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isInfoEnabled).thenReturn(true)
      val message = "info"
      val cause = new RuntimeException("cause")
      logger.info(message, cause)
      verify(underlying).info(message, cause)
    }
    "not call the underlying logger's info method if the info level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isInfoEnabled).thenReturn(false)
      logger.info("info", new RuntimeException("cause"))
      verify(underlying, never).info(anyString, anyObject)
    }
  }

  "Calling info with a message and parameters" should {
    "call the underlying logger's info method if the info level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isInfoEnabled).thenReturn(true)
      val message = "info"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.info(message, arg1)
      verify(underlying).info(message, arg1)
      logger.info(message, arg1, arg2)
      verify(underlying).info(message, arg1, arg2: Any)
      logger.info(message, arg1, arg2b)
      verify(underlying).info(message, arg1, arg2b: Any)
      logger.info(message, arg1, arg2b, arg3)
      verify(underlying).info(message, arg1, arg2b, arg3)
    }
    "not call the underlying logger's info method if the info level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isInfoEnabled).thenReturn(false)
      val message = "info"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.info(message, arg1)
      verify(underlying, never).info(anyString, anyObject)
      logger.info(message, arg1, arg2)
      verify(underlying, never).info(anyString, anyObject, anyObject: Any)
      logger.info(message, arg1, arg2b)
      verify(underlying, never).info(anyString, anyObject, anyObject: Any)
      logger.info(message, arg1, arg2b, arg3)
      verify(underlying, never).info(anyString, anyObject, anyObject, anyObject)
    }
  }

  // Debug

  "Calling debug with a message" should {
    "call the underlying logger's debug method if the debug level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isDebugEnabled).thenReturn(true)
      val message = "debug"
      logger.debug(message)
      verify(underlying).debug(message)
    }
    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isDebugEnabled).thenReturn(false)
      logger.debug("debug")
      verify(underlying, never).debug(anyString)
    }
  }

  "Calling debug with a message and cause" should {
    "call the underlying logger's debug method if the debug level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isDebugEnabled).thenReturn(true)
      val message = "debug"
      val cause = new RuntimeException("cause")
      logger.debug(message, cause)
      verify(underlying).debug(message, cause)
    }
    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isDebugEnabled).thenReturn(false)
      logger.debug("debug", new RuntimeException("cause"))
      verify(underlying, never).debug(anyString, anyObject)
    }
  }

  "Calling debug with a message and parameters" should {
    "call the underlying logger's debug method if the debug level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isDebugEnabled).thenReturn(true)
      val message = "debug"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.debug(message, arg1)
      verify(underlying).debug(message, arg1)
      logger.debug(message, arg1, arg2)
      verify(underlying).debug(message, arg1, arg2: Any)
      logger.debug(message, arg1, arg2b)
      verify(underlying).debug(message, arg1, arg2b: Any)
      logger.debug(message, arg1, arg2b, arg3)
      verify(underlying).debug(message, arg1, arg2b, arg3)
    }
    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isDebugEnabled).thenReturn(false)
      val message = "debug"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.debug(message, arg1)
      verify(underlying, never).debug(anyString, anyObject)
      logger.debug(message, arg1, arg2)
      verify(underlying, never).debug(anyString, anyObject, anyObject: Any)
      logger.debug(message, arg1, arg2b)
      verify(underlying, never).debug(anyString, anyObject, anyObject: Any)
      logger.debug(message, arg1, arg2b, arg3)
      verify(underlying, never).debug(anyString, anyObject, anyObject, anyObject)
    }
  }

  // Trace

  "Calling trace with a message" should {
    "call the underlying logger's trace method if the trace level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isTraceEnabled).thenReturn(true)
      val message = "trace"
      logger.trace(message)
      verify(underlying).trace(message)
    }
    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isTraceEnabled).thenReturn(false)
      logger.trace("trace")
      verify(underlying, never).trace(anyString)
    }
  }

  "Calling trace with a message and cause" should {
    "call the underlying logger's trace method if the trace level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isTraceEnabled).thenReturn(true)
      val message = "trace"
      val cause = new RuntimeException("cause")
      logger.trace(message, cause)
      verify(underlying).trace(message, cause)
    }
    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isTraceEnabled).thenReturn(false)
      logger.trace("trace", new RuntimeException("cause"))
      verify(underlying, never).trace(anyString, anyObject)
    }
  }

  "Calling trace with a message and parameters" should {
    "call the underlying logger's trace method if the trace level is enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isTraceEnabled).thenReturn(true)
      val message = "trace"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.trace(message, arg1)
      verify(underlying).trace(message, arg1)
      logger.trace(message, arg1, arg2)
      verify(underlying).trace(message, arg1, arg2: Any)
      logger.trace(message, arg1, arg2b)
      verify(underlying).trace(message, arg1, arg2b: Any)
      logger.trace(message, arg1, arg2b, arg3)
      verify(underlying).trace(message, arg1)
    }
    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val underlying = mock[Underlying]
      val logger = Logger(underlying)
      when(underlying.isTraceEnabled).thenReturn(false)
      val message = "trace"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.trace(message, arg1)
      verify(underlying, never).trace(anyString, anyObject)
      logger.trace(message, arg1, arg2)
      verify(underlying, never).trace(anyString, anyObject, anyObject: Any)
      logger.trace(message, arg1, arg2b)
      verify(underlying, never).trace(anyString, anyObject, anyObject: Any)
      logger.trace(message, arg1, arg2b, arg3)
      verify(underlying, never).trace(anyString, anyObject, anyObject, anyObject)
    }
  }
}
