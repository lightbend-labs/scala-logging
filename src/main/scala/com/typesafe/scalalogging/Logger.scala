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

import org.slf4j.{ Logger => Underlying }
import org.slf4j.Marker

/**
 * Companion for [[Logger]], providing a factory for [[Logger]]s.
 */
object Logger {

  /**
   * Create a [[Logger]] wrapping the given underlying `org.slf4j.Logger`.
   */
  def apply(underlying: Underlying): Logger =
    new Logger(underlying)
}

/**
 * Implementation for a performant logger based on macros and an underlying `org.slf4j.Logger`.
 */
class Logger(val underlying: Underlying) {

  // Error

  def error(message: String): Unit = macro LoggerMacro.errorMessage

  def error(message: String, cause: Throwable): Unit = macro LoggerMacro.errorMessageCause

  def error(message: String, args: AnyRef*): Unit = macro LoggerMacro.errorMessageArgs

  def error(marker: Marker, message: String): Unit = macro LoggerMacro.errorMessageMarker

  def error(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.errorMessageCauseMarker

  def error(marker: Marker, message: String, args: AnyRef*): Unit = macro LoggerMacro.errorMessageArgsMarker

  // Warn

  def warn(message: String): Unit = macro LoggerMacro.warnMessage

  def warn(message: String, cause: Throwable): Unit = macro LoggerMacro.warnMessageCause

  def warn(message: String, args: AnyRef*): Unit = macro LoggerMacro.warnMessageArgs

  def warn(marker: Marker, message: String): Unit = macro LoggerMacro.warnMessageMarker

  def warn(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.warnMessageCauseMarker

  def warn(marker: Marker, message: String, args: AnyRef*): Unit = macro LoggerMacro.warnMessageArgsMarker

  // Info

  def info(message: String): Unit = macro LoggerMacro.infoMessage

  def info(message: String, cause: Throwable): Unit = macro LoggerMacro.infoMessageCause

  def info(message: String, args: AnyRef*): Unit = macro LoggerMacro.infoMessageArgs

  def info(marker: Marker, message: String): Unit = macro LoggerMacro.infoMessageMarker

  def info(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.infoMessageCauseMarker

  def info(marker: Marker, message: String, args: AnyRef*): Unit = macro LoggerMacro.infoMessageArgsMarker

  // Debug

  def debug(message: String): Unit = macro LoggerMacro.debugMessage

  def debug(message: String, cause: Throwable): Unit = macro LoggerMacro.debugMessageCause

  def debug(message: String, args: AnyRef*): Unit = macro LoggerMacro.debugMessageArgs

  def debug(marker: Marker, message: String): Unit = macro LoggerMacro.debugMessageMarker

  def debug(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.debugMessageCauseMarker

  def debug(marker: Marker, message: String, args: AnyRef*): Unit = macro LoggerMacro.debugMessageArgsMarker

  // Trace

  def trace(message: String): Unit = macro LoggerMacro.traceMessage

  def trace(message: String, cause: Throwable): Unit = macro LoggerMacro.traceMessageCause

  def trace(message: String, args: AnyRef*): Unit = macro LoggerMacro.traceMessageArgs

  def trace(marker: Marker, message: String): Unit = macro LoggerMacro.traceMessageMarker

  def trace(marker: Marker, message: String, cause: Throwable): Unit = macro LoggerMacro.traceMessageCauseMarker

  def trace(marker: Marker, message: String, args: AnyRef*): Unit = macro LoggerMacro.traceMessageArgsMarker

}
