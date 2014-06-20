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
package slf4j

import org.slf4j.{ Logger => Underlying }
import scala.annotation.switch
import scala.reflect.macros.Context

private object LoggerMacro {

  type LoggerContext = Context {
    type PrefixType = Logger
  }
  // Error

  def errorMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(message.splice)
    )

  def errorMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) =
    (args.length: @switch) match {
      case 1 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isErrorEnabled)
            c.prefix.splice.underlying.error(message.splice, args(0).splice)
        )
      case 2 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isErrorEnabled)
            c.prefix.splice.underlying.error(message.splice, args(0).splice, args(1).splice: Any)
        )
      case _ =>
        logParams(c)(message, args)("error")
    }

  def errorMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isErrorEnabled)
        c.prefix.splice.underlying.error(message.splice, cause.splice)
    )

  // Warn

  def warnMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(message.splice)
    )

  def warnMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) =
    (args.length: @switch) match {
      case 1 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isWarnEnabled)
            c.prefix.splice.underlying.warn(message.splice, args(0).splice)
        )
      case 2 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isWarnEnabled)
            c.prefix.splice.underlying.warn(message.splice, args(0).splice, args(1).splice: Any)
        )
      case _ =>
        logParams(c)(message, args)("warn")
    }

  def warnMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isWarnEnabled)
        c.prefix.splice.underlying.warn(message.splice, cause.splice)
    )

  // Info

  def infoMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(message.splice)
    )

  def infoMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) =
    (args.length: @switch) match {
      case 1 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isInfoEnabled)
            c.prefix.splice.underlying.info(message.splice, args(0).splice)
        )
      case 2 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isInfoEnabled)
            c.prefix.splice.underlying.info(message.splice, args(0).splice, args(1).splice: Any)
        )
      case _ =>
        logParams(c)(message, args)("info")
    }

  def infoMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isInfoEnabled)
        c.prefix.splice.underlying.info(message.splice, cause.splice)
    )

  // Debug

  def debugMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(message.splice)
    )

  def debugMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) =
    (args.length: @switch) match {
      case 1 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isDebugEnabled)
            c.prefix.splice.underlying.debug(message.splice, args(0).splice)
        )
      case 2 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isDebugEnabled)
            c.prefix.splice.underlying.debug(message.splice, args(0).splice, args(1).splice: Any)
        )
      case _ =>
        logParams(c)(message, args)("debug")
    }

  def debugMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isDebugEnabled)
        c.prefix.splice.underlying.debug(message.splice, cause.splice)
    )

  // Trace

  def traceMessage(c: LoggerContext)(message: c.Expr[String]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(message.splice)
    )

  def traceMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) =
    (args.length: @switch) match {
      case 1 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isTraceEnabled)
            c.prefix.splice.underlying.trace(message.splice, args(0).splice)
        )
      case 2 =>
        c.universe.reify(
          if (c.prefix.splice.underlying.isTraceEnabled)
            c.prefix.splice.underlying.trace(message.splice, args(0).splice, args(1).splice: Any)
        )
      case _ =>
        logParams(c)(message, args)("trace")
    }

  def traceMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) =
    c.universe.reify(
      if (c.prefix.splice.underlying.isTraceEnabled)
        c.prefix.splice.underlying.trace(message.splice, cause.splice)
    )

  // Common

  private def logParams(c: LoggerContext)(
    message: c.Expr[String],
    params: Seq[c.Expr[AnyRef]])(
      level: String) = {
    import c.universe._
    val isEnabled = Select(
      Select(c.prefix.tree, newTermName("underlying")),
      newTermName(s"is${level.head.toUpper +: level.tail}Enabled")
    )
    val paramsWildcard = Typed(
      Apply(
        Ident(newTermName("List")),
        (params map (_.tree)).toList
      ),
      Ident(tpnme.WILDCARD_STAR)
    )
    val log = Apply(
      Select(Select(c.prefix.tree, newTermName("underlying")), newTermName(level)),
      message.tree +: List(paramsWildcard)
    )
    c.Expr(If(isEnabled, log, Literal(Constant(()))))
  }
}
