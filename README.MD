### 网站后台
![拾肆亿主页](https://github.com/ChinaVolvocars/jingxuan/blob/master/image/01.png)
![拾肆亿详情](https://github.com/ChinaVolvocars/jingxuan/blob/master/image/02.png)
![拾肆亿主页](https://github.com/ChinaVolvocars/jingxuan/blob/master/image/03.png)
![拾肆亿新闻](https://github.com/ChinaVolvocars/jingxuan/blob/master/image/04.png)
![拾肆亿新闻详情](https://github.com/ChinaVolvocars/jingxuan/blob/master/image/05.png)


**问题：** 

Spring Boot 整合 MySql8.0.13 时，启动报错，无法正确连接数据库。


**原因：** 

网上按照报错信息查了一大堆帖子，主要定位在 mysql 的8小时问题上。但是实际上并没有那么复杂。

因为 mysql 高版本的驱动变为：
```
com.mysql.cj.jdbc.Driver
```
所以对相应的连接参数也做了更高程度的约定：
```
characterEncoding=utf-8    //确定字符集
serverTimezone=GMT%2B8     //确定时区（这里事东八区）
useSSL=false               //禁用SSL连接
```

**解决方案：**

所以正确的 application.properties 文件内容应该是：

```
#数据源
spring.datasource.url=jdbc:mysql://localhost:3306/mis?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#持久层
spring.jpa.database=mysql
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.hbm2ddl.auto=update

```

**解决方案**

application.yml 文件如下

```yml

spring:
  jmx:
    enabled: false
  thymeleaf:
    cache: false
  mobile: 
    devicedelegatingviewresolver:
      enabled: true
      mobile-prefix: 
      tablet-prefix: 
      mobile-suffix: .mobile
      tablet-suffix: .mobile  #.tablet
  datasource:
    url: jdbc:mysql://localhost:3306/jiameng?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false
    username: root
    password: 123456
    driver-class-name: com.mysql.cj.jdbc.Driver
    validation-query: SELECT 1
    test-on-borrow: true

```
