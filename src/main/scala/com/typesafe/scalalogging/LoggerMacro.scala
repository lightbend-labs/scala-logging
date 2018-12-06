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
import scala.reflect.macros.blackbox

private object LoggerMacro {

  type LoggerContext = blackbox.Context { type PrefixType = Logger }

  // Error

  def errorMessage(c: LoggerContext)(message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    errorMessageArgs(c)(messageFormat, args: _*)
  }

  def errorMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $underlying.error($message, $cause)"
  }

  def errorMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isErrorEnabled) $underlying.error($message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isErrorEnabled) $underlying.error($message, ..$anyRefArgs)"
  }

  def errorMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    errorMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def errorMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled($marker)) $underlying.error($marker, $message, $cause)"
  }

  def errorMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isErrorEnabled($marker)) $underlying.error($marker, $message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isErrorEnabled($marker)) $underlying.error($marker, $message, ..$anyRefArgs)"
  }

  def errorCode(c: LoggerContext)(body: c.Expr[Unit]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isErrorEnabled) $body"
  }

  // Warn

  def warnMessage(c: LoggerContext)(message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    warnMessageArgs(c)(messageFormat, args: _*)
  }

  def warnMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $underlying.warn($message, $cause)"
  }

  def warnMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isWarnEnabled) $underlying.warn($message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isWarnEnabled) $underlying.warn($message, ..$anyRefArgs)"
  }

  def warnMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    warnMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def warnMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled($marker)) $underlying.warn($marker, $message, $cause)"
  }

  def warnMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isWarnEnabled($marker)) $underlying.warn($marker, $message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isWarnEnabled($marker)) $underlying.warn($marker, $message, ..$anyRefArgs)"
  }

  def warnCode(c: LoggerContext)(body: c.Expr[Unit]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isWarnEnabled) $body"
  }

  // Info

  def infoMessage(c: LoggerContext)(message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    infoMessageArgs(c)(messageFormat, args: _*)
  }

  def infoMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $underlying.info($message, $cause)"
  }

  def infoMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isInfoEnabled) $underlying.info($message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isInfoEnabled) $underlying.info($message, ..$anyRefArgs)"
  }

  def infoMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    infoMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def infoMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled($marker)) $underlying.info($marker, $message, $cause)"
  }

  def infoMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isInfoEnabled($marker)) $underlying.info($marker, $message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isInfoEnabled($marker)) $underlying.info($marker, $message, ..$anyRefArgs)"
  }

  def infoCode(c: LoggerContext)(body: c.Expr[Unit]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isInfoEnabled) $body"
  }

  // Debug

  def debugMessage(c: LoggerContext)(message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    debugMessageArgs(c)(messageFormat, args: _*)
  }

  def debugMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $underlying.debug($message, $cause)"
  }

  def debugMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isDebugEnabled) $underlying.debug($message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isDebugEnabled) $underlying.debug($message, ..$anyRefArgs)"
  }

  def debugMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    debugMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def debugMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled($marker)) $underlying.debug($marker, $message, $cause)"
  }

  def debugMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isDebugEnabled($marker)) $underlying.debug($marker, $message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isDebugEnabled($marker)) $underlying.debug($marker, $message, ..$anyRefArgs)"
  }

  def debugCode(c: LoggerContext)(body: c.Expr[Unit]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isDebugEnabled) $body"
  }

  // Trace

  def traceMessage(c: LoggerContext)(message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    traceMessageArgs(c)(messageFormat, args: _*)
  }

  def traceMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $underlying.trace($message, $cause)"
  }

  def traceMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isTraceEnabled) $underlying.trace($message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isTraceEnabled) $underlying.trace($message, ..$anyRefArgs)"
  }

  def traceMessageMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    val (messageFormat, args) = deconstructInterpolatedMessage(c)(message)
    traceMessageArgsMarker(c)(marker, messageFormat, args: _*)
  }

  def traceMessageCauseMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled($marker)) $underlying.trace($marker, $message, $cause)"
  }

  def traceMessageArgsMarker(c: LoggerContext)(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    val anyRefArgs = formatArgs(c)(args: _*)
    if (args.length == 2)
      q"if ($underlying.isTraceEnabled($marker)) $underlying.trace($marker, $message, _root_.scala.Array(${anyRefArgs.head}, ${anyRefArgs(1)}): _*)"
    else
      q"if ($underlying.isTraceEnabled($marker)) $underlying.trace($marker, $message, ..$anyRefArgs)"
  }

  def traceCode(c: LoggerContext)(body: c.Expr[Unit]): c.universe.Tree = {
    import c.universe._
    val underlying = q"${c.prefix}.underlying"
    q"if ($underlying.isTraceEnabled) $body"
  }

  /** Checks whether `message` is an interpolated string and transforms it into SLF4J string interpolation. */
  private def deconstructInterpolatedMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._

    message.tree match {
      case q"scala.StringContext.apply(..$parts).s(..$args)" =>
        val format = parts.iterator.map({ case Literal(Constant(str: String)) => str })
          // Emulate standard interpolator escaping
          .map(StringContext.treatEscapes)
          // Escape literal slf4j format anchors if the resulting call will require a format string
          .map(str => if (args.nonEmpty) str.replace("{}", "\\{}") else str)
          .mkString("{}")

        val formatArgs = args.map(t => c.Expr[Any](t))

        (c.Expr(q"$format"), formatArgs)

      case _ => (message, Seq.empty)
    }
  }

  private def formatArgs(c: LoggerContext)(args: c.Expr[Any]*) = {
    import c.universe._
    args.map { arg =>
      c.Expr[AnyRef](if (arg.tree.tpe <:< weakTypeOf[AnyRef]) arg.tree else q"$arg.asInstanceOf[_root_.scala.AnyRef]")
    }
  }
}
