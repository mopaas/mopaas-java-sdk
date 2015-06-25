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

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public final class PropertiesUtils {
	private static Logger logger = Logger.getLogger(PropertiesUtils.class);
	private final static String CONF_DIR = "settings.properties";
	private static Properties pro;

	private PropertiesUtils() {
	}

	/**
	 * Get properties
	 * @param name
	 * @return
	 */
	public static String getProperty(String name) {
        
		if (pro != null)
			return pro.getProperty(name);
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			if (cl == null) {
				cl = PropertiesUtils.class.getClassLoader();
			}
			pro = new Properties();
			pro.load(cl.getResourceAsStream(CONF_DIR));
		} catch (Exception e) {
			LogUtils.exception(logger, e);
		}
		return pro.getProperty(name);
	}
}
