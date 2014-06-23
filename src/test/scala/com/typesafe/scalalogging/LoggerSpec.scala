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

package com.typesafe.scalalogging

import org.mockito.Matchers._
import org.mockito.Mockito._
import org.slf4j.{ Logger => Underlying }
import org.scalatest.{ Matchers, WordSpec }
import org.scalatest.mock.MockitoSugar

class LoggerSpec extends WordSpec with Matchers with MockitoSugar {

  // Error

  "Calling error with a message" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, true)
      import f._
      logger.error(msg)
      verify(underlying).error(msg)
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, false)
      import f._
      logger.error(msg)
      verify(underlying, never).error(anyString)
    }
  }

  "Calling error with a message and cause" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, true)
      import f._
      logger.error(msg, cause)
      verify(underlying).error(msg, cause)
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, false)
      import f._
      logger.error(msg, cause)
      verify(underlying, never).error(anyString, anyObject)
    }
  }

  "Calling error with a message and parameters" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, true)
      import f._
      logger.error(msg, arg1)
      verify(underlying).error(msg, List(arg1): _*)
      logger.error(msg, arg1, arg2)
      verify(underlying).error(msg, List(arg1, arg2): _*)
      logger.error(msg, arg1, arg2, arg3)
      verify(underlying).error(msg, arg1, arg2, arg3)
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, false)
      import f._
      logger.error(msg, arg1)
      verify(underlying, never).error(msg, List(arg1): _*)
      logger.error(msg, arg1, arg2)
      verify(underlying, never).error(msg, List(arg1, arg2): _*)
      logger.error(msg, arg1, arg2, arg3)
      verify(underlying, never).error(msg, arg1, arg2, arg3)
    }
  }

  // Warn

  "Calling warn with a message" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, true)
      import f._
      logger.warn(msg)
      verify(underlying).warn(msg)
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, false)
      import f._
      logger.warn(msg)
      verify(underlying, never).warn(anyString)
    }
  }

  "Calling warn with a message and cause" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, true)
      import f._
      logger.warn(msg, cause)
      verify(underlying).warn(msg, cause)
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, false)
      import f._
      logger.warn(msg, cause)
      verify(underlying, never).warn(anyString, anyObject)
    }
  }

  "Calling warn with a message and parameters" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, true)
      import f._
      logger.warn(msg, arg1)
      verify(underlying).warn(msg, List(arg1): _*)
      logger.warn(msg, arg1, arg2)
      verify(underlying).warn(msg, List(arg1, arg2): _*)
      logger.warn(msg, arg1, arg2, arg3)
      verify(underlying).warn(msg, arg1, arg2, arg3)
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, false)
      import f._
      logger.warn(msg, arg1)
      verify(underlying, never).warn(msg, List(arg1): _*)
      logger.warn(msg, arg1, arg2)
      verify(underlying, never).warn(msg, List(arg1, arg2): _*)
      logger.warn(msg, arg1, arg2, arg3)
      verify(underlying, never).warn(msg, arg1, arg2, arg3)
    }
  }

  // Info

  "Calling info with a message" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, true)
      import f._
      logger.info(msg)
      verify(underlying).info(msg)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, false)
      import f._
      logger.info(msg)
      verify(underlying, never).info(anyString)
    }
  }

  "Calling info with a message and cause" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, true)
      import f._
      logger.info(msg, cause)
      verify(underlying).info(msg, cause)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, false)
      import f._
      logger.info(msg, cause)
      verify(underlying, never).info(anyString, anyObject)
    }
  }

  "Calling info with a message and parameters" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, true)
      import f._
      logger.info(msg, arg1)
      verify(underlying).info(msg, List(arg1): _*)
      logger.info(msg, arg1, arg2)
      verify(underlying).info(msg, List(arg1, arg2): _*)
      logger.info(msg, arg1, arg2, arg3)
      verify(underlying).info(msg, arg1, arg2, arg3)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, false)
      import f._
      logger.info(msg, arg1)
      verify(underlying, never).info(msg, List(arg1): _*)
      logger.info(msg, arg1, arg2)
      verify(underlying, never).info(msg, List(arg1, arg2): _*)
      logger.info(msg, arg1, arg2, arg3)
      verify(underlying, never).info(msg, arg1, arg2, arg3)
    }
  }

  // Debug

  "Calling debug with a message" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, true)
      import f._
      logger.debug(msg)
      verify(underlying).debug(msg)
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, false)
      import f._
      logger.debug(msg)
      verify(underlying, never).debug(anyString)
    }
  }

  "Calling debug with a message and cause" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, true)
      import f._
      logger.debug(msg, cause)
      verify(underlying).debug(msg, cause)
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, false)
      import f._
      logger.debug(msg, cause)
      verify(underlying, never).debug(anyString, anyObject)
    }
  }

  "Calling debug with a message and parameters" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, true)
      import f._
      logger.debug(msg, arg1)
      verify(underlying).debug(msg, List(arg1): _*)
      logger.debug(msg, arg1, arg2)
      verify(underlying).debug(msg, List(arg1, arg2): _*)
      logger.debug(msg, arg1, arg2, arg3)
      verify(underlying).debug(msg, arg1, arg2, arg3)
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, false)
      import f._
      logger.debug(msg, arg1)
      verify(underlying, never).debug(msg, List(arg1): _*)
      logger.debug(msg, arg1, arg2)
      verify(underlying, never).debug(msg, List(arg1, arg2): _*)
      logger.debug(msg, arg1, arg2, arg3)
      verify(underlying, never).debug(msg, arg1, arg2, arg3)
    }
  }

  // Trace

  "Calling trace with a message" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, true)
      import f._
      logger.trace(msg)
      verify(underlying).trace(msg)
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, false)
      import f._
      logger.trace(msg)
      verify(underlying, never).trace(anyString)
    }
  }

  "Calling trace with a message and cause" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, true)
      import f._
      logger.trace(msg, cause)
      verify(underlying).trace(msg, cause)
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, false)
      import f._
      logger.trace(msg, cause)
      verify(underlying, never).trace(anyString, anyObject)
    }
  }

  "Calling trace with a message and parameters" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, true)
      import f._
      logger.trace(msg, arg1)
      verify(underlying).trace(msg, List(arg1): _*)
      logger.trace(msg, arg1, arg2)
      verify(underlying).trace(msg, List(arg1, arg2): _*)
      logger.trace(msg, arg1, arg2, arg3)
      verify(underlying).trace(msg, arg1, arg2, arg3)
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, false)
      import f._
      logger.trace(msg, arg1)
      verify(underlying, never).trace(msg, List(arg1): _*)
      logger.trace(msg, arg1, arg2)
      verify(underlying, never).trace(msg, List(arg1, arg2): _*)
      logger.trace(msg, arg1, arg2, arg3)
      verify(underlying, never).trace(msg, arg1, arg2, arg3)
    }
  }

  def fixture(p: Underlying => Boolean, isEnabled: Boolean) =
    new {
      val msg = "msg"
      val cause = new RuntimeException("cause")
      val arg1 = "arg1"
      val arg2 = new Integer(1)
      val arg3 = "arg3"
      val underlying = mock[org.slf4j.Logger]
      when(p(underlying)).thenReturn(isEnabled)
      val logger = Logger(underlying)
    }
}
