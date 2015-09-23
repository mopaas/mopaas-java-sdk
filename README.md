# MoPaaS-JAVA-SDK
## 一个使用Apache HttpClient的简单、易用、易扩展的Java SDK
---

基于 [MOPAAS HTTP REST API接口](http://help.tiger.mopaas.com/)开发，适用于Java 6及以上版本。

## 目录
* [准备] (#准备)
* [基础] (#基础)
  * [Domain list] (#domainlist)
  * [Create domain] (#createdomain)
  * [Delete domain] (#deletedomain)
  * [Quota] (#quota)
  * [Logs] (#logs)
  * [Logs with page] (#logswithpage)
  * [Logs with date] (#logswithdate)
  * [Logs with page and date] (#logswithpageanddate)
* [应用] (#应用)
  * [App type list] (#apptypelist)
  * [Create app] (#createapp)
  * [Upgrade app] (#upgradeapp)
  * [App list] (#applist)
  * [App details] (#apptdetails)
  * [Create package version] (#createpackage)
  * [Delete package version] (#deletepackage)
  * [Upload package] (#uploadpackage)
  * [Package list] (#packagelist)
  * [Deploy app] (#deployapp)
  * [Start app] (#start app)
  * [Stop app] (#stop app)
  * [Bind domain] (#binddomain)
  * [Unbind domain] (#unbinddomain)
  * [App instances] (#appinstances)
  * [App envs] (#appenvs)
  * [App envs update] (#appenvsupdate)
  * [App day traffic] (#appdaytraffic)
  * [App request] (#apprequest)
  * [App traffic] (#apptraffic)
  * [Delete app] (#deleteapp)
* [服务] (#服务)
  * [Service type list] (#servicetypelist)
  * [Service plan list] (#serviceplanlist)
  * [Create service] (#createservice)
  * [Service instance list] (#serviceinstancelist)
  * [Bind service] (#bindservice)
  * [Unbind service] (#unbindservice)
  * [Upgrade service] (#upgradeservice)
  * [Service credentials] (#servicecredentials)
  * [Delete service] (#deleteservice)
* [支付] (#支付)
  * [Balances] (#balances)
  * [Payments] (#payments)
  * [Balance details] (#balancedetails)
  * [Budget] (#budget)  
---

<a name="准备"></a>
### 准备

##### 注册用户
大家可以登录[MoPaaS主站](http://www.mopaas.com/)，开启PaaS之旅。具体教程请参见[“文档中心”](http://help.tiger.mopaas.com/)。

##### 初始化MoPaaSClient
初始化MoPaaSClient：

1. 指定公钥和密钥
    MoPaaSClient client = MoPaaSClient.newClient("您的MoPaaS公钥", "您的MoPaaS密钥");
    

若不了解`公钥和密钥`，请参见[“公钥和密钥”](http://www.mopaas.com/)

---
<a name="基础"></a>
### 基础

<a name="domainlist"></a>
#### Domain list

获取指定域名列表，包括自己创建的外部域名以及MoPaaS提供的公共域名。

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/base/domain/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertNotNull(out.getResult());

<a name="createdomain"></a>
#### Create domain

创建外部域名

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/base/domain/bejson.com/create");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());


<a name="deletedomain"></a>
#### Delete domain

删除外部域名

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("DELETE");
        in.setUri("/api/v2/base/domain/bejson.com/");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());

<a name="quota"></a>
#### Quota

配额及使用状况查询

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/base/quota");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());

<a name="logs"></a>
#### Logs

日志查询

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/base/logs/all");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());

<a name="logswithpage"></a>
#### Logs with page

日志查询（带分页）

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/base/logs/all/page/1/3");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());

<a name="logswithdate"></a>
#### Logs with date

日志查询（带时间）

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/base/logs/all/date/2015-01-01/2015-06-30");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());

<a name="logswithpageanddate"></a>
#### Logs with page and date

日志查询（带时间和分页）

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/base/logs/all/2015-01-01/2015-06-30/1/3");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
---
<a name="应用"></a>
### 应用
<a name="apptypelist"></a>
#### App type list

应用类型列表

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/type/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="createapp"></a>
#### Create app

创建应用

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/tiger.mopaas.com/PHP/128");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="upgradeapp"></a>
#### Upgrade app

升级应用

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/128/2");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="applist"></a>
#### App list

应用列表

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="apptdetails"></a>
#### App details

应用详情

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        Assert.assertEquals("php0626", out.getResult().get("name"));

<a name="createpackage"></a>
#### Create package version

代码包创建

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
         in.setUri("/api/v2/app/package/php0626/v1/create");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        
<a name="deletepackage"></a>
#### Delete package version

代码包删除

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("DELETE");
        in.setUri("/api/v2/app/package/php0626/v1/");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        
<a name="uploadpackage"></a>
#### Upload package

上传代码包

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("PUT");
        in.setUri("/api/v2/app/php0626/v1/upload");
        in.setFile(new File("d:/Users/xx/Desktop/phptest/phptest-v3.zip"));
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());

<a name="packagelist"></a>
#### Package list

应用代码包列表

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/package/php0626");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="deployapp"></a>
#### Deploy app

发布应用

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/v1/deploy");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="start app"></a>
#### Start app

启动应用

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/start");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="stop app"></a>
#### Stop app

停止应用

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626/stop");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="binddomain"></a>
#### Bind domain

绑定域名

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/domain/php0626/php06261.tiger.mopaas.com/bind");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="unbinddomain"></a>
#### Unbind domain

解绑域名

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/domain/php0626/php06261.tiger.mopaas.com/unbind");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="appinstances"></a>
#### App instances

应用实例列表

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/instance/php0626/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="appenvs"></a>
#### App envs

环境变量列表

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/env/php0626/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNotNull(out.getResult());

<a name="appenvsupdate"></a>
#### App envs update

更新环境变量

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/env/php0626/a.b.c.d/");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="appdaytraffic"></a>
#### App day traffic

应用当天流量

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/php0626");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getResult());
        Assert.assertEquals("php0626", out.getResult().get("name"));
        String appGuid = (String)out.getResult().get("guid");
        in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/app/traffic/" + appGuid);
        out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNotNull(out.getResult());

<a name="apprequest"></a>
#### App request

应用访问量

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

<a name="apptraffic"></a>
#### App traffic

应用流量

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

<a name="deleteapp"></a>
#### Delete app

删除应用

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("DELETE");
        in.setUri("/api/v2/app/php0626");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNull(out.getResult());

---
<a name="服务"></a>
### 服务
<a name="servicetypelist"></a>
#### Service type list

服务类型列表

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/type/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="serviceplanlist"></a>
#### Service plan list

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/plan/MySQL/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="createservice"></a>
#### Create service

创建服务

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/MySQL/mysql0626/" + UrlCodingUtils.encodeBase64("MySQL 125M".getBytes()) + "/create");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());

<a name="serviceinstancelist"></a>
#### Service instance list

服务实例列表

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());

<a name="bindservice"></a>
#### Bind service

绑定服务

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/php0609/mysql0626/bind");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());

<a name="unbindservice"></a>
#### Unbind service

解绑服务

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/php0609/mysql0626/unbind");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());

<a name="upgradeservice"></a>
#### Upgrade service

升级服务

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/mysql0626/" + UrlCodingUtils.encodeBase64("MySQL 250M".getBytes()) + "/upgrade");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        
<a name="servicecredentials"></a>
#### Service credentials

服务登录信息

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/service/dd2ce6bd-b6ad-4250-93dd-4a8ff76a24ff/fc894f51-00cd-4114-a7c1-0547b81e77bc/credentials");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNotNull(out.getResult());

<a name="deleteservice"></a>
#### Delete service

删除服务

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("DELETE");
        in.setUri("/api/v2/service/mysql0626");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());

---
<a name="支付"></a>
### 支付
<a name="balances"></a>
#### Balances

余额查询

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/pay/balance");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNotNull(out.getResult());

<a name="payments"></a>
#### Payments

消费记录

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/pay/list");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getList());
        Assert.assertNotNull(out.getResult());

<a name="balancedetails"></a>
#### Balance details

充值记录

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/pay/balanceDetails");
        MoPaaSOutVo out = client.exec(in, MoPaaSOutVo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNotNull(out.getList());
        Assert.assertNull(out.getResult());
        
<a name="budget"></a>
#### Budget

消费预估

        MoPaaSInVo in = new MoPaaSInVo();
        in.setMethod("GET");
        in.setUri("/api/v2/pay/bugdet");
        MoPaaSOut2Vo out = client.exec(in, MoPaaSOut2Vo.class);
        Assert.assertEquals("API_0", out.getCode());
        Assert.assertNull(out.getResult());

---
