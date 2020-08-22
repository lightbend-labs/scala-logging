package com.typesafe.scalalogging

import org.slf4j.{ Logger => Underlying }

trait CanLog[A] {
  def logMessage(originalMsg: String, a: A): String
  def afterLog(a: A): Unit = {
    val _ = a
  }
}

@SerialVersionUID(957385465L)
class LoggerTakingImplicit[A] private[scalalogging] (val underlying: Underlying)(implicit val canLogEv: CanLog[A]) extends LoggerTakingImplicitImpl[A] with Serializable