package com.typesafe.scalalogging


import java.lang.ClassCastException
import org.slf4j.{ Logger => Underlying }
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito._
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

class LoggerWithTaggedAargsSpec extends AnyWordSpec with MockitoSugar with Matchers with Varargs {

  trait Tag

  import tag._

  "Calling error with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isErrorEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.error("This should not throw: {}, {}", arg1, arg2)
      }
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isErrorEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.error(s"This should not throw: $arg1, $arg2")
      }
    }
  }

  "Calling trace with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isTraceEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.trace("This should not throw: {}, {}", arg1, arg2)
      }
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isTraceEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.trace(s"This should not throw: $arg1, $arg2")
      }
    }
  }

  "Calling debug with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isTraceEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.debug("This should not throw: {}, {}", arg1, arg2)
      }
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isTraceEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.debug(s"This should not throw: $arg1, $arg2")
      }
    }
  }

  "Calling info with tagged args" should {

    "not throw ClassCastException when varargs are passed" in {
      val f = fixture(_.isInfoEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.info("This should not throw: {}, {}", arg1, arg2)
      }
    }

    "not throw ClassCastException when interpolated message is passed" in {
      val f = fixture(_.isInfoEnabled)
      import f._
      noException shouldBe thrownBy {
        logger.info(s"This should not throw: $arg1, $arg2")
      }
    }
  }

  def fixture(p: Underlying => Boolean, isEnabled: Boolean = true) =
    new {
      val arg1 = tag[Tag][String]("arg1")
      val arg2 = tag[Tag][Integer](Integer.valueOf(1))
      val underlying = mock[org.slf4j.Logger]
      when(p(underlying)).thenReturn(isEnabled)
      val logger = Logger(underlying)
    }
}
