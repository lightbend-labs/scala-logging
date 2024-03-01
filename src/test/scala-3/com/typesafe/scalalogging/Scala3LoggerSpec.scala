package com.typesafe.scalalogging

import org.mockito.Mockito._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import org.slf4j.{Logger => Underlying}

class Scala3LoggerSpec extends AnyWordSpec with Matchers with Varargs with MockitoSugar {

  // Info
  "Calling info with an interpolated message, only scala 3" should {
    "fix Varargs compilation error issue 354 only scala 3" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      class LogWrapper(val underlying: Logger) {
        inline def info(message: String, inline args: AnyRef*): Unit = underlying.info(message, args: _*)
      }
      val logWrapper = new LogWrapper(logger)
      logWrapper.info("""Hello {}""", arg5ref)
      verify(underlying).info("""Hello {}""", arg5ref)
    }

    "work when passing a Seq as repeated arguments" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info("""Hello {}""", Seq(arg5ref):_*)
      verify(underlying).info("""Hello {}""", arg5ref)
    }

    "work when passing a fun as repeated arguments" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._
      logger.info("""Hello {}""", forceVarargs(arg5ref):_*)
      verify(underlying).info("""Hello {}""", arg5ref)
    }
  }

  private def fixture(p: Underlying => Boolean, isEnabled: Boolean) = new LoggerF(p, isEnabled)
  private class LoggerF(p: Underlying => Boolean, isEnabled: Boolean) {
    val msg = "msg"
    val cause = new RuntimeException("cause")
    val arg1 = "arg1"
    val arg2: Integer = Integer.valueOf(1)
    val arg3 = "arg3"
    val arg4 = 4
    val arg4ref: AnyRef = arg4.asInstanceOf[AnyRef]
    val arg5 = true
    val arg5ref: AnyRef = arg5.asInstanceOf[AnyRef]
    val arg6 = 6L
    val arg6ref: AnyRef = arg6.asInstanceOf[AnyRef]
    val arg7 = new Throwable
    val arg7ref: AnyRef = arg7.asInstanceOf[AnyRef]
    val underlying: Underlying = mock[org.slf4j.Logger]
    when(p(underlying)).thenReturn(isEnabled)
    val logger: Logger = Logger(underlying)
  }
}
