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

import java.io.StringWriter;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.type.TypeReference;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class JsonUtils {
    /**
     * Converts the object to a JSON string
     */
    public static String toJSON(Object value) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            StringWriter writer = new StringWriter();
            mapper.writeValue(writer, value);
            return writer.toString();
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Converts the JSON string to an Object (either Map or List)
     */
    public static Object fromJSON(String value) {
        return fromJSON(value, Object.class);
    }

    /**
     * Converts the JSON string to a typed object via a TypeReference The main
     * complication is handling of Generic types: if they are used, one has to
     * use TypeReference object, to work around Java Type Erasure.
     * 
     * ex: return JSONUtils.fromJSON(this.answersJson, new
     * TypeReference<List<StanzaAnswer>>(){});
     */
    public static <T> T fromJSON(String value, TypeReference<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(value, type);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Converts the JSON string to a typed object (or Map/List if Object.class
     * is passed in)
     */
    public static <T> T fromJSON(String value, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(value, type);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}