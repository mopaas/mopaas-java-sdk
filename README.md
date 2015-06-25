# MoPaaS-JAVA-SDK
# 暂时还未开发完毕，请耐心等待。Developing, please wait.
## 一个使用Apache HttpClient的简单、易用、易扩展的Java SDK
---

基于 [MOPAAS HTTP REST API接口](http://help.tiger.mopaas.com/)开发，适用于Java 6及以上版本。

## 目录
* [准备] (#准备)
* [基础] (#基础)
  * [Domain list] (#domainlist)
* [应用] (#应用)
  * [App] (#app)
* [支付] (#支付)
  * [Payment] (#payment)

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

---
