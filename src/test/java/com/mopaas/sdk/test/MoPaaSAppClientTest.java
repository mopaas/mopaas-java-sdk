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
package com.mopaas.sdk.test;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mopaas.sdk.MoPaaSClient;
import com.mopaas.sdk.vo.MoPaaSInVo;
import com.mopaas.sdk.vo.MoPaaSOutVo;

/**
 * 
 * @author YeFeng Shen<yfshen@anchora.me>
 * 
 */
public class MoPaaSAppClientTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

   MoPaaSClient client = MoPaaSClient.newClient("968f6de8-117b-4236-b10e-25e790a198b7", "1c2c4861-ca1e-4f05-97b8-e7d5a4f2d232");
   
    
    @Test
    public void testAppTypes() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/type/list");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testAppCreate() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/tiger.mopaas.com/PHP/128");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testAppUpgrade() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/128/2");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testUpload() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("PUT");
        in.setUri("/api/v2/app/php0626/v1/upload");
        in.setFile(new File("d:/Users/yfshen/Desktop/phptest/phptest-v3.zip"));
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
    }
    
    @Test
    public void testAppPush() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/v1/deploy");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }
    
    @Test
    public void testAppList() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/list");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
    
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testApp() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626");
    
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
    
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        Assert.assertEquals("php0626", out.getResult().get("name"));
    }

    @Test
    public void testAppPackages() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/package/php0626");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
    
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());
    }
    
    @Test
    public void testAppStart() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/start");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }
    
    @Test
    public void testAppEnvs() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/env/php0626/list");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNotNull(out.getResult());
    }
    
    @Test
    public void testAppUpdateEnvs() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/env/php0626/a.b.c.d/");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testAppBindUrl() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/domain/php0626/php06261.tiger.mopaas.com/bind");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }
    
    @Test
    public void testAppUnbindUrl() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/domain/php0626/php06261.tiger.mopaas.com/unbind");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }
    
    @Test
    public void testAppInstances() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626");

        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        Assert.assertEquals("php0626", out.getResult().get("name"));
        
        if("STOPPED".equals(out.getResult().get("state"))) {
            in = new MoPaaSInVo();
            in.setMethod("GET");
            in.setUri("/api/v2/app/php0626/start");
            
            out = client.exec(in, MoPaaSOutVo.class);
            // Assert.assertEquals("API_0", out.getCode());
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/instance/php0626/list");
        
        out = client.exec(in, MoPaaSOutVo.class);
    
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testAppStop() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/stop");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
    
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testAppTrafficDay() {
        String appGuid;

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626");

        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        Assert.assertEquals("php0626", out.getResult().get("name"));
        
        appGuid = (String)out.getResult().get("guid");
        
        in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/traffic/" + appGuid);
        
        out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNotNull(out.getResult());
    }
    
    @Test
    public void testAppTraffic() {
        String appGuid;

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626");

        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        Assert.assertEquals("php0626", out.getResult().get("name"));
        
        appGuid = (String)out.getResult().get("guid");

        in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/traffic/" + appGuid + "/24");
        
        out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());
    }
    
    @Test
    public void testAppRequest() {
        String appGuid;

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626");

        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        Assert.assertEquals("php0626", out.getResult().get("name"));
        
        appGuid = (String)out.getResult().get("guid");

        in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/request/" + appGuid + "/24");
        
        out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());
    }
    
    @Test
    public void testAppDelete() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("DELETE");
        in.setUri("/api/v2/app/php0626");

        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);

        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());
    }

    @Test
    public void testAppPackagesCreate() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/package/php0626/v1/create");
        
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
  
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getResult());
    }
    
    
    
    @Test
    public void testAppPackagesDelete() {
        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("DELETE");
        in.setUri("/api/v2/app/package/php0626/v1/");

		MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
    
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getResult());
    }
}
