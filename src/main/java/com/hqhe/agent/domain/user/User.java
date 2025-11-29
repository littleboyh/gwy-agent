package com.hqhe.agent.domain.user;

import com.hqhe.agent.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseEntity {
    /**
     * 用户名
     */
    private String nickName;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 是否会员
     */
    private Boolean isPro;

    /**
     * 会员到期时间
     */
    private Date proExpireTime;

    /**
     * 使用的邀请码
     */
    private String inviteCode;
}
