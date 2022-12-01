网关服务

**说明**

* 动态路由通过nacos配置中心后台修改，yaml格式，内容参考：
```
spring:
  cloud:
    gateway:
        routes:
            - id: a1 # 路由的编号
              uri: lb://discoveryprovidersrv # 路由到的目标地址
              predicates: # 断言，作为路由的匹配条件，对应 RouteDefinition 数组
                - Path=/a/**
              filters:
                - RewritePath=/a/(?<remaining>.*),/${remaining}     # 将 /a 前缀剔除
            - id: b1 # 路由的编号
              uri: https://www.oschina.net # http://127.0.0.1:7004 # 路由的目标地址
              predicates: # 断言，作为路由的匹配条件，对应 RouteDefinition 数组
                - Path=/b
              filters: # 过滤器，对请求进行拦截，实现自定义的功能，对应 FilterDefinition 数组
                - StripPrefix=1
        discovery:
            locator:
                enabled: true # 是否开启，默认为 false 关闭
                url-expression: "'lb://' + serviceId" # 路由的目标地址的表达式，默认为 "'lb://' + serviceId"
```