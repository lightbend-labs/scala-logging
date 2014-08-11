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

import org.slf4j.Marker
import scala.reflect.macros.blackbox.Context

private object LoggerMacro {

  type LoggerContext = Context { type PrefixType = Logger }

  // Error

  def errorMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($message)"
  }

  def errorMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($message, $cause)"
  }

  def errorMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isErrorEnabled) $underlying.error($message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isErrorEnabled) $underlying.error($message, ..$args)"
  }

  def errorMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($marker, $message)"
  }

  def errorMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($marker, $message, $cause)"
  }

  def errorMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isErrorEnabled) $underlying.error($marker, $message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isErrorEnabled) $underlying.error($marker, $message, ..$args)"
  }

  // Warn

  def warnMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($message)"
  }

  def warnMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($message, $cause)"
  }

  def warnMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isWarnEnabled) $underlying.warn($message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isWarnEnabled) $underlying.warn($message, ..$args)"
  }

  def warnMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($marker, $message)"
  }

  def warnMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($marker, $message, $cause)"
  }

  def warnMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isWarnEnabled) $underlying.warn($marker, $message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isWarnEnabled) $underlying.warn($marker, $message, ..$args)"
  }

  // Info

  def infoMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($message)"
  }

  def infoMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($message, $cause)"
  }

  def infoMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isInfoEnabled) $underlying.info($message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isInfoEnabled) $underlying.info($message, ..$args)"
  }

  def infoMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($marker, $message)"
  }

  def infoMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($marker, $message, $cause)"
  }

  def infoMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isInfoEnabled) $underlying.info($marker, $message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isInfoEnabled) $underlying.info($marker, $message, ..$args)"
  }

  // Debug

  def debugMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($message)"
  }

  def debugMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($message, $cause)"
  }

  def debugMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isDebugEnabled) $underlying.debug($message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isDebugEnabled) $underlying.debug($message, ..$args)"
  }

  def debugMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($marker, $message)"
  }

  def debugMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($marker, $message, $cause)"
  }

  def debugMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isDebugEnabled) $underlying.debug($marker, $message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isDebugEnabled) $underlying.debug($marker, $message, ..$args)"
  }

  // Trace

  def traceMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($message)"
  }

  def traceMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($message, $cause)"
  }

  def traceMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isTraceEnabled) $underlying.trace($message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isTraceEnabled) $underlying.trace($message, ..$args)"
  }

  def traceMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($marker, $message)"
  }

  def traceMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($marker, $message, $cause)"
  }

  def traceMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isTraceEnabled) $underlying.trace($marker, $message, List(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isTraceEnabled) $underlying.trace($marker, $message, ..$args)"
  }

}
