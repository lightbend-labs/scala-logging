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

import scala.annotation.switch
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
    (args.length: @switch) match {
      case 1 => q"if ($underlying.isErrorEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.error($underlying, $message, ${args(0)})"
      case 2 => q"if ($underlying.isErrorEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.error($underlying, $message, ${args(0)}, ${args(1)})"
      case _ => q"if ($underlying.isErrorEnabled) $underlying.error($message, ..$args)"
    }
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
    (args.length: @switch) match {
      case 1 => q"if ($underlying.isWarnEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.warn($underlying, $message, ${args(0)})"
      case 2 => q"if ($underlying.isWarnEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.warn($underlying, $message, ${args(0)}, ${args(1)})"
      case _ => q"if ($underlying.isWarnEnabled) $underlying.warn($message, ..$args)"
    }
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
    (args.length: @switch) match {
      case 1 => q"if ($underlying.isInfoEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.info($underlying, $message, ${args(0)})"
      case 2 => q"if ($underlying.isInfoEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.info($underlying, $message, ${args(0)}, ${args(1)})"
      case _ => q"if ($underlying.isInfoEnabled) $underlying.info($message, ..$args)"
    }
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
    (args.length: @switch) match {
      case 1 => q"if ($underlying.isDebugEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.debug($underlying, $message, ${args(0)})"
      case 2 => q"if ($underlying.isDebugEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.debug($underlying, $message, ${args(0)}, ${args(1)})"
      case _ => q"if ($underlying.isDebugEnabled) $underlying.debug($message, ..$args)"
    }
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
    (args.length: @switch) match {
      case 1 => q"if ($underlying.isTraceEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.trace($underlying, $message, ${args(0)})"
      case 2 => q"if ($underlying.isTraceEnabled) com.typesafe.scalalogging.slf4j.LoggerSupport.trace($underlying, $message, ${args(0)}, ${args(1)})"
      case _ => q"if ($underlying.isTraceEnabled) $underlying.trace($message, ..$args)"
    }
  }
}
