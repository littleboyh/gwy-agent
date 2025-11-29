CREATE TABLE `user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键',
    `nick_name` VARCHAR(64) NOT NULL COMMENT '昵称',
    `email` VARCHAR(128) NOT NULL COMMENT '邮箱',
    `password` VARCHAR(128) NOT NULL COMMENT '密码',
    `avatar` VARCHAR(255) NOT NULL COMMENT '头像',
    `is_pro` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否会员',
    `pro_expire_time` DATETIME NULL COMMENT '会员到期时间',
    `invite_code` VARCHAR(64) NOT NULL COMMENT '使用的邀请码',
    `deleted` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除标记',
    `lock_version` INT NOT NULL DEFAULT 0 COMMENT '乐观锁版本',
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modified_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_email` (`email`),
    UNIQUE KEY `uk_invite_code` (`invite_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
