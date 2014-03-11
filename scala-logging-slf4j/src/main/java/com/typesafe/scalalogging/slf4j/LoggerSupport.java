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

package com.typesafe.scalalogging.slf4j;

import org.slf4j.Logger;

class LoggerSupport {

    // Error

    public static void error(Logger logger, String message, Object arg) {
        logger.error(message, arg);
    }

    public static void error(Logger logger, String message, Object arg1, Object arg2) {
        logger.error(message, arg1, arg2);
    }

    // Warn

    public static void warn(Logger logger, String message, Object arg) {
        logger.warn(message, arg);
    }

    public static void warn(Logger logger, String message, Object arg1, Object arg2) {
        logger.warn(message, arg1, arg2);
    }

    // Warn

    public static void info(Logger logger, String message, Object arg) {
        logger.info(message, arg);
    }

    public static void info(Logger logger, String message, Object arg1, Object arg2) {
        logger.info(message, arg1, arg2);
    }

    // Debug

    public static void debug(Logger logger, String message, Object arg) {
        logger.debug(message, arg);
    }

    public static void debug(Logger logger, String message, Object arg1, Object arg2) {
        logger.debug(message, arg1, arg2);
    }
}
