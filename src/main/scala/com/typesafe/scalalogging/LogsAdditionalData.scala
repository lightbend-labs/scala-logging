package com.typesafe.scalalogging

import org.slf4j.{ Logger => Underlying }

/**
 * common trait for loggers, such as LoggerTakingConstructorArg and LoggerTakingImplicit who use a strategy CanLog[A]
 * to log some additional data A that they have access too
 */
trait LogsAdditionalData[A] {
  protected def underlying: Underlying
  protected def canLogEv: CanLog[A]
}