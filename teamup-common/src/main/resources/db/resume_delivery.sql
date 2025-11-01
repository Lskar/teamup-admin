# 简历投递表
CREATE TABLE resume_delivery
(
    id             BIGINT PRIMARY KEY AUTO_INCREMENT,
    project_id     BIGINT NOT NULL COMMENT '项目ID',
    applicant_id   BIGINT NOT NULL COMMENT '申请人ID',
    resume_content TEXT COMMENT '简历内容',
    status         INT DEFAULT 0 COMMENT '状态：0-已投递, 1-已查看, 2-已录取, 3-已拒绝',
    delivery_time  DATETIME    DEFAULT CURRENT_TIMESTAMP COMMENT '投递时间',
    viewed_time    DATETIME COMMENT '查看时间',
    processed_time DATETIME COMMENT '处理时间',
    notes          TEXT COMMENT '备注',
    INDEX idx_project_status (project_id, status),
    INDEX idx_applicant (applicant_id),
    INDEX idx_delivery_time (delivery_time)
);