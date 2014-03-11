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

trait Logger {

  // Error

  /**
   * Log at *error* level.
   * @param message the error message
   */
  def error(message: String): Unit

  /**
   * Log at *error* level.
   * @param message the error message
   * @param cause the cause for the error
   */
  def error(message: String, cause: Throwable): Unit

  /**
   * Log at *error* level.
   * @param message the error message
   * @param args the arguments used to format the error message
   */
  def error(message: String, args: AnyRef*): Unit

  // Warn

  /**
   * Log at *warning* level.
   * @param message the warning message
   */
  def warn(message: String): Unit

  /**
   * Log at *warning* level.
   * @param message the warning message
   * @param cause the cause for the warning
   */
  def warn(message: String, cause: Throwable): Unit

  /**
   * Log at *warning* level.
   * @param message the warning message
   * @param args the arguments used to format the warning message
   */
  def warn(message: String, args: AnyRef*): Unit

  // Info

  /**
   * Log at *info* level.
   * @param message the info message
   */
  def info(message: String): Unit

  /**
   * Log at *info* level.
   * @param message the info message
   * @param cause the cause for the info
   */
  def info(message: String, cause: Throwable): Unit

  /**
   * Log at *info* level.
   * @param message the info message
   * @param args the arguments used to format the info message
   */
  def info(message: String, args: AnyRef*): Unit

  // Debug

  /**
   * Log at *debug* level.
   * @param message the debug message
   */
  def debug(message: String): Unit

  /**
   * Log at *debug* level.
   * @param message the debug message
   * @param cause the cause for the debug
   */
  def debug(message: String, cause: Throwable): Unit

  /**
   * Log at *debug* level.
   * @param message the debug message
   * @param args the arguments used to format the debug message
   */
  def debug(message: String, args: AnyRef*): Unit
}

/**
 * Utility to keep [[Logger]] methods abstract, because term macros cannot override abstract methods.
 */
private[scalalogging] class BaseLogger extends Logger {

  // Error

  override def error(message: String): Unit =
    ???

  override def error(message: String, cause: Throwable): Unit =
    ???

  override def error(message: String, args: AnyRef*): Unit =
    ???

  // Warn

  override def warn(message: String): Unit =
    ???

  override def warn(message: String, cause: Throwable): Unit =
    ???

  override def warn(message: String, args: AnyRef*): Unit =
    ???

  // Info

  override def info(message: String): Unit =
    ???

  override def info(message: String, cause: Throwable): Unit =
    ???

  override def info(message: String, args: AnyRef*): Unit =
    ???

  // Debug

  override def debug(message: String): Unit =
    ???

  override def debug(message: String, cause: Throwable): Unit =
    ???

  override def debug(message: String, args: AnyRef*): Unit =
    ???
}
