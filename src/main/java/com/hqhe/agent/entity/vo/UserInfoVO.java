package com.hqhe.agent.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoVO {
    /**
     * 用户Id
     */
    private Long userId;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 是否是会员
     */
    private Boolean isPro;

    /**
     * 会员到期时间
     */
    private Date proExpireTime;

    /**
     * 考试次数
     */
    private Integer examsCount;

    /**
     * 平均得分
     */
    private Double avgScore;

    /**
     * 活跃天数
     */
    private Integer daysActive;
}
