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
package macros

import scala.annotation.switch
import scala.reflect.macros.blackbox.Context

private[scalalogging] object LoggerMacro {

  type LoggerContext = Context {
    type PrefixType = {
      def adapter: LoggerAdapter
    }
  }

  // Error

  def errorMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isErrorEnabled) $adapter.error($message)"
  }

  def errorMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isErrorEnabled) $adapter.error($message, $cause)"
  }

  def errorMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    (args.length: @switch) match {
      case 1 => q"if ($adapter.isErrorEnabled) $adapter.error($message, ${args(0)})"
      case 2 => q"if ($adapter.isErrorEnabled) $adapter.error($message, ${args(0)}, ${args(1)})"
      case _ => q"if ($adapter.isErrorEnabled) $adapter.error($message, Seq(..$args))"
    }
  }

  // Warn

  def warnMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isWarnEnabled) $adapter.warn($message)"
  }

  def warnMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isWarnEnabled) $adapter.warn($message, $cause)"
  }

  def warnMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    (args.length: @switch) match {
      case 1 => q"if ($adapter.isWarnEnabled) $adapter.warn($message, ${args(0)})"
      case 2 => q"if ($adapter.isWarnEnabled) $adapter.warn($message, ${args(0)}, ${args(1)})"
      case _ => q"if ($adapter.isWarnEnabled) $adapter.warn($message, Seq(..$args))"
    }
  }

  // Info

  def infoMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isInfoEnabled) $adapter.info($message)"
  }

  def infoMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isInfoEnabled) $adapter.info($message, $cause)"
  }

  def infoMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    (args.length: @switch) match {
      case 1 => q"if ($adapter.isInfoEnabled) $adapter.info($message, ${args(0)})"
      case 2 => q"if ($adapter.isInfoEnabled) $adapter.info($message, ${args(0)}, ${args(1)})"
      case _ => q"if ($adapter.isInfoEnabled) $adapter.info($message, Seq(..$args))"
    }
  }

  // Debug

  def debugMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isDebugEnabled) $adapter.debug($message)"
  }

  def debugMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isDebugEnabled) $adapter.debug($message, $cause)"
  }

  def debugMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    (args.length: @switch) match {
      case 1 => q"if ($adapter.isDebugEnabled) $adapter.debug($message, ${args(0)})"
      case 2 => q"if ($adapter.isDebugEnabled) $adapter.debug($message, ${args(0)}, ${args(1)})"
      case _ => q"if ($adapter.isDebugEnabled) $adapter.debug($message, Seq(..$args))"
    }
  }

  // Trace

  def traceMessage(c: LoggerContext)(message: c.Expr[String]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isTraceEnabled) $adapter.trace($message)"
  }

  def traceMessageCause(c: LoggerContext)(message: c.Expr[String], cause: c.Expr[Throwable]) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    q"if ($adapter.isTraceEnabled) $adapter.trace($message, $cause)"
  }

  def traceMessageArgs(c: LoggerContext)(message: c.Expr[String], args: c.Expr[AnyRef]*) = {
    import c.universe._
    val adapter = q"${c.prefix}.adapter"
    (args.length: @switch) match {
      case 1 => q"if ($adapter.isTraceEnabled) $adapter.trace($message, ${args(0)})"
      case 2 => q"if ($adapter.isTraceEnabled) $adapter.trace($message, ${args(0)}, ${args(1)})"
      case _ => q"if ($adapter.isTraceEnabled) $adapter.trace($message, Seq(..$args))"
    }
  }
}
