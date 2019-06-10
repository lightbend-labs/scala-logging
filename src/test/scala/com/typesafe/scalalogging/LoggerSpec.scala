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

import java.io._

import org.mockito.scalatest.IdiomaticMockito
import org.scalatest.{ Matchers, WordSpec }
import org.slf4j.{ Logger => Underlying }

trait Varargs {
  // TODO: we used to wrap in List(...): _*, which I assume was to force the varags method to be chosen.
  // I encapsulated that here in something that works across 2.12/2.13.
  def forceVarargs[T](xs: T*): scala.Seq[T] = scala.Seq(xs: _*)
}

class LoggerSpec
  extends WordSpec
  with Matchers
  with IdiomaticMockito
  with Varargs {

  // Error

  "Calling error with a message" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(msg)
      underlying.error(msg) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled returns false)
      import f._
      logger.error(msg)
      underlying.error(*) wasNever called
    }
  }

  "Calling error with an interpolated message" should {

    "call the underlying logger's error method with arguments if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"msg $arg1 $arg2 $arg3")
      underlying.error("msg {} {} {}", arg1, arg2, arg3) was called
    }

    "call the underlying logger's error method with two arguments if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"msg $arg1 $arg2")
      underlying.error("msg {} {}", forceVarargs(arg1, arg2): _*) was called
    }

  }

  "Calling error with a message and cause" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(msg, cause)
      underlying.error(msg, cause) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled returns false)
      import f._
      logger.error(msg, cause)
      underlying.error(*, any[Object]) wasNever called
    }
  }

  "Calling error with a message and parameters" should {

    "call the underlying logger's error method if the error level is enabled" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(msg, arg1)
      underlying.error(msg, arg1) was called
      logger.error(msg, arg1, arg2)
      underlying.error(msg, forceVarargs(arg1, arg2): _*) was called
      logger.error(msg, arg1, arg2, arg3)
      underlying.error(msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's error method if the error level is not enabled" in {
      val f = fixture(_.isErrorEnabled returns false)
      import f._
      logger.error(msg, arg1)
      underlying.error(msg, arg1) wasNever called
      logger.error(msg, arg1, arg2)
      underlying.error(msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.error(msg, arg1, arg2, arg3)
      underlying.error(msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Warn

  "Calling warn with a message" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(msg)
      underlying.warn(msg) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled returns false)
      import f._
      logger.warn(msg)
      underlying.warn(*) wasNever called
    }
  }

  "Calling warn with an interpolated message" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(s"msg $arg1 $arg2 $arg3")
      underlying.warn("msg {} {} {}", arg1, arg2, arg3) was called
    }

    "call the underlying logger's warn method with two arguments if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(s"msg $arg1 $arg2")
      underlying.warn("msg {} {}", forceVarargs(arg1, arg2): _*) was called
    }
  }

  "Calling warn with a message and cause" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(msg, cause)
      underlying.warn(msg, cause) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled returns false)
      import f._
      logger.warn(msg, cause)
      underlying.warn(*, any[Object]) wasNever called
    }
  }

  "Calling warn with a message and parameters" should {

    "call the underlying logger's warn method if the warn level is enabled" in {
      val f = fixture(_.isWarnEnabled returns true)
      import f._
      logger.warn(msg, arg1)
      underlying.warn(msg, arg1) was called
      logger.warn(msg, arg1, arg2)
      underlying.warn(msg, forceVarargs(arg1, arg2): _*) was called
      logger.warn(msg, arg1, arg2, arg3)
      underlying.warn(msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's warn method if the warn level is not enabled" in {
      val f = fixture(_.isWarnEnabled returns false)
      import f._
      logger.warn(msg, arg1)
      underlying.warn(msg, arg1) wasNever called
      logger.warn(msg, arg1, arg2)
      underlying.warn(msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.warn(msg, arg1, arg2, arg3)
      underlying.warn(msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Info

  "Calling info with a message" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(msg)
      underlying.info(msg) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled returns false)
      import f._
      logger.info(msg)
      underlying.info(*) wasNever called
    }
  }

  "Calling info with an interpolated message" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(s"msg $arg1 $arg2 $arg3")
      underlying.info("msg {} {} {}", arg1, arg2, arg3) was called
    }

    "call the underlying logger's info method with two arguments if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(s"msg $arg1 $arg2")
      underlying.info("msg {} {}", forceVarargs(arg1, arg2): _*) was called
    }
  }

  "Calling info with a message and cause" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(msg, cause)
      underlying.info(msg, cause) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled returns false)
      import f._
      logger.info(msg, cause)
      underlying.info(*, any[Object]) wasNever called
    }
  }

  "Calling info with a message and parameters" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled returns true)
      import f._
      logger.info(msg, arg1)
      underlying.info(msg, arg1) was called
      logger.info(msg, arg1, arg2)
      underlying.info(msg, forceVarargs(arg1, arg2): _*) was called
      logger.info(msg, arg1, arg2, arg3)
      underlying.info(msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled returns false)
      import f._
      logger.info(msg, arg1)
      underlying.info(msg, arg1) wasNever called
      logger.info(msg, arg1, arg2)
      underlying.info(msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.info(msg, arg1, arg2, arg3)
      underlying.info(msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Debug

  "Calling debug with a message" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(msg)
      underlying.debug(msg) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled returns false)
      import f._
      logger.debug(msg)
      underlying.debug(*) wasNever called
    }
  }
  "Calling debug with an interpolated message" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(s"msg $arg1 $arg2 $arg3")
      underlying.debug("msg {} {} {}", arg1, arg2, arg3) was called
    }

    "call the underlying logger's debug method with two arguments if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(s"msg $arg1 $arg2")
      underlying.debug("msg {} {}", forceVarargs(arg1, arg2): _*) was called
    }
  }

  "Calling debug with a message and cause" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(msg, cause)
      underlying.debug(msg, cause) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled returns false)
      import f._
      logger.debug(msg, cause)
      underlying.debug(*, any[Object]) wasNever called
    }
  }

  "Calling debug with a message and parameters" should {

    "call the underlying logger's debug method if the debug level is enabled" in {
      val f = fixture(_.isDebugEnabled returns true)
      import f._
      logger.debug(msg, arg1)
      underlying.debug(msg, arg1) was called
      logger.debug(msg, arg1, arg2)
      underlying.debug(msg, forceVarargs(arg1, arg2): _*) was called
      logger.debug(msg, arg1, arg2, arg3)
      underlying.debug(msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's debug method if the debug level is not enabled" in {
      val f = fixture(_.isDebugEnabled returns false)
      import f._
      logger.debug(msg, arg1)
      underlying.debug(msg, arg1) wasNever called
      logger.debug(msg, arg1, arg2)
      underlying.debug(msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.debug(msg, arg1, arg2, arg3)
      underlying.debug(msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Trace

  "Calling trace with a message" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(msg)
      underlying.trace(msg) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled returns false)
      import f._
      logger.trace(msg)
      underlying.trace(*) wasNever called
    }
  }

  "Calling trace with an interpolated message" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(s"msg $arg1 $arg2 $arg3")
      underlying.trace("msg {} {} {}", arg1, arg2, arg3) was called
    }

    "call the underlying logger's trace method with two arguments if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(s"msg $arg1 $arg2")
      underlying.trace("msg {} {}", forceVarargs(arg1, arg2): _*) was called
    }
  }

  "Calling trace with a message and cause" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(msg, cause)
      underlying.trace(msg, cause) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled returns false)
      import f._
      logger.trace(msg, cause)
      underlying.trace(*, any[Object]) wasNever called
    }
  }

  "Calling trace with a message and parameters" should {

    "call the underlying logger's trace method if the trace level is enabled" in {
      val f = fixture(_.isTraceEnabled returns true)
      import f._
      logger.trace(msg, arg1)
      underlying.trace(msg, arg1) was called
      logger.trace(msg, arg1, arg2)
      underlying.trace(msg, forceVarargs(arg1, arg2): _*) was called
      logger.trace(msg, arg1, arg2, arg3)
      underlying.trace(msg, arg1, arg2, arg3) was called
    }

    "not call the underlying logger's trace method if the trace level is not enabled" in {
      val f = fixture(_.isTraceEnabled returns false)
      import f._
      logger.trace(msg, arg1)
      underlying.trace(msg, arg1) wasNever called
      logger.trace(msg, arg1, arg2)
      underlying.trace(msg, forceVarargs(arg1, arg2): _*) wasNever called
      logger.trace(msg, arg1, arg2, arg3)
      underlying.trace(msg, arg1, arg2, arg3) wasNever called
    }
  }

  // Interpolator destructuring corner cases

  "Logging a message using the standard string interpolator" should {

    "call the underlying format method with boxed versions of value arguments" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"msg ${1}")
      underlying.error("msg {}", 1.asInstanceOf[AnyRef]) was called
    }

    "call the underlying format method with boxed versions of arguments of type Any" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"msg ${1.asInstanceOf[Any]}")
      underlying.error("msg {}", 1.asInstanceOf[AnyRef]) was called
    }

    "call the underlying format method escaping literal format anchors" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"foo {} bar $arg1")
      underlying.error("foo \\{} bar {}", arg1) was called
    }

    "call the underlying method without escaping format anchors when the message has no interpolations" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"foo {} bar")
      underlying.error("foo {} bar") was called
    }

    "call the underlying format method when the interpolated string contains escape sequences" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"foo\nbar $arg1")
      underlying.error(s"foo\nbar {}", arg1) was called
    }

    "call the underlying format method when the interpolated string is triple quoted and contains escape sequences" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error(s"""foo\nbar $arg1""")
      underlying.error(s"""foo\nbar {}""", arg1) was called
    }
  }

  "Logging a message using slf4 interpolator and Any args" should {
    "map args to AnyRef for 2 args" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error("foo {}, bar {}", arg4, arg5)
      underlying.error("foo {}, bar {}", forceVarargs(arg4ref, arg5ref): _*) was called
    }

    "map args to AnyRef for non 2 args" in {
      val f = fixture(_.isErrorEnabled returns true)
      import f._
      logger.error("foo {}", arg4)
      underlying.error("foo {}", arg4ref) was called
      logger.error("foo {}, bar {}, {}", arg4, arg5, arg6)
      underlying.error("foo {}, bar {}, {}", arg4ref, arg5ref, arg6ref) was called
    }
  }

  "Serializing Logger" should {

    def serialize(logger: Logger): Array[Byte] = {
      val byteArrayStream = new ByteArrayOutputStream
      val out = new ObjectOutputStream(byteArrayStream)

      out.writeObject(logger)
      out.close()
      byteArrayStream.close()

      byteArrayStream.toByteArray
    }

    def deserialize(array: Array[Byte]): Logger = {
      val byteArrayStream = new ByteArrayInputStream(array)
      val in = new ObjectInputStream(byteArrayStream)

      val logger = in.readObject.asInstanceOf[Logger]
      in.close()
      byteArrayStream.close()

      logger
    }

    "be usable after deserialization" in {
      val logger = deserialize(
        serialize(Logger(org.slf4j.LoggerFactory.getLogger("test"))))

      logger.trace("Back from deserialization")
    }

    "constructed by explicit class and be usable after deserialization" in {
      val logger = deserialize(serialize(Logger(classOf[LoggerSpec])))

      logger.trace("Back from deserialization")
    }

    "constructed by implicit class tag and be usable after deserialization" in {
      val logger = deserialize(serialize(Logger[LoggerSpec]))

      logger.trace("Back from deserialization")
    }
  }

  "Serializing LoggerTakingImplicit" should {
    case class CorrelationId(value: String)
    implicit val correlationId: CorrelationId =
      CorrelationId(value = "correlationId")

    implicit case object canLogCorrelationId extends CanLog[CorrelationId] {
      def logMessage(originalMsg: String, a: CorrelationId): String =
        s"${a.value} $originalMsg"
    }

    def serialize[A](logger: LoggerTakingImplicit[A]): Array[Byte] = {
      val byteArrayStream = new ByteArrayOutputStream
      val out = new ObjectOutputStream(byteArrayStream)

      out.writeObject(logger)
      out.close()
      byteArrayStream.close()

      byteArrayStream.toByteArray
    }

    def deserialize[A](array: Array[Byte]): LoggerTakingImplicit[A] = {
      val byteArrayStream = new ByteArrayInputStream(array)
      val in = new ObjectInputStream(byteArrayStream)

      val logger = in.readObject.asInstanceOf[LoggerTakingImplicit[A]]
      in.close()
      byteArrayStream.close()

      logger
    }

    "be usable after deserialization" in {
      val logger =
        deserialize[CorrelationId](
          serialize[CorrelationId](
            Logger.takingImplicit[CorrelationId](
              org.slf4j.LoggerFactory.getLogger("test"))))

      logger.trace("Back from deserialization")
    }

    "constructed by explicit class and be usable after deserialization" in {
      val logger =
        deserialize[CorrelationId](
          serialize[CorrelationId](
            Logger.takingImplicit[CorrelationId](classOf[LoggerSpec])))

      logger.trace("Back from deserialization")
    }

    "constructed by implicit class tag and be usable after deserialization" in {
      val logger =
        deserialize[CorrelationId](
          serialize[CorrelationId](
            Logger.takingImplicit[LoggerSpec, CorrelationId]))

      logger.trace("Back from deserialization")
    }
  }

  def fixture(p: Underlying => Unit) =
    new {
      val msg = "msg"
      val cause = new RuntimeException("cause")
      val arg1 = "arg1"
      val arg2 = new Integer(1)
      val arg3 = "arg3"
      val arg4 = 4
      val arg4ref = arg4.asInstanceOf[AnyRef]
      val arg5 = true
      val arg5ref = arg5.asInstanceOf[AnyRef]
      val arg6 = 6L
      val arg6ref = arg6.asInstanceOf[AnyRef]
      val underlying = mock[org.slf4j.Logger]
      p(underlying)
      val logger = Logger(underlying)
    }
}
