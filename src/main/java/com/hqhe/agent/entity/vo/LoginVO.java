package com.hqhe.agent.entity.vo;

import lombok.Data;

@Data
public class LoginVO {
    /**
     * 用户标识，如用户ID
     */
    private String userId;
    /**
     * 访问令牌
     */
    private String token;

    /**
     * 令牌过期时间
     */
    private Long tokenExpiration;
}
