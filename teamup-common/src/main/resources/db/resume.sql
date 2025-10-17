# 简历基本信息表
CREATE TABLE resume
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT,
    applicant_id     BIGINT       NOT NULL COMMENT '申请人ID',
    resume_title     VARCHAR(200) NOT NULL COMMENT '简历标题',
    resume_content   TEXT COMMENT '简历详细内容',
    resume_file_path VARCHAR(500) COMMENT '简历文件存储路径',
    file_format      VARCHAR(10) COMMENT '文件格式：PDF, DOC, DOCX等',
    file_size        BIGINT COMMENT '文件大小(字节)',
    created_time     DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time     DATETIME   DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    status           tinyint(1) DEFAULT NULL COMMENT '简历状态0：未删除 1：已删除',
    INDEX idx_applicant_id (applicant_id),
    INDEX idx_created_time (created_time)
) COMMENT ='简历基本信息表';