package com.typesafe.scalalogging

import org.mockito.Mockito._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import org.slf4j.{ Logger => Underlying }

class Scala2 extends AnyWordSpec with MockitoSugar {

  "Calling Logger from Scala 2" should {
    "work" in {
      val f = fixture(_.isInfoEnabled, isEnabled = true)
      import f._

      logger.info("message")
      verify(underlying).info("message")
    }
  }

  private def fixture(p: Underlying => Boolean, isEnabled: Boolean) = new LoggerF(p, isEnabled)
  private class LoggerF(p: Underlying => Boolean, isEnabled: Boolean) {
    val msg = "msg"
    val cause = new RuntimeException("cause")
    val arg1 = "arg1"
    val arg2 = Integer.valueOf(1)
    val arg3 = "arg3"
    val arg4 = 4
    val arg4ref = arg4.asInstanceOf[AnyRef]
    val arg5 = true
    val arg5ref = arg5.asInstanceOf[AnyRef]
    val arg6 = 6L
    val arg6ref = arg6.asInstanceOf[AnyRef]
    val arg7 = new Throwable
    val arg7ref = arg7.asInstanceOf[AnyRef]
    val underlying = mock[org.slf4j.Logger]
    when(p(underlying)).thenReturn(isEnabled)
    val logger = Logger(underlying)
  }
}
