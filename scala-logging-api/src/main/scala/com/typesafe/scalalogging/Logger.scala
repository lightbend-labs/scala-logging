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

import com.typesafe.scalalogging.macros.LoggerMacro
import scala.language.experimental._

/**
 * API for a performant logger based on macros.
 */
trait Logger {
  def adapter: LoggerAdapter

  // Error

  final def error(message: String): Unit = macro LoggerMacro.errorMessage

  final def error(message: String, cause: Throwable): Unit = macro LoggerMacro.errorMessageCause

  final def error(message: String, args: AnyRef*): Unit = macro LoggerMacro.errorMessageArgs

  // Warn

  final def warn(message: String): Unit = macro LoggerMacro.warnMessage

  final def warn(message: String, cause: Throwable): Unit = macro LoggerMacro.warnMessageCause

  final def warn(message: String, args: AnyRef*): Unit = macro LoggerMacro.warnMessageArgs

  // Info

  final def info(message: String): Unit = macro LoggerMacro.infoMessage

  final def info(message: String, cause: Throwable): Unit = macro LoggerMacro.infoMessageCause

  final def info(message: String, args: AnyRef*): Unit = macro LoggerMacro.infoMessageArgs

  // Debug

  final def debug(message: String): Unit = macro LoggerMacro.debugMessage

  final def debug(message: String, cause: Throwable): Unit = macro LoggerMacro.debugMessageCause

  final def debug(message: String, args: AnyRef*): Unit = macro LoggerMacro.debugMessageArgs

  // Trace

  final def trace(message: String): Unit = macro LoggerMacro.traceMessage

  final def trace(message: String, cause: Throwable): Unit = macro LoggerMacro.traceMessageCause

  final def trace(message: String, args: AnyRef*): Unit = macro LoggerMacro.traceMessageArgs
}

