# mini API 后端
一个提供丰富的API接口供开发者调用的平台
# 项目介绍
mini API平台是一个接口提供平台，提供了多种接口给开发者调用，以帮助开发人员便捷的实现功能，提高开发效率。

项目的前端使用React，后端使用Java语言开发，本模块为项目的后端模块。
# 技术栈
* 开发语言：Java
* 框架：Spring Boot 2.7.2、Mybatis-Plus、Spring Cloud
* 数据库：MySQL、Redis
* 网关：Spring Cloud Gateway
* 注册中心：Nacos
* 服务调用：Dubbo
* 中间件：Rabbit MQ
# 模块划分
* api-backend：后端核心服务，包括用户管理、接口管理等
* api-gateway：网关服务，所有请求都需要经过网关鉴权
* api-common：存放项目公共使用内容的模块，包括实体类信息、工具类等
* api-interface：接口服务模块，提供具体的接口供使用，实际上线可能有来自不同地址的不同接口，这里只是一个范例。
* api-order：订单服务模块，提供接口的购买服务，待完善中
* api-third-party：第三方服务模块，包括腾讯云短信、阿里云oss存储、支付宝沙箱等
* api-sdk：为开发者提供的sdk
