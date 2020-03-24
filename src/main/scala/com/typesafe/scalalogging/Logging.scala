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

import org.slf4j.LoggerFactory
import org.slf4j.{ Logger => Underlying }

/**
 * Defines `logger` as a lazy value initialized with an underlying `org.slf4j.Logger`
 * named according to the class into which this trait is mixed.
 */
trait LazyLogging {

  @transient
  protected lazy val logger: Logger =
    Logger(LoggerFactory.getLogger(getClass.getName))
}

/**
 * Defines `logger` as a value initialized with an underlying `org.slf4j.Logger`
 * named according to the class into which this trait is mixed.
 */
trait StrictLogging {

  protected val logger: Logger =
    Logger(LoggerFactory.getLogger(getClass.getName))
}

/**
 * Defines lazy logger that also logs data of type A from the inheritance base class.
 *
 * If you don't need a trait and can inherit an abstract class you can use this class to implicitly get CanLog via an
 * import statement without creating your own domain Trait.
 *
 * see LoggerTakingConstructorArgSpec for example
 *
 */
abstract class LazyLoggingInContextOf[A](implicit override protected val canLog: CanLog[A]) extends CustomizeLazyLoggingInContextOf[A]

/**
 * Defines lazy logger that also logs data of type A from the inheritance base class.
 *
 * Extend this base class with a hardcoded reference to your domain CanLog[A] for ease of use - like so
 * trait LazyLoggingInContextOfDomain extends CustomizeLazyLoggingInContextOf[DomainObject] {
 *   override protected val canLog: CanLog[DomainObject] = GlobalReference.toMyDomainObjectCanLogInstance
 * }
 *
 * and later inherit it into your classes:
 * class MyClass(override protected val context: DomainObject) extends LazyLoggingInContextOfDomain {
 *   ... do stuff with logger
 * }
 */
trait CustomizeLazyLoggingInContextOf[A] {

  protected def context: A
  protected def canLog: CanLog[A]

  protected def underlying: Underlying = LoggerFactory.getLogger(getClass.getName)

  @transient
  protected lazy val logger: LoggerTakingConstructorArg[A] = Logger.inContextOf[A](underlying)(canLog, context)

}