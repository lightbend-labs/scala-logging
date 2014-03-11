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
package slf4j

import org.mockito.Matchers._
import org.mockito.Mockito._
import org.scalatest.{ ShouldMatchers, WordSpec }
import org.scalatest.mock.MockitoSugar

class LoggerSpec extends WordSpec with ShouldMatchers with MockitoSugar {

  "Calling error with a message" should {
    "call the underlying logger's error method if the error level is enabled" in {
      val underlying = mock[org.slf4j.Logger]
      val logger = new Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(true)
      val message = "error"
      logger.error(message)
      verify(underlying).error(message)
    }
    "not call the underlying logger's error method if the error level is not enabled" in {
      val underlying = mock[org.slf4j.Logger]
      val logger = new Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(false)
      logger.error("error")
      verify(underlying, never).error(anyString)
    }
  }

  "Calling error with a message and cause" should {
    "call the underlying logger's error method if the error level is enabled" in {
      val underlying = mock[org.slf4j.Logger]
      val logger = new Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(true)
      val message = "error"
      val cause = new RuntimeException("cause")
      logger.error(message, cause)
      verify(underlying).error(message, cause)
    }
    "not call the underlying logger's error method if the error level is not enabled" in {
      val underlying = mock[org.slf4j.Logger]
      val logger = new Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(false)
      logger.error("error", new RuntimeException("cause"))
      verify(underlying, never).error(anyString, anyObject)
    }
  }

  "Calling error with a message and parameters" should {
    "call the underlying logger's error method if the error level is enabled" in {
      val underlying = mock[org.slf4j.Logger]
      val logger = new Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(true)
      val message = "error"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.error(message, arg1)
      LoggerSpecSupport.verifyError(underlying, message, arg1)
      logger.error(message, arg1, arg2)
      LoggerSpecSupport.verifyError(underlying, message, arg1, arg2)
      logger.error(message, arg1, arg2b)
      LoggerSpecSupport.verifyError(underlying, message, arg1, arg2b)
      logger.error(message, arg1, arg2b, arg3)
      verify(underlying).error(message, arg1, arg2b, arg3)
    }
    "not call the underlying logger's error method if the error level is not enabled" in {
      val underlying = mock[org.slf4j.Logger]
      val logger = new Logger(underlying)
      when(underlying.isErrorEnabled).thenReturn(false)
      val message = "error"
      val arg1 = "arg1"
      val arg2 = "arg2"
      val arg2b = new Integer(1)
      val arg3 = "arg3"
      logger.error(message, arg1)
      LoggerSpecSupport.verifyNeverError(underlying, message, arg1)
      logger.error(message, arg1, arg2)
      LoggerSpecSupport.verifyNeverError(underlying, message, arg1, arg2)
      logger.error(message, arg1, arg2b)
      LoggerSpecSupport.verifyNeverError(underlying, message, arg1, arg2b)
      logger.error(message, arg1, arg2b, arg3)
      verify(underlying, never).error(anyString, anyObject, anyObject, anyObject)
    }
  }
}
