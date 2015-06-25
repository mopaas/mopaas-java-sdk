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

import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.mopaas.sdk.enums.MsgEnum;
import com.mopaas.sdk.vo.MoPaaSInVo;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class SignatureUtils {
    private static final Logger logger = Logger.getLogger(SignatureUtils.class);
    
    /**
     * Signature
     * @param method
     * @param uri
     * @param secretKey
     * @param treeMap
     * @return
     */
    public static String signature(MoPaaSInVo vo, String secretKey) {
        String method = vo.getMethod();
        String uri = vo.getUri();
        TreeMap<String, Object> treeMap = vo.getMap();
        if(method == null || method.length() == 0) {
            logger.error(MsgEnum.M_00001.getMessage());
            throw new RuntimeException(MsgEnum.M_00001.getMessage());
        }
        if(secretKey == null || secretKey.length() == 0) {
            logger.error(MsgEnum.M_00002.getMessage());
            throw new RuntimeException(MsgEnum.M_00002.getMessage());
        }
        StringBuffer param = new StringBuffer();
        param.append(method).append(uri);
        if(vo.getFile() != null && vo.getFile().length() > 0) {
            param.append(vo.getFile().length());
            param.append(EncoderUtils.md5(vo.getFile()));
            param.append(vo.getFileType());
        }
        if(treeMap != null) {
            for(String key : treeMap.keySet()) {
                param.append(key).append(treeMap.get(key));
            }
        }
        
        logger.debug("Generated parameters are: " + param);
        String signture = EncoderUtils.sha1(param.append(secretKey).toString());
        logger.debug("Generated signatrue is: " + signture);
        
        return signture;
    }
}
