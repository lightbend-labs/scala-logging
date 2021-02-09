package com.typesafe.scalalogging

import org.mockito.scalatest.MockitoSugar
import org.slf4j.{ Logger => Underlying }
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

object tag {

  def apply[U] = new Tagger[U]

  trait Tagged[U]
  type @@[+T, U] = T with Tagged[U]

  class Tagger[U] {
    def apply[T](t: T): T @@ U = t.asInstanceOf[T @@ U]
  }
}

class LoggerWithTaggedArgsSpec extends AnyWordSpec with Matchers with Varargs with MockitoSugar {

  trait Tag

  "Calling error with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isErrorEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.error("This should not throw: {}, {} - {}", arg1, arg2, arg3)
      }
      verify(underlying).error(any[String], *, *, *)
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isErrorEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.error(s"This should not throw: $arg1, $arg2, $arg3")
      }
      verify(underlying).error(any[String], *, *, *)
    }
  }

  "Calling trace with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isTraceEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.trace("This should not throw: {}, {} - {}", arg1, arg2, arg3)
      }
      verify(underlying).trace(any[String], *, *, *)
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isTraceEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.trace(s"This should not throw: $arg1, $arg2, $arg3")
      }
      verify(underlying).trace(any[String], *, *, *)
    }
  }

  "Calling debug with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isDebugEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.debug("This should not throw: {}, {} - {}", arg1, arg2, arg3)
      }
      verify(underlying).debug(any[String], *, *, *)
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isDebugEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.debug(s"This should not throw: $arg1, $arg2, $arg3")
      }
      verify(underlying).debug(any[String], *, *, *)
    }
  }

  "Calling info with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isInfoEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.info("This should not throw: {}, {} - {}", arg1, arg2, arg3)
      }
      verify(underlying).info(any[String], *, *, *)
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isInfoEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.info(s"This should not throw: $arg1, $arg2, $arg3")
      }
      verify(underlying).info(any[String], *, *, *)
    }
  }

  def fixture(p: Underlying => Boolean, isEnabled: Boolean = true) =
    new {
      val arg1 = tag[Tag][String]("arg1")
      val arg2 = tag[Tag][Integer](Integer.valueOf(1))
      val arg3 = tag[Tag][Boolean](true)
      val underlying = mock[org.slf4j.Logger]
      when(p(underlying)).thenReturn(isEnabled)
      val logger = Logger(underlying)
    }
}
