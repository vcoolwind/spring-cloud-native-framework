http://127.0.0.1:8102/reviews/2099a055-1e21-46ef-825e-9e0de93554ea

Nacos通过命名命名空间区分不同的应用组，通过使用group区分不同的环境。
spring:
  cloud:
    nacos:
      #username: nacos
      #password: nacos
      discovery:
        #nacos的服务地址
        server-addr: 192.168.92.3:31848
        #nacos的命名空间，用来标记应用组
        namespace: bookinfo
        # 分组，用来标记使用环境
        group: dev