CREATE TABLE project
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    title           VARCHAR(200) NOT NULL COMMENT '项目标题',
    description     TEXT COMMENT '项目描述',
    requirements    TEXT COMMENT '招募要求',
    project_type    VARCHAR(50) COMMENT '项目类型',
    college         VARCHAR(100) COMMENT '所属学院',
    major           VARCHAR(100) COMMENT '相关专业',
    status INT DEFAULT 0 COMMENT '状态：0-待审核, 1-已发布, 2-已满员, 3-已结束,4-已删除',
    creator_id      BIGINT       NOT NULL COMMENT '创建者ID',
    team_size       INT         DEFAULT 1 COMMENT '团队规模',
    current_members INT         DEFAULT 1 COMMENT '当前成员数',
    start_time      DATETIME COMMENT '开始时间',
    end_time        DATETIME COMMENT '结束时间',
    created_time    DATETIME    DEFAULT CURRENT_TIMESTAMP,
    updated_time    DATETIME    DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_status (status),
    INDEX idx_college (college),
    INDEX idx_creator (creator_id),
    INDEX idx_created_time (created_time)
);