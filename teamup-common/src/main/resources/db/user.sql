CREATE TABLE `user`
(
    `id`          bigint NOT NULL,
    `username`    varchar(256) DEFAULT NULL,
    `password`    varchar(512) DEFAULT NULL,
    `mail`        varchar(512) DEFAULT NULL,
    `phone`       varchar(128) DEFAULT NULL,
    `Sid`         varchar(256) DEFAULT NULL COMMENT '学号',
    `college`     varchar(256) DEFAULT NULL COMMENT '学院',
    `major`       varchar(256) DEFAULT NULL COMMENT '专业',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `status`      tinyint(1)   DEFAULT NULL COMMENT '账号状态0：未删除 1：已删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci