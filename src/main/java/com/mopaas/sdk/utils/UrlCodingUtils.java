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

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class UrlCodingUtils {

    private static Logger logger = Logger.getLogger(UrlCodingUtils.class);
    /***
     * encode by Base64
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static String encodeBase64(byte[] input) {
        String result = null;
        try {
            Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
            Method mainMethod = clazz.getMethod("encode", byte[].class);
            mainMethod.setAccessible(true);
            Object retObj = mainMethod.invoke(null, new Object[] { input });
            result = (String) retObj;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return result;
    }

    /***
     * decode by Base64
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static String decodeBase64(String input) {
        String result = null;
        try {
            Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
            Method mainMethod = clazz.getMethod("decode", String.class);
            mainMethod.setAccessible(true);
            Object retObj = mainMethod.invoke(null, input);
            if (retObj != null) {
                result = new String((byte[]) retObj);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return result;
    }
}
