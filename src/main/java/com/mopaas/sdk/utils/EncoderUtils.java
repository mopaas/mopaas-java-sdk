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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class EncoderUtils {
    private static final Logger logger = Logger.getLogger(EncoderUtils.class);
    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String md5(File file) {
        return encode("MD5", file);
    }

    public static String md5(String str) {
        return encode("MD5", str);
    }

    public static String sha1(String str) {
        return encode("SHA1", str);
    }

    private static String encode(String algorithm, String str) {
        String result = null;
        if (str == null) {
            return result;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(str.getBytes("UTF-8"));
            result = getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            LogUtils.exception(logger, e);
        }
        return result;
    }

    private static String encode(String algorithm, File file) {
        String result = null;
        if (file == null) {
            return result;
        }
        
        FileInputStream fis = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length = -1;
            while ((length = fis.read(buffer)) != -1) {
                messageDigest.update(buffer, 0, length);
            }
            result = getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            LogUtils.exception(logger, e);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    /**
     * SHA1
     * @param key
     * @param str
     * @return
     */
    public static String sha1(String key, String str) {
        String algorithm = "HmacSHA1";
        String result = null;
        try {
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(keySpec);
            result = getFormattedText(mac.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e) {
            LogUtils.exception(logger, e);
        }
        return result;
    }
    
    /**
     * Base64
     * @param str
     * @return
     */
    public static String base64(String str) {
        String result = null;
        try {
            result = new String(Base64.encodeBase64(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            LogUtils.exception(logger, e);
        }
        return result;
    }
}
