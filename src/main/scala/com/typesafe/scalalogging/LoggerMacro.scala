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
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    errorMessageArgs(c)(messageFormat, args: _*)
  }

  def errorMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($message, $cause)"
  }

  def errorMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isErrorEnabled) $underlying.error($message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isErrorEnabled) $underlying.error($message, ..$args)"
  }

  def errorMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    errorMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def errorMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($marker, $message, $cause)"
  }

  def errorMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isErrorEnabled) $underlying.error($marker, $message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isErrorEnabled) $underlying.error($marker, $message, ..$args)"
  }

  // Warn

  def warnMessage(c: LoggerContext)(message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    warnMessageArgs(c)(messageFormat, args: _*)
  }

  def warnMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($message, $cause)"
  }

  def warnMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isWarnEnabled) $underlying.warn($message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isWarnEnabled) $underlying.warn($message, ..$args)"
  }

  def warnMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    warnMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def warnMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($marker, $message, $cause)"
  }

  def warnMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isWarnEnabled) $underlying.warn($marker, $message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isWarnEnabled) $underlying.warn($marker, $message, ..$args)"
  }

  // Info

  def infoMessage(c: LoggerContext)(message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    infoMessageArgs(c)(messageFormat, args: _*)
  }

  def infoMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($message, $cause)"
  }

  def infoMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isInfoEnabled) $underlying.info($message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isInfoEnabled) $underlying.info($message, ..$args)"
  }

  def infoMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    infoMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def infoMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($marker, $message, $cause)"
  }

  def infoMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isInfoEnabled) $underlying.info($marker, $message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isInfoEnabled) $underlying.info($marker, $message, ..$args)"
  }

  // Debug

  def debugMessage(c: LoggerContext)(message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    debugMessageArgs(c)(messageFormat, args: _*)
  }

  def debugMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($message, $cause)"
  }

  def debugMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isDebugEnabled) $underlying.debug($message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isDebugEnabled) $underlying.debug($message, ..$args)"
  }

  def debugMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    debugMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def debugMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($marker, $message, $cause)"
  }

  def debugMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isDebugEnabled) $underlying.debug($marker, $message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isDebugEnabled) $underlying.debug($marker, $message, ..$args)"
  }

  // Trace

  def traceMessage(c: LoggerContext)(message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    traceMessageArgs(c)(messageFormat, args: _*)
  }

  def traceMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($message, $cause)"
  }

  def traceMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isTraceEnabled) $underlying.trace($message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isTraceEnabled) $underlying.trace($message, ..$args)"
  }

  def traceMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]) = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    traceMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def traceMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($marker, $message, $cause)"
  }

  def traceMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*) = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    if (args.length == 2)
      q"if ($underlying.isTraceEnabled) $underlying.trace($marker, $message, _root_.scala.Array(${args(0)}, ${args(1)}): _*)"
    else
      q"if ($underlying.isTraceEnabled) $underlying.trace($marker, $message, ..$args)"
  }

  /** Checks whether `messsage` is an interpolated string and transforms it into SLF4J string interpolation. */
  private def deconstructInterpolatedMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._

    message.tree match {
      case q"scala.StringContext.apply(..$parts).s(..$args)" =>
        // Escape slf4j format anchors
        val messageFormat = parts.map({ case Literal(Constant(s: String)) => s.replace("{}", "\\{}") }).mkString("{}")
        (c.Expr(q"$messageFormat"), args map { arg =>
          // Box interpolated AnyVals by explicitly getting the string representation
          c.Expr[Any](if (arg.tpe <:< weakTypeOf[AnyVal]) q"$arg.toString" else arg)
        })

      case _ => (message, Seq.empty)
    }
  }

}
