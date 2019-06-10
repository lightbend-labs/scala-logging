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

import java.util.NoSuchElementException

import org.mockito.scalatest.IdiomaticMockito
import org.scalatest.{ Matchers, WordSpec }
import org.slf4j.{ Marker, Logger => Underlying }

object DummyMarker extends Marker {
  def add(childMarker: Marker): Unit = {}
  def contains(childName: String): Boolean = false
  def contains(child: Marker): Boolean = false
  def getName: String = "DummyMarker"
  def hasChildren: Boolean = false
  def hasReferences: Boolean = false
  def iterator(): java.util.Iterator[Marker] = new java.util.Iterator[Marker] {
    def hasNext: Boolean = false
    def next(): Marker = throw new NoSuchElementException()
    override def remove(): Unit = throw new NoSuchElementException()
  }
  def remove(child: Marker): Boolean = false
}

class LoggerWithMarkerSpec
  extends WordSpec
  with Matchers
  with IdiomaticMockito
  with Varargs {

  // Error

  "Calling error with a marker and a message" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = true)
      import f._
      logger.error(marker, msg)
      underlying.error(marker, msg) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = false)
      import f._
      logger.error(marker, msg)
      underlying.error(DummyMarker, *) wasNever called
    }

    "call the underlying logger's error method if the error level is enabled and string is interpolated" in {
      val f = fixture(_.isErrorEnabled, isEnabled = true)
      import f._
      logger.error(marker, s"msg $arg1 $arg2 $arg3")
      underlying.error(marker, "msg {} {} {}", arg1, arg2, arg3) was called
    }
  }

  "Calling error with a marker and a message and cause" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = true)
      import f._
      logger.error(marker, msg, cause)
      underlying.error(marker, msg, cause) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = false)
      import f._
      logger.error(marker, msg, cause)
      underlying.error(DummyMarker, *, *) wasNever called
    }
  }

  "Calling error with a marker and a message and parameters" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = true)
      import f._
      logger.error(marker, msg, arg1)
      underlying.error(marker, msg, arg1) was called
      logger.error(marker, msg, arg1, arg2)
      underlying.error(marker, msg, forceVarargs(arg1, arg2): _*) was called
      logger.error(marker, msg, arg1, arg2, arg3)
      underlying.error(marker, msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled, isEnabled = false)
      import f._
      logger.error(marker, msg, arg1)
      underlying.error(marker, msg, arg1) wasNever called
      logger.error(marker, msg, arg1, arg2)
      underlying.error(marker, msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.error(marker, msg, arg1, arg2, arg3)
      underlying.error(marker, msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Warn

  "Calling warn with a marker and a message" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = true)
      import f._
      logger.warn(marker, msg)
      underlying.warn(marker, msg) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = false)
      import f._
      logger.warn(marker, msg)
      underlying.warn(DummyMarker, *) wasNever called
    }

    "call the underlying logger's warn method if the warn level is enabled and string is interpolated" in {
      val f = fixture(_.isWarnEnabled, isEnabled = true)
      import f._
      logger.warn(marker, s"msg $arg1 $arg2 $arg3")
      underlying.warn(marker, "msg {} {} {}", arg1, arg2, arg3) was called
    }
  }

  "Calling warn with a marker and a message and cause" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = true)
      import f._
      logger.warn(marker, msg, cause)
      underlying.warn(marker, msg, cause) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = false)
      import f._
      logger.warn(marker, msg, cause)
      underlying.warn(DummyMarker, *, *) wasNever called
    }
  }

  "Calling warn with a marker and a message and parameters" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = true)
      import f._
      logger.warn(marker, msg, arg1)
      underlying.warn(marker, msg, arg1) was called
      logger.warn(marker, msg, arg1, arg2)
      underlying.warn(marker, msg, forceVarargs(arg1, arg2): _*) was called
      logger.warn(marker, msg, arg1, arg2, arg3)
      underlying.warn(marker, msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled, isEnabled = false)
      import f._
      logger.warn(marker, msg, arg1)
      underlying.warn(marker, msg, arg1) wasNever called
      logger.warn(marker, msg, arg1, arg2)
      underlying.warn(marker, msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.warn(marker, msg, arg1, arg2, arg3)
      underlying.warn(marker, msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Info

  "Calling info with a marker and a message" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info(marker, msg)
      underlying.info(marker, msg) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = false)
      import f._
      logger.info(marker, msg)
      underlying.info(DummyMarker, *) wasNever called
    }

    "call the underlying logger's info method if the info level is enabled and string is interpolated" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info(marker, s"msg $arg1 $arg2 $arg3")
      underlying.info(marker, "msg {} {} {}", arg1, arg2, arg3) was called
    }
  }

  "Calling info with a marker and a message and cause" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info(marker, msg, cause)
      underlying.info(marker, msg, cause) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = false)
      import f._
      logger.info(marker, msg, cause)
      underlying.info(DummyMarker, *, *) wasNever called
    }
  }

  "Calling info with a marker and a message and parameters" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info(marker, msg, arg1)
      underlying.info(marker, msg, arg1) was called
      logger.info(marker, msg, arg1, arg2)
      underlying.info(marker, msg, forceVarargs(arg1, arg2): _*) was called
      logger.info(marker, msg, arg1, arg2, arg3)
      underlying.info(marker, msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, isEnabled = false)
      import f._
      logger.info(marker, msg, arg1)
      underlying.info(marker, msg, arg1) wasNever called
      logger.info(marker, msg, arg1, arg2)
      underlying.info(marker, msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.info(marker, msg, arg1, arg2, arg3)
      underlying.info(marker, msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Debug

  "Calling debug with a marker and a message" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = true)
      import f._
      logger.debug(marker, msg)
      underlying.debug(marker, msg) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = false)
      import f._
      logger.debug(marker, msg)
      underlying.debug(DummyMarker, *) wasNever called
    }

    "call the underlying logger's debug method if the debug level is enabled and string is interpolated" in {
      val f = fixture(_.isDebugEnabled, isEnabled = true)
      import f._
      logger.debug(marker, s"msg $arg1 $arg2 $arg3")
      underlying.debug(marker, "msg {} {} {}", arg1, arg2, arg3) was called
    }
  }

  "Calling debug with a marker and a message and cause" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = true)
      import f._
      logger.debug(marker, msg, cause)
      underlying.debug(marker, msg, cause) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = false)
      import f._
      logger.debug(marker, msg, cause)
      underlying.debug(DummyMarker, *, *) wasNever called
    }
  }

  "Calling debug with a marker and a message and parameters" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = true)
      import f._
      logger.debug(marker, msg, arg1)
      underlying.debug(marker, msg, arg1) was called
      logger.debug(marker, msg, arg1, arg2)
      underlying.debug(marker, msg, forceVarargs(arg1, arg2): _*) was called
      logger.debug(marker, msg, arg1, arg2, arg3)
      underlying.debug(marker, msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled, isEnabled = false)
      import f._
      logger.debug(marker, msg, arg1)
      underlying.debug(marker, msg, arg1) wasNever called
      logger.debug(marker, msg, arg1, arg2)
      underlying.debug(marker, msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.debug(marker, msg, arg1, arg2, arg3)
      underlying.debug(marker, msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Trace

  "Calling trace with a marker and a message" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = true)
      import f._
      logger.trace(marker, msg)
      underlying.trace(marker, msg) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = false)
      import f._
      logger.trace(marker, msg)
      underlying.trace(DummyMarker, *) wasNever called
    }

    "call the underlying logger's trace method if the trace level is enabled and string is interpolated" in {
      val f = fixture(_.isTraceEnabled, isEnabled = true)
      import f._
      logger.trace(marker, s"msg $arg1 $arg2 $arg3")
      underlying.trace(marker, "msg {} {} {}", arg1, arg2, arg3) was called
    }
  }

  "Calling trace with a marker and a message and cause" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = true)
      import f._
      logger.trace(marker, msg, cause)
      underlying.trace(marker, msg, cause) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = false)
      import f._
      logger.trace(marker, msg, cause)
      underlying.trace(DummyMarker, *, *) wasNever called
    }
  }

  "Calling trace with a marker and a message and parameters" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = true)
      import f._
      logger.trace(marker, msg, arg1)
      underlying.trace(marker, msg, arg1) was called
      logger.trace(marker, msg, arg1, arg2)
      underlying.trace(marker, msg, forceVarargs(arg1, arg2): _*) was called
      logger.trace(marker, msg, arg1, arg2, arg3)
      underlying.trace(marker, msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled, isEnabled = false)
      import f._
      logger.trace(marker, msg, arg1)
      underlying.trace(marker, msg, arg1) wasNever called
      logger.trace(marker, msg, arg1, arg2)
      underlying.trace(marker, msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.trace(marker, msg, arg1, arg2, arg3)
      underlying.trace(marker, msg, arg1, arg2, arg3) wasNever called
    }
  }

  def fixture(p: Underlying => Marker => Boolean, isEnabled: Boolean) =
    new {
      val marker = DummyMarker
      val msg = "msg"
      val cause = new RuntimeException("cause")
      val arg1 = "arg1"
      val arg2 = new Integer(1)
      val arg3 = "arg3"
      val underlying = mock[org.slf4j.Logger]
      p(underlying)(marker) returns isEnabled
      val logger = Logger(underlying)
    }
}
