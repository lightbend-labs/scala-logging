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
      case 1 => q"if ($underlying.isErrorEnabled) LoggerSupport.error($underlying, $message, ${args(0)})"
      case 2 => q"if ($underlying.isErrorEnabled) LoggerSupport.error($underlying, $message, ${args(0)}, ${args(1)})"
      case _ => q"if ($underlying.isErrorEnabled) $underlying.error($message, ..$args)"
    }
  }
}
