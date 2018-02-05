package com.typesafe.scalalogging

import java.util.UUID

import com.typesafe.scalalogging.compliant.CompliantLogger
import com.typesafe.scalalogging.compliant.CompliantLogger.CompliantObject
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.slf4j.{ Logger => Underlying }
import org.scalatest.{ Matchers, WordSpec }
import org.scalatest.mock.MockitoSugar

class CompliantLoggerSpec extends WordSpec with Matchers with MockitoSugar {

  case class Customer(personalInformation: String, nonPersonalInformation: UUID) extends CompliantObject[Customer] {
    override def mkLog(): String = nonPersonalInformation.toString
  }

  private val mockCompliantObject: CompliantObject[Customer] = Customer("Rhys Bradbury", UUID.randomUUID())

  // Info

  "Calling info with a message" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, true)
      import f._
      logger.info(obj)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, false)
      import f._
      logger.info(obj)
      verify(underlying, never).info(anyString)
    }
  }

  "Calling info with a message and cause" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, true)
      import f._
      logger.info(obj, cause)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, false)
      import f._
      logger.info(obj, cause)
      verify(underlying, never).info(anyString, anyObject)
    }
  }

  "Calling info with a message and parameters" should {

    "call the underlying logger's info method if the info level is enabled" in {
      val f = fixture(_.isInfoEnabled, true)
      import f._
      logger.info(obj, arg1)
      logger.info(obj, arg1, arg2)
      logger.info(obj, arg1, arg2, arg3)
    }

    "not call the underlying logger's info method if the info level is not enabled" in {
      val f = fixture(_.isInfoEnabled, false)
      import f._
      logger.info(obj, arg1)
      logger.info(obj, arg1, arg2)
      logger.info(obj, arg1, arg2, arg3)
    }
  }

  def fixture(p: Underlying => Boolean, isEnabled: Boolean) =
    new {
      val obj = mockCompliantObject
      val cause = new RuntimeException("cause")
      val arg1 = "arg1"
      val arg2 = new Integer(1)
      val arg3 = "arg3"
      val underlying = mock[org.slf4j.Logger]
      when(p(underlying)).thenReturn(isEnabled)
      val logger = CompliantLogger(underlying)
    }
}
