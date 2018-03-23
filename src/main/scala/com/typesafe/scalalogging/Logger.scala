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

import org.slf4j.{ LoggerFactory, Marker, Logger => Underlying }
import scala.language.experimental.macros
import scala.reflect.ClassTag

/**
 * Companion for [[Logger]], providing a factory for [[Logger]]s.
 */
object Logger {

  /**
   * Create a [[Logger]] wrapping the given underlying `org.slf4j.Logger`.
   */
  def apply(underlying: Underlying): Logger =
    new Logger(underlying)

  /**
   * Create a [[LoggerTakingImplicit]] wrapping the given underlying `org.slf4j.Logger`.
   */
  def takingImplicit[A](underlying: Underlying)(implicit ev: CanLog[A]): LoggerTakingImplicit[A] =
    new LoggerTakingImplicit[A](underlying)

  /**
   * Create a [[Logger]] for the given name.
   * Example:
   * {{{
   *   val logger = Logger("application")
   * }}}
   */
  def apply(name: String): Logger =
    new Logger(LoggerFactory.getLogger(name))

  /**
   * Create a [[LoggerTakingImplicit]] for the given name.
   * Example:
   * {{{
   *   val logger = Logger.takingImplicit[CorrelationId]("application")
   * }}}
   */
  def takingImplicit[A](name: String)(implicit ev: CanLog[A]): LoggerTakingImplicit[A] =
    new LoggerTakingImplicit[A](LoggerFactory.getLogger(name))

  /**
   * Create a [[Logger]] wrapping the created underlying `org.slf4j.Logger`.
   */
  def apply(clazz: Class[_]): Logger =
    new Logger(LoggerFactory.getLogger(clazz.getName))

  /**
   * Create a [[LoggerTakingImplicit]] wrapping the created underlying `org.slf4j.Logger`.
   */
  def takingImplicit[A](clazz: Class[_])(implicit ev: CanLog[A]): LoggerTakingImplicit[A] =
    new LoggerTakingImplicit[A](LoggerFactory.getLogger(clazz.getName))

  /**
   * Create a [[Logger]] for the runtime class wrapped by the implicit class
   * tag parameter.
   * Example:
   * {{{
   *   val logger = Logger[MyClass]
   * }}}
   */
  def apply[T](implicit ct: ClassTag[T]): Logger =
    new Logger(LoggerFactory.getLogger(ct.runtimeClass.getName.stripSuffix("$")))

  /**
   * Create a [[LoggerTakingImplicit]] for the runtime class wrapped by the implicit class
   * tag parameter.
   * Example:
   * {{{
   *   val logger = Logger.takingImplicit[MyClass, CorrelationId]
   * }}}
   */
  def takingImplicit[T, A](implicit ct: ClassTag[T], ev: CanLog[A]): LoggerTakingImplicit[A] =
    new LoggerTakingImplicit[A](LoggerFactory.getLogger(ct.runtimeClass.getName.stripSuffix("$")))
}

/**
 * Implementation of a fast logger based on macros and an underlying `org.slf4j.Logger`.
 */
@SerialVersionUID(538248225L)
final class Logger private (val underlying: Underlying) extends Serializable {

  // Error

  def error(message: String): Unit = macro LoggerMacro.errorMessage

  def error(message: String, cause: Throwable): Unit = macro LoggerMacro.errorMessageCause

  def error(message: String, args: Any*): Unit = macro LoggerMacro.errorMessageArgs

  def error(marker: Marker, message: String): Unit = macro LoggerMacro.errorMessageMarker

  def error(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.errorMessageCauseMarker

  def error(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.errorMessageArgsMarker

  def whenErrorEnabled(body: Unit): Unit = macro LoggerMacro.errorCode

  // Warn

  def warn(message: String): Unit = macro LoggerMacro.warnMessage

  def warn(message: String, cause: Throwable): Unit = macro LoggerMacro.warnMessageCause

  def warn(message: String, args: Any*): Unit = macro LoggerMacro.warnMessageArgs

  def warn(marker: Marker, message: String): Unit = macro LoggerMacro.warnMessageMarker

  def warn(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.warnMessageCauseMarker

  def warn(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.warnMessageArgsMarker

  def whenWarnEnabled(body: Unit): Unit = macro LoggerMacro.warnCode

  // Info

  def info(message: String): Unit = macro LoggerMacro.infoMessage

  def info(message: String, cause: Throwable): Unit = macro LoggerMacro.infoMessageCause

  def info(message: String, args: Any*): Unit = macro LoggerMacro.infoMessageArgs

  def info(marker: Marker, message: String): Unit = macro LoggerMacro.infoMessageMarker

  def info(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.infoMessageCauseMarker

  def info(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.infoMessageArgsMarker

  def whenInfoEnabled(body: Unit): Unit = macro LoggerMacro.infoCode

  // Debug

  def debug(message: String): Unit = macro LoggerMacro.debugMessage

  def debug(message: String, cause: Throwable): Unit = macro LoggerMacro.debugMessageCause

  def debug(message: String, args: Any*): Unit = macro LoggerMacro.debugMessageArgs

  def debug(marker: Marker, message: String): Unit = macro LoggerMacro.debugMessageMarker

  def debug(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.debugMessageCauseMarker

  def debug(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.debugMessageArgsMarker

  def whenDebugEnabled(body: Unit): Unit = macro LoggerMacro.debugCode

  // Trace

  def trace(message: String): Unit = macro LoggerMacro.traceMessage

  def trace(message: String, cause: Throwable): Unit = macro LoggerMacro.traceMessageCause

  def trace(message: String, args: Any*): Unit = macro LoggerMacro.traceMessageArgs

  def trace(marker: Marker, message: String): Unit = macro LoggerMacro.traceMessageMarker

  def trace(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.traceMessageCauseMarker

  def trace(marker: Marker, message: String, args: Any*): Unit = macro LoggerMacro.traceMessageArgsMarker

  def whenTraceEnabled(body: Unit): Unit = macro LoggerMacro.traceCode

}
