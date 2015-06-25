// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.mopaas.sdk.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import com.mopaas.sdk.enums.MsgEnum;
import com.mopaas.sdk.exception.MoPaaSException;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class LogUtils {
    private static final Logger logger = Logger.getLogger(LogUtils.class);
    
    public static void exception(Logger logger, Exception e) {
        StringWriter sw = new StringWriter();
        try {
            e.printStackTrace(new PrintWriter(sw));
            logger.error(logger.getName() + " occured " + e.getClass().getSimpleName() + " " + e.getMessage());
            logger.error(sw.toString());
        } finally {
            try {
                sw.close();
            } catch (IOException e1) {
                logger.error(e1);
            }
        }
    }
    
    public static void exception(Class<?> clazz, Throwable e) {
        StringWriter sw = new StringWriter();
        try {
            e.printStackTrace(new PrintWriter(sw));
            if (e instanceof MoPaaSException) {
                logger.warn(clazz.getName() + " occured " + e.getClass().getSimpleName() + " " + MsgEnum.getByCode(((MoPaaSException) e).getCode()));
            } else {
                logger.warn(clazz.getName() + " occured " + e.getClass().getSimpleName() + " " + e.getMessage());
            }
            logger.warn(sw.toString());
        } finally {
            try {
                sw.close();
            } catch (IOException e1) {
                logger.error(e1);
            }
        }
    }
}
