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
package com.mopaas.sdk.exception;

import com.mopaas.sdk.enums.MsgEnum;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class MoPaaSException extends Exception {
    
    private static final long serialVersionUID = 7061205581174292757L;
    private String code;
    
    /**
     * Exception with code and message
     * @param code
     * @param message
     */
    public MoPaaSException(String code, String message) {
        super(message);
        this.code = code;
    }
    
    /**
     * Exception with code and message
     * @param code
     * @param message
     */
    public MoPaaSException(int code, String message) {
        super(message);
        this.code = code + "";
    }

    /**
     * Exception with enum
     * @param msgEnum
     */
    public MoPaaSException(MsgEnum msgEnum) {
        super(msgEnum.getMessage());
        this.code = msgEnum.name();
    }

    /**
     * Get code
     * @return
     */
    public String getCode() {
        return code;
    }
}
