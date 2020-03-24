package com.typesafe.scalalogging

import org.slf4j.Marker

import scala.reflect.macros.blackbox

/***
 * macros for logging, just a thin layer that extracts an instance A from the containing LoggerTakingConstructorArg[A]
 * and uses LogsAdditionalDataMacro with it
 */
private object LoggerTakingConstructorArgMacro {

  type LoggerContext[A] = blackbox.Context { type PrefixType = LogsAdditionalData[A] }

  // Error

  def errorMessage[A](c: LoggerContext[A])(message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.errorMessage[A](c)(message)(c.Expr(a))
  }

  def errorMessageCause[A](c: LoggerContext[A])(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.errorMessageCause[A](c)(message, cause)(c.Expr(a))
  }

  def errorMessageArgs[A](c: LoggerContext[A])(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.errorMessageArgs[A](c)(message, args: _*)(c.Expr(a))
  }

  def errorMessageMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.errorMessageMarker[A](c)(marker, message)(c.Expr(a))
  }

  def errorMessageCauseMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.errorMessageCauseMarker[A](c)(marker, message, cause)(c.Expr(a))
  }

  def errorMessageArgsMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.errorMessageArgsMarker[A](c)(marker, message, args: _*)(c.Expr(a))
  }

  // Warn

  def warnMessage[A](c: LoggerContext[A])(message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.warnMessage[A](c)(message)(c.Expr(a))
  }

  def warnMessageCause[A](c: LoggerContext[A])(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.warnMessageCause[A](c)(message, cause)(c.Expr(a))
  }

  def warnMessageArgs[A](c: LoggerContext[A])(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.warnMessageArgs[A](c)(message, args: _*)(c.Expr(a))
  }

  def warnMessageMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.warnMessageMarker[A](c)(marker, message)(c.Expr(a))
  }

  def warnMessageCauseMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.warnMessageCauseMarker[A](c)(marker, message, cause)(c.Expr(a))
  }

  def warnMessageArgsMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.warnMessageArgsMarker[A](c)(marker, message, args: _*)(c.Expr(a))
  }

  // Info

  def infoMessage[A](c: LoggerContext[A])(message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.infoMessage[A](c)(message)(c.Expr(a))
  }

  def infoMessageCause[A](c: LoggerContext[A])(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.infoMessageCause[A](c)(message, cause)(c.Expr(a))
  }

  def infoMessageArgs[A](c: LoggerContext[A])(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.infoMessageArgs[A](c)(message, args: _*)(c.Expr(a))
  }

  def infoMessageMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.infoMessageMarker[A](c)(marker, message)(c.Expr(a))
  }

  def infoMessageCauseMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.infoMessageCauseMarker[A](c)(marker, message, cause)(c.Expr(a))
  }

  def infoMessageArgsMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.infoMessageArgsMarker[A](c)(marker, message, args: _*)(c.Expr(a))
  }

  // Debug

  def debugMessage[A](c: LoggerContext[A])(message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.debugMessage[A](c)(message)(c.Expr(a))
  }

  def debugMessageCause[A](c: LoggerContext[A])(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.debugMessageCause[A](c)(message, cause)(c.Expr(a))
  }

  def debugMessageArgs[A](c: LoggerContext[A])(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.debugMessageArgs[A](c)(message, args: _*)(c.Expr(a))
  }

  def debugMessageMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.debugMessageMarker[A](c)(marker, message)(c.Expr(a))
  }

  def debugMessageCauseMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.debugMessageCauseMarker[A](c)(marker, message, cause)(c.Expr(a))
  }

  def debugMessageArgsMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.debugMessageArgsMarker[A](c)(marker, message, args: _*)(c.Expr(a))
  }

  // Trace

  def traceMessage[A](c: LoggerContext[A])(message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.traceMessage[A](c)(message)(c.Expr(a))
  }

  def traceMessageCause[A](c: LoggerContext[A])(message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.traceMessageCause[A](c)(message, cause)(c.Expr(a))
  }

  def traceMessageArgs[A](c: LoggerContext[A])(message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.traceMessageArgs[A](c)(message, args: _*)(c.Expr(a))
  }

  def traceMessageMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.traceMessageMarker[A](c)(marker, message)(c.Expr(a))
  }

  def traceMessageCauseMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], cause: c.Expr[Throwable]): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.traceMessageCauseMarker[A](c)(marker, message, cause)(c.Expr(a))
  }

  def traceMessageArgsMarker[A](c: LoggerContext[A])(marker: c.Expr[Marker], message: c.Expr[String], args: c.Expr[Any]*): c.universe.Tree = {
    import c.universe._
    val a = q"${c.prefix}.a"
    LogsAdditionalDataMacro.traceMessageArgsMarker[A](c)(marker, message, args: _*)(c.Expr(a))
  }
}
