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

import org.mockito.Mockito._
import org.scalatest.{ ShouldMatchers, WordSpec }
import org.scalatest.mock.MockitoSugar
import org.slf4j.ILoggerFactory
import org.slf4j.impl.StaticLoggerBinder

class LoggingSpec extends WordSpec with ShouldMatchers with MockitoSugar {
  private def registerLogger(logger: org.slf4j.Logger): Unit = {
    StaticLoggerBinder.getSingleton.setLoggerFactory(
      new ILoggerFactory {
        override def getLogger(name: String): org.slf4j.Logger = logger
      })
  }

  "Mixed LazyLogging trait" should {
    "overwrite methods in Logging trait" in {
      val underlying = mock[org.slf4j.Logger]
      when(underlying.isDebugEnabled).thenReturn(true)
      registerLogger(underlying)
      trait Test {
        self: Logging =>
        def test(): Unit = logger.debug("test")
      }
      object Test extends Test with LazyLogging
      Test.test()
      verify(underlying).debug("test")
    }
  }

  "Mixed StrictLogging trait" should {
    "overwrite methods in Logging trait" in {
      val underlying = mock[org.slf4j.Logger]
      when(underlying.isDebugEnabled).thenReturn(true)
      registerLogger(underlying)
      trait Test {
        self: Logging =>
        def test(): Unit = logger.debug("test")
      }
      object Test extends Test with StrictLogging
      Test.test()
      verify(underlying).debug("test")
    }
  }
}
