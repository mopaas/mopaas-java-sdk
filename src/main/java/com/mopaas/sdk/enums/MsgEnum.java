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
package com.mopaas.sdk.enums;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public enum MsgEnum {
    M_00001("Method is null or empty!")
    ,M_00002("SecretKey is null or empty!")
    ,M_00003("Exception occured in request!")
    ,M_00004("File is null or empty when PUT!")
    ;

    private final String message;

    private MsgEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static MsgEnum getByCode(String code) {
        MsgEnum result = null;
        for (MsgEnum tmp : values()) {
            if (tmp.name().equals(code)) {
                result = tmp;
            }
        }
        return result;
    }
}
