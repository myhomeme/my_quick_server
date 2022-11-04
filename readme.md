# 火速开发后端系统1.0

[TOC]

# 1.前言

火速开发后端系统，原系统基础的是[ruoyi](http://doc.ruoyi.vip/)系统3.0，现在ruoyi系统已经迭代到4.7，随着工具更多的重点落在告警方面，并且前后端分离的大趋势下，火开2.0借鉴ruoyi4.7代码，完成架构框架

**系统需求**

- JDK >= 1.8
- MySQL >= 5.7
- Maven >= 3.0



# 2.快速了解

本项目是一个 Java EE 企业级平台，集成市面上常见的后台插件，提供火速开发的环境



# 3.后台手册

## 3.1 统一响应

使用RestControllerAdvice和ResponseBodyAdvice接口实现所有controller的统一响应格式设置

```java
{
    "code": 200,
    "msg": "操作成功",
    "data": "Hello World!",
    "timestamp": 1650770553710
}
```

使用注解SneakyThrows和注解ExceptionHandler处理全局的异常，指定返回的接口为响应头为500,将所有的catch部分的异常装成runtime exception抛出

```java
{
    "code": 500,
    "msg": "/ by zero",
    "data": "java.lang.ArithmeticException: / by zero\r\n\tat test.web.com.huangzb.paas.admin.MyTestController.getException(MyTestController.java:27)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat ...",
    "timestamp": 1650783981148
}
```



## 3.2 动态数据源使用

使用插件dynamic-datasource【[源代码](https://gitee.com/baomidou/dynamic-datasource-spring-boot-starter)】

### 3.2.1 配置

在spring-druid.yml文件中配置数据源信息

```yml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/oe?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
    dynamic:
      primary: master #设置默认的数据源或者数据源组,默认值即为master
      strict: true #严格匹配数据源,默认false. true未匹配到指定数据源时抛异常,false使用默认数据源
      datasource:
        master:
          url: jdbc:mysql://127.0.0.1:3306/oe
          username: root
          password: root123
    type: com.alibaba.druid.pool.DruidDataSource
          driver-class-name: com.mysql.jdbc.Driver # 3.2.0开始支持SPI可省略此配置
        slave_1:
          url: jdbc:mysql://*:8066/*?useUnicode=true&characterEncoding=utf8
          username: *
          password: *
          driver-class-name: com.mysql.jdbc.Driver
        slave_2:
          driverClassName: oracle.jdbc.OracleDriver
          url: jdbc:oracle:thin:@//*:1524/*
          username: *
          password: *
```

### 3.2.2 使用

和oe之前系统一样使用

**@DS** 可以注解在方法上或类上，**同时存在就近原则 方法上注解 优先于 类上注解**。

| 注解          | 结果                                     |
| ------------- | ---------------------------------------- |
| 没有@DS       | 默认数据源                               |
| @DS("dsName") | dsName可以为组名也可以为具体某个库的名称 |





# 4.更新日志

##  v1.0.0

- v1.0.0 2022-04-22
  - 1.框架依赖完成spring boot+mybatis plus+swagger+druid
  - 2.增加mybatis plus的代码生成器



> 引用
>
> [SpringBoot 如何统一后端返回格式](https://juejin.cn/post/6986800656950493214)
>
> [dynamic-datasource-spring-boot-starter](https://gitee.com/baomidou/dynamic-datasource-spring-boot-starter)
