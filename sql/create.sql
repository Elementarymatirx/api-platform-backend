create schema api collate utf8mb4_0900_ai_ci;
use api;
create table if not exists alipay_info
(
    orderNumber    varchar(256)                       not null comment '订单id'
    primary key,
    subject        varchar(256)                       null comment '交易名称',
    totalAmount    double                             not null comment '交易金额',
    buyerPayAmount double                             null comment '买家付款金额',
    buyerId        varchar(256)                       null comment '买家在支付宝的唯一id',
    tradeNo        varchar(256)                       not null comment '支付宝交易凭证号',
    tradeStatus    varchar(512)                       null comment '交易状态',
    gmtPayment     datetime default CURRENT_TIMESTAMP not null comment '买家付款时间'
    )
    comment '交易信息';

create table if not exists api_order
(
    id          bigint auto_increment comment '主键'
    primary key,
    userId      bigint                             not null comment '调用用户id',
    interfaceId bigint                             not null comment '接口id',
    orderNumber varchar(256)                       not null comment '订单号',
    total       int      default 0                 not null comment '购买数量',
    charging    double   default 0                 not null comment '单价',
    totalAmount double   default 0                 not null comment '交易金额',
    status      int      default 0                 not null comment '交易状态',
    createTime  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint  default 0                 not null comment '是否删除'
    )
    comment '订单表' collate = utf8mb4_unicode_ci;

create table if not exists interface_charging
(
    id              bigint auto_increment comment '主键'
    primary key,
    interfaceId     bigint                             not null comment '接口id',
    charging        double                             not null comment '计费规则（元/条）',
    availablePieces varchar(128)                       not null comment '接口剩余可调用次数',
    userId          bigint                             not null comment '用户id',
    createTime      datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete        tinyint  default 0                 not null comment '是否删除'
    )
    comment '用户调用接口关系' collate = utf8mb4_unicode_ci;

create table if not exists interface_info
(
    id             bigint auto_increment comment '主键'
    primary key,
    name           varchar(256)                       not null comment '名称',
    description    varchar(256)                       null comment '描述',
    url            varchar(512)                       not null comment '接口地址',
    requestHeader  text                               null comment '请求头',
    responseHeader text                               null comment '响应头',
    status         int      default 0                 not null comment '接口状态(0-关闭,1-开启)',
    method         varchar(256)                       not null comment '请求类型',
    userId         bigint                             not null comment '创建人',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除(0-未删,1-已删)',
    requestParams  text                               null comment '请求参数',
    methodName     varchar(256)                       null comment 'SDK中的方法名'
    )
    comment '接口信息';

create table if not exists order_lock
(
    id          bigint auto_increment comment 'id'
    primary key,
    orderNumber varchar(256)                       not null comment '订单编号',
    chargingId  bigint                             not null comment '计费id',
    userId      bigint                             not null comment '用户id',
    lockNum     bigint                             not null comment '锁定数量',
    lockStatus  int      default 0                 null comment '锁定状态(1-已锁定 0-已解锁 2-扣减)',
    createTime  datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime  datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete    tinyint  default 0                 not null comment '是否删除'
    )
    comment '订单锁';

create table if not exists user
(
    id           bigint auto_increment comment 'id'
    primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    accessKey    varchar(512)                           not null comment 'accessKey',
    secretKey    varchar(512)                           not null comment 'secretKey',
    gender       int          default 0                 null comment '性别',
    phoneNum     varchar(256)                           not null comment '手机号'
    )
    comment '用户' collate = utf8mb4_unicode_ci;

create table if not exists user_interface_info
(
    id              bigint auto_increment comment '主键'
    primary key,
    userId          bigint                             not null comment '调用用户id',
    interfaceInfoId bigint                             not null comment '接口id',
    totalNum        int      default 0                 not null comment '总调用次数',
    leftNum         int      default 0                 not null comment '剩余调用次数',
    status          int      default 0                 not null comment '0-正常,1-禁用',
    createTime      datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete        tinyint  default 0                 not null comment '是否删除'
)
    comment '用户调用接口关系' collate = utf8mb4_unicode_ci;

