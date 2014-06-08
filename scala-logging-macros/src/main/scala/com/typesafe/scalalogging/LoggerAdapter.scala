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

/**
 * Adapter interface for plugging in different logging frameworks.
 *
 * Each logging framework should implement this trait.
 */
trait LoggerAdapter {

  // Error

  def isErrorEnabled: Boolean

  def error(message: String): Unit

  def error(message: String, arg0: AnyRef): Unit

  def error(message: String, arg0: AnyRef, arg1: AnyRef): Unit

  def error(message: String, args: Seq[AnyRef]): Unit

  def error(message: String, cause: Throwable): Unit

  // Warn

  def isWarnEnabled: Boolean

  def warn(message: String): Unit

  def warn(message: String, arg0: AnyRef): Unit

  def warn(message: String, arg0: AnyRef, arg1: AnyRef): Unit

  def warn(message: String, args: Seq[AnyRef]): Unit

  def warn(message: String, cause: Throwable): Unit

  // Info

  def isInfoEnabled: Boolean

  def info(message: String): Unit

  def info(message: String, arg0: AnyRef): Unit

  def info(message: String, arg0: AnyRef, arg1: AnyRef): Unit

  def info(message: String, args: Seq[AnyRef]): Unit

  def info(message: String, cause: Throwable): Unit

  // Debug

  def isDebugEnabled: Boolean

  def debug(message: String): Unit

  def debug(message: String, arg0: AnyRef): Unit

  def debug(message: String, arg0: AnyRef, arg1: AnyRef): Unit

  def debug(message: String, args: Seq[AnyRef]): Unit

  def debug(message: String, cause: Throwable): Unit

  // Trace

  def isTraceEnabled: Boolean

  def trace(message: String): Unit

  def trace(message: String, arg0: AnyRef): Unit

  def trace(message: String, arg0: AnyRef, arg1: AnyRef): Unit

  def trace(message: String, args: Seq[AnyRef]): Unit

  def trace(message: String, cause: Throwable): Unit
}
