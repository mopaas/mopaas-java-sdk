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
package com.mopaas.sdk;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mopaas.sdk.enums.MsgEnum;
import com.mopaas.sdk.utils.FormUtils;
import com.mopaas.sdk.utils.HttpClientUtils;
import com.mopaas.sdk.utils.JsonUtils;
import com.mopaas.sdk.utils.PropertiesUtils;
import com.mopaas.sdk.utils.SignatureUtils;
import com.mopaas.sdk.vo.MoPaaSInVo;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class MoPaaSClient {
    private static final Logger logger = Logger.getLogger(MoPaaSClient.class);

    private final String apiUrl;
    private final String accessKey;
    private final String secretKey;

    /**
     * constructor
     * @param accessKey
     * @param secretKey
     */
    public MoPaaSClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        apiUrl = PropertiesUtils.getProperty("api_url");
    }

    /**
     * constructor
     * @param region
     * @param accessKey
     * @param secretKey
     */
    public MoPaaSClient(String region, String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        apiUrl = PropertiesUtils.getProperty("api_url");
    }

    /**
     * Create client without region
     * @param accessKey
     * @param secretKey
     * @return
     */
    public static MoPaaSClient newClient(String accessKey, String secretKey) {
        return new MoPaaSClient(null, accessKey, secretKey);
    }

    /**
     * Executor
     * @param inVo
     * @param type
     * @return
     */
    public <T> T exec(MoPaaSInVo inVo, Class<T> type) {
        return JsonUtils.fromJSON(execute(inVo), type);
    }
    
    /**
     * Execute the request
     * @param vo
     * @return
     */
    private String execute(MoPaaSInVo vo) {
        String signature;
        signature = SignatureUtils.signature(vo, secretKey);

        String url = apiUrl + vo.getUri();
        Map<String, String> header = new HashMap<String, String>();
        header.put("signature", signature);
        header.put("accessKey", accessKey);
        logger.debug("Request url is: " + url);
        String param = null;
        if(vo.getMap() != null && vo.getMap().size() > 0) {
            param = FormUtils.toForm(vo.getMap());
        }
        String res = null;
        if("GET".equals(vo.getMethod())) {
            res = HttpClientUtils.getByHttp(url, param, header);
        } else if ("PUT".equals(vo.getMethod())) {
            if(vo.getFile() == null || vo.getFile().length() == 0) {
                logger.error(MsgEnum.M_00004.getMessage());
                throw new RuntimeException(MsgEnum.M_00004.getMessage());
            }
            
            header.put("fileType", vo.getFileType());
            res = HttpClientUtils.putByHttp(url, header, vo.getFile());
        } else if("DELETE".equals(vo.getMethod())) {
            res = HttpClientUtils.deleteByHttp(url, header);
        }
        
        logger.debug("Call result is: " + res);
        return res;
    }
}
