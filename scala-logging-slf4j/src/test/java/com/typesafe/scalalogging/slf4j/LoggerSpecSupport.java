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

import static org.mockito.Mockito.*;

public class LoggerSpecSupport {
    
    // Error

    public static void verifyError(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying).error(message, arg);
    }

    public static void verifyError(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying).error(message, arg1, arg2);
    }

    public static void verifyNeverError(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying, never()).error(message, arg);
    }

    public static void verifyNeverError(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying, never()).error(message, arg1, arg2);
    }

    // Warn

    public static void verifyWarn(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying).warn(message, arg);
    }

    public static void verifyWarn(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying).warn(message, arg1, arg2);
    }

    public static void verifyNeverWarn(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying, never()).warn(message, arg);
    }

    public static void verifyNeverWarn(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying, never()).warn(message, arg1, arg2);
    }

    // Info

    public static void verifyInfo(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying).info(message, arg);
    }

    public static void verifyInfo(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying).info(message, arg1, arg2);
    }

    public static void verifyNeverInfo(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying, never()).info(message, arg);
    }

    public static void verifyNeverInfo(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying, never()).info(message, arg1, arg2);
    }

    // Debug

    public static void verifyDebug(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying).debug(message, arg);
    }

    public static void verifyDebug(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying).debug(message, arg1, arg2);
    }

    public static void verifyNeverDebug(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying, never()).debug(message, arg);
    }

    public static void verifyNeverDebug(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying, never()).debug(message, arg1, arg2);
    }

    // Trace

    public static void verifyTrace(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying).trace(message, arg);
    }

    public static void verifyTrace(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying).trace(message, arg1, arg2);
    }

    public static void verifyNeverTrace(org.slf4j.Logger underlying, String message, Object arg) {
        verify(underlying, never()).trace(message, arg);
    }

    public static void verifyNeverTrace(org.slf4j.Logger underlying, String message, Object arg1, Object arg2) {
        verify(underlying, never()).trace(message, arg1, arg2);
    }
}
