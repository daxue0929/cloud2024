## 简介
本仓库是学习bilili上的,尚硅谷2024版Spring Cloud视频教程,跟着学习产生的微服务代码.

### 主要内容
1. 介绍了Spring Cloud集成LoadBalancer
2. 介绍了Spring Cloud集成Openfeign
3. 介绍了Sring Cloud集成resilience4j

### 代码结构图
暂无

### 视频地址：

> https://www.bilibili.com/video/BV1gW421P7RD

### 本地启动

1.首先要本地启动 consul 注册中心``consul agent -dev`` 命令
> 直接``control + c`` 退出即可   
> 访问地址：``http://localhost:8500/``

如果启动的是alibaba的服务,可能需要启动``nacos``
> ``cd /Users/wangxuedi/dev/nacos/bin``  
> 然后运行命令 ``sh startup.sh -m standalone``  
> 浏览器访问 http://localhost:8848/nacos


2.如果想看到zipkin链路的效果，还需要启动 ``brew services start zipkin``工具
> 可以使用 ``brew services stop zipkin`` 关闭zipkin服务  
> 浏览器打开地址访问 http://localhost:9411/zipkin/

3.打开``sentinel``流量治理组件  
```bash
java -jar ~/dev/sentinel/sentinel-dashboard-1.8.7.jar  

请求访问地址 http://localhost:8080/#/login

登录/密码 sentinel/sentinel  

退出时,直接 "control + c" 退出即可
```

### 总结：

通过学习本课程，基本熟悉Spring Cloud常用的几个组件的使用。更深入的使用  
还需要研究官网的文档，或者分析相关实现源码