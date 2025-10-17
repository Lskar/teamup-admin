CREATE TABLE `project_user`
(
    `project_id` BIGINT NOT NULL COMMENT '项目ID',
    `user_id`    BIGINT NOT NULL COMMENT '用户ID',
    `role`       VARCHAR(50) DEFAULT 'MEMBER' COMMENT '角色：CREATOR-创建者, MEMBER-成员',
    `join_time`  DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '加入时间',

#     -- 唯一索引防止重复添加同一用户到同一个项目
#     UNIQUE KEY `uk_project_user` (`project_id`, `user_id`),
    -- 主键
    PRIMARY KEY (`project_id`, `user_id`)

    -- 其他常用查询索引
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;