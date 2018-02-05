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

import org.slf4j.LoggerFactory

/**
 * Defines `logger` as a lazy value initialized with an underlying `org.slf4j.Logger`
 * named according to the class into which this trait is mixed.
 */
trait LazyLogging {

  protected lazy val logger: Logger =
    Logger(LoggerFactory.getLogger(getClass.getName))
}

/**
 * Defines `logger` as a value initialized with an underlying `org.slf4j.Logger`
 * named according to the class into which this trait is mixed.
 */
trait StrictLogging {

  protected val logger: Logger =
    Logger(LoggerFactory.getLogger(getClass.getName))
}

/**
 * Defines `logger` as a value initialized with an underlying `org.slf4j.Logger`
 * named according to the class into which this trait is mixed.
 */
trait CompliantLogging {

  protected val logger: Logger =
    Logger(LoggerFactory.getLogger(getClass.getName))
}