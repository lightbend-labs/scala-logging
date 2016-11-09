package com.typesafe.scalalogging

package object fluent {

  /**
   * Enables logging on any type. Passes the value through the logging method.
   *
   * Example:
   *
   * {{{
   * def complexComputation =
   *   (list: List[Any])
   *     .map(f1)
   *     .info("so far we have " + _)
   *     .collect(f2)
   *     .info("and now we have " + _)
   * }}}
   *
   */
  implicit class FluentLogging[T](subject: T)(implicit logger: Logger) {
    def debug(f: T => String):T = { logger.debug(f(subject)); subject }
    def error(f: T => String):T = { logger.error(f(subject)); subject }
    def info(f: T => String):T = { logger.info(f(subject)); subject }
    def trace(f: T => String):T = { logger.trace(f(subject)); subject }
    def warn(f: T => String):T = { logger.warn(f(subject)); subject }

    def debug(msg: => String):T = { logger.debug(msg); subject }
    def error(msg: => String):T = { logger.error(msg); subject }
    def info(msg: => String):T = { logger.info(msg); subject }
    def trace(msg: => String):T = { logger.trace(msg); subject }
    def warn(msg: => String):T = { logger.warn(msg); subject }
  }

}
